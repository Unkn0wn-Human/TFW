package net.isaacj.tfw.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.isaacj.tfw.world.feature.ModPlacedFeatures;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

import java.rmi.registry.Registry;

public class ModSnowLayersGen {

    public static void generateSnowLayers() {
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SNOW_LAYERS_PLACED.getKey().get());
    }
}

