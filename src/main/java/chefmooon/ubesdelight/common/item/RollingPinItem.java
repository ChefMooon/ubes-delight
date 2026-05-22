package chefmooon.ubesdelight.common.item;

import chefmooon.ubesdelight.common.utility.TextUtils;
import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.Set;

public class RollingPinItem extends Item {
    public static final Set<ResourceKey<Enchantment>> ALLOWED_ENCHANTMENTS = Sets.newHashSet(Enchantments.UNBREAKING, Enchantments.MENDING, Enchantments.FORTUNE);
    public static final Set<ResourceKey<Enchantment>> DENIED_ENCHANTMENTS = Sets.newHashSet(Enchantments.EFFICIENCY);
    public RollingPinItem(Properties properties) {
        super(properties);
    }

    public static ItemAttributeModifiers createAttributes(ToolMaterial toolMaterial, float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, attackDamage + toolMaterial.attackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(TextUtils.res("base_attack_knockback"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }
}
