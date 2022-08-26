package net.isaacj.tfw.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;



public record SnowLayersConfig(BlockStateProvider block, IntProvider height) implements FeatureConfig {
    public static final Codec<SnowLayersConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.TYPE_CODEC.fieldOf("block").forGetter(SnowLayersConfig::block),
            IntProvider.VALUE_CODEC.fieldOf("height").forGetter(SnowLayersConfig::height)
    ).apply(instance, SnowLayersConfig::new));
}
