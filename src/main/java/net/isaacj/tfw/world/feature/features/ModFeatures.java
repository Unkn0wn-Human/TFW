package net.isaacj.tfw.world.feature.features;

import net.isaacj.tfw.TFWmod;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;


public class ModFeatures {


    public static final Feature<DefaultFeatureConfig> SNOW_LAYERS = register("snow_layers_feature", new
            SnowLayersFeature(DefaultFeatureConfig.CODEC));

    public static final Feature<DefaultFeatureConfig> SNOW_LAYERS_FIX = register("snow_layers_fix_feature", new
            SnowLayersFixFeature(DefaultFeatureConfig.CODEC));


    private static <T extends Feature<?>> T register(String name, T entry) {
        return Registry.register(Registry.FEATURE, TFWmod.id(name), entry);
    }


    public static void registerFeatures() {
        System.out.println("Registering Features for " + TFWmod.MOD_ID);
    }
}
