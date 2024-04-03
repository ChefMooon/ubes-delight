package com.chefmoon.ubesdelight.util;

import net.minecraft.util.StringIdentifiable;

public enum CookingPotRecipeCategory implements StringIdentifiable {
    MEALS("meals"),
    DRINKS("drinks"),
    MISC("misc");
    public static final Codec<CookingPotRecipeCategory> CODEC = StringIdentifiable.createCodec(CookingPotRecipeCategory::values);
    private final String id;

    private CookingPotRecipeCategory(String id) {
        this.id = id;
    }

    @Override
    public String asString() {
        return this.id;
    }
}
