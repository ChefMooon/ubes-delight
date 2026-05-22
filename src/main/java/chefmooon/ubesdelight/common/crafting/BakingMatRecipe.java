package chefmooon.ubesdelight.common.crafting;

import chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import chefmooon.ubesdelight.common.registry.UbesDelightRecipeBookCategories;
import chefmooon.ubesdelight.common.registry.UbesDelightRecipeSerializers;
import chefmooon.ubesdelight.common.registry.UbesDelightRecipeTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.refabricated.inventory.RecipeWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class BakingMatRecipe implements Recipe<RecipeWrapper> {

    protected final String group;
    protected final List<Ingredient> ingredientList;
    protected final List<Ingredient> processStages;
    protected final Ingredient tool;
    protected final List<ChanceResult> resultList;
    protected final Optional<SoundEvent> soundEvent;

    protected PlacementInfo placementInfo;

    public BakingMatRecipe(String group, List<Ingredient> ingredientList, List<Ingredient> processStages, Ingredient tool, List<ChanceResult> resultList, Optional<SoundEvent> soundEvent) {
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
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return this.group;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredientList;
    }

    public List<Ingredient> getProcessStages() {
        return this.processStages;
    }

    public List<Ingredient> getIngredientsAndTool() {
        NonNullList<Ingredient> ingredientTool = NonNullList.create();
        ingredientTool.addAll(this.ingredientList);
        ingredientTool.add(this.tool);
        return this.ingredientList;
    }

    public Ingredient getTool() {
        return this.tool;
    }

    public List<ItemStackTemplate> getResultList() {
        return getRollableResults().stream().map(ChanceResult::stack).collect(Collectors.toList());
    }

    public ItemStackTemplate getMandatoryResult() {
        return getRollableResults().stream().filter(chanceResult -> chanceResult.chance() == 1).map(ChanceResult::stack).findFirst().get();
    }

    public List<ItemStackTemplate> getMandatoryResults() {
        return getRollableResults().stream().filter(chanceResult -> chanceResult.chance() == 1).map(ChanceResult::stack).toList();
    }

    public List<ChanceResult> getVariableResult() {
        return getRollableResults().stream().filter(chanceResult -> chanceResult.chance() != 1).toList();
    }

    public List<ChanceResult> getRollableResults() {
        return this.resultList;
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level level) {
        boolean inputMatch;
        boolean processMatch = false;

        // inv.ingredientAmount() does not return the correct amount of ingredients? below is a workaround
        StackedItemContents inputList = new StackedItemContents();
        int i = 0;

        for (int j = 0; j < BakingMatBlockEntity.MAX_INGREDIENTS; j++) {
            ItemStack itemStack = inv.getItem(j);
            if (!itemStack.isEmpty()) {
                i++;
                inputList.accountStack(itemStack, 1);
            }
        }
        inputMatch = (i == this.ingredientList.size() && inputList.canCraft(this, null));

        if (!inputMatch && !processStages.isEmpty() && !inv.isEmpty()) {
            for (Ingredient ingredient : processStages) {
                if (ingredient.test(inv.getItem(0))) {
                    processMatch = true;
                }
            }
        }

        return inputMatch || processMatch;
    }

    @Override
    public ItemStack assemble(RecipeWrapper inv) {
        return this.resultList.get(0).stack().create().copy();
    }

    public List<ItemStack> getRollResults(RandomSource rand, int fortuneLevel) {
        List<ItemStack> results = new ArrayList<>();
        List<ChanceResult> rollableResults = getRollableResults();
        for (ChanceResult output : rollableResults) {
            ItemStack stack;
            if (output.chance() == 1) {
                stack = output.stack().create();
            } else {
                stack = output.rollStackOutput(rand, fortuneLevel);
            }
            if (!stack.isEmpty())
                results.add(stack);
        }
        return results;
    }

    @Override
    public RecipeSerializer<? extends Recipe<RecipeWrapper>> getSerializer() {
        return UbesDelightRecipeSerializers.BAKING_MAT.get();
    }

    @Override
    public RecipeType<? extends Recipe<RecipeWrapper>> getType() {
        return UbesDelightRecipeTypes.BAKING_MAT.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        if (placementInfo == null) {
            placementInfo = PlacementInfo.create(ingredientList);
        }
        return placementInfo;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return UbesDelightRecipeBookCategories.BAKING_MAT.get();
    }

    public Optional<SoundEvent> getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BakingMatRecipe that = (BakingMatRecipe) o;

        if (!group().equals(that.group())) return false;
        if (!ingredientList.equals(that.ingredientList)) return false;
        if (!processStages.equals(that.processStages)) return false;
        if (!getTool().equals(that.getTool())) return false;
        if (!getResultList().equals(that.getResultList())) return false;
        return Objects.equals(soundEvent, that.soundEvent);
    }

    @Override
    public int hashCode() {
        int result = group().hashCode();
        result = 31 * result + ingredientList.hashCode();
        result = 31 * result + processStages.hashCode();
        result = 31 * result + getTool().hashCode();
        result = 31 * result + getResultList().hashCode();
        result = 31 * result + (soundEvent.map(Objects::hashCode).orElse(0));
        return result;
    }

