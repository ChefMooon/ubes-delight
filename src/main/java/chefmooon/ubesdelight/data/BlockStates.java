package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.block.*;
import chefmooon.ubesdelight.common.block.leaf_feast.LumpiaLeafFeastBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.LeafFeastBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import chefmooon.ubesdelight.common.core.LeafFeastTypes;
import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class BlockStates extends BlockStateProvider {

    private static final int DEFAULT_ANGLE_OFFSET = 180;

    public BlockStates(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UbesDelight.MOD_ID, existingFileHelper);
    }

    private static String getName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    private static ResourceLocation getResource(Block block) {
        return ResourceLocation.parse(ModelLocationUtils.getModelLocation(block).getPath());
    }

    private ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(getResourceUDBlock(getName(block)), models().existingFileHelper);
    }

    public ResourceLocation getResourceUDBlock(String name) {
        return TextUtils.res(ModelProvider.BLOCK_FOLDER + "/" + name);
    }

    @Override
    protected void registerStatesAndModels() {
        // TODO: fix create blocks? block files are manually made for now.
//        registerCrateBlock(UbesDelightBlocks.UBE_CRATE.get());
//        registerCrateBlock(UbesDelightBlocks.GARLIC_CRATE.get());
//        registerCrateBlock(UbesDelightBlocks.GINGER_CRATE.get());
//        registerCrateBlock(UbesDelightBlocks.LEMONGRASS_CRATE.get());

        registerFlowerPotPlant(UbesDelightBlocks.WILD_UBE.get(), UbesDelightBlocks.POTTED_UBE.get());
        registerFlowerPotPlant(UbesDelightBlocks.WILD_GARLIC.get(), UbesDelightBlocks.POTTED_GARLIC.get());
        registerFlowerPotPlant(UbesDelightBlocks.WILD_GINGER.get(), UbesDelightBlocks.POTTED_GINGER.get());
        registerDoublePlant(UbesDelightBlocks.WILD_LEMONGRASS.get());

        customStageBlock(UbesDelightBlocks.UBE_CROP.get(), getResourceUDBlock("template_odd_crop"), "odd_crop", UbeCropBlock.AGE,  Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3));
        customComplexStageBlock(UbesDelightBlocks.GARLIC_CROP.get(), GarlicCropBlock.AGE, Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3));
        customComplexStageBlock(UbesDelightBlocks.GINGER_CROP.get(), GarlicCropBlock.AGE, Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3));
        lemongrassStalkBlock(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get());
        lemongrassBlock(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get());

        horizontalBlock(UbesDelightBlocks.KALAN.get(), state -> {
            String name = getName(UbesDelightBlocks.KALAN.get());
            String suffix = state.getValue(KalanBlock.LIT) ? "_on" : "";

            return models().cubeBottomTop(name + suffix,
                    getResourceUDBlock(name + "_side" + suffix),
                    getResourceUDBlock(name + "_bottom"),
                    getResourceUDBlock(name + "_top" + suffix));
        });

        customHorizontalBlock(UbesDelightBlocks.BAKING_MAT_BAMBOO.get(), $ -> existingModel(UbesDelightBlocks.BAKING_MAT_BAMBOO.get()), BakingMatBlock.WATERLOGGED);

        registerBasicCake(UbesDelightBlocks.UBE_CAKE.get());
        registerLecheFlan(UbesDelightBlocks.LECHE_FLAN_FEAST.get());
        registerLumpiaLeafFeast(UbesDelightBlocks.LUMPIA_FEAST.get());

        registerDrinkFeast(UbesDelightBlocks.MILK_TEA_UBE_FEAST.get());
        registerDrinkFeast(UbesDelightBlocks.HALO_HALO_FEAST.get());

        registerGlassCup(UbesDelightBlocks.GLASS_CUP_HALO_HALO.get());
        registerGlassCup(UbesDelightBlocks.GLASS_CUP_MILK_TEA_UBE.get());

        getVariantBuilder(UbesDelightBlocks.LEAF_FEAST.get())
                .forAllStates(state -> {
                    LeafFeastTypes type = state.getValue(LeafFeastBlock.LEAF_FEAST_TYPE);
                    Direction facing = state.getValue(HorizontalDirectionalBlock.FACING);

                    ResourceLocation model = switch (type) {
                        case BASE -> modLoc("block/leaf_feast");
                        case TIP -> modLoc("block/leaf_feast_tip");
                        case END -> modLoc("block/leaf_feast_end");
                        case MIDDLE -> modLoc("block/leaf_feast_middle");
                    };

                    int yRot = ((int) facing.toYRot() + 180) % 360; // adjust if needed for your model orientation

                    return ConfiguredModel.builder()
                            .modelFile(models().getExistingFile(model))
                            .rotationY(yRot)
                            .build();
                });

        getVariantBuilder(UbesDelightBlocks.UNIVERSAL_LEAF_FEAST.get())
                .forAllStates(state -> {
                    LeafFeastTypes type = state.getValue(LeafFeastBlock.LEAF_FEAST_TYPE);
                    Direction facing = state.getValue(HorizontalDirectionalBlock.FACING);

                    ResourceLocation model = switch (type) {
                        case BASE -> modLoc("block/leaf_feast");
                        case TIP -> modLoc("block/leaf_feast_tip");
                        case END -> modLoc("block/leaf_feast_end");
                        case MIDDLE -> modLoc("block/leaf_feast_middle");
                    };

                    int yRot = ((int) facing.toYRot() + 180) % 360;

                    return ConfiguredModel.builder()
                            .modelFile(models().getExistingFile(model))
                            .rotationY(yRot)
                            .build();
                });

        registerEnsaymadaLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA.get());
        registerEnsaymadaLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE.get());
        registerPandesalLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_PANDESAL.get());
        registerPandesalLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE.get());
        registerHopiaLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO.get());
        registerHopiaLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE.get());

        registerRiceLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_COOKED_RICE.get());
        registerRiceLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_FRIED_RICE.get());
        registerRiceLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_SINANGAG.get());

    }

    private void registerCrateBlock(Block block)  {
        ResourceLocation fdBottom = ResourceLocation.fromNamespaceAndPath("farmersdelight", "block/crate_bottom");
        boolean hasFdBottom = models().existingFileHelper.exists(
                fdBottom,
                net.minecraft.server.packs.PackType.CLIENT_RESOURCES,
                ".png",
                "textures"
        );
        ResourceLocation bottom = hasFdBottom ? fdBottom : ResourceLocation.parse(ModelLocationUtils.getModelLocation(block) + "_top");
        this.simpleBlock(block,
                models().cubeBottomTop(getName(block),
                        ResourceLocation.parse(ModelLocationUtils.getModelLocation(block) + "_side"),
                        ResourceLocation.parse(ModelLocationUtils.getModelLocation(block) + "_top"),
//                        ResourceLocation.parse(ModelLocationUtils.getModelLocation(block) + "_top") // TODO: fix the bottom texture
                        bottom
                )
        );
    }

    private void registerFlowerPotPlant(Block plant, Block pottedPlant) {
        this.simpleBlock(plant, models().withExistingParent(getName(plant), getResourceUDBlock("template_crop_cross"))
                .texture("cross", getResourceUDBlock(getName(plant))).renderType("cutout"));
        this.simpleBlock(pottedPlant, models().withExistingParent(getName(pottedPlant), getResourceUDBlock("template_potted_flower"))
                .texture("plant", getResourceUDBlock(getName(plant))).renderType("cutout"));

    }

    private void registerDoublePlant(Block block) {
        getVariantBuilder(block)
                .partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)
                .modelForState().modelFile(models().cross(getName(block) + "_bottom", getResourceUDBlock(getName(block) + "_bottom")).renderType("cutout")).addModel()
                .partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER)
                .modelForState().modelFile(models().cross(getName(block) + "_top", getResourceUDBlock(getName(block) + "_top")).renderType("cutout")).addModel();
    }

    public void customStageBlock(Block block, ResourceLocation parent, String textureKey, IntegerProperty ageProperty, List<Integer> suffixes, Property<?>... ignored) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int age = state.getValue(ageProperty);
            String stageName = getName(block) + "_stage";
            stageName += suffixes.isEmpty() ? age : suffixes.get(Math.min(suffixes.size(), age));
            return ConfiguredModel.builder()
                    .modelFile(models().singleTexture(stageName, parent, textureKey, getResourceUDBlock(stageName)).renderType("cutout")).build();
        }, ignored);
    }

    public void customComplexStageBlock(Block block, IntegerProperty ageProperty, List<Integer> suffixes, Property<?>... ignored) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int age = state.getValue(ageProperty);
            String stageName = getName(block) + "_stage";
            stageName += suffixes.isEmpty() ? age : suffixes.get(Math.min(suffixes.size() - 1, age));
            return ConfiguredModel.builder().modelFile(models().withExistingParent(stageName, getResourceUDBlock("template_complex_crop_cross"))
                    .texture("cross_v1", getResourceUDBlock(stageName + "_v1"))
                    .texture("cross_v2", getResourceUDBlock(stageName + "_v2"))
                    .renderType("cutout")
            ).build();
        }, ignored);
    }

    public void lemongrassStalkBlock(Block block) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int age = state.getValue(LemongrassStalkCropBlock.LEMONGRASS_AGE);
            boolean isSupporting = state.getValue(LemongrassStalkCropBlock.SUPPORTING) & age == 3;
            String stageName = isSupporting
                    ? getName(block) + "_supporting"
                    : getName(block) + "_stage" + age;
            return ConfiguredModel.builder().modelFile(models().singleTexture(stageName, getResourceUDBlock("template_crop_cross"), "cross", getResourceUDBlock(stageName))
                    .renderType("cutout")).build();
        });
    }

    public void lemongrassBlock(Block block) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
           int age = state.getValue(LemongrassLeafCropBlock.lEMONGRASS_AGE);
           String stageName = getName(block) + "_stage" + age;
           return ConfiguredModel.builder().modelFile(models().singleTexture(stageName, getResourceUDBlock("template_crop_cross"), "cross", getResourceUDBlock(stageName))
                   .renderType("cutout")).build();
        });
    }

    public void registerBasicCake(Block block) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int bites = state.getValue(UbesDelightCakeBlock.BITES);
            String name = getName(block);
            String suffix = bites > 0 ? "_slice" + bites : "";
            String template = bites == 0 ? "template_cake" : "template_cake_slice" + bites;
            return ConfiguredModel.builder().modelFile(models().withExistingParent(name + suffix, getResourceUDBlock(template))
                    .texture("particle", getResourceUDBlock(name + "_side"))
                    .texture("bottom", getResourceUDBlock(name + "_bottom"))
                    .texture("top", getResourceUDBlock(name + "_top"))
                    .texture("side", getResourceUDBlock(name + "_side"))
                    .texture("inside", getResourceUDBlock(name + "_inner"))).build();
        });
    }

    public void registerLecheFlan(Block block) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int bites = state.getValue(LecheFlanFeastBlock.BITES);
            String name = getName(block);
            String suffix = bites > 0 ? "_bite" + bites : "";
            String template = bites == 0 ? "template_leche_flan_feast" : "template_leche_flan_feast_bite" + bites;
            return ConfiguredModel.builder().modelFile(models().withExistingParent(name + suffix, getResourceUDBlock(template))
                    .texture("particle", getResourceUDBlock(name + "_side"))
                    .texture("bottom", getResourceUDBlock(name + "_bottom"))
                    .texture("top", getResourceUDBlock(name + "_top"))
                    .texture("side", getResourceUDBlock(name + "_side"))
                    .texture("inside", getResourceUDBlock(name + "_inner"))).build();
        });
    }

    public void registerLumpiaLeafFeast(Block block) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int servings = state.getValue(LumpiaLeafFeastBlock.SERVINGS);
            LeafFeastTypes feastType = state.getValue(LumpiaLeafFeastBlock.LEAF_FEAST_TYPE);
            Direction facing = state.getValue(HorizontalDirectionalBlock.FACING);

            String section = feastType == LeafFeastTypes.MIDDLE ? "middle" : "base";
            int suffix = Math.min(servings, 3);
            String name = getName(block);

            String modelName = "block/leaf_feast/leaf_feast_" + name + "_" + section + "_" + suffix;
            String parent = "leaf_feast/template_leaf_feast_" + section + "_lumpia_" + suffix;

            int yRot = ((int) facing.toYRot() + 180) % 360;

            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, getResourceUDBlock(parent))
                            .texture("top", getResourceUDBlock("leaf_feast_top"))
                            .texture("bottom", getResourceUDBlock("leaf_feast_bottom"))
                            .texture("content", getResourceUDBlock(name.replace("leaf_feast_", "")))
                            .texture("content_alt", getResourceUDBlock(name.replace("leaf_feast_", "") + "_alt"))
                            .renderType("cutout"))
                    .rotationY(yRot)
                    .build();
        });
    }

    public void registerDrinkFeast(Block block) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int servings = state.getValue(DrinkableFeastBlock.SERVINGS);
            String name = getName(block);
            ResourceLocation punchBowl = getResourceUDBlock("punch_bowl");
            String suffix = switch(servings) {
                case 0 -> "_leftover";
                case 1 -> "_stage3";
                case 2 -> "_stage2";
                case 3 -> "_stage1";
                case 4 -> "_stage0";
                default -> throw new IllegalStateException("Unexpected value: " + servings);
            };
            return ConfiguredModel.builder().modelFile(models().withExistingParent(name + suffix, getResourceUDBlock("template_drink_feast" + suffix))
                            .texture("particle", punchBowl)
                            .texture("inside", getResourceUDBlock(name))
                            .texture("punch_bowl", punchBowl)
                    .renderType("cutout")).build();
        });
    }

    public void registerGlassCup(Block block) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int servings = state.getValue(GlassCupBlock.SERVINGS) + 1;
            String name = getName(block);
            String suffix = "_servings" + servings;
            return ConfiguredModel.builder().modelFile(models().withExistingParent(name + suffix, getResourceUDBlock("template_glass_cup_" + servings))
                    .texture("cup", getResourceUDBlock("glass_cup"))
                    .texture("inside", getResourceUDBlock(name))
                    .renderType("cutout")).build();
        });
    }

    private ResourceLocation getLeafFeastContentTexture(Block block) {
        return getResourceUDBlock(getName(block).replace("leaf_feast_", "").replace("_half", ""));
    }

    private void registerEnsaymadaLeafFeastVariant(Block block) {
        registerBreadLeafFeastVariant(block, "ensaymada");
    }

    private void registerPandesalLeafFeastVariant(Block block) {
        registerBreadLeafFeastVariant(block, "pandesal");
    }

    private void registerHopiaLeafFeastVariant(Block block) {
        registerBreadLeafFeastVariant(block, "hopia");
    }

    private void registerRiceLeafFeastVariant(Block block) {
        registerBreadLeafFeastVariant(block, "rice");
    }

    private void registerBreadLeafFeastVariant(Block block, String typeName) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int servings = state.getValue(SimpleLeafFeastBlock.SERVINGS);
            LeafFeastTypes feastType = state.getValue(SimpleLeafFeastBlock.LEAF_FEAST_TYPE);
            Direction facing = state.getValue(HorizontalDirectionalBlock.FACING);

            String section = switch (feastType) {
                case BASE -> "base";
                case TIP -> "tip";
                case END -> "end";
                case MIDDLE -> "middle";
            };

            int suffix = switch (feastType) {
                case BASE, MIDDLE -> servings;
                case TIP, END -> Math.min(servings, 3);
            };

            String modelName = "block/leaf_feast/" + getName(block) + "_" + section + "_" + suffix;
            String parent = "leaf_feast/template_leaf_feast_" + section + "_" + typeName + "_" + suffix;

            int yRot = ((int) facing.toYRot() + 180) % 360;

            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, getResourceUDBlock(parent))
                            .texture("top", getResourceUDBlock(
                                    switch (section) {
                                        case "tip" -> "leaf_feast_tip_top";
                                        case "end" -> "leaf_feast_end_top";
                                        default -> "leaf_feast_top";
                                    }))
                            .texture("bottom", getResourceUDBlock(
                                    switch (section) {
                                        case "tip" -> "leaf_feast_tip_bottom";
                                        case "end" -> "leaf_feast_end_bottom";
                                        default -> "leaf_feast_bottom";
                                    }))
                            .texture("content", getLeafFeastContentTexture(block))
                            .renderType("cutout"))
                    .rotationY(yRot)
                    .build();
        });
    }

    public void customHorizontalBlock(Block block, Function<BlockState, ModelFile> modelFunc, Property<?>... ignored) {
        getVariantBuilder(block).forAllStatesExcept(state -> ConfiguredModel.builder()
                .modelFile(modelFunc.apply(state))
                .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                .build(), ignored);
    }
}
