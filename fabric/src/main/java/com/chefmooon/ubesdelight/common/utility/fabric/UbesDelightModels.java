package com.chefmooon.ubesdelight.common.utility.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;

import java.util.Optional;

public class UbesDelightModels {
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

    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE = block("template_leaf_feast_rice",
            TextureSlot.LAYER0, TextureSlot.LAYER1, TextureSlot.LAYER2, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_END = block("template_leaf_feast_rice_end",
            TextureSlot.LAYER0, TextureSlot.LAYER1, TextureSlot.LAYER2, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_MIDDLE = block("template_leaf_feast_rice_middle",
            TextureSlot.LAYER0, TextureSlot.LAYER1, TextureSlot.LAYER2, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_RICE_TIP = block("template_leaf_feast_rice_tip",
            TextureSlot.LAYER0, TextureSlot.LAYER1, TextureSlot.LAYER2, TextureSlot.PARTICLE);

    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA = block("template_leaf_feast_ensaymada",
            TextureSlot.LAYER0, TextureSlot.LAYER1, TextureSlot.LAYER2, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_TIP = block("template_leaf_feast_ensaymada_tip",
            TextureSlot.LAYER0, TextureSlot.LAYER1, TextureSlot.LAYER2, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_END = block("template_leaf_feast_ensaymada_end",
            TextureSlot.LAYER0, TextureSlot.LAYER1, TextureSlot.LAYER2, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE = block("template_leaf_feast_ensaymada_middle",
            TextureSlot.LAYER0, TextureSlot.LAYER1, TextureSlot.LAYER2, TextureSlot.PARTICLE);

    private static ModelTemplate block(String parent, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(UbesDelight.res("block/" + parent)), Optional.empty(), textureSlots);
    }
}
