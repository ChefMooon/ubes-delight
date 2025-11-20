package com.chefmooon.ubesdelight.integration.eiv.baking_mat.fabric;

import com.chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import de.crafty.eiv.common.api.recipe.EivRecipeType;
import de.crafty.eiv.common.api.recipe.IEivServerRecipe;
import de.crafty.eiv.common.recipe.util.EivTagUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class BakingMatServerRecipe implements IEivServerRecipe {
    public static final EivRecipeType<BakingMatServerRecipe> TYPE = EivRecipeType.register(
            TextUtils.res("baking_mat"),
            () -> new BakingMatServerRecipe(null, null, null, null, null)
    );

    private List<Ingredient> inputs;
    private Ingredient toolInput;
    private List<ChanceResult> chanceOutputs;
    private List<ItemStack> mandatoryOutputs;
    private List<Ingredient> processStages;

    public BakingMatServerRecipe(List<Ingredient> inputs, Ingredient tool, List<Ingredient> processStages, List<ItemStack> mandatoryOutputs, List<ChanceResult> chanceOutputs) {
        this.inputs = inputs;
        this.toolInput = tool;
        this.chanceOutputs = chanceOutputs;
        this.mandatoryOutputs = mandatoryOutputs;
        this.processStages = processStages;
    }

    public List<Ingredient> getInputs() {
        return inputs;
    }

    public Ingredient getToolInput() {
        return toolInput;
    }

    public List<ChanceResult> getChanceOutputs() {
        return chanceOutputs;
    }

    public List<ItemStack> getMandatoryOutputs() {
        return mandatoryOutputs;
    }

    public List<Ingredient> getProcessStages() {
        return processStages;
    }

    @Override
    public void writeToTag(CompoundTag compoundTag) {
        compoundTag.put("inputs", EivTagUtil.writeList(this.inputs, (origin, tag) -> EivTagUtil.writeIngredient(origin)));
        compoundTag.put("tool", EivTagUtil.writeIngredient(this.toolInput));
        compoundTag.put("processing_stages", EivTagUtil.writeList(this.processStages, (origin, tag) -> EivTagUtil.writeIngredient(origin)));
        compoundTag.put("mandatory_outputs", EivTagUtil.writeList(this.mandatoryOutputs, (origin, tag) -> EivTagUtil.encodeItemStack(origin)));
        compoundTag.put("chance_outputs", encodeRollableResult(this.chanceOutputs));
    }

    @Override
    public void loadFromTag(CompoundTag compoundTag) {
        this.inputs = EivTagUtil.readList(compoundTag, "inputs", EivTagUtil::readIngredient);
        this.toolInput = EivTagUtil.readIngredient(compoundTag.getCompound("tool").orElseGet(CompoundTag::new));
        this.processStages = EivTagUtil.readList(compoundTag, "processing_stages", EivTagUtil::readIngredient);
        this.mandatoryOutputs = EivTagUtil.readList(compoundTag, "mandatory_outputs", EivTagUtil::decodeItemStack);
        this.chanceOutputs = decodeRollableResult(compoundTag.get("chance_outputs"));
    }

    // Adapted from Farmer's Delight Refabricated (EIV Integration) 2025-11-20
    private static ListTag encodeRollableResult(List<ChanceResult> rollableResults) {
        ListTag listTag = new ListTag();
        for (ChanceResult rollableResult : rollableResults) {
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.put("item", EivTagUtil.encodeItemStack(rollableResult.stack()));
            compoundTag.putFloat("chance", rollableResult.chance());
            listTag.add(compoundTag);
        }
        return listTag;
    }

    private static List<ChanceResult> decodeRollableResult(Tag providedTag) {
        List<ChanceResult> list = new ArrayList<>();
        if (providedTag instanceof ListTag listTag) {
            for (Tag tag : listTag) {
                CompoundTag compoundTag = tag.asCompound().orElseGet(CompoundTag::new);
                var stack = EivTagUtil.decodeItemStack(compoundTag.getCompoundOrEmpty("item"));
                var chance = compoundTag.getFloatOr("chance", 1);
                ChanceResult chanceResult = new ChanceResult(stack, chance);
                list.add(chanceResult);
            }
        }
        return list;
    }

    @Override
    public EivRecipeType<? extends IEivServerRecipe> getRecipeType() {
        return TYPE;
    }
}
