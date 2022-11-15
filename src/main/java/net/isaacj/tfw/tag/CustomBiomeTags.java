package net.isaacj.tfw.tag;

import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class CustomBiomeTags{

    public static final TagKey<Biome> IS_FROZEN = of("tfw:frozen_biomes");

    private CustomBiomeTags(){
    }

    private static TagKey<Biome> of(String id) {
        return TagKey.of(Registry.BIOME_KEY, new Identifier(id));
    }
}
