package chefmooon.ubesdelight.common;


import chefmooon.ubesdelight.UbesDelight;
import eu.midnightdust.lib.config.MidnightConfig;

public class Configuration extends MidnightConfig {

    //Basic Config
    @MidnightConfig.Entry(category = "common") public static boolean enableUDCropCrates = true;
    @MidnightConfig.Entry(category = "common") public static boolean farmersBuyUDCrops = true;
    @MidnightConfig.Entry(category = "common") public static boolean wanderingTraderSellsUDItems = true;

    //World Generation
    @MidnightConfig.Comment(category = "common", centered = true) public static MidnightConfig.Comment worldGenerationSettings;
    @MidnightConfig.Entry(category = "common") public static boolean generateUDChestLoot = true;
    @MidnightConfig.Entry(category = "common") public static boolean generateWildUbe = true;
    public static int chanceWildUbe = 50;
    @MidnightConfig.Entry(category = "common") public static boolean generateWildGarlic = true;
    public static int chanceWildGarlic = 80;
    @MidnightConfig.Entry(category = "common") public static boolean generateWildGinger = true;
    public static int chanceWildGinger = 80;
    @MidnightConfig.Entry(category = "common") public static boolean generateWildLemongrass = true;
    public static int chanceWildLemongrass = 80;
    @MidnightConfig.Entry(category = "common", min = 0.0D, max = 1.0D) public static double bakingMatFortuneBonus = 0.1D;

    @MidnightConfig.Entry(category = "client") public static boolean isFoodEffectTooltip = true;

    public static boolean isEnableUDCropCrates() {
        return enableUDCropCrates;
    }

    public static boolean farmersBuyUDCrops() {
        return farmersBuyUDCrops;
    }

    public static boolean wanderingTraderSellsUDItems() {
        return wanderingTraderSellsUDItems;
    }

    public static boolean generateUDChestLoot() {
        return generateUDChestLoot;
    }

    public static boolean generateWildUbe() {
        return generateWildUbe;
    }

    public static int chanceWildUbe() {
        return chanceWildUbe;
    }

    public static boolean generateWildGarlic() {
        return generateWildGarlic;
    }

    public static int chanceWildGarlic() {
        return chanceWildGarlic;
    }

    public static boolean generateWildGinger() {
        return generateWildGinger;
    }

    public static int chanceWildGinger() {
        return chanceWildGinger;
    }

    public static boolean generateWildLemongrass() {
        return generateWildLemongrass;
    }

    public static int chanceWildLemongrass() {
        return chanceWildLemongrass;
    }

    public static double bakingMatFortuneBonus() {
        return bakingMatFortuneBonus;
    }

    public static boolean isFoodEffectTooltip() {
        return isFoodEffectTooltip;
    }

    public static void init() {
        MidnightConfig.init(UbesDelight.MOD_ID, Configuration.class);
    }
}
