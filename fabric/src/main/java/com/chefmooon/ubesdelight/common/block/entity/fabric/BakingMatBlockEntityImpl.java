package com.chefmooon.ubesdelight.common.block.entity.fabric;

import com.chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import com.chefmooon.ubesdelight.common.block.fabric.BakingMatBlockImpl;
import com.chefmooon.ubesdelight.common.block.fabric.SyncedBlockEntity;
import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.mixin.accessor.RecipeManagerAccessor;
import com.chefmooon.ubesdelight.common.registry.UbesDelightAdvancements;
import com.chefmooon.ubesdelight.common.registry.UbesDelightSounds;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlockEntityTypesImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightRecipeTypesImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandlerContainer;
import io.github.fabricators_of_create.porting_lib.transfer.item.RecipeWrapper;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BakingMatBlockEntityImpl extends SyncedBlockEntity {
    public static final int MAX_INGREDIENTS = BakingMatBlockEntity.MAX_INGREDIENTS;
    public static final int MAX_PROCESSING_STAGES = BakingMatBlockEntity.MAX_PROCESSING_STAGES;
    public static final int MAX_RESULTS = BakingMatBlockEntity.MAX_RESULTS;
    private final ItemStackHandlerContainer inventory;
    private final ItemStackHandlerContainer inputHandler;
    private ResourceLocation lastRecipeId;

    public BakingMatBlockEntityImpl(BlockPos pos, BlockState state) {
        super(UbesDelightBlockEntityTypesImpl.BAKING_MAT_BAMBOO, pos, state);
        inventory = createHandler();
        inputHandler = inventory;
    }

    public static void init() {
        ItemStorage.SIDED.registerForBlockEntity(BakingMatBlockEntityImpl::getStorage, UbesDelightBlockEntityTypesImpl.BAKING_MAT_BAMBOO);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        inventory.deserializeNBT(tag.getCompound("Inventory"));
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Inventory", inventory.serializeNBT());
    }

    public boolean processItemUsingTool(ItemStack tool, @Nullable Player player) {
        if (level == null) return false;

        Optional<BakingMatRecipeImpl> matchingRecipe = getMatchingRecipe(new RecipeWrapper(inventory), tool, player);

        matchingRecipe.ifPresent(recipe -> {
            List<Ingredient> processStages = recipe.getProcessStages();
            List<ItemStack> ingredientContainers = getInventoryContainers(inventory);

            BlockPos blockPos = getBlockPos();

            if (!recipe.getProcessStages().isEmpty()) {
                if (!getBlockState().getValue(BakingMatBlockImpl.PROCESSING)) {
                    if (!ingredientContainers.isEmpty()) spawnResults(ingredientContainers);
                    level.setBlockAndUpdate(blockPos, this.getBlockState().setValue(BakingMatBlockImpl.PROCESSING, true));
                    clearInventory();
                    ItemStack itemStack = Arrays.stream(processStages.get(0).getItems()).findFirst().orElse(ItemStack.EMPTY);
                    inventory.setItem(0, itemStack);
                    spawnParticles(level, blockPos, itemStack, 5);
                    inventoryChanged();
                } else if (getBlockState().getValue(BakingMatBlockImpl.PROCESSING)) {
                    int currentStage = getProcessStage(inventory.getItem(0), processStages);
                    if (currentStage < recipe.getProcessStages().size() - 1) {
                        ItemStack currentStageItem = inventory.getItem(0);
                        int nextStage = getNextProcessStage(currentStageItem, processStages);
                        if (!processStages.get(nextStage).isEmpty()) {
                            clearInventory();
                            ItemStack nextStageItem = Arrays.stream(processStages.get(nextStage).getItems()).findFirst().orElse(ItemStack.EMPTY);
                            spawnParticles(level, blockPos, nextStageItem, 5);
                            inventory.setItem(0, nextStageItem);
                            inventoryChanged();
                        }
                    } else if (currentStage == recipe.getProcessStages().size() - 1) {
                        spawnRolledResults(recipe, blockPos, level, tool, null);
                        level.setBlockAndUpdate(blockPos, this.getBlockState().setValue(BakingMatBlockImpl.PROCESSING, false));
                    }
                }
            } else {
                spawnRolledResults(recipe, blockPos, level, tool, ingredientContainers);
            }

            triggerAdvancement(player);
            damagetool(tool, player);
            playProcessingSound(recipe.getSoundEvent(), tool);
        });

        return matchingRecipe.isPresent();
    }

    private Optional<BakingMatRecipeImpl> getMatchingRecipe(RecipeWrapper recipeWrapper, ItemStack toolStack, @Nullable Player player) {
        if (level == null) return Optional.empty();

        if (lastRecipeId != null) {
            Recipe<RecipeWrapper> recipe = ((RecipeManagerAccessor) level.getRecipeManager())
                    .getRecipeMap(UbesDelightRecipeTypesImpl.BAKING_MAT.get())
                    .get(lastRecipeId);
            if (recipe instanceof BakingMatRecipeImpl && recipe.matches(recipeWrapper, level) && ((BakingMatRecipeImpl) recipe).getTool().test(toolStack)) {
                return Optional.of((BakingMatRecipeImpl) recipe);
            }
        }

        List<BakingMatRecipeImpl> recipeList = level.getRecipeManager().getRecipesFor(UbesDelightRecipeTypesImpl.BAKING_MAT.get(), recipeWrapper, level);
        if (recipeList.isEmpty()) {
            if (player != null) player.displayClientMessage(TextUtils.getTranslatable("tooltip.baking_mat.invalid_item"), true);
            return Optional.empty();
        }

        Optional<BakingMatRecipeImpl> recipe = recipeList.stream().filter(bakingMatRecipeImpl -> bakingMatRecipeImpl.getTool().test(toolStack)).findFirst();
        if (recipe.isEmpty()) {
            if (player != null) player.displayClientMessage(TextUtils.getTranslatable("tooltip.baking_mat.invalid_tool"), true);
            return Optional.empty();
        }
        lastRecipeId = recipe.get().getId();
        return recipe;
    }

    private void spawnRolledResults(BakingMatRecipeImpl recipe, BlockPos blockPos, Level level, ItemStack tool, @Nullable List<ItemStack> containers) {
        List<ItemStack> results = recipe.getRollResults(level.random, EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, tool));
        if (containers != null && !containers.isEmpty()) results.addAll(containers);
        if (!results.isEmpty()) {
            spawnParticles(level, blockPos, results.get(0).copy(), 5);
            spawnResults(results);
            clearInventory();
        }
    }

    private void spawnResults(List<ItemStack> results) {
        for (ItemStack result : results) {
            Direction direction = getBlockState().getValue(BakingMatBlockImpl.FACING).getCounterClockWise();
            ItemEntity entity = new ItemEntity(level,
                    worldPosition.getX() + 0.5 + (direction.getStepX() * 0.2),
                    worldPosition.getY() + 0.2,
                    worldPosition.getZ() + 0.5 + (direction.getStepZ() * 0.2), result.copy());
            entity.setDeltaMovement(direction.getStepX() * 0.2F, 0.0F, direction.getStepZ() * 0.2F);
            level.addFreshEntity(entity);
        }
    }

    private void playProcessingSound(String soundEventID, ItemStack tool) {
        playProcessingSound(soundEventID, tool, (ItemStack) null);
    }

    private void playProcessingSound(String soundEventID, ItemStack tool, @Nullable ItemStack item) {
        SoundEvent sound = BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation(soundEventID));
        // NOTE: unused inputs for future implementation of specific results
        if (sound != null) {
            playSound(sound, 1.0f, 1.0f);
        } else if (tool.is(CommonTags.C_TOOLS_ROLLING_PINS)) {
            playSound(UbesDelightSounds.BLOCK_BAKING_MAT_ROLLING_PIN.get(), 1.0f, 0.8f);
        }
    }

    private void playSound(SoundEvent sound, float volume, float pitch) {
        if (level != null)
            level.playSound(null, worldPosition.getX() + 0.5F, worldPosition.getY() + 0.5F, worldPosition.getZ() + 0.5F, sound, SoundSource.BLOCKS, volume, pitch);
    }

    private void damagetool(ItemStack tool, Player player) {
        if (player != null) {
            tool.hurtAndBreak(1, player, user -> user.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        } else {
            if (tool.hurt(1, level.random, null)) {
                tool.setCount(0);
            }
        }
    }

    private void triggerAdvancement(Player player) {
        if (player instanceof ServerPlayer) {
            UbesDelightAdvancements.BAKING_MAT.trigger((ServerPlayer) player);
        }
    }

    public static void spawnParticles(Level level, BlockPos pos, ItemStack stack, int count) {
        for (int i = 0; i < count; ++i) {
            Vec3 vec3d = new Vec3(((double) level.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, ((double) level.random.nextFloat() - 0.5D) * 0.1D);
            if (level instanceof ServerLevel) {
                ((ServerLevel) level).sendParticles(new ItemParticleOption(ParticleTypes.ITEM, stack), pos.getX() + 0.5F, pos.getY() + 0.1F, pos.getZ() + 0.5F, 1, vec3d.x, vec3d.y + 0.05D, vec3d.z, 0.0D);
            } else {
                level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, stack), pos.getX() + 0.5F, pos.getY() + 0.1F, pos.getZ() + 0.5F, vec3d.x, vec3d.y + 0.05D, vec3d.z);
            }
        }
    }

    private Integer getProcessStage(ItemStack itemStack, List<Ingredient> processStages) {
        Integer stage = 0;
        for (int i = 0; i < processStages.size(); i++) {
            if (!processStages.get(i).isEmpty()) {
                if (itemStack.is(Arrays.stream(processStages.get(i).getItems()).findFirst().get().getItem())) {
                    return stage;
                } else {
                    stage++;
                }
            }
        }
        return stage;
    }

    private Integer getNextProcessStage(ItemStack itemStack, List<Ingredient> processStages) {
        Integer stage = 0;
        for (int i = 0; i < processStages.size(); i++) {
            if (!processStages.get(i).isEmpty()) {
                if (itemStack.is(Arrays.stream(processStages.get(i).getItems()).findFirst().get().getItem())) {
                    if (i == processStages.size()-1) {
                        return stage;
                    } else {
                        return stage+1;
                    }
                } else {
                    stage++;
                }
            }
        }
        return stage;
    }

    private List<ItemStack> getInventoryContainers(ItemStackHandlerContainer inventory) {
        List<ItemStack> ingredientContainers = new ArrayList<>();
        for (int i = 0; i < inventory.getSlotCount(); i++) {
            ItemStack itemStack = inventory.getItem(i);
            if (!itemStack.isEmpty()) {
                if (!itemStack.getRecipeRemainder().is(Items.AIR)) {
                    ingredientContainers.add(itemStack.getRecipeRemainder());
                }
            }
        }
        return ingredientContainers;
    }

    public void clearInventory() {
        inventory.clearContent();
    }

        public void setInventory(NonNullList<ItemStack> list) {
        for (int i = 0; i < MAX_INGREDIENTS-1; i++) {
            this.inventory.setItem(i, list.get(i));
        }
    }

    public int getContainerSize() {
        return MAX_INGREDIENTS;
    }

    public NonNullList<ItemStack> getItems() {
        NonNullList<ItemStack> items = NonNullList.withSize(MAX_INGREDIENTS, ItemStack.EMPTY);
        for (int i = 0; i < MAX_INGREDIENTS; i++) {
            items.set(i, inventory.getItem(i));
        }
        return items;
    }

    public boolean isEmpty() {
        return inventory.getItem(0).isEmpty();
    }

    public boolean isFull() {
        return !inventory.getItem(MAX_INGREDIENTS).isEmpty();
    }

    public boolean addItem(ItemStack itemStack) {
        for (int i = 0; i < inventory.getSlotCount(); i++) {
            ItemStack inventoryStack = inventory.getItem(i);
            if (inventoryStack.isEmpty()) {
                inventory.setItem(i, itemStack.split(1));
                inventoryChanged();
                return true;
            }
        }
        return false;
    }

    public ItemStack removeItem() {
        for (int i = MAX_INGREDIENTS-1; i >= 0; i--) {
            ItemStack itemStack = inventory.getItem(i);
            if (!itemStack.isEmpty()) {
                inventory.setItem(i, ItemStack.EMPTY);
                inventoryChanged();
                return itemStack;
            }
        }
        return ItemStack.EMPTY;
    }

    public int getItemsQuantity() {
        int items = 0;
        for (int i = 0; i <= MAX_INGREDIENTS-1; i++) {
            ItemStack itemstack = inventory.getItem(i);
            if (!itemstack.isEmpty()) {
                items++;
            }
        }
        return items;
    }

    public ItemStackHandlerContainer getInventory() {
        return this.inventory;
    }

    public Vec2 getItemOffset(int index) {
        return BakingMatBlockEntity.getItemOffset(index);
    }

    @NotNull
    public Storage<ItemVariant> getStorage(@Nullable Direction side) {
        return inputHandler;
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
    }

    private ItemStackHandlerContainer createHandler() {
        return new ItemStackHandlerContainer(MAX_INGREDIENTS)
        {
            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }

            @Override
            protected void onContentsChanged(int slot) {
                inventoryChanged();
            }
        };
    }
}
