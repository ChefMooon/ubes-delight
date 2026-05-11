//package com.chefmooon.ubesdelight.integration.rrv.baking_mat.fabric;
//
//import cc.cassian.rrv.api.recipe.ReliableClientRecipe;
//import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
//import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
//import cc.cassian.rrv.common.recipe.inventory.SlotContent;
//import com.chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
//import com.chefmooon.ubesdelight.common.utility.TextUtils;
//import net.minecraft.client.gui.GuiGraphics;
//import net.minecraft.client.renderer.RenderPipelines;
//import net.minecraft.resources.Identifier;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//
//public class BakingMatViewRecipe implements ReliableClientRecipe {
//    private final List<SlotContent> inputs;
//    private final SlotContent toolInput;
//    private final LinkedHashMap<SlotContent, Float> chanceOutputs;
//    private final List<SlotContent> mandatoryOutputs;
//    private final List<SlotContent> processStages;
//
//    public BakingMatViewRecipe(BakingMatServerRecipe recipe) {
//        this.inputs = new ArrayList<>();
//        recipe.getInputs().forEach(ingredient -> {
//            this.inputs.add(SlotContent.of(ingredient));
//        });
//
//        this.toolInput = SlotContent.of(recipe.getToolInput());
//
//        this.chanceOutputs = new LinkedHashMap<>();
//        recipe.getChanceOutputs().forEach(ingredient -> {
//            this.chanceOutputs.put(SlotContent.of(ingredient.stack()), ingredient.chance());
//        });
//
//        this.mandatoryOutputs = new ArrayList<>();
//        recipe.getMandatoryOutputs().forEach(ingredient -> {
//            this.mandatoryOutputs.add(SlotContent.of(ingredient.getItem()));
//        });
//
//        this.processStages = new ArrayList<>();
//        recipe.getProcessStages().forEach(ingredient -> {
//            this.processStages.add(SlotContent.of(ingredient));
//        });
//    }
//
//    @Override
//    public ReliableClientRecipeType getViewType() {
//        return BakingMatViewType.INSTANCE;
//    }
//
//    @Override
//    public void bindSlots(RecipeViewMenu.SlotFillContext slotFillContext) {
//        // Slots -> 0-8: Inputs, 9: Tool, 10-13: Mandatory Outputs, 14-17: Chance Outputs, 18-22: Process Stages
//        for (int i = 0; i < inputs.size() && i < BakingMatBlockEntity.MAX_INGREDIENTS; i++) {
//            slotFillContext.bindOptionalSlot(i, inputs.get(i), BakingMatSlotRenderer.DEFAULT);
//        }
//
//        slotFillContext.bindOptionalSlot(9, toolInput, BakingMatSlotRenderer.DEFAULT);
//
//        for (int i = 0; i < mandatoryOutputs.size() && i < BakingMatBlockEntity.MAX_RESULTS; i++) {
//            slotFillContext.bindOptionalSlot(10 + i, mandatoryOutputs.get(i), BakingMatSlotRenderer.DEFAULT);
//        }
//
//        for (int i = 0; i < chanceOutputs.size() && i < BakingMatBlockEntity.MAX_RESULTS; i++) {
//            SlotContent content = (SlotContent) chanceOutputs.keySet().toArray()[i];
//            slotFillContext.bindOptionalSlot(14 + i, content, BakingMatSlotRenderer.CHANCE);
//        }
//
//        for (int i = 0; i < processStages.size() && i < BakingMatBlockEntity.MAX_PROCESSING_STAGES; i++) {
//            slotFillContext.bindOptionalSlot(18 + i, processStages.get(i), BakingMatSlotRenderer.DEFAULT);
//        }
//    }
//
//    public interface BakingMatSlotRenderer {
//        Identifier TEXTURE = TextUtils.res("textures/gui/emi/baking_mat.png");
//
//        RecipeViewMenu.OptionalSlotRenderer DEFAULT = (guiGraphics, mouseX, mouseY, partialTicks) -> guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, 0, 0, 0, 80, 18 ,18, 256, 256);
//        RecipeViewMenu.OptionalSlotRenderer CHANCE = (guiGraphics, mouseX, mouseY, partialTicks) -> guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, 0, 0, 18, 80, 18 ,18, 256, 256);
//
//        void render(GuiGraphics var1, int var2, int var3, float var4);
//    }
//
//    @Override
//    public List<SlotContent> getIngredients() {
//        List<SlotContent> ingredients = new ArrayList<>(this.inputs);
//        ingredients.add(this.toolInput);
//        ingredients.addAll(this.processStages);
//        return ingredients;
//    }
//
//    @Override
//    public List<SlotContent> getResults() {
//        List<SlotContent> results = new ArrayList<>(this.mandatoryOutputs);
//        results.addAll(this.chanceOutputs.keySet());
//        results.addAll(this.processStages);
//        return results;
//    }
//}
