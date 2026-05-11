//package com.chefmooon.ubesdelight.integration.rrv.baking_mat.fabric;
//
//import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
//import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
//import com.chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
//import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
//import com.chefmooon.ubesdelight.common.utility.TextUtils;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.Identifier;
//import net.minecraft.world.item.ItemStack;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.List;
//
//public class BakingMatViewType implements ReliableClientRecipeType {
//    public static final BakingMatViewType INSTANCE = new BakingMatViewType();
//    @Override
//    public Component getDisplayName() {
//        return TextUtils.getTranslatable("rei.baking_mat");
//    }
//
//    @Override
//    public int getDisplayWidth() {
//        return 151;
//    }
//
//    @Override
//    public int getDisplayHeight() {
//        return 56;
//    }
//
//    @Override
//    public @Nullable Identifier getGuiTexture() {
//        return TextUtils.res("textures/gui/eiv/baking_mat.png");
//    }
//
//    @Override
//    public int getSlotCount() {
//        return 23;
//    }
//
//    @Override
//    public void placeSlots(RecipeViewMenu.SlotDefinition slotDefinition) {
//        // Slots -> 0-8: Inputs, 9: Tool, 10-13: Mandatory Outputs, 14-17: Chance Outputs, 18-22: Process Stages
//        for (int i = 0; i < BakingMatBlockEntity.MAX_INGREDIENTS; i++) { // Inputs
//            XY offset = getItemOffset(28,29, i);
//            slotDefinition.addItemSlot(i, offset.x, offset.y);
//        }
//
//        slotDefinition.addItemSlot(9, 69, 10); // Tool slot
//
//        for (int i = 0; i < BakingMatBlockEntity.MAX_RESULTS; i++) { // Mandatory outputs
//            int x = 91 + i * 19;
//            int y = 30;
//            slotDefinition.addItemSlot(10 + i, x, y);
//        }
//
//        for (int i = 0; i < BakingMatBlockEntity.MAX_RESULTS; i++) { // Chance outputs
//            int x = 91 + i * 19;
//            int y = 10;
//            slotDefinition.addItemSlot(14 + i, x, y);
//        }
//
//        for (int i = 0; i < BakingMatBlockEntity.MAX_PROCESSING_STAGES; i++) { // Process stages
//            int x = 69 + i * 19;
//            int y = 49;
//            slotDefinition.addItemSlot(18 + i, x, y);
//        }
//    }
//
//    public static XY getItemOffset(int x, int y, int index) {
//        final int offset = 19;
//        final int[] dx = {0,  offset, -offset, 0, 0,  offset, -offset,  offset, -offset};
//        final int[] dy = {0,  0,  0, -offset, offset, -offset, -offset,  offset,  offset};
//        if (index < 0 || index >= dx.length)
//            throw new IndexOutOfBoundsException("index: " + index);
//        return new XY(x + dx[index], y + dy[index]);
//    }
//
//    public record XY(int x, int y) {}
//
//    @Override
//    public Identifier getId() {
//        return Identifier.withDefaultNamespace("baking_mat");
//    }
//
//    @Override
//    public ItemStack getIcon() {
//        return new ItemStack(UbesDelightItemsImpl.BAKING_MAT_BAMBOO.get());
//    }
//
//    @Override
//    public List<ItemStack> getCraftReferences() {
//        return List.of(UbesDelightItemsImpl.BAKING_MAT_BAMBOO.get().getDefaultInstance());
//    }
//}
