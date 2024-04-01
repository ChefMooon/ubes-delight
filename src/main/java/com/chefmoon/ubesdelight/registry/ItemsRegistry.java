package com.chefmoon.ubesdelight.registry;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.item.*;
import com.chefmoon.ubesdelight.item.enumeration.FoodItem;
import com.chefmoon.ubesdelight.item.enumeration.UDToolMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;


public enum ItemsRegistry {

    //Heat Source
    KALAN("kalan", () -> new UDBlockItem(BlocksRegistry.KALAN.get(),base())),
    BAKING_MAT_BAMBOO("baking_mat_bamboo", () -> new UDBlockItem(BlocksRegistry.BAKING_MAT_BAMBOO.get(), base()), 200, null),
    ROLLING_PIN_WOOD("rolling_pin_wood", () -> new RollingPinItem(UDToolMaterials.RP_WOOD, base())),

    //Wild Vegetables
    WILD_UBE("wild_ube", () -> new UDBlockItem(BlocksRegistry.WILD_UBE.get()), null, .65f),
    WILD_GARLIC("wild_garlic", () -> new UDBlockItem(BlocksRegistry.WILD_GARLIC.get()), null, .65f),
    WILD_GINGER("wild_ginger", () -> new UDBlockItem(BlocksRegistry.WILD_GINGER.get()), null, .65f),
    WILD_LEMONGRASS("wild_lemongrass", () -> new UDBlockItem(BlocksRegistry.WILD_LEMONGRASS.get()), null, .65f),

    //Vegetable Crates
    UBE_CRATE("ube_crate", () -> new UDBlockItem((BlocksRegistry.UBE_CRATE.get()))),
    GARLIC_CRATE("garlic_crate", () -> new UDBlockItem((BlocksRegistry.GARLIC_CRATE.get()))),
    GINGER_CRATE("ginger_crate", () -> new UDBlockItem((BlocksRegistry.GINGER_CRATE.get()))),
    LEMONGRASS_CRATE("lemongrass_crate", () -> new UDBlockItem((BlocksRegistry.LEMONGRASS_CRATE.get()))),

    //Feasts
    UBE_CAKE("ube_cake", () -> new UDBlockItem(BlocksRegistry.UBE_CAKE.get(), noStack()), null, 1.f),
    LECHE_FLAN_FEAST("leche_flan_feast", () -> new UDBlockItem(BlocksRegistry.LECHE_FLAN_FEAST.get(), noStack()), null, 1.f),
    LUMPIA_FEAST("lumpia_feast", () -> new UDBlockItem(BlocksRegistry.LUMPIA_FEAST.get(), noStack())),
    HALO_HALO_FEAST("halo_halo_feast", () -> new UDBlockItem(BlocksRegistry.HALO_HALO_FEAST.get(), noStack())),
    MILK_TEA_UBE_FEAST("milk_tea_ube_feast", () -> new UDBlockItem(BlocksRegistry.MILK_TEA_UBE_FEAST.get(), noStack())),

