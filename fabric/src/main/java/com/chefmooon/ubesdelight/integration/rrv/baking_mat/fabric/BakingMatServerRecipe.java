package com.chefmooon.ubesdelight.integration.rrv.baking_mat.fabric;

import cc.cassian.rrv.api.TagUtil;
import cc.cassian.rrv.api.recipe.ReliableServerRecipe;
import cc.cassian.rrv.api.recipe.ReliableServerRecipeType;
import com.chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class BakingMatServerRecipe implements ReliableServerRecipe {
    public static final ReliableServerRecipeType<BakingMatServerRecipe> TYPE = ReliableServerRecipeType.register(
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
        compoundTag.put("inputs", TagUtil.writeList(this.inputs, (origin, tag) -> TagUtil.writeIngredient(origin)));
        compoundTag.put("tool", TagUtil.writeIngredient(this.toolInput));
        compoundTag.put("processing_stages", TagUtil.writeList(this.processStages, (origin, tag) -> TagUtil.writeIngredient(origin)));
        compoundTag.put("mandatory_outputs", TagUtil.writeList(this.mandatoryOutputs, (origin, tag) -> TagUtil.encodeItemStackOnServer(origin)));
        compoundTag.put("chance_outputs", encodeRollableResult(this.chanceOutputs));
    }

    @Override
    public void loadFromTag(CompoundTag compoundTag) {
        this.inputs = TagUtil.readList(compoundTag, "inputs", TagUtil::readIngredient);
        this.toolInput = TagUtil.readIngredient(compoundTag.getCompound("tool").orElseGet(CompoundTag::new));
        this.processStages = TagUtil.readList(compoundTag, "processing_stages", TagUtil::readIngredient);
        this.mandatoryOutputs = TagUtil.readList(compoundTag, "mandatory_outputs", TagUtil::decodeItemStackOnClient);
        this.chanceOutputs = decodeRollableResult(compoundTag.get("chance_outputs"));
    }

    // Adapted from Farmer's Delight Refabricated (EIV Integration) 2025-11-20
    // Further adapted to RRV 2026-01-20. Thank you devs <3
    private static ListTag encodeRollableResult(List<ChanceResult> rollableResults) {
        ListTag listTag = new ListTag();
        for (ChanceResult rollableResult : rollableResults) {
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.put("item", TagUtil.encodeItemStackOnServer(rollableResult.stack()));
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
                var stack = TagUtil.decodeItemStackOnClient(compoundTag.getCompoundOrEmpty("item"));
                var chance = compoundTag.getFloatOr("chance", 1);
                ChanceResult chanceResult = new ChanceResult(stack, chance);
                list.add(chanceResult);
            }
        }
        return list;
    }

    @Override
    public ReliableServerRecipeType<? extends ReliableServerRecipe> getRecipeType() {
        return TYPE;
    }
}
