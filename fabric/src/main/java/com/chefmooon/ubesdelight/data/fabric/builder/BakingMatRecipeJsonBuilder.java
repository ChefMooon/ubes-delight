package com.chefmooon.ubesdelight.data.fabric.builder;

import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class BakingMatRecipeJsonBuilder implements RecipeBuilder {
    private final NonNullList<Ingredient> ingredientList = NonNullList.create();
    private final NonNullList<Ingredient> processStages = NonNullList.create();
    private final NonNullList<ChanceResult> resultList = NonNullList.createWithCapacity(4);
    private final Ingredient tool;
    private SoundEvent soundEvent;
    private BakingMatRecipeJsonBuilder(NonNullList<Ingredient> ingredientList, @Nullable NonNullList<Ingredient> processStages, Ingredient tool, ItemLike mainResult, int count, float chance) {
        this.ingredientList.addAll(ingredientList);
        this.processStages.addAll(processStages != null ? processStages : NonNullList.create());
        this.resultList.add(new ChanceResult(new ItemStackTemplate(mainResult.asItem(), count), chance));
        this.tool = tool;
    }

    public static BakingMatRecipeJsonBuilder create(NonNullList<Ingredient> ingredientList, @Nullable NonNullList<Ingredient> processStages, Ingredient tool, ItemLike mainResult) {
        return new BakingMatRecipeJsonBuilder(ingredientList, processStages, tool, mainResult, 1, 1);
    }
    public static BakingMatRecipeJsonBuilder create(NonNullList<Ingredient> ingredientList, @Nullable NonNullList<Ingredient> processStages, Ingredient tool, ItemLike mainResult, int count) {
        return new BakingMatRecipeJsonBuilder(ingredientList, processStages, tool, mainResult, count, 1);
    }
    public BakingMatRecipeJsonBuilder addOutput(Item item) {
        return this.addOutput(item, 1, 1.f);
    }
    public BakingMatRecipeJsonBuilder addOutput(Item item, Integer count, Float chance) {
        this.resultList.add(new ChanceResult(new ItemStackTemplate(item, count), chance));
        return this;
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
    public ResourceKey<Recipe<?>> defaultId() {
        return ResourceKey.create(Registries.RECIPE, getDefaultRecipeID(getResult()));
    }

    public Item getResult() {
        if (!this.resultList.isEmpty()) return this.resultList.get(0).stack().create().getItem();
        return null;
    }

    public static Identifier getDefaultRecipeID(ItemLike itemLike) {
        return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(itemLike.asItem()));
    }

    public void build(RecipeOutput output, String id) {
        ResourceKey<Recipe<?>> resourceKey = ResourceKey.create(Registries.RECIPE, TextUtils.res("baking_mat/" + id));
        this.save(output, resourceKey);
    }

    @Override
    public void save(RecipeOutput output, ResourceKey<Recipe<?>> resourceKey) {
        BakingMatRecipeImpl recipe = new BakingMatRecipeImpl(
                "",
                this.ingredientList,
                this.processStages,
                this.tool,
                this.resultList,
                this.soundEvent == null ? Optional.empty() : Optional.of(this.soundEvent)
        );
        output.accept(resourceKey, recipe, null);
    }
}
