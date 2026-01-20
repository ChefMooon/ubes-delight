package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.resources.Identifier;

public class UbesDelightRecipePropertySets {
    public static final Identifier BAKING_MAT_INPUT_ONE = propertySet("baking_mat_input_one");
    public static final Identifier BAKING_MAT_INPUT_TWO = propertySet("baking_mat_input_two");
    public static final Identifier BAKING_MAT_INPUT_THREE = propertySet("baking_mat_input_three");
    public static final Identifier BAKING_MAT_INPUT_FOUR = propertySet("baking_mat_input_four");
    public static final Identifier BAKING_MAT_INPUT_FIVE = propertySet("baking_mat_input_five");
    public static final Identifier BAKING_MAT_INPUT_SIX = propertySet("baking_mat_input_six");
    public static final Identifier BAKING_MAT_INPUT_SEVEN = propertySet("baking_mat_input_seven");
    public static final Identifier BAKING_MAT_INPUT_EIGHT = propertySet("baking_mat_input_eight");
    public static final Identifier BAKING_MAT_INPUT_NINE = propertySet("baking_mat_input_nine");
    public static final Identifier BAKING_MAT_TOOL = propertySet("baking_mat_tool");

    private static Identifier propertySet(String name) {
        return TextUtils.res(name);
    }
}
