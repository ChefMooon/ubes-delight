package chefmooon.ubesdelight.common.crafting.ingredient;

import chefmooon.ubesdelight.common.Configuration;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;

/**
 * Credits to the Create team for the implementation of results with chances!
 */
public record ChanceResult(ItemStackTemplate stack, float chance) {
    public static final ChanceResult EMPTY = new ChanceResult(null, 1);
    public static final Codec<ChanceResult> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            ItemStackTemplate.CODEC.fieldOf("item").forGetter(ChanceResult::stack),
            Codec.FLOAT.optionalFieldOf("chance", 1.0f).forGetter(ChanceResult::chance)
    ).apply(inst, ChanceResult::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, ChanceResult> STREAM_CODEC = StreamCodec.composite(
            ItemStackTemplate.STREAM_CODEC, ChanceResult::stack,
            ByteBufCodecs.FLOAT, ChanceResult::chance,
            ChanceResult::new
    );

    public ItemStack rollOutput(RandomSource rand, int fortuneLevel) {
        int outputAmount = stack.count();
        double fortuneBonus = Configuration.bakingMatFortuneBonus() * fortuneLevel;
        for (int roll = 0; roll < stack.count(); roll++)
            if (rand.nextFloat() > chance + fortuneBonus)
                outputAmount--;
        if (outputAmount == 0)
            return ItemStack.EMPTY;
        ItemStack out = stack.create().copy();
        out.setCount(outputAmount);
        return out;
    }

    // This method rolls 1 time, and returns the stack amount if the roll succeeds instead of multiple rolls
    public ItemStack rollStackOutput(RandomSource rand, int fortuneLevel) {
        int outputAmount = stack.count();
        double fortuneBonus = Configuration.bakingMatFortuneBonus() * fortuneLevel;
        if (rand.nextFloat() < chance + fortuneBonus) return new ItemStack(stack.create().copy().getItem(), outputAmount);
        return ItemStack.EMPTY;
    }
}
