package com.chefmoon.ubesdelight.recipe;

import com.chefmoon.ubesdelight.block.entity.BakingMatBlockEntity;
import com.chefmoon.ubesdelight.recipe.ingredient.ChanceResult;
import com.chefmoon.ubesdelight.registry.RecipeTypesRegistry;
import com.nhoryzon.mc.farmersdelight.util.RecipeMatcher;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BakingMatRecipe implements Recipe<Inventory> {
    private final Identifier id;
    private final String group;
    private final DefaultedList<Ingredient> ingredientList;
    private final DefaultedList<Ingredient> processStages;
    private final Ingredient tool;
    private final DefaultedList<ChanceResult> resultList;
    private final String soundEvent;

    public BakingMatRecipe(Identifier id, String group, DefaultedList<Ingredient> ingredientList, DefaultedList<Ingredient> processStages, Ingredient tool, DefaultedList<ChanceResult> resultList, String soundEvent) {
        this.id = id;
        this.group = group;
        this.ingredientList = ingredientList;
        this.processStages = processStages;
        this.tool = tool;
        this.resultList = resultList;
        this.soundEvent = soundEvent;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        Boolean inputMatch;
        Boolean processMatch = false;

        List<ItemStack> inputList = new ArrayList<>();
        int inputSlotCount = 0;
        
        for (int slotOffset = 0; slotOffset < BakingMatBlockEntity.MAX_INGREDIENTS; ++slotOffset) {
            ItemStack itemStack = inventory.getStack(slotOffset);
            if (!itemStack.isEmpty()) {
                ++inputSlotCount;
                inputList.add(itemStack);
            }
        }
        inputMatch = (inputSlotCount == ingredientList.size() && RecipeMatcher.findMatches(inputList, ingredientList) != null);

        for (Ingredient ingredient : processStages) {
            if (Arrays.stream(ingredient.getMatchingStacks()).findFirst().get().isOf(inputList.get(0).getItem())) {
                processMatch = true;
            }
        }

        return inputMatch || processMatch;
    }

    @Override
    public ItemStack craft(Inventory inventory, DynamicRegistryManager registryManager) {
        return resultList.get(0).stack().copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= ingredientList.size();
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return resultList.get(0).stack();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypesRegistry.BAKING_MAT_RECIPE_SERIALIZER.serializer();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeTypesRegistry.BAKING_MAT_RECIPE_SERIALIZER.type();
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return ingredientList;
    }

    public DefaultedList<Ingredient> getProcessStages() {
        return processStages;
    }

    public DefaultedList<Ingredient> getIngredientsAndTool() {
        DefaultedList<Ingredient> ingredientTool = DefaultedList.of();
        for (Ingredient ingredient : ingredientList) {
            ingredientTool.add(ingredient);
        }
        ingredientTool.add(tool);

        return ingredientTool;
    }

    public List<ItemStack> getResultList() {
        return getRollableResults().stream().map(ChanceResult::stack).collect(Collectors.toList());
    }

    public List<ItemStack> getMandatoryResult() {
        return getRollableResults().stream().filter(chanceResult -> chanceResult.chance() == 1).map(ChanceResult::stack).toList();
    }

    public List<ChanceResult> getVariableResult() {
        return getRollableResults().stream().filter(chanceResult -> chanceResult.chance() != 1).toList();
    }

    public DefaultedList<ChanceResult> getRollableResults() {
        return resultList;
    }

    public List<ItemStack> getRolledResults(Random rand, int fortuneLevel) {
        List<ItemStack> results = new ArrayList<>();
        getRollableResults().forEach(chanceResult -> {
            ItemStack stack = chanceResult.rollOutput(rand, fortuneLevel);
            if (!stack.isEmpty()) {
                results.add(stack);
            }
        });

        return results;
    }

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public boolean isIgnoredInRecipeBook() {
        return true;
    }

    public Ingredient getTool() {
        return tool;
    }

    public String getSoundEvent() {
        return soundEvent;
    }
}
