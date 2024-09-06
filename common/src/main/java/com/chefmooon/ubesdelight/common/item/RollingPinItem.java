package com.chefmooon.ubesdelight.common.item;

import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
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

public class RollingPinItem extends DiggerItem {
    public static final Set<ResourceKey<Enchantment>> ALLOWED_ENCHANTMENTS = Sets.newHashSet(Enchantments.UNBREAKING, Enchantments.MENDING, Enchantments.FORTUNE);
    public static final Set<ResourceKey<Enchantment>> DENIED_ENCHANTMENTS = Sets.newHashSet(Enchantments.EFFICIENCY);
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    public RollingPinItem(Tier tier, Properties properties) {
        super(tier, CommonTags.C_MINEABLE_ROLLING_PIN, properties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_KNOCKBACK.value(), new AttributeModifier(TextUtils.res("base_attack_knockback"), 1.2, AttributeModifier.Operation.ADD_VALUE));
        this.defaultModifiers = builder.build();
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }
}
