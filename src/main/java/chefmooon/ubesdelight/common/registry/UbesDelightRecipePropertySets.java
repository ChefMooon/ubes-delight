package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.RecipePropertySet;

public class UbesDelightRecipePropertySets {
    public static final ResourceKey<RecipePropertySet> BAKING_MAT_INPUT_ONE = ResourceKey.create(RecipePropertySet.TYPE_KEY, propertySet("baking_mat_input_one"));
    public static final ResourceKey<RecipePropertySet> BAKING_MAT_INPUT_TWO = ResourceKey.create(RecipePropertySet.TYPE_KEY, propertySet("baking_mat_input_two"));
    public static final ResourceKey<RecipePropertySet> BAKING_MAT_INPUT_THREE = ResourceKey.create(RecipePropertySet.TYPE_KEY, propertySet("baking_mat_input_three"));
    public static final ResourceKey<RecipePropertySet> BAKING_MAT_INPUT_FOUR = ResourceKey.create(RecipePropertySet.TYPE_KEY, propertySet("baking_mat_input_four"));
    public static final ResourceKey<RecipePropertySet> BAKING_MAT_INPUT_FIVE = ResourceKey.create(RecipePropertySet.TYPE_KEY, propertySet("baking_mat_input_five"));
    public static final ResourceKey<RecipePropertySet> BAKING_MAT_INPUT_SIX = ResourceKey.create(RecipePropertySet.TYPE_KEY, propertySet("baking_mat_input_six"));
    public static final ResourceKey<RecipePropertySet> BAKING_MAT_INPUT_SEVEN = ResourceKey.create(RecipePropertySet.TYPE_KEY, propertySet("baking_mat_input_seven"));
    public static final ResourceKey<RecipePropertySet> BAKING_MAT_INPUT_EIGHT = ResourceKey.create(RecipePropertySet.TYPE_KEY, propertySet("baking_mat_input_eight"));
    public static final ResourceKey<RecipePropertySet> BAKING_MAT_INPUT_NINE = ResourceKey.create(RecipePropertySet.TYPE_KEY, propertySet("baking_mat_input_nine"));
    public static final ResourceKey<RecipePropertySet> BAKING_MAT_TOOL = ResourceKey.create(RecipePropertySet.TYPE_KEY, propertySet("baking_mat_tool"));

    private static Identifier propertySet(String name) {
        return TextUtils.res(name);
    }
}
