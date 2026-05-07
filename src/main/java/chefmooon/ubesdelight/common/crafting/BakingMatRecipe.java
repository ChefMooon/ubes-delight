package chefmooon.ubesdelight.common.crafting;

import chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import chefmooon.ubesdelight.common.registry.UbesDelightRecipeSerializers;
import chefmooon.ubesdelight.common.registry.UbesDelightRecipeTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.RecipeMatcher;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

import java.util.*;
import java.util.stream.Collectors;

public class BakingMatRecipe implements Recipe<RecipeWrapper> {
    protected final String group;
    protected final NonNullList<Ingredient> ingredientList;
    protected final NonNullList<Ingredient> processStages;
    protected final Ingredient tool;
    protected final NonNullList<ChanceResult> resultList;
    protected final Optional<SoundEvent> soundEvent;

    public BakingMatRecipe(String group, NonNullList<Ingredient> ingredientList, NonNullList<Ingredient> processStages, Ingredient tool, NonNullList<ChanceResult> resultList, Optional<SoundEvent> soundEvent) {
        this.group = group;
        this.ingredientList = ingredientList;
        this.processStages = processStages;
        this.tool = tool;
        this.resultList = resultList;
        this.soundEvent = soundEvent;
    }

    @Override
    public boolean isSpecial() {
        return true;
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
    public ItemStack getResultItem(HolderLookup.Provider provider) {
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

    public Optional<SoundEvent> getSoundEventID() {
        return this.soundEvent;
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level level) {
        boolean inputMatch;
        boolean processMatch = false;

        List<ItemStack> inputList = new ArrayList<>();
        int i = 0;

        for (int j = 0; j < BakingMatBlockEntity.MAX_INGREDIENTS; j++) {
            ItemStack itemStack = inv.getItem(j);
            if (!itemStack.isEmpty()) {
                i++;
                inputList.add(itemStack);
            }
        }
        inputMatch = (i == ingredientList.size() && RecipeMatcher.findMatches(inputList, ingredientList) != null);

        if (processStages.size() > 0 && inputList.size() > 0) {
            for (Ingredient ingredient : processStages) {
                if (Arrays.stream(ingredient.getItems()).findFirst().get().is(inputList.get(0).getItem())) {
                    processMatch = true;
                }
            }
        }

        return inputMatch || processMatch;
    }

    @Override
    public ItemStack assemble(RecipeWrapper inv, HolderLookup.Provider provider) {
        return this.resultList.get(0).stack().copy();
    }

    public List<ItemStack> getRollResults(RandomSource rand, int fortuneLevel) {
        List<ItemStack> results = new ArrayList<>();
        List<ChanceResult> rollableResults = getRollableResults();
        for (ChanceResult output : rollableResults) {
            ItemStack stack;
            if (output.chance() == 1) {
                stack = output.stack();
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
        return UbesDelightRecipeSerializers.BAKING_MAT.get();
    }

    @Override
    public RecipeType<?> getType() {
        return UbesDelightRecipeTypes.BAKING_MAT.get();
    }

    public Optional<SoundEvent> getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BakingMatRecipe that = (BakingMatRecipe) o;

        if (!getGroup().equals(that.getGroup())) return false;
        if (!ingredientList.equals(that.ingredientList)) return false;
        if (!processStages.equals(that.processStages)) return false;
        if (!getTool().equals(that.getTool())) return false;
        if (!getResultList().equals(that.getResultList())) return false;
        return Objects.equals(soundEvent, that.soundEvent);
    }

    @Override
    public int hashCode() {
        int result = getGroup().hashCode();
        result = 31 * result + ingredientList.hashCode();
        result = 31 * result + processStages.hashCode();
        result = 31 * result + getTool().hashCode();
        result = 31 * result + getResultList().hashCode();
        result = 31 * result + (soundEvent.map(Object::hashCode).orElse(0));
        return result;
    }

    public static class Serializer implements RecipeSerializer<BakingMatRecipe> {
        private static final MapCodec<BakingMatRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.STRING.optionalFieldOf("group", "").forGetter(BakingMatRecipe::getGroup),
                Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap(ingredients -> {
                    if (ingredients.isEmpty()) {
                        return DataResult.error(() -> "No ingredients for baking recipe");
                    }
                    if (ingredients.size() > BakingMatBlockEntity.MAX_INGREDIENTS) {
                        return DataResult.error(() -> "Too many ingredients for baking recipe! Max ingredients is " + BakingMatBlockEntity.MAX_INGREDIENTS);
                    }
                    NonNullList<Ingredient> nonNullList = NonNullList.create();
                    nonNullList.addAll(ingredients);
                    return DataResult.success(nonNullList);
                }, DataResult::success).forGetter(BakingMatRecipe::getIngredients),
                Ingredient.CODEC.listOf().fieldOf("processing_stages").flatXmap(processStages -> {
                    if (processStages.size() > BakingMatBlockEntity.MAX_PROCESSING_STAGES) {
                        return DataResult.error(() -> "Too many processing stages for baking recipe! Max processing stages is "+ BakingMatBlockEntity.MAX_PROCESSING_STAGES);
                    }
                    NonNullList<Ingredient> nonNullList = NonNullList.create();
                    nonNullList.addAll(processStages);
                    return DataResult.success(nonNullList);
                }, DataResult::success).forGetter(BakingMatRecipe::getProcessStages),
                Ingredient.CODEC.fieldOf("tool").forGetter(BakingMatRecipe::getTool),
                Codec.list(ChanceResult.CODEC).fieldOf("result").flatXmap(chanceResults -> {
                    if (chanceResults.size() > BakingMatBlockEntity.MAX_RESULTS) {
                        return DataResult.error(() -> "Too many results for baking recipe! The maximum quantity of unique results is "+ BakingMatBlockEntity.MAX_RESULTS);
                    }
                    NonNullList<ChanceResult> nonNullList = NonNullList.create();
                    nonNullList.addAll(chanceResults);
                    return DataResult.success(nonNullList);
                }, DataResult::success).forGetter(BakingMatRecipe::getRollableResults),
                SoundEvent.DIRECT_CODEC.optionalFieldOf("sound").forGetter(BakingMatRecipe::getSoundEvent)
        ).apply(inst, BakingMatRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, BakingMatRecipe> STREAM_CODEC = StreamCodec.of(BakingMatRecipe.Serializer::toNetwork, BakingMatRecipe.Serializer::fromNetwork);
        public Serializer() {
        }

        @Override
        public MapCodec<BakingMatRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, BakingMatRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        public static BakingMatRecipe fromNetwork(RegistryFriendlyByteBuf buf) {
            String groupIn = buf.readUtf(32767);

            int i = buf.readVarInt();
            NonNullList<Ingredient> ingredientList = NonNullList.withSize(i, Ingredient.EMPTY);
            for (int j = 0; j < ingredientList.size(); ++j) {
                ingredientList.set(j, Ingredient.CONTENTS_STREAM_CODEC.decode(buf));
            }

            int k = buf.readVarInt();
            NonNullList<Ingredient> processingStagesList = NonNullList.withSize(k, Ingredient.EMPTY);
            for (int l = 0; l < processingStagesList.size(); ++l) {
                processingStagesList.set(l, Ingredient.CONTENTS_STREAM_CODEC.decode(buf));
            }

            Ingredient tool = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);

            int m = buf.readVarInt();
            NonNullList<ChanceResult> resultsList = NonNullList.withSize(m, ChanceResult.EMPTY);
            for (int n = 0; n < resultsList.size(); ++n) {
                resultsList.set(n, ChanceResult.read(buf));
            }

            Optional<SoundEvent> soundID = Optional.empty();
            if (buf.readBoolean()) {
                Optional<Holder.Reference<SoundEvent>> holder = BuiltInRegistries.SOUND_EVENT.getHolder(buf.readResourceKey(Registries.SOUND_EVENT));
                if (holder.isPresent() && holder.get().isBound()) {
                    soundID = Optional.of(holder.get().value());
                }
            }

            return new BakingMatRecipe(groupIn, ingredientList, processingStagesList, tool, resultsList, soundID);
        }

        public static void toNetwork(RegistryFriendlyByteBuf buf, BakingMatRecipe recipe) {
            buf.writeUtf(recipe.group);

            buf.writeVarInt(recipe.ingredientList.size());
            for (Ingredient ingredient : recipe.ingredientList) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ingredient);
            }

            buf.writeVarInt(recipe.processStages.size());
            for (Ingredient processingStages : recipe.processStages) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buf, processingStages);
            }

            Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.tool);

            buf.writeVarInt(recipe.resultList.size());
            for (ChanceResult result : recipe.resultList) {
                result.write(buf);
            }

            if (recipe.getSoundEvent().isPresent()) {
                Optional<ResourceKey<SoundEvent>> resourceKey = BuiltInRegistries.SOUND_EVENT.getResourceKey(recipe.getSoundEvent().get());
                resourceKey.ifPresentOrElse(rk -> {
                    buf.writeBoolean(true);
                    buf.writeResourceKey(rk);
                }, () -> buf.writeBoolean(false));
            } else {
                buf.writeBoolean(false);
            }
        }
    }
}
