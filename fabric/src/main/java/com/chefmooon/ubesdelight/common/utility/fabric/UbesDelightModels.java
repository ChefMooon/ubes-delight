package com.chefmooon.ubesdelight.common.utility.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;

import java.util.Optional;

public class UbesDelightModels {
    public static final ModelTemplate TEMPLATE_ROLLING_PIN_3D = item("template_rolling_pin_3d", TextureSlot.CONTENT);
    public static final ModelTemplate FLAT_HANDHELD_ITEM_FLIPPED = item("flat_handheld_item_flipped", TextureSlot.LAYER0);

    public static final ModelTemplate TEMPLATE_CAKE = block("template_cake",
            TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE);
    public static final ModelTemplate TEMPLATE_CAKE_SLICE1 = block("template_cake_slice1",
            TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INSIDE);
    public static final ModelTemplate TEMPLATE_CAKE_SLICE2 = block("template_cake_slice2",
            TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INSIDE);
    public static final ModelTemplate TEMPLATE_CAKE_SLICE3 = block("template_cake_slice3",
            TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INSIDE);
    public static final ModelTemplate TEMPLATE_CAKE_SLICE4 = block("template_cake_slice4",
            TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INSIDE);
    public static final ModelTemplate TEMPLATE_CAKE_SLICE5 = block("template_cake_slice5",
            TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INSIDE);
    public static final ModelTemplate TEMPLATE_CAKE_SLICE6 = block("template_cake_slice6",
            TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INSIDE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_LEFTOVER = block("template_drink_feast_leftover",
            UbesDelightTextureSlots.DRINK_FEAST_INSIDE, UbesDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_STAGE0 = block("template_drink_feast_stage0",
            UbesDelightTextureSlots.DRINK_FEAST_INSIDE, UbesDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_STAGE1 = block("template_drink_feast_stage1",
            UbesDelightTextureSlots.DRINK_FEAST_INSIDE, UbesDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_STAGE2 = block("template_drink_feast_stage2",
            UbesDelightTextureSlots.DRINK_FEAST_INSIDE, UbesDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_STAGE3 = block("template_drink_feast_stage3",
            UbesDelightTextureSlots.DRINK_FEAST_INSIDE, UbesDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);

    public static final ModelTemplate TEMPLATE_COMPLEX_CROSS = block("template_complex_crop_cross",
            UbesDelightTextureSlots.CROSS_V1, UbesDelightTextureSlots.CROSS_V2);
    public static final ModelTemplate TEMPLATE_ODD_CROP = block("template_odd_crop",
            UbesDelightTextureSlots.ODD_CROP);

    public static final ModelTemplate TEMPLATE_CROP_CROSS = block("template_crop_cross",
            TextureSlot.CROSS);

    public static final ModelTemplate TEMPLATE_POTTED_FLOWER = block("template_potted_flower",
            TextureSlot.PLANT);

    public static final ModelTemplate TEMPLATE_GLASS_CUP_1 = block("template_glass_cup_1", UbesDelightTextureSlots.INSIDE, UbesDelightTextureSlots.CUP);
    public static final ModelTemplate TEMPLATE_GLASS_CUP_2 = block("template_glass_cup_2", UbesDelightTextureSlots.INSIDE, UbesDelightTextureSlots.CUP);
    public static final ModelTemplate TEMPLATE_GLASS_CUP_3 = block("template_glass_cup_3", UbesDelightTextureSlots.INSIDE, UbesDelightTextureSlots.CUP);
    public static final ModelTemplate TEMPLATE_GLASS_CUP_4 = block("template_glass_cup_4", UbesDelightTextureSlots.INSIDE, UbesDelightTextureSlots.CUP);


    public static final ModelTemplate TEMPLATE_LEAF_FEAST_LUMPIA_1 = block("leaf_feast/template_leaf_feast_base_lumpia_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT, UbesDelightTextureSlots.CONTENT_ALT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_LUMPIA_2 = block("leaf_feast/template_leaf_feast_base_lumpia_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT, UbesDelightTextureSlots.CONTENT_ALT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_LUMPIA_3 = block("leaf_feast/template_leaf_feast_base_lumpia_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT, UbesDelightTextureSlots.CONTENT_ALT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_LUMPIA_MIDDLE_1 = block("leaf_feast/template_leaf_feast_middle_lumpia_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT, UbesDelightTextureSlots.CONTENT_ALT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_LUMPIA_MIDDLE_2 = block("leaf_feast/template_leaf_feast_middle_lumpia_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT, UbesDelightTextureSlots.CONTENT_ALT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_LUMPIA_MIDDLE_3 = block("leaf_feast/template_leaf_feast_middle_lumpia_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT, UbesDelightTextureSlots.CONTENT_ALT);


    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_1 = block("leaf_feast/template_leaf_feast_base_ensaymada_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_2 = block("leaf_feast/template_leaf_feast_base_ensaymada_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_3 = block("leaf_feast/template_leaf_feast_base_ensaymada_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_4 = block("leaf_feast/template_leaf_feast_base_ensaymada_4", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_5 = block("leaf_feast/template_leaf_feast_base_ensaymada_5", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_6 = block("leaf_feast/template_leaf_feast_base_ensaymada_6", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE_1 = block("leaf_feast/template_leaf_feast_middle_ensaymada_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE_2 = block("leaf_feast/template_leaf_feast_middle_ensaymada_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE_3 = block("leaf_feast/template_leaf_feast_middle_ensaymada_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE_4 = block("leaf_feast/template_leaf_feast_middle_ensaymada_4", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE_5 = block("leaf_feast/template_leaf_feast_middle_ensaymada_5", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE_6 = block("leaf_feast/template_leaf_feast_middle_ensaymada_6", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_TIP_1 = block("leaf_feast/template_leaf_feast_tip_ensaymada_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_TIP_2 = block("leaf_feast/template_leaf_feast_tip_ensaymada_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_TIP_3 = block("leaf_feast/template_leaf_feast_tip_ensaymada_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_END_1 = block("leaf_feast/template_leaf_feast_end_ensaymada_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_END_2 = block("leaf_feast/template_leaf_feast_end_ensaymada_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_END_3 = block("leaf_feast/template_leaf_feast_end_ensaymada_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);

    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_1 = block("leaf_feast/template_leaf_feast_base_pandesal_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_2 = block("leaf_feast/template_leaf_feast_base_pandesal_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_3 = block("leaf_feast/template_leaf_feast_base_pandesal_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_4 = block("leaf_feast/template_leaf_feast_base_pandesal_4", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_5 = block("leaf_feast/template_leaf_feast_base_pandesal_5", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_6 = block("leaf_feast/template_leaf_feast_base_pandesal_6", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_MIDDLE_1 = block("leaf_feast/template_leaf_feast_middle_pandesal_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_MIDDLE_2 = block("leaf_feast/template_leaf_feast_middle_pandesal_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_MIDDLE_3 = block("leaf_feast/template_leaf_feast_middle_pandesal_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_MIDDLE_4 = block("leaf_feast/template_leaf_feast_middle_pandesal_4", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_MIDDLE_5 = block("leaf_feast/template_leaf_feast_middle_pandesal_5", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_MIDDLE_6 = block("leaf_feast/template_leaf_feast_middle_pandesal_6", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_TIP_1 = block("leaf_feast/template_leaf_feast_tip_pandesal_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_TIP_2 = block("leaf_feast/template_leaf_feast_tip_pandesal_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_TIP_3 = block("leaf_feast/template_leaf_feast_tip_pandesal_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_END_1 = block("leaf_feast/template_leaf_feast_end_pandesal_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_END_2 = block("leaf_feast/template_leaf_feast_end_pandesal_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_PANDESAL_END_3 = block("leaf_feast/template_leaf_feast_end_pandesal_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);

    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_1 = block("leaf_feast/template_leaf_feast_base_hopia_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_2 = block("leaf_feast/template_leaf_feast_base_hopia_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_3 = block("leaf_feast/template_leaf_feast_base_hopia_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_4 = block("leaf_feast/template_leaf_feast_base_hopia_4", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_5 = block("leaf_feast/template_leaf_feast_base_hopia_5", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_6 = block("leaf_feast/template_leaf_feast_base_hopia_6", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_MIDDLE_1 = block("leaf_feast/template_leaf_feast_middle_hopia_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_MIDDLE_2 = block("leaf_feast/template_leaf_feast_middle_hopia_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_MIDDLE_3 = block("leaf_feast/template_leaf_feast_middle_hopia_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_MIDDLE_4 = block("leaf_feast/template_leaf_feast_middle_hopia_4", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_MIDDLE_5 = block("leaf_feast/template_leaf_feast_middle_hopia_5", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_MIDDLE_6 = block("leaf_feast/template_leaf_feast_middle_hopia_6", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_TIP_1 = block("leaf_feast/template_leaf_feast_tip_hopia_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_TIP_2 = block("leaf_feast/template_leaf_feast_tip_hopia_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_TIP_3 = block("leaf_feast/template_leaf_feast_tip_hopia_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_END_1 = block("leaf_feast/template_leaf_feast_end_hopia_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_END_2 = block("leaf_feast/template_leaf_feast_end_hopia_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_HOPIA_END_3 = block("leaf_feast/template_leaf_feast_end_hopia_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);

    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_1 = block("leaf_feast/template_leaf_feast_base_rice_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_2 = block("leaf_feast/template_leaf_feast_base_rice_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_3 = block("leaf_feast/template_leaf_feast_base_rice_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_4 = block("leaf_feast/template_leaf_feast_base_rice_4", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_5 = block("leaf_feast/template_leaf_feast_base_rice_5", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_6 = block("leaf_feast/template_leaf_feast_base_rice_6", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_MIDDLE_1 = block("leaf_feast/template_leaf_feast_middle_rice_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_MIDDLE_2 = block("leaf_feast/template_leaf_feast_middle_rice_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_MIDDLE_3 = block("leaf_feast/template_leaf_feast_middle_rice_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_MIDDLE_4 = block("leaf_feast/template_leaf_feast_middle_rice_4", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_MIDDLE_5 = block("leaf_feast/template_leaf_feast_middle_rice_5", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_MIDDLE_6 = block("leaf_feast/template_leaf_feast_middle_rice_6", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_TIP_1 = block("leaf_feast/template_leaf_feast_tip_rice_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_TIP_2 = block("leaf_feast/template_leaf_feast_tip_rice_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_TIP_3 = block("leaf_feast/template_leaf_feast_tip_rice_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_END_1 = block("leaf_feast/template_leaf_feast_end_rice_1", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_END_2 = block("leaf_feast/template_leaf_feast_end_rice_2", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_END_3 = block("leaf_feast/template_leaf_feast_end_rice_3", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.CONTENT);

    private static ModelTemplate item(String parent, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(UbesDelight.res("item/" + parent)), Optional.empty(), textureSlots);
    }

    private static ModelTemplate block(String parent, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(UbesDelight.res("block/" + parent)), Optional.empty(), textureSlots);
    }
}
