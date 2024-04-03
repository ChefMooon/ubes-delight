package com.chefmoon.ubesdelight.block.entity;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.advancement.BakingMatTrigger;
import com.chefmoon.ubesdelight.block.BakingMatBlock;
import com.chefmoon.ubesdelight.mixin.accessors.RecipeManagerAccessorMixin;
import com.chefmoon.ubesdelight.recipe.BakingMatRecipe;
import com.chefmoon.ubesdelight.registry.AdvancementsRegistry;
import com.chefmoon.ubesdelight.registry.BlockEntityTypesRegistry;
import com.chefmoon.ubesdelight.registry.RecipeTypesRegistry;
import com.chefmoon.ubesdelight.registry.SoundsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BakingMatBlockEntity extends BlockEntity implements ImplementedInventory {

    public static final int MAX_INGREDIENTS = 9;
    public static final int MAX_PROCESSING_STAGES = 5;
    public static final int MAX_RESULTS = 4;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(MAX_INGREDIENTS, ItemStack.EMPTY);
    private Identifier lastRecipeID;
    public BakingMatBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityTypesRegistry.BAKING_MAT_BAMBOO.get(), pos, state);
    }

    public void setInventory(DefaultedList<ItemStack> list) {
        for (int i = 0; i < inventory.size(); i++) {
            this.inventory.set(i, inventory.get(i));
        }
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void markDirty() {
        world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        super.markDirty();
        /* Minecraft 1.19.2
        if(!world.isClient()) {
            PacketByteBuf data = PacketByteBufs.create();
            data.writeInt(inventory.size());
            for(int i = 0; i < inventory.size(); i++) {
                data.writeItemStack(inventory.get(i));
            }
            data.writeBlockPos(getPos());

            for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
                ServerPlayNetworking.send(player, ModMessages.ITEM_SYNC, data);
            }
        }
        super.markDirty();

         */
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    @Override
    public void clear() {
        inventory.clear();
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    /* Minecraft 1.19.2
    @Override
    public NbtCompound toInitialChunkDataNbt() {
        NbtCompound nbtCompound = new NbtCompound();
        Inventories.writeNbt(nbtCompound, this.inventory, true);
        return nbtCompound;
    }

     */

    @Override
    public int getMaxCountPerStack() {
        return 1;
    }


    // Future Hopper interface implementation
    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        return false;
    }
    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        return false;
    }
    public int getItemsQuantity() {
        int items = 0;
        for (int i = 0; i <= MAX_INGREDIENTS-1; i++) {
            ItemStack itemstack = inventory.get(i);
            if (!itemstack.isEmpty()) {
                items++;
            }
        }
        return items;
    }

    public boolean isEmpty() {
        return inventory.get(0).isEmpty();
    }

    public boolean isFull() {
        for (int i = MAX_INGREDIENTS-1; i >= 0; i--) {
            ItemStack itemstack = inventory.get(i);
            if (itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean addItem(ItemStack itemStack) {
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack itemstack = inventory.get(i);
            if (itemstack.isEmpty()) {
                inventory.set(i, itemStack.split(1));
                inventoryChanged();
                return true;
            }
        }

        return false;
    }

    public ItemStack removeItem() {
        for (int i = MAX_INGREDIENTS-1; i >= 0; i--) {
            ItemStack itemstack = inventory.get(i);
            if (!itemstack.isEmpty()) {
                inventory.set(i, ItemStack.EMPTY);
                inventoryChanged();
                return itemstack;
            }
        }

        return ItemStack.EMPTY;
    }

    public Vec2f getItemOffset(int index) {
        final float xOffset = .25f;
        final float yOffset = .25f;
        final Vec2f[] offsets = {
                new Vec2f(.0f, .0f), new Vec2f(xOffset, .0f), new Vec2f(-xOffset, .0f),
                new Vec2f(.0f, yOffset), new Vec2f(.0f, -yOffset), new Vec2f(xOffset, yOffset),
                new Vec2f(-xOffset, yOffset), new Vec2f(xOffset, -yOffset), new Vec2f(-xOffset, -yOffset)
        };

        return offsets[index];
    }

    public void inventoryChanged() {
        markDirty();
        if (world != null) {
            world.updateListeners(getPos(), getCachedState(), getCachedState(), 3);
        }
    }

    public boolean processItemUsingTool(ItemStack tool, PlayerEntity player) {
        if (world == null) {
            return false;
        }

        Optional<BakingMatRecipe> matchingRecipe = getMatchingRecipe(ImplementedInventory.of(this.inventory), tool, player);

        matchingRecipe.ifPresent(recipe -> {
            List<ItemStack> results = recipe.getRolledResults(world.getRandom(), EnchantmentHelper.getLevel(Enchantments.FORTUNE, tool));
            List<Ingredient> ingredients = recipe.getIngredients();
            List<Ingredient> processStages = recipe.getProcessStages();
            List<ItemStack> ingredientContainers = DefaultedList.of();

            if (!recipe.getProcessStages().isEmpty()) {
                if (!getCachedState().get(BakingMatBlock.PROCESSING)) {
                    for (ItemStack itemStack : inventory) {
                        if (!itemStack.isEmpty()) {
                            if (!itemStack.getRecipeRemainder().isOf(Items.AIR)) {
                                ingredientContainers.add(itemStack.getRecipeRemainder());
                            }
                        }
                    }
                    if (!ingredientContainers.isEmpty()) {
                        spawnResults(recipe, tool, ingredientContainers);
                    }
                    world.setBlockState(pos, this.getCachedState().with(BakingMatBlock.PROCESSING, true));
                    clear();
                    ItemStack itemStack = Arrays.stream(processStages.get(0).getMatchingStacks()).findFirst().orElse(ItemStack.EMPTY);
                    spawnParticles(itemStack, 5);
                    inventory.set(0, itemStack);
                    inventoryChanged();
                } else if (getCachedState().get(BakingMatBlock.PROCESSING)) {
                    int currentStage = getProcessStage(inventory.get(0), processStages);
                    if (currentStage < recipe.getProcessStages().size() - 1) {
                        ItemStack currentStageItem = inventory.get(0);
                        int nextStage = getNextProcessStage(currentStageItem, processStages);
                        if (!processStages.get(nextStage).isEmpty()) {
                            clear();
                            ItemStack nextStageItem = Arrays.stream(processStages.get(nextStage).getMatchingStacks()).findFirst().orElse(ItemStack.EMPTY);
                            spawnParticles(nextStageItem, 5);
                            inventory.set(0, nextStageItem);
                            inventoryChanged();
                        }
                    } else if (currentStage == recipe.getProcessStages().size() - 1) {
                        spawnParticles(results.get(0).copy(), 5);
                        spawnResults(recipe, tool, results);
                        world.setBlockState(pos, this.getCachedState().with(BakingMatBlock.PROCESSING, false));
                    }
                }
            } else {
                for (ItemStack itemStack : inventory) {
                    if (!itemStack.isEmpty()) {
                        if (!itemStack.getRecipeRemainder().isOf(Items.AIR)) {
                            results.add(itemStack.getRecipeRemainder());
                        }
                    }
                }
                spawnParticles(results.get(0).copy(), 5);
                spawnResults(recipe, tool, results);
            }

            triggerAdvancement(player);
            damageTool(tool, player);
            playProcessingSound(recipe.getSoundEvent(), tool.getItem(), results);
        });

        return matchingRecipe.isPresent();
    }

    private void spawnResults(BakingMatRecipe recipe, ItemStack tool, List<ItemStack> results) {
        for (ItemStack result : results) {
            Direction direction = getCachedState().get(BakingMatBlock.FACING).rotateYCounterclockwise();
            ItemEntity entity = new ItemEntity(world,
                    pos.getX() + .5 + (direction.getOffsetX() * .2),
                    pos.getY() + .2,
                    pos.getZ() + .5 + (direction.getOffsetZ() * .2), result.copy());
            entity.setVelocity(direction.getOffsetX() * .2f, .0f, direction.getOffsetZ() * .2f);
            world.spawnEntity(entity);
            clear();
        }
    }

    private void playProcessingSound(String soundEventID, Item tool, List<ItemStack> results) {
        SoundEvent sound = Registries.SOUND_EVENT.get(new Identifier(soundEventID));

        // NOTE: unused inputs for future implementation of specific results

        if (sound != null) {
            playSound(sound, 1.f, 1.f);
        } else if (tool.getDefaultStack().isIn(CommonTags.C_ROLLING_PINS)){
            playSound(SoundsRegistry.BLOCK_BAKING_MAT_ROLLING_PIN.get(), 1.f, .8f);
        }
    }

    private void playSound(SoundEvent sound, float volume, float pitch) {
        Objects.requireNonNull(world).playSound(null, pos.getX() + .5f, pos.getY() + .5f, pos.getZ() + .5f, sound, SoundCategory.BLOCKS, volume, pitch);
    }

    private void damageTool(ItemStack tool, PlayerEntity player) {
        if (player != null) {
            tool.damage(1, player, user -> user.sendToolBreakStatus(Hand.MAIN_HAND));
        } else {
            if (tool.damage(1, world.getRandom(), null)) {
                tool.setCount(0);
            }
        }
    }

    public void spawnParticles(ItemStack stack, int count) {
        for (int i = 0; i < count; ++i) {
            Vec3d vec3d = new Vec3d((world.getRandom().nextFloat() - .5d) * .1d, Math.random() * .1d + .1d,
                    (world.getRandom().nextFloat() - .5d) * .1d);
            if (world instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(new ItemStackParticleEffect(ParticleTypes.ITEM, stack), pos.getX() + .5f,
                        pos.getY() + .1f, pos.getZ() + .5f, 1, vec3d.x, vec3d.y + .05d, vec3d.z, .0d);
            } else {
                world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, stack), pos.getX() + .5f, pos.getY() + .1f,
                        pos.getZ() + .5f, vec3d.x, vec3d.y + .05d, vec3d.z);
            }
        }
    }

    private Integer getProcessStage(ItemStack itemStack, List<Ingredient> processStages) {
        Integer stage = 0;
        for (int i = 0; i < processStages.size(); i++) {
            if (!processStages.get(i).isEmpty()) {
                if (itemStack.isOf(Arrays.stream(processStages.get(i).getMatchingStacks()).findFirst().get().getItem())) {
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
                if (itemStack.isOf(Arrays.stream(processStages.get(i).getMatchingStacks()).findFirst().get().getItem())) {
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

    private void triggerAdvancement(PlayerEntity playerEntity) {
        if (playerEntity instanceof ServerPlayerEntity serverPlayerEntity) {
            ((BakingMatTrigger) AdvancementsRegistry.BAKING_MAT.get()).trigger(serverPlayerEntity);
        }
    }

    // This is potential for spawning ingredients from processingStage
    public void setInventoryIngredientsFromProcessingStage() {

        Optional<BakingMatRecipe> matchingRecipe = getMatchingIngredients(ImplementedInventory.of(this.inventory));

        matchingRecipe.ifPresent(recipe -> {
            List<Ingredient> ingredients = recipe.getIngredients();
            for (int i = 0; i < ingredients.size(); i++) {
                if (!ingredients.get(i).isEmpty()) {
                    inventory.set(i, Arrays.stream(ingredients.get(i).getMatchingStacks()).findFirst().orElse(ItemStack.EMPTY));
                }
            }
        });
        inventoryChanged();

    }
    private Optional<BakingMatRecipe> getMatchingIngredients(ImplementedInventory implementedInventory) {
        if (world == null) {
            return Optional.empty();
        }

        List<BakingMatRecipe> recipeList = world.getRecipeManager().getAllMatches(RecipeTypesRegistry.BAKING_MAT_RECIPE_SERIALIZER.type(), implementedInventory, world);
        if (recipeList.isEmpty()) {
            return Optional.empty();
        }

        Optional<BakingMatRecipe> recipe = recipeList.stream().findFirst();
        if (recipe.isEmpty()) {
            return Optional.empty();
        }

        return recipe;
    }

    private Optional<BakingMatRecipe> getMatchingRecipe(ImplementedInventory implementedInventory, ItemStack toolStack, @Nullable PlayerEntity player) {
        if (world == null) {
            return Optional.empty();
        }

        if (lastRecipeID != null) {
            Recipe<Inventory> recipe = ((RecipeManagerAccessorMixin) world.getRecipeManager())
                    .getAllForType(RecipeTypesRegistry.BAKING_MAT_RECIPE_SERIALIZER.type())
                    .get(lastRecipeID);
            if (recipe instanceof BakingMatRecipe && recipe.matches(implementedInventory, world) && ((BakingMatRecipe) recipe).getTool().test(toolStack)) {
                return Optional.of((BakingMatRecipe) recipe);
            }
        }

        List<BakingMatRecipe> recipeList = world.getRecipeManager().getAllMatches(RecipeTypesRegistry.BAKING_MAT_RECIPE_SERIALIZER.type(), implementedInventory, world);
        if (recipeList.isEmpty()) {
            if (player != null) {
                player.sendMessage(UbesDelightMod.tooltip("tooltip.baking_mat.invalid_item"), true);
            }
            return Optional.empty();
        }

        Optional<BakingMatRecipe> recipe = recipeList.stream().filter(bakingMatRecipe -> bakingMatRecipe.getTool().test(toolStack)).findFirst();
        if (recipe.isEmpty()) {
            if (player != null) {
                player.sendMessage(UbesDelightMod.tooltip("tooltip.baking_mat.invalid_tool"), true);
            }

            return Optional.empty();
        }
        lastRecipeID = recipe.get().getId();

        return recipe;
    }
}
