package com.chefmooon.ubesdelight.common.item;

import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Set;
import java.util.UUID;

public class RollingPinItem extends DiggerItem {
    public static final Set<Enchantment> ALLOWED_ENCHANTMENTS = Sets.newHashSet(Enchantments.UNBREAKING, Enchantments.MENDING, Enchantments.BLOCK_FORTUNE);
    public static final Set<Enchantment> DENIED_ENCHANTMENTS = Sets.newHashSet(Enchantments.BLOCK_EFFICIENCY);
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    public RollingPinItem(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
        super(attackDamageModifier, attackSpeedModifier, tier, CommonTags.C_MINEABLE_ROLLING_PIN, properties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(UUID.fromString("e56350e0-8756-464d-92f9-54289ab41e0a"), "Tool modifier", 1.2, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, (user) -> user.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
    }
}
