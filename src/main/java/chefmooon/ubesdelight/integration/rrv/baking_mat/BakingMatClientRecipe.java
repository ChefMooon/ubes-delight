package chefmooon.ubesdelight.integration.rrv.baking_mat;

import cc.cassian.rrv.api.recipe.ReliableClientRecipe;
import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import cc.cassian.rrv.common.recipe.inventory.SlotContent;
import chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BakingMatClientRecipe implements ReliableClientRecipe {
    private final List<SlotContent> inputs;
    private final SlotContent toolInput;
    private final LinkedHashMap<SlotContent, Float> chanceOutputs;
    private final List<SlotContent> mandatoryOutputs;
    private final List<SlotContent> processStages;
    private final Identifier id;
    public BakingMatClientRecipe(Identifier identifier, List<Ingredient> inputs, Ingredient tool, List<Ingredient> processStages, List<ItemStackTemplate> mandatoryOutputs, List<ChanceResult> chanceOutputs) {
        this.id = identifier;
        this.inputs = new ArrayList<>();
        inputs.forEach(ingredient -> {
            this.inputs.add(SlotContent.of(ingredient));
        });

        this.toolInput = SlotContent.of(tool);

        this.chanceOutputs = new LinkedHashMap<>();
        chanceOutputs.forEach(ingredient -> {
            this.chanceOutputs.put(SlotContent.of(ingredient.stack()), ingredient.chance());
        });

        this.mandatoryOutputs = new ArrayList<>();
        mandatoryOutputs.forEach(ingredient -> {
            this.mandatoryOutputs.add(SlotContent.of(ingredient.create().getItem()));
        });

        this.processStages = new ArrayList<>();
        processStages.forEach(ingredient -> {
            this.processStages.add(SlotContent.of(ingredient));
        });
    }

    @Override
    public ReliableClientRecipeType getType() {
        return BakingMatClientRecipeType.INSTANCE;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public void bindSlots(RecipeViewMenu.SlotFillContext slotFillContext) {
        // Slots -> 0-8: Inputs, 9: Tool, 10-13: Mandatory Outputs, 14-17: Chance Outputs, 18-22: Process Stages
        for (int i = 0; i < inputs.size() && i < BakingMatBlockEntity.MAX_INGREDIENTS; i++) {
            slotFillContext.bindOptionalSlot(i, inputs.get(i), BakingMatSlotRenderer.DEFAULT);
        }

        slotFillContext.bindOptionalSlot(9, toolInput, BakingMatSlotRenderer.DEFAULT);

        for (int i = 0; i < mandatoryOutputs.size() && i < BakingMatBlockEntity.MAX_RESULTS; i++) {
            slotFillContext.bindOptionalSlot(10 + i, mandatoryOutputs.get(i), BakingMatSlotRenderer.DEFAULT);
        }

        for (int i = 0; i < chanceOutputs.size() && i < BakingMatBlockEntity.MAX_RESULTS; i++) {
            SlotContent content = (SlotContent) chanceOutputs.keySet().toArray()[i];
            slotFillContext.bindOptionalSlot(14 + i, content, BakingMatSlotRenderer.CHANCE);
        }

        for (int i = 0; i < processStages.size() && i < BakingMatBlockEntity.MAX_PROCESSING_STAGES; i++) {
            slotFillContext.bindOptionalSlot(18 + i, processStages.get(i), BakingMatSlotRenderer.DEFAULT);
        }
    }

    public interface BakingMatSlotRenderer {
        Identifier TEXTURE = TextUtils.res("textures/gui/emi/baking_mat.png");

        RecipeViewMenu.OptionalSlotRenderer DEFAULT = (guiGraphics, mouseX, mouseY, partialTicks) -> guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, 0, 0, 0, 80, 18 ,18, 256, 256);
        RecipeViewMenu.OptionalSlotRenderer CHANCE = (guiGraphics, mouseX, mouseY, partialTicks) -> guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, 0, 0, 18, 80, 18 ,18, 256, 256);

        void render(GuiGraphicsExtractor var1, int var2, int var3, float var4);
    }

    @Override
    public List<SlotContent> getIngredients() {
        List<SlotContent> ingredients = new ArrayList<>(this.inputs);
        ingredients.add(this.toolInput);
        ingredients.addAll(this.processStages);
        return ingredients;
    }

    @Override
    public List<SlotContent> getResults() {
        List<SlotContent> results = new ArrayList<>(this.mandatoryOutputs);
        results.addAll(this.chanceOutputs.keySet());
        results.addAll(this.processStages);
        return results;
    }
}
