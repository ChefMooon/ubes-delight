package com.chefmoon.ubesdelight.util;

import com.chefmoon.ubesdelight.UbesDelightMod;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModels {
    public static final Model TEMPLATE_CAKE = ModModels.block("template_cake", TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE);
    public static final Model TEMPLATE_CAKE_SLICE1 = ModModels.block("template_cake_slice1", TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.INSIDE);
    public static final Model TEMPLATE_CAKE_SLICE2 = ModModels.block("template_cake_slice2", TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.INSIDE);
    public static final Model TEMPLATE_CAKE_SLICE3 = ModModels.block("template_cake_slice3", TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.INSIDE);
    public static final Model TEMPLATE_CAKE_SLICE4 = ModModels.block("template_cake_slice4", TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.INSIDE);
    public static final Model TEMPLATE_CAKE_SLICE5 = ModModels.block("template_cake_slice5", TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.INSIDE);
    public static final Model TEMPLATE_CAKE_SLICE6 = ModModels.block("template_cake_slice6", TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.INSIDE);
    public static final Model TEMPLATE_DRINK_FEAST_LEFTOVER = ModModels.block("template_drink_feast_leftover", ModTextureKey.DRINK_FEAST_INSIDE, ModTextureKey.PUNCH_BOWL, TextureKey.PARTICLE);
    public static final Model TEMPLATE_DRINK_FEAST_STAGE0 = ModModels.block("template_drink_feast_stage0", ModTextureKey.DRINK_FEAST_INSIDE, ModTextureKey.PUNCH_BOWL, TextureKey.PARTICLE);
    public static final Model TEMPLATE_DRINK_FEAST_STAGE1 = ModModels.block("template_drink_feast_stage1", ModTextureKey.DRINK_FEAST_INSIDE, ModTextureKey.PUNCH_BOWL, TextureKey.PARTICLE);
    public static final Model TEMPLATE_DRINK_FEAST_STAGE2 = ModModels.block("template_drink_feast_stage2", ModTextureKey.DRINK_FEAST_INSIDE, ModTextureKey.PUNCH_BOWL, TextureKey.PARTICLE);
    public static final Model TEMPLATE_DRINK_FEAST_STAGE3 = ModModels.block("template_drink_feast_stage3", ModTextureKey.DRINK_FEAST_INSIDE, ModTextureKey.PUNCH_BOWL, TextureKey.PARTICLE);

    public static final Model TEMPLATE_COMPLEX_CROSS = ModModels.block("template_complex_crop_cross", ModTextureKey.CROSS_V1, ModTextureKey.CROSS_V2);
    public static final Model TEMPLATE_ODD_CROP = ModModels.block("template_odd_crop", ModTextureKey.ODD_CROP);

    private static Model block(String parent, TextureKey ... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(UbesDelightMod.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }
}
