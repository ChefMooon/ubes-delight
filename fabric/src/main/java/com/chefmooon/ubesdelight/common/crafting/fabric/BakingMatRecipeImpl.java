package com.chefmooon.ubesdelight.common.crafting.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import com.chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
import com.chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightRecipeTypesImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.github.fabricators_of_create.porting_lib.transfer.item.RecipeWrapper;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BakingMatRecipeImpl extends BakingMatRecipe implements Recipe<RecipeWrapper> {

    public BakingMatRecipeImpl(ResourceLocation id, String group, NonNullList<Ingredient> ingredientList, NonNullList<Ingredient> processStages, Ingredient tool, NonNullList<ChanceResult> resultList, String soundEvent) {
        super(id, group, ingredientList, processStages, tool, resultList, soundEvent);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.ingredientList;
    }

    public NonNullList<Ingredient> getProcessStages() {
        return this.processStages;
    }

    public NonNullList<Ingredient> getIngredientsAndTool() {
        NonNullList<Ingredient> ingredientTool = NonNullList.create();
        ingredientTool.addAll(this.ingredientList);
        ingredientTool.add(this.tool);
        return this.ingredientList;
    }

    public Ingredient getTool() {
        return this.tool;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return this.resultList.get(0).stack();
    }

    public List<ItemStack> getResultList() {
        return getRollableResults().stream().map(ChanceResult::stack).collect(Collectors.toList());
    }

    public ItemStack getMandatoryResult() {
        return getRollableResults().stream().filter(chanceResult -> chanceResult.chance() == 1).map(ChanceResult::stack).findFirst().get();
    }

    public List<ItemStack> getMandatoryResults() {
        return getRollableResults().stream().filter(chanceResult -> chanceResult.chance() == 1).map(ChanceResult::stack).toList();
    }

    public List<ChanceResult> getVariableResult() {
        return getRollableResults().stream().filter(chanceResult -> chanceResult.chance() != 1).toList();
    }

    public NonNullList<ChanceResult> getRollableResults() {
        return this.resultList;
    }

    public String getSoundEventID() {
        return this.soundEvent;
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level level) {
        boolean inputMatch;
        boolean processMatch = false;

        StackedContents inputList = new StackedContents();
        int i = 0;

        for (int j = 0; j < BakingMatBlockEntity.MAX_INGREDIENTS; j++) {
            ItemStack itemStack = inv.getItem(j);
            if (!itemStack.isEmpty()) {
                i++;
                inputList.accountStack(itemStack);
            }
        }
        inputMatch = (i == ingredientList.size() && inputList.canCraft(this, null));

        if (!inputMatch && processStages.size() > 0 && !inputList.contents.isEmpty()) {
            for (Ingredient ingredient : processStages) {
                if (Arrays.stream(ingredient.getItems()).findFirst().get().is(inv.getItem(0).getItem())) {
                    processMatch = true;
                }
            }
        }

        return inputMatch || processMatch;
    }

    @Override
    public ItemStack assemble(RecipeWrapper container, RegistryAccess registryAccess) {
        return this.resultList.get(0).stack().copy();
    }

    public List<ItemStack> getRollResults(RandomSource rand, int fortuneLevel) {
        List<ItemStack> results = new ArrayList<>();
        List<ChanceResult> rollableResults = getRollableResults();
        for (ChanceResult output : rollableResults) {
            ItemStack stack;
            if (output.chance() == 1) {
                stack = output.rollOutput(rand, fortuneLevel);
            } else {
                stack = output.rollStackOutput(rand, fortuneLevel);
            }
            if (!stack.isEmpty())
                results.add(stack);
        }
        return results;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.ingredientList.size();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return UbesDelightRecipeTypesImpl.BAKING_MAT.get();
    }

    public String getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BakingMatRecipeImpl that = (BakingMatRecipeImpl) o;

        if (!getId().equals(that.getId())) return false;
        if (!getGroup().equals(that.getGroup())) return false;
        if (!ingredientList.equals(that.ingredientList)) return false;
        if (!processStages.equals(that.processStages)) return false;
        if (!getTool().equals(that.getTool())) return false;
        if (!getResultList().equals(that.getResultList())) return false;
        return Objects.equals(soundEvent, that.soundEvent);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getGroup() != null ? getGroup().hashCode() : 0);
        result = 31 * result + ingredientList.hashCode();
        result = 31 * result + processStages.hashCode();
        result = 31 * result + getTool().hashCode();
        result = 31 * result + getResultList().hashCode();
        result = 31 * result + (soundEvent != null ? soundEvent.hashCode() : 0);
        return result;
    }

    public static class Serializer implements RecipeSerializer<BakingMatRecipeImpl> {
        public Serializer() {
        }

        @Override
        public BakingMatRecipeImpl fromJson(ResourceLocation id, JsonObject json) {
            final String group = GsonHelper.getAsString(json, "group", "");
            final NonNullList<Ingredient> ingredientList = readIngredients(GsonHelper.getAsJsonArray(json, "ingredients"));
            final NonNullList<Ingredient> processingStages = readIngredients(GsonHelper.getAsJsonArray(json, "processing_stages"));
            final Ingredient tool = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "tool"));
            if (ingredientList.isEmpty()) {
                throw new JsonParseException("No ingredients for baking recipe");
            } else if (tool.isEmpty()) {
                throw new JsonParseException("No tool for baking recipe");
            } else if (ingredientList.size() > BakingMatBlockEntity.MAX_INGREDIENTS) {
                throw new JsonParseException("Too many ingredients for baking recipe! Max ingredients is " + BakingMatBlockEntity.MAX_INGREDIENTS);
            } else if (processingStages.size() > BakingMatBlockEntity.MAX_PROCESSING_STAGES) {
                throw new JsonParseException("Too many processing stages for baking recipe! Max processing stages is "+ BakingMatBlockEntity.MAX_PROCESSING_STAGES);
            } else {
                final NonNullList<ChanceResult> results = readResults(GsonHelper.getAsJsonArray(json, "result"));
                if (results.size() > BakingMatBlockEntity.MAX_RESULTS) {
                    throw new JsonParseException("Too many results for baking recipe! The maximum quantity of unique results is " + BakingMatBlockEntity.MAX_RESULTS);
                } else {
                    final String soundID = GsonHelper.getAsString(json, "sound", "");
                    return new BakingMatRecipeImpl(id, group, ingredientList, processingStages, tool, results, soundID);
                }
            }
        }

        private static NonNullList<Ingredient> readIngredients(JsonArray ingredientArray) {
            NonNullList<Ingredient> nonnulllist = NonNullList.create();
            for (int i = 0; i < ingredientArray.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(ingredientArray.get(i));
                if (!ingredient.isEmpty()) {
                    nonnulllist.add(ingredient);
                }
            }
            return nonnulllist;
        }

        private static NonNullList<ChanceResult> readResults(JsonArray resultArray) {
            NonNullList<ChanceResult> results = NonNullList.create();
            for (JsonElement result : resultArray) {
                results.add(ChanceResult.deserialize(result));
            }
            return results;
        }

        @Override
        public BakingMatRecipeImpl fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            String groupIn = buf.readUtf(32767);

            NonNullList<Ingredient> ingredientList = NonNullList.withSize(buf.readVarInt(), Ingredient.EMPTY);
            ingredientList.replaceAll(ignored -> Ingredient.fromNetwork(buf));

            NonNullList<Ingredient> processingStagesList = NonNullList.withSize(buf.readVarInt(), Ingredient.EMPTY);
            processingStagesList.replaceAll(ignored -> Ingredient.fromNetwork(buf));

            Ingredient tool = Ingredient.fromNetwork(buf);

            NonNullList<ChanceResult> resultsList = NonNullList.withSize(buf.readVarInt(), ChanceResult.EMPTY);
            resultsList.replaceAll(ignored -> ChanceResult.read(buf));

            String soundID = buf.readUtf();

            return new BakingMatRecipeImpl(id, groupIn, ingredientList, processingStagesList, tool, resultsList, soundID);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, BakingMatRecipeImpl recipe) {
            buf.writeUtf(recipe.group);

            buf.writeVarInt(recipe.ingredientList.size());
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buf);
            }

            buf.writeVarInt(recipe.processStages.size());
            for (Ingredient processingStages : recipe.getProcessStages()) {
                processingStages.toNetwork(buf);
            }

            recipe.tool.toNetwork(buf);

            buf.writeVarInt(recipe.resultList.size());
            for (ChanceResult result : recipe.resultList) {
                result.write(buf);
            }

            buf.writeUtf(recipe.soundEvent);
        }
    }
}
