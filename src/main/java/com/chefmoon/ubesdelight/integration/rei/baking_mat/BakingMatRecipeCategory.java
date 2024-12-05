package com.chefmoon.ubesdelight.integration.rei.baking_mat;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.integration.rei.ChanceArrayIngredient;
import com.chefmoon.ubesdelight.integration.rei.UbesDelightREI;
import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import me.shedaniel.math.Dimension;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class BakingMatRecipeCategory implements DisplayCategory<BakingMatRecipeDisplay> {

    private static final Identifier GUI_TEXTURE = new Identifier(UbesDelightMod.MOD_ID, "textures/gui/rei/baking_mat.png");


    @Override
    public CategoryIdentifier<? extends BakingMatRecipeDisplay> getCategoryIdentifier() {
        return UbesDelightREI.BAKING_MAT;
    }

    @Override
    public Text getTitle() {
        return UbesDelightMod.tooltip("rei.baking_mat");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(BlocksRegistry.BAKING_MAT_BAMBOO.get());
    }

    @Override
    public List<Widget> setupDisplay(BakingMatRecipeDisplay display, Rectangle bounds) {
        // This should be improved, but it hurts.
        Point startPoint = new Point(bounds.getCenterX() - 70, bounds.getCenterY() - 28);
        List<Widget> widgets = new ArrayList<>();

        widgets.add(Widgets.createRecipeBase(bounds));

        widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, new Rectangle(startPoint.x, startPoint.y, 76, 34), 4, 7));

        widgets.add(Widgets.createSlot(new Rectangle(new Point(startPoint.x + 60, startPoint.y + 5), new Dimension(16, 16)))
                .entries(display.getToolInput()).markInput().disableBackground());

        int inputsIte = 0;
        List<EntryIngredient> getIngredientEntries = display.getIngredientEntries();
        for (int i = 0; i < getIngredientEntries.size(); i++, inputsIte++) {
            Point slotLoc = BakingMatRecipeDisplay.getItemOffset(startPoint.x + 22, startPoint.y + 22, i);
            widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, new Rectangle(slotLoc.x, slotLoc.y, 16, 16), 0, 48));
            widgets.add(Widgets.createSlot(new Rectangle(new Point(slotLoc.x, slotLoc.y), new Dimension(16, 16)))
                    .entries(getIngredientEntries.get(i)).markInput().disableBackground());
        }

        // Process Stages
        List<EntryIngredient> processStagesEntries = display.getProcessStages();
        if (processStagesEntries.size() > 0) {
            int processStagesBoundsWidth = processStagesEntries.size() * 15;
            Rectangle processStagesBounds = new Rectangle(startPoint.x + 42, startPoint.y + 39, processStagesBoundsWidth, 14);

            int processStagesIte = 0;
            for (int i = 0; i < processStagesEntries.size(); i++, processStagesIte++) {
                Point slotLoc = new Point(18 + (processStagesBounds.x + processStagesIte * 15), 3 + processStagesBounds.y);
                widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, new Rectangle(slotLoc.x, slotLoc.y, 14, 14), 32, 48));
                widgets.add(Widgets.createSlot(new Rectangle(new Point(slotLoc.x, slotLoc.y), new Dimension(14, 14)))
                        .entries(processStagesEntries.get(i)).markOutput().disableBackground());
            }
        }

        List<EntryIngredient> outputEntries = display.getOutputEntries();
        int outputWidth = 17 * (outputEntries.size());
        Rectangle outputBounds = new Rectangle(startPoint.x + 80, startPoint.y + 5, outputWidth, 33);

        int mandatoryOutputsIte = 0;
        List<EntryIngredient> mandatoryOutputEntries = display.getMandatoryOutputs();
        for (int i = 0; i < mandatoryOutputEntries.size(); i++, mandatoryOutputsIte++) {
            Point slotLoc = new Point(outputBounds.x + mandatoryOutputsIte * 17, outputBounds.y + 17);
            widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, new Rectangle(slotLoc.x, slotLoc.y, 16, 16), 0, 48));
            widgets.add(Widgets.createSlot(new Rectangle(new Point(slotLoc.x, slotLoc.y), new Dimension(16, 16)))
                    .entries(mandatoryOutputEntries.get(i)).markOutput().disableBackground());
        }

        int chanceOutputsIte = 0;
        List<ChanceArrayIngredient> chanceOutputEntries = display.getChanceOutputs();
        for (int i = 0; i < chanceOutputEntries.size(); i++, chanceOutputsIte++) {
            Point slotLoc = new Point(outputBounds.x + chanceOutputsIte * 17, outputBounds.y);
            widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, new Rectangle(slotLoc.x, slotLoc.y, 16, 16), 16, 48));
            ChanceArrayIngredient chanceArrayIngredient = chanceOutputEntries.get(i);
            widgets.add(Widgets.createSlot(new Rectangle(new Point(slotLoc.x, slotLoc.y), new Dimension(16, 16)))
                    .entries(chanceArrayIngredient).markOutput().disableBackground());
        }

        return widgets;
    }
}
