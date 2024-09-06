package com.chefmooon.ubesdelight.data.fabric.builder;

import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class BakingMatRecipeJsonBuilder implements RecipeBuilder {
    private final NonNullList<Ingredient> ingredientList = NonNullList.create();
    private final NonNullList<Ingredient> processStages = NonNullList.create();
    private final NonNullList<ChanceResult> resultList = NonNullList.createWithCapacity(4);
    private final Ingredient tool;
    private SoundEvent soundEvent;
    private BakingMatRecipeJsonBuilder(NonNullList<Ingredient> ingredientList, @Nullable NonNullList<Ingredient> processStages, Ingredient tool, ItemStack mainResult, int count, float chance) {
        this.ingredientList.addAll(ingredientList);
        this.processStages.addAll(processStages != null ? processStages : NonNullList.create());
        this.resultList.add(new ChanceResult(new ItemStack(mainResult.getItem(), count), chance));
        this.tool = tool;
    }

    public static BakingMatRecipeJsonBuilder create(NonNullList<Ingredient> ingredientList, @Nullable NonNullList<Ingredient> processStages, Ingredient tool, Item mainResult) {
        return new BakingMatRecipeJsonBuilder(ingredientList, processStages, tool, new ItemStack(mainResult), 1, 1);
    }
    public static BakingMatRecipeJsonBuilder create(NonNullList<Ingredient> ingredientList, @Nullable NonNullList<Ingredient> processStages, Ingredient tool, Item mainResult, int count) {
        return new BakingMatRecipeJsonBuilder(ingredientList, processStages, tool, new ItemStack(mainResult), count, 1);
    }
    public BakingMatRecipeJsonBuilder addOutput(Item item) {
        return this.addOutput(item, 1, 1.f);
    }
    public BakingMatRecipeJsonBuilder addOutput(Item item, Integer count, Float chance) {
        this.resultList.add(new ChanceResult(new ItemStack(item, count), chance));
        return this;
    }
    public BakingMatRecipeJsonBuilder input(TagKey<Item> tag) {
        return this.input(Ingredient.of(tag));
    }
    public BakingMatRecipeJsonBuilder input(TagKey<Item> tag, int size) {
        return this.input(Ingredient.of(tag), size);
    }
    public BakingMatRecipeJsonBuilder input(ItemLike itemProvider) {
        return this.input(Ingredient.of(itemProvider));
    }
    public BakingMatRecipeJsonBuilder input(ItemLike itemProvider, int size) {
        return this.input(Ingredient.of(itemProvider), size);
    }

    public BakingMatRecipeJsonBuilder input(Ingredient ingredient) {
        return this.input((Ingredient) ingredient, 1);
    }

    public BakingMatRecipeJsonBuilder input(Ingredient ingredient, int size) {
        for(int i = 0; i < size; ++i) {
            this.ingredientList.add(ingredient);
        }
        return this;
    }

    public BakingMatRecipeJsonBuilder addSound(SoundEvent soundEvent) {
        this.soundEvent = soundEvent;
        return this;
    }
    @Override
    public RecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String groupName) {
        return null;
    }

    @Override
    public Item getResult() {
        if (!this.resultList.isEmpty()) return this.resultList.get(0).stack().getItem();
        return null;
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        BakingMatRecipeImpl recipe = new BakingMatRecipeImpl(
                "",
                this.ingredientList,
                this.processStages,
                this.tool,
                this.resultList,
                this.soundEvent == null ? Optional.empty() : Optional.of(this.soundEvent)
        );
        output.accept(id.withPrefix("baking_mat/"), recipe, null);
    }
}
