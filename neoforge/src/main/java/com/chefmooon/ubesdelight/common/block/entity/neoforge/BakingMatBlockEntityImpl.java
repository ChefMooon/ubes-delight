package com.chefmooon.ubesdelight.common.block.entity.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import com.chefmooon.ubesdelight.common.block.neoforge.BakingMatBlockImpl;
import com.chefmooon.ubesdelight.common.crafting.neoforge.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightSounds;
import com.chefmooon.ubesdelight.common.registry.neoforge.UbesDelightAdvancementsImpl;
import com.chefmooon.ubesdelight.common.registry.neoforge.UbesDelightBlockEntityTypesImpl;
import com.chefmooon.ubesdelight.common.registry.neoforge.UbesDelightRecipeTypesImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.entity.SyncedBlockEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@EventBusSubscriber(modid = UbesDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class BakingMatBlockEntityImpl extends SyncedBlockEntity {
    public static final int MAX_INGREDIENTS = BakingMatBlockEntity.MAX_INGREDIENTS;
    public static final int MAX_PROCESSING_STAGES = BakingMatBlockEntity.MAX_PROCESSING_STAGES;
    public static final int MAX_RESULTS = BakingMatBlockEntity.MAX_RESULTS;
    private final ItemStackHandler inventory;
    //private final IItemHandler inputHandler;
    private final RecipeManager.CachedCheck<RecipeWrapper, BakingMatRecipeImpl> quickCheck;
    public BakingMatBlockEntityImpl(BlockPos pos, BlockState state) {
        super(UbesDelightBlockEntityTypesImpl.BAKING_MAT_BAMBOO.get(), pos, state);
        inventory = createHandler();
        //inputHandler = LazyOptional.of(() -> inventory);
        this.quickCheck = RecipeManager.createCheck(UbesDelightRecipeTypesImpl.BAKING_MAT.get());
    }

    @Override
    public void loadAdditional(CompoundTag compound, HolderLookup.Provider registries) {
        super.loadAdditional(compound, registries);
        inventory.deserializeNBT(registries, compound.getCompound("Inventory"));
    }

    @Override
    public void saveAdditional(CompoundTag compound, HolderLookup.Provider registries) {
        super.saveAdditional(compound, registries);
        compound.put("Inventory", inventory.serializeNBT(registries));
    }

    public boolean processItemUsingTool(ItemStack tool, @Nullable Player player) {
        if (level == null) return false;

        Optional<RecipeHolder<BakingMatRecipeImpl>> matchingRecipe = getMatchingRecipe(new RecipeWrapper(inventory), tool, player);

        matchingRecipe.ifPresent(recipe -> {
            // todo - after first commit - cleanup
            //List<ItemStack> results = List.of();
            //List<Ingredient> ingredients = recipe.getIngredients();
            List<Ingredient> processStages = recipe.value().getProcessStages();
            List<ItemStack> ingredientContainers = getInventoryContainers(inventory);

            BlockPos blockPos = getBlockPos();

            if (!recipe.value().getProcessStages().isEmpty()) {
                if (!getBlockState().getValue(BakingMatBlockImpl.PROCESSING)) {
                    if (!ingredientContainers.isEmpty()) {
                        spawnResults(ingredientContainers);
                    }
                    level.setBlockAndUpdate(getBlockPos(), this.getBlockState().setValue(BakingMatBlockImpl.PROCESSING, true));
                    setInventory(NonNullList.withSize(MAX_INGREDIENTS, ItemStack.EMPTY));
                    clearInventory();
                    ItemStack itemStack = Arrays.stream(processStages.get(0).getItems()).findFirst().orElse(ItemStack.EMPTY);
                    inventory.setStackInSlot(0, itemStack);
                    spawnParticles(level, getBlockPos(), itemStack, 5);
                    inventoryChanged();
                } else if (getBlockState().getValue(BakingMatBlockImpl.PROCESSING)) {
                    int currentStage = getProcessStage(inventory.getStackInSlot(0), processStages);
                    if (currentStage < recipe.value().getProcessStages().size() - 1) {
                        ItemStack currentStageItem = inventory.getStackInSlot(0);
                        int nextStage = getNextProcessStage(currentStageItem, processStages);
                        if (!processStages.get(nextStage).isEmpty()) {
                            clearInventory();
                            ItemStack nextStageItem = Arrays.stream(processStages.get(nextStage).getItems()).findFirst().orElse(ItemStack.EMPTY);
                            spawnParticles(level, getBlockPos(), nextStageItem, 5);
                            inventory.setStackInSlot(0, nextStageItem);
                            inventoryChanged();
                        }
                    } else if (currentStage == recipe.value().getProcessStages().size() - 1) {
                        spawnRolledResults(recipe.value(), blockPos, level, tool, null);
                        level.setBlockAndUpdate(getBlockPos(), this.getBlockState().setValue(BakingMatBlockImpl.PROCESSING, false));
                    }
                }
            } else {
                spawnRolledResults(recipe.value(), blockPos, level, tool, ingredientContainers);
            }

            triggerAdvancement(player);
            if (!level.isClientSide) tool.hurtAndBreak(1, (ServerLevel) level, (ServerPlayer) player, (item) -> {});
            playProcessingSound(recipe.value().getSoundEvent().orElse(null), tool);
        });

        return matchingRecipe.isPresent();
    }

    private Optional<RecipeHolder<BakingMatRecipeImpl>> getMatchingRecipe(RecipeWrapper inventoryWrapper, ItemStack toolStack, @Nullable Player player) {
        if (level == null) return Optional.empty();

        Optional<RecipeHolder<BakingMatRecipeImpl>> recipe = quickCheck.getRecipeFor(inventoryWrapper, this.level);
        if (recipe.isPresent()) {
            if (recipe.get().value().getTool().test(toolStack)) {
                return recipe;
            } else if (player != null) {
                player.displayClientMessage(TextUtils.getTranslatable("tooltip.baking_mat.invalid_tool"), true);
            }
        } else if (player != null) {
            player.displayClientMessage(TextUtils.getTranslatable("tooltip.baking_mat.invalid_item"), true);
        }

        return Optional.empty();
    }

    private void spawnRolledResults(BakingMatRecipeImpl recipe, BlockPos blockPos, Level level, ItemStack tool, @Nullable List<ItemStack> containers) {
        List<ItemStack> results = recipe.getRollResults(level.random, EnchantmentHelper.getTagEnchantmentLevel(level.holder(Enchantments.FORTUNE).get(), tool));
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

    private void playProcessingSound(SoundEvent soundEvent, ItemStack tool) {
        playProcessingSound(soundEvent, tool, (ItemStack) null);
    }

    private void playProcessingSound(@Nullable SoundEvent soundEvent, ItemStack tool, @Nullable ItemStack item) {
        // NOTE: unused inputs for future implementation of specific results
        if (soundEvent != null) {
            playSound(soundEvent, 1.0f, 1.0f);
        } else if (tool.is(CommonTags.C_TOOLS_ROLLING_PIN)) {
            playSound(UbesDelightSounds.BLOCK_BAKING_MAT_ROLLING_PIN.get(), 1.0f, 0.8f);
        }
    }

    private void playSound(SoundEvent sound, float volume, float pitch) {
        if (level != null)
            level.playSound(null, worldPosition.getX() + 0.5F, worldPosition.getY() + 0.5F, worldPosition.getZ() + 0.5F, sound, SoundSource.BLOCKS, volume, pitch);
    }

    private void triggerAdvancement(Player player) {
        if (player instanceof ServerPlayer) {
            UbesDelightAdvancementsImpl.USE_BAKING_MAT.get().trigger((ServerPlayer) player);
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

    private List<ItemStack> getInventoryContainers(ItemStackHandler inventory) {
        List<ItemStack> ingredientContainers = new ArrayList<>();
        for (int i = 0; i < inventory.getSlots(); i++) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if (!itemStack.isEmpty()) {
                if (!itemStack.getCraftingRemainingItem().is(Items.AIR)) {
                    ingredientContainers.add(itemStack.getCraftingRemainingItem());
                }
            }
        }
        return ingredientContainers;
    }

    public void clearInventory() {
        setInventory(NonNullList.withSize(MAX_INGREDIENTS, ItemStack.EMPTY));
    }

    public void setInventory(NonNullList<ItemStack> list) {
        for (int i = 0; i < MAX_INGREDIENTS-1; i++) {
            this.inventory.setStackInSlot(i, list.get(i));
        }
    }

    public int getContainerSize() {
        return MAX_INGREDIENTS;
    }

    public NonNullList<ItemStack> getItems() {
        NonNullList<ItemStack> items = NonNullList.withSize(MAX_INGREDIENTS, ItemStack.EMPTY);
        for (int i = 0; i < MAX_INGREDIENTS; i++) {
            items.set(i, inventory.getStackInSlot(i));
        }
        return items;
    }

    public boolean isEmpty() {
        return inventory.getStackInSlot(0).isEmpty();
    }

    public boolean isFull() {
        return !inventory.getStackInSlot(MAX_INGREDIENTS-1).isEmpty();
    }

    public boolean addItem(ItemStack itemStack) {
        for (int i = 0; i < inventory.getSlots(); i++) {
            ItemStack inventoryStack = inventory.getStackInSlot(i);
            if (inventoryStack.isEmpty()) {
                inventory.setStackInSlot(i, itemStack.split(1));
                inventoryChanged();
                return true;
            }
        }
        return false;
    }

    public ItemStack removeItem() {
        for (int i = MAX_INGREDIENTS-1; i >= 0; i--) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if (!itemStack.isEmpty()) {
                inventory.setStackInSlot(i, ItemStack.EMPTY);
                inventoryChanged();
                return itemStack;
            }
        }
        return ItemStack.EMPTY;
    }

    public int getItemsQuantity() {
        int items = 0;
        for (int i = 0; i <= MAX_INGREDIENTS-1; i++) {
            ItemStack itemstack = inventory.getStackInSlot(i);
            if (!itemstack.isEmpty()) {
                items++;
            }
        }
        return items;
    }

    public IItemHandler getInventory() {
        return inventory;
    }

    public Vec2 getItemOffset(int index) {
        return BakingMatBlockEntity.getItemOffset(index);
    }

//    @Override
//    @Nonnull
//    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
//        if (cap.equals(ForgeCapabilities.ITEM_HANDLER)) {
//            return inputHandler.cast();
//        }
//        return super.getCapability(cap, side);
//    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                UbesDelightBlockEntityTypesImpl.BAKING_MAT_BAMBOO.get(),
                (be, context) -> be.getInventory()
        );
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(MAX_INGREDIENTS)
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
