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

    private static ModelTemplate block(String parent, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(UbesDelight.res("block/" + parent)), Optional.empty(), textureSlots);
    }
}
