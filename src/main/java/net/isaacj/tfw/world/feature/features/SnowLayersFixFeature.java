package net.isaacj.tfw.world.feature.features;

import com.mojang.serialization.Codec;
import net.isaacj.tfw.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class SnowLayersFixFeature extends Feature<DefaultFeatureConfig> {
    public SnowLayersFixFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }


    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {

        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        BlockPos.Mutable mutable = new BlockPos.Mutable();


        for (int y = 0; y < 200; y++) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    int k = blockPos.getX() + x;
                    int l = blockPos.getZ() + z;
                    int m = blockPos.getY() + y;
                    mutable.set(k, m, l);

                    if (structureWorldAccess.getBlockState(mutable).isOf(Blocks.AIR) &&
                            structureWorldAccess.getBlockState(mutable.west()).isOf(ModBlocks.COMPACT_SNOW)) {
                        structureWorldAccess.setBlockState(mutable, Blocks.SNOW_BLOCK.getDefaultState(), 2);

                    } else if (structureWorldAccess.getBlockState(mutable).isOf(Blocks.AIR) &&
                            structureWorldAccess.getBlockState(mutable.east()).isOf(ModBlocks.COMPACT_SNOW)) {

                        structureWorldAccess.setBlockState(mutable, Blocks.SNOW_BLOCK.getDefaultState(), 2);

                    } else if (structureWorldAccess.getBlockState(mutable).isOf(Blocks.AIR) &&
                            structureWorldAccess.getBlockState(mutable.north()).isOf(ModBlocks.COMPACT_SNOW)) {

                        structureWorldAccess.setBlockState(mutable, Blocks.SNOW_BLOCK.getDefaultState(), 2);

                    } else if (structureWorldAccess.getBlockState(mutable).isOf(Blocks.AIR) &&
                            structureWorldAccess.getBlockState(mutable.south()).isOf(ModBlocks.COMPACT_SNOW)) {

                        structureWorldAccess.setBlockState(mutable, Blocks.SNOW_BLOCK.getDefaultState(), 2);

                    }
                }
            }
        }
            return true;

        }
    }
