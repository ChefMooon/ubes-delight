package com.chefmooon.ubesdelight.common.crafting.ingredient;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;

/**
 * Credits to the Create team for the implementation of results with chances!
 */
public record ChanceResult(ItemStack stack, float chance) {
    public static final ChanceResult EMPTY = new ChanceResult(ItemStack.EMPTY, 1);
    public static final Codec<ChanceResult> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            ItemStack.CODEC.fieldOf("item").forGetter(ChanceResult::stack),
            Codec.FLOAT.optionalFieldOf("chance", 1.0f).forGetter(ChanceResult::chance)
    ).apply(inst, ChanceResult::new));

    public ItemStack rollOutput(RandomSource rand, int fortuneLevel) {
        int outputAmount = stack.getCount();
        double fortuneBonus = 0.1 * fortuneLevel;
        for (int roll = 0; roll < stack.getCount(); roll++)
            if (rand.nextFloat() > chance + fortuneBonus)
                outputAmount--;
        if (outputAmount == 0)
            return ItemStack.EMPTY;
        ItemStack out = stack.copy();
        out.setCount(outputAmount);
        return out;
    }

    // This method rolls 1 time, and returns the stack amount if the roll succeeds instead of multiple rolls
    public ItemStack rollStackOutput(RandomSource rand, int fortuneLevel) {
        int outputAmount = stack.getCount();
        double fortuneBonus = 0.1 * fortuneLevel;
        if (rand.nextFloat() > chance + fortuneBonus) return new ItemStack(stack.copy().getItem(), outputAmount);
        return ItemStack.EMPTY;
    }

    public void write(RegistryFriendlyByteBuf buf) {
        ItemStack.STREAM_CODEC.encode(buf, stack());
        buf.writeFloat(chance());
    }

    public static ChanceResult read(RegistryFriendlyByteBuf buf) {
        return new ChanceResult(ItemStack.STREAM_CODEC.decode(buf), buf.readFloat());
    }
}
