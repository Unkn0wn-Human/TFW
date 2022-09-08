package net.isaacj.tfw.world.feature.features;

import com.mojang.serialization.Codec;
import net.isaacj.tfw.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.data.server.BlockTagProvider;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.lang3.mutable.Mutable;

public class SnowLayersFeature extends Feature<DefaultFeatureConfig> {


    public SnowLayersFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }


    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        BlockPos.Mutable mutable2 = new BlockPos.Mutable();




            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    int k = blockPos.getX() + x;
                    int l = blockPos.getZ() + z;
                    int m = structureWorldAccess.getTopY(Heightmap.Type.MOTION_BLOCKING, k, l);
                    mutable.set(k, m, l);
                    mutable2.set(k, m, l).move(Direction.UP, 1);


                    if (structureWorldAccess.getBlockState(mutable.down()).isOf(Blocks.DIRT) ||
                            (structureWorldAccess.getBlockState(mutable.down()).isOf(Blocks.WATER)) ||
                            (structureWorldAccess.getBlockState(mutable.down()).isOf(Blocks.ICE)) ||
                            (structureWorldAccess.getBlockState(mutable.down()).isOf(Blocks.STONE)))
                    {
                        structureWorldAccess.setBlockState(mutable, ModBlocks.COMPACT_SNOW.getDefaultState(), 2);
                        structureWorldAccess.setBlockState(mutable2, ModBlocks.COMPACT_SNOW.getDefaultState(), 2);
                    }
                }
            }





        return true;
    }
}





