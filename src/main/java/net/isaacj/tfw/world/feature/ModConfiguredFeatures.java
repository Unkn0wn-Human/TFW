package net.isaacj.tfw.world.feature;

import net.isaacj.tfw.TFWmod;
import net.isaacj.tfw.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {


    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> SYPH_TREE =
            ConfiguredFeatures.register("syph_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.SYPH_LOG),
                    new StraightTrunkPlacer(3, 6, 2),
                    BlockStateProvider.of(Blocks.AIR),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 2)).build());


    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> BLUE_SYPH_TREE =
            ConfiguredFeatures.register("blue_syph_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.SYPH_LOG),
                    new StraightTrunkPlacer(2, 3, 1),
                    BlockStateProvider.of(Blocks.AIR),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> BURNT_TADACIA_TREE =
            ConfiguredFeatures.register("burnt_tadacia_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.BURNT_TADACIA_LOG),
                    new StraightTrunkPlacer(3, 6, 2),
                    BlockStateProvider.of(Blocks.AIR),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                    new TwoLayersFeatureSize(1, 0, 2)).build());



    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + TFWmod.MOD_ID);
    }
}