//    public static class Serializer implements RecipeSerializer<BakingMatRecipe> {
    public static class Serializer {
        private static final MapCodec<BakingMatRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.STRING.optionalFieldOf("group", "").forGetter(BakingMatRecipe::group),
                Ingredient.CODEC.listOf(1, BakingMatBlockEntity.MAX_INGREDIENTS).fieldOf("ingredients").forGetter(BakingMatRecipe::getIngredients),
                Ingredient.CODEC.listOf(0, BakingMatBlockEntity.MAX_PROCESSING_STAGES).fieldOf("processing_stages").forGetter(BakingMatRecipe::getProcessStages),
                Ingredient.CODEC.fieldOf("tool").forGetter(BakingMatRecipe::getTool),
                Codec.list(ChanceResult.CODEC).fieldOf("result").forGetter(BakingMatRecipe::getRollableResults),
                SoundEvent.DIRECT_CODEC.optionalFieldOf("sound").forGetter(BakingMatRecipe::getSoundEvent)
        ).apply(inst, BakingMatRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, BakingMatRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        public Serializer() {
        }

        public static MapCodec<BakingMatRecipe> codec() {
            return CODEC;
        }

        public static StreamCodec<RegistryFriendlyByteBuf, BakingMatRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        public static BakingMatRecipe fromNetwork(RegistryFriendlyByteBuf buf) {
            String groupIn = buf.readUtf(32767);

            List<Ingredient> ingredientList = Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list(BakingMatBlockEntity.MAX_INGREDIENTS)).decode(buf);
            List<Ingredient> processingStagesList = Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list(BakingMatBlockEntity.MAX_PROCESSING_STAGES)).decode(buf);
            Ingredient tool = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
            List<ChanceResult> resultsList = ChanceResult.STREAM_CODEC.apply(ByteBufCodecs.list( BakingMatBlockEntity.MAX_RESULTS)).decode(buf);
            Optional<SoundEvent> soundID = ByteBufCodecs.optional(ByteBufCodecs.registry(Registries.SOUND_EVENT)).decode(buf);

            return new BakingMatRecipe(groupIn, ingredientList, processingStagesList, tool, resultsList, soundID);
        }

        public static void toNetwork(RegistryFriendlyByteBuf buf, BakingMatRecipe recipe) {
            buf.writeUtf(recipe.group);
            Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list(BakingMatBlockEntity.MAX_INGREDIENTS)).encode(buf, recipe.ingredientList);
            Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list(BakingMatBlockEntity.MAX_PROCESSING_STAGES)).encode(buf, recipe.processStages);
            Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.tool);
            ChanceResult.STREAM_CODEC.apply(ByteBufCodecs.list(BakingMatBlockEntity.MAX_RESULTS)).encode(buf, recipe.resultList);
            ByteBufCodecs.optional(ByteBufCodecs.registry(Registries.SOUND_EVENT)).encode(buf, recipe.getSoundEvent());
        }
    }
}
