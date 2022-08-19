package net.isaacj.tfw.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record SnowLayersConfig(IntProvider height, BlockStateProvider block) implements FeatureConfig {

    public static final Codec<SnowLayersConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            IntProvider.VALUE_CODEC.fieldOf("height").forGetter(SnowLayersConfig::height),
            BlockStateProvider.TYPE_CODEC.fieldOf("block").forGetter(SnowLayersConfig::block)
    ).apply(instance, instance.stable(SnowLayersConfig::new)));

}