    //Items
    POISONOUS_UBE("poisonous_ube", () -> new Item(base())),
    UBE("ube", () -> new AliasedBlockItem(BlocksRegistry.UBE_CROP.get(), food(FoodItem.UBE.get())), null, .65f),
    GARLIC("garlic", () -> new AliasedBlockItem(BlocksRegistry.GARLIC_CROP.get(), food(FoodItem.GARLIC.get())), null, .65f),
    GINGER("ginger", () -> new AliasedBlockItem(BlocksRegistry.GINGER_CROP.get(), food(FoodItem.GINGER.get())), null, .65f),
    LEMONGRASS("lemongrass", () -> new UDConsumableItem(food(FoodItem.LEMONGRASS.get())), null, .65f),
    LEMONGRASS_SEEDS("lemongrass_seeds", () -> new AliasedBlockItem(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), base()), null, .3f),

    //Ingredients
    CONDENSED_MILK_BOTTLE("condensed_milk_bottle", () -> new UDDrinkableItem(food(FoodItem.CONDENSED_MILK_BOTTLE.get(), Items.GLASS_BOTTLE, 16), true)),
    FISH_SAUCE_BOTTLE("fish_sauce_bottle", () -> new UDDrinkableItem(food(FoodItem.FISH_SAUCE_BOTTLE.get(), Items.GLASS_BOTTLE, 16), true)),
    MILK_POWDER("milk_powder", () -> new Item(base())),
    SUGAR_BROWN("sugar_brown", () -> new Item(base())),
    LUMPIA_WRAPPER("lumpia_wrapper", () -> new Item(base()), null, .4f),

    //Drinks
    MILK_TEA_UBE("milk_tea_ube", () -> new UDDrinkableItem(food(FoodItem.MILK_TEA_UBE.get(), Items.GLASS_BOTTLE, 16), true)),
    HALO_HALO("halo_halo", () -> new UDDrinkableBlockItem(BlocksRegistry.GLASS_CUP_HALO_HALO.get(), food(FoodItem.HALO_HALO.get(), Items.GLASS_BOTTLE, 16), true, true)),

    //Partial Vegetables
    GARLIC_CHOP("garlic_chop", () -> new UDConsumableItem(food(FoodItem.GARLIC_CHOP.get())), null, .4f),
    GINGER_CHOP("ginger_chop", () -> new UDConsumableItem(food(FoodItem.GINGER_CHOP.get())), null, .4f),

    //Finger Foods
    SINANGAG("sinangag", () -> new UDConsumableItem(food(FoodItem.SINANGAG.get(), Items.BOWL, 16), true)),
    KINILAW("kinilaw", () -> new UDConsumableItem(food(FoodItem.KINILAW.get(), Items.BOWL, 16), true)),
    LUMPIA("lumpia", () -> new Item(foodBase(FoodItem.LUMPIA.get()))),
    TOCINO("tocino", () -> new Item(foodBase(FoodItem.TOCINO.get()))),
    CHICKEN_INASAL("chicken_inasal", () -> new Item(foodBase(FoodItem.CHICKEN_INASAL.get()))),

    //Meals
    CHICKEN_INASAL_RICE("chicken_inasal_rice", () -> new UDConsumableItem(food(FoodItem.CHICKEN_INASAL_RICE.get(), Items.BOWL, 16), true)),
    TOSILOG("tosilog", () -> new UDConsumableItem(food(FoodItem.TOSILOG.get(), Items.BOWL, 16), true)),
    BANGSILOG("bangsilog", () -> new UDConsumableItem(food(FoodItem.BANGSILOG.get(), Items.BOWL, 16), true)),
    SISIG("sisig", () -> new UDConsumableItem(food(FoodItem.SISIG.get(), Items.BOWL, 16), true)),
    BULALO("bulalo", () -> new UDConsumableItem(food(FoodItem.BULALO.get(), Items.BOWL, 16), true)),
    ARROZ_CALDO("arroz_caldo", () -> new UDConsumableItem(food(FoodItem.ARROZ_CALDO.get(), Items.BOWL, 16), true)),
    MECHADO("mechado", () -> new UDConsumableItem(food(FoodItem.MECHADO.get(), Items.BOWL, 16), true)),

    //Sweets
    COOKIE_UBE("cookie_ube", () -> new UDConsumableItem(food(FoodItem.COOKIES.get())), null, .85f),
    COOKIE_GINGER("cookie_ginger", () -> new UDConsumableItem(food(FoodItem.COOKIES.get())), null, .85f),

    LECHE_FLAN("leche_flan", () -> new Item(foodBase(FoodItem.LECHE_FLAN.get())), null, .85f),
    UBE_CAKE_SLICE("ube_cake_slice", () -> new UDConsumableItem(food(FoodItem.UBE_CAKE_SLICE.get())), null, .85f),

    //Baking
    RAW_POLVORONE("raw_polvorone", () -> new Item(base())),
    POLVORONE("polvorone", () -> new UDConsumableItem(food(FoodItem.POLVORONE.get()))),
    RAW_POLVORONE_PINIPIG("raw_polvorone_pinipig", () -> new Item(base())),
    POLVORONE_PINIPIG("polvorone_pinipig", () -> new UDConsumableItem(food(FoodItem.POLVORONE.get()))),
    RAW_POLVORONE_UBE("raw_polvorone_ube", () -> new Item(base())),
    POLVORONE_UBE("polvorone_ube", () -> new UDConsumableItem(food(FoodItem.POLVORONE.get()))),
    RAW_POLVORONE_CC("raw_polvorone_cc", () -> new Item(base())),
    POLVORONE_CC("polvorone_cc", () -> new UDConsumableItem(food(FoodItem.POLVORONE.get()))),

    PANDESAL_RAW("pandesal_raw", () -> new UDConsumableItem(food(FoodItem.PANDESAL_RAW.get()))),
    PANDESAL("pandesal", () -> new UDConsumableItem(food(FoodItem.PANDESAL.get())), null, .7f),
    PANDESAL_UBE_RAW("pandesal_ube_raw", () -> new UDConsumableItem(food(FoodItem.PANDESAL_RAW.get()))),
    PANDESAL_UBE("pandesal_ube", () -> new UDConsumableItem(food(FoodItem.PANDESAL_UBE.get()), true), null, .7f),
    ENSAYMADA_RAW("ensaymada_raw", () -> new UDConsumableItem(food(FoodItem.ENSAYMADA_RAW.get()))),
    ENSAYMADA("ensaymada", () -> new UDConsumableItem(food(FoodItem.ENSAYMADA.get())), null, .7f),
    ENSAYMADA_UBE_RAW("ensaymada_ube_raw", () -> new UDConsumableItem(food(FoodItem.ENSAYMADA_RAW.get()))),
    ENSAYMADA_UBE("ensaymada_ube", () -> new UDConsumableItem(food(FoodItem.ENSAYMADA_UBE.get()), true), null, .7f),
    HOPIA_MUNGGO_RAW("hopia_munggo_raw", () -> new UDConsumableItem(food(FoodItem.HOPIA_RAW.get()))),
    HOPIA_MUNGGO("hopia_munggo", () -> new UDConsumableItem(food(FoodItem.HOPIA_MUNGGO.get())), null, .7f),
    HOPIA_UBE_RAW("hopia_ube_raw", () -> new UDConsumableItem(food(FoodItem.HOPIA_RAW.get()))),
    HOPIA_UBE("hopia_ube", () -> new UDConsumableItem(food(FoodItem.HOPIA_UBE.get()), true), null, .7f),

    //Baking Stages
    POLVORONE_STAGE0("polvorone_stage0", () -> new Item(base()), false),
    POLVORONE_STAGE1("polvorone_stage1", () -> new Item(base()), false),
    POLVORONE_STAGE2("polvorone_stage2", () -> new Item(base()), false),
    POLVORONE_PINIPIG_STAGE0("polvorone_pinipig_stage0", () -> new Item(base()), false),
    POLVORONE_PINIPIG_STAGE1("polvorone_pinipig_stage1", () -> new Item(base()), false),
    POLVORONE_PINIPIG_STAGE2("polvorone_pinipig_stage2", () -> new Item(base()), false),
    POLVORONE_UBE_STAGE0("polvorone_ube_stage0", () -> new Item(base()), false),
    POLVORONE_UBE_STAGE1("polvorone_ube_stage1", () -> new Item(base()), false),
    POLVORONE_UBE_STAGE2("polvorone_ube_stage2", () -> new Item(base()), false),
    POLVORONE_CC_STAGE0("polvorone_cc_stage0", () -> new Item(base()), false),
    POLVORONE_CC_STAGE1("polvorone_cc_stage1", () -> new Item(base()), false),
    POLVORONE_CC_STAGE2("polvorone_cc_stage2", () -> new Item(base()), false),

    PANDESAL_STAGE0("pandesal_stage0", () -> new Item(base()), false),
    PANDESAL_STAGE1("pandesal_stage1", () -> new Item(base()), false),
    PANDESAL_STAGE2("pandesal_stage2", () -> new Item(base()), false),
    PANDESAL_UBE_STAGE0("pandesal_ube_stage0", () -> new Item(base()), false),
    PANDESAL_UBE_STAGE1("pandesal_ube_stage1", () -> new Item(base()), false),
    PANDESAL_UBE_STAGE2("pandesal_ube_stage2", () -> new Item(base()), false),
    ENSAYMADA_STAGE0("ensaymada_stage0", () -> new Item(base()), false),
    ENSAYMADA_STAGE1("ensaymada_stage1", () -> new Item(base()), false),
    ENSAYMADA_STAGE2("ensaymada_stage2", () -> new Item(base()), false),
    ENSAYMADA_STAGE3("ensaymada_stage3", () -> new Item(base()), false),
    ENSAYMADA_UBE_STAGE0("ensaymada_ube_stage0", () -> new Item(base()), false),
    ENSAYMADA_UBE_STAGE1("ensaymada_ube_stage1", () -> new Item(base()), false),
    ENSAYMADA_UBE_STAGE2("ensaymada_ube_stage2", () -> new Item(base()), false),
    ENSAYMADA_UBE_STAGE3("ensaymada_ube_stage3", () -> new Item(base()), false),
    HOPIA_MUNGGO_STAGE0("hopia_munggo_stage0", () -> new Item(base()), false),
    HOPIA_MUNGGO_STAGE1("hopia_munggo_stage1", () -> new Item(base()), false),
    HOPIA_MUNGGO_STAGE2("hopia_munggo_stage2", () -> new Item(base()), false),
    HOPIA_UBE_STAGE0("hopia_ube_stage0", () -> new Item(base()), false),
    HOPIA_UBE_STAGE1("hopia_ube_stage1", () -> new Item(base()), false),
    HOPIA_UBE_STAGE2("hopia_ube_stage2", () -> new Item(base()), false)

    ;


    private final String pathName;
    private final Supplier<Item> itemSupplier;
    private final Integer burnTime;
    private final Float compostingChance;
    private final Boolean obtainable;
    private Item item;

    ItemsRegistry(String pathName, Supplier<Item> itemSupplier) {
        this(pathName, itemSupplier, null, null, true);
    }
    ItemsRegistry(String pathName, Supplier<Item> itemSupplier, Integer burnTime, Float compostingChance) {
        this(pathName, itemSupplier, burnTime, compostingChance, true);
    }

    ItemsRegistry(String pathName, Supplier<Item> itemSupplier, Boolean obtainable) {
        this(pathName, itemSupplier, null, null, obtainable);
    }

    ItemsRegistry(String pathName, Supplier<Item> itemSupplier, Integer burnTime, Float compostingChance, Boolean obtainable) {
        this.pathName = pathName;
        this.itemSupplier = itemSupplier;
        this.burnTime = burnTime;
        this.compostingChance = compostingChance;
        this.obtainable = obtainable;
    }

    public static void registerAll() {
        for (ItemsRegistry value : values()) {
            Registry.register(Registries.ITEM, new Identifier(UbesDelightMod.MOD_ID, value.pathName), value.get());
            if (value.obtainable) {
                ItemGroupEvents.modifyEntriesEvent(UbesDelightMod.ITEM_GROUP).register(entries -> entries.add(value.get()));
            }
            if (value.burnTime != null && value.burnTime > 0) {
                FuelRegistry.INSTANCE.add(value.get(), value.burnTime);
            }
            if (value.compostingChance != null && value.compostingChance > .0f && value.compostingChance <= 1.f) {
                CompostingChanceRegistry.INSTANCE.add(value.get(), value.compostingChance);
            }
        }
    }

    public Item get() {
        if (item == null) {
            item = itemSupplier.get();
        }
        return item;
    }

    public String getId() {
        return Registries.ITEM.getId(get()).toString();
    }

    private static FabricItemSettings base() {
        return new FabricItemSettings();
    }
    private static FabricItemSettings noStack() {
        return new FabricItemSettings().maxCount(1);
    }
    private static FabricItemSettings foodBase(FoodComponent food) {
        return new FabricItemSettings().food(food);
    }
    private static FabricItemSettings food(FoodComponent food) {
        return new FabricItemSettings().food(food).recipeRemainder(Items.AIR);
    }
    private static FabricItemSettings food(FoodComponent food, Item remainder, int maxCount) {
        return new FabricItemSettings().food(food).recipeRemainder(remainder).maxCount(maxCount);
    }
}
