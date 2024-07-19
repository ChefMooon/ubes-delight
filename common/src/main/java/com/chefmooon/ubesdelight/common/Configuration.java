package com.chefmooon.ubesdelight.common;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class Configuration {

    @ExpectPlatform
    public static boolean isEnableUDCropCrates() {
        return false;
    }

    @ExpectPlatform
    public static boolean farmersBuyUDCrops() {
        return false;
    }

    @ExpectPlatform
    public static boolean wanderingTraderSellsUDItems() {
        return false;
    }

    @ExpectPlatform
    public static boolean generateUDChestLoot() {
        return false;
    }

    @ExpectPlatform
    public static boolean generateWildUbe() {
        return false;
    }

    @ExpectPlatform
    public static int chanceWildUbe() {
        return 0;
    }

    @ExpectPlatform
    public static boolean generateWildGarlic() {
        return false;
    }

    @ExpectPlatform
    public static int chanceWildGarlic() {
        return 0;
    }

    @ExpectPlatform
    public static boolean generateWildGinger() {
        return false;
    }

    @ExpectPlatform
    public static int chanceWildGinger() {
        return 0;
    }

    @ExpectPlatform
    public static boolean generateWildLemongrass() {
        return false;
    }

    @ExpectPlatform
    public static int chanceWildLemongrass() {
        return 0;
    }

    @ExpectPlatform
    public static boolean isFoodEffectTooltip() {
        return false;
    }

    @ExpectPlatform
    public static void init() {
        throw new AssertionError();
    }
}
