package net.isaacj.tfw.world.feature;

import net.isaacj.tfw.TFWmod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> SYPH_TREE_PLACED_KEY = registerKey("syph_tree_placed");

    //public static final PlacedFeature SYPH_TREE_PLACED = registerPlacedFeature("syph_tree_placed",
           // ModConfiguredFeatures.SYPH_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                    //PlacedFeatures.createCountExtraModifier(1, 0.1f, 2))));



    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TFWmod.MOD_ID, name), placedFeature);
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(TFWmod.MOD_ID, name));
    }
}
