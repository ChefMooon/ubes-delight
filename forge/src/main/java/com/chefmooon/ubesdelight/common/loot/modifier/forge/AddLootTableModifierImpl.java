package com.chefmooon.ubesdelight.common.loot.modifier.forge;

import com.chefmooon.ubesdelight.common.Configuration;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class AddLootTableModifierImpl extends LootModifier {
    public static final Supplier<Codec<AddLootTableModifierImpl>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> LootModifier.codecStart(inst)
                    .and(ResourceLocation.CODEC.fieldOf("lootTable").forGetter((m) -> m.lootTable))
                    .apply(inst, AddLootTableModifierImpl::new)));

    private final ResourceLocation lootTable;

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    protected AddLootTableModifierImpl(LootItemCondition[] conditionsIn, ResourceLocation lootTable) {
        super(conditionsIn);
        this.lootTable = lootTable;
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (Configuration.generateUDChestLoot()) {
            LootTable extraTable = context.getResolver().getLootTable(this.lootTable);
            extraTable.getRandomItemsRaw(context, LootTable.createStackSplitter(context.getLevel(), generatedLoot::add));
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
