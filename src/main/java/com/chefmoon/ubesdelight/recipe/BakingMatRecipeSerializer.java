package com.chefmoon.ubesdelight.recipe;

import com.chefmoon.ubesdelight.block.entity.BakingMatBlockEntity;
import com.chefmoon.ubesdelight.recipe.ingredient.ChanceResult;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;

public class BakingMatRecipeSerializer implements RecipeSerializer<BakingMatRecipe> {

    @Override
    public BakingMatRecipe read(Identifier id, JsonObject json) {
        final String group = JsonHelper.getString(json, "group", "");
        final DefaultedList<Ingredient> ingredientList = readIngredients(JsonHelper.getArray(json, "ingredients"));
        final DefaultedList<Ingredient> processingStages = readProcessingStages(JsonHelper.getArray(json, "processing_stages"));
        final Ingredient tool = Ingredient.fromJson(JsonHelper.getObject(json, "tool"));
        if (ingredientList.isEmpty()) {
            throw new JsonParseException("No ingredients for baking recipe");
        } else if (tool.isEmpty()) {
            throw new JsonParseException("No tool for baking recipe");
        } else if (ingredientList.size() > BakingMatBlockEntity.MAX_INGREDIENTS) {
            throw new JsonParseException("Too many ingredients for baking recipe! Max ingredients is " + BakingMatBlockEntity.MAX_INGREDIENTS);
        } else if (processingStages.size() > BakingMatBlockEntity.MAX_PROCESSING_STAGES) {
            throw new JsonParseException("Too many processing stages for baking recipe! Max processing stages is "+ BakingMatBlockEntity.MAX_PROCESSING_STAGES);
        } else {
            final DefaultedList<ChanceResult> resultList = readResultList(JsonHelper.getArray(json, "result"));
            if (resultList.size() > BakingMatBlockEntity.MAX_RESULTS) {
                throw new JsonParseException("Too many results for baking recipe! The maximum quantity of unique results is " + BakingMatBlockEntity.MAX_RESULTS);
            } else {
                final String soundId = JsonHelper.getString(json, "sound", "");
                return new BakingMatRecipe(id, group, ingredientList, processingStages, tool, resultList, soundId);
            }
        }
    }

    @Override
    public BakingMatRecipe read(Identifier id, PacketByteBuf buf) {
        String groupIn = buf.readString(32767);

        DefaultedList<Ingredient> ingredientList = DefaultedList.ofSize(buf.readVarInt(), Ingredient.EMPTY);
        ingredientList.replaceAll(ignored -> Ingredient.fromPacket(buf));

        DefaultedList<Ingredient> processingStagesList = DefaultedList.ofSize(buf.readVarInt(), Ingredient.EMPTY);
        processingStagesList.replaceAll(ignored -> Ingredient.fromPacket(buf));

        Ingredient tool = Ingredient.fromPacket(buf);

        DefaultedList<ChanceResult> resultList = DefaultedList.ofSize(buf.readVarInt(), ChanceResult.EMPTY);
        resultList.replaceAll(ignored -> ChanceResult.read(buf));

        String soundId = buf.readString();

        return new BakingMatRecipe(id, groupIn, ingredientList, processingStagesList, tool, resultList, soundId);
    }

    @Override
    public void write(PacketByteBuf buf, BakingMatRecipe recipe) {
        buf.writeString(recipe.getGroup());
        buf.writeVarInt(recipe.getIngredients().size());

        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.write(buf);
        }

        buf.writeVarInt(recipe.getProcessStages().size());
        for (Ingredient processingStages : recipe.getProcessStages()) {
            processingStages.write(buf);
        }

        recipe.getTool().write(buf);

        buf.writeVarInt(recipe.getRollableResults().size());
        for (ChanceResult result : recipe.getRollableResults()) {
            result.write(buf);
        }

        buf.writeString(recipe.getSoundEvent());
    }

    private static DefaultedList<Ingredient> readIngredients(JsonArray ingredientArray) {
        DefaultedList<Ingredient> ingredientList = DefaultedList.of();

        for (JsonElement ingredientJson : ingredientArray) {
            Ingredient ingredient = Ingredient.fromJson(ingredientJson);
            if (!ingredient.isEmpty()) {
                ingredientList.add(ingredient);
            }
        }

        return ingredientList;
    }

    private static DefaultedList<Ingredient> readProcessingStages(JsonArray processStagesArray) {
        DefaultedList<Ingredient> processingStageList = DefaultedList.of();

        for (JsonElement ingredientJson : processStagesArray) {
            Ingredient ingredient = Ingredient.fromJson(ingredientJson);
            if (!ingredient.isEmpty()) {
                processingStageList.add(ingredient);
            }
        }

        return processingStageList;
    }

    private static DefaultedList<ChanceResult> readResultList(JsonArray resultArray) {
        DefaultedList<ChanceResult> resultList = DefaultedList.of();

        for (JsonElement resultJson : resultArray) {
            resultList.add(ChanceResult.deserialize(resultJson));
        }

        return resultList;
    }
}
