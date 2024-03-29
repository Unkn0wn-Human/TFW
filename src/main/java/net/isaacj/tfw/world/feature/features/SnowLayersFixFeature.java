package net.isaacj.tfw.world.feature.features;

import com.mojang.serialization.Codec;
import net.isaacj.tfw.block.ModBlocks;
import net.isaacj.tfw.tag.CustomBlockTags;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Arrays;
import java.util.List;

public class SnowLayersFixFeature extends Feature<DefaultFeatureConfig> {
    public SnowLayersFixFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }


    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        final List<Block> COMPACT_SNOW = Arrays.asList(
                ModBlocks.COMPACT_SNOW, ModBlocks.COMPACT_SNOW_TADACIA, ModBlocks.COMPACT_SNOW_BURNT_TADACIA, ModBlocks.COMPACT_SNOW_SYPH);

        for (int y = 0; y < 350; y++) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    int k = blockPos.getX() + x;
                    int l = blockPos.getZ() + z;
                    int m = blockPos.getY() + y;
                    mutable.set(k, m, l);

                    BlockState blockState = structureWorldAccess.getBlockState(mutable);
                    BlockState blockWest = structureWorldAccess.getBlockState(mutable.west());
                    BlockState blockEast = structureWorldAccess.getBlockState(mutable.east());
                    BlockState blockNorth = structureWorldAccess.getBlockState(mutable.north());
                    BlockState blockSouth = structureWorldAccess.getBlockState(mutable.south());
                    BlockState blockDown = structureWorldAccess.getBlockState(mutable.down());

                    if (blockState.isOf(Blocks.AIR) &&
                            (COMPACT_SNOW.contains(blockWest.getBlock()) ||
                                    COMPACT_SNOW.contains(blockEast.getBlock()) ||
                                    COMPACT_SNOW.contains(blockNorth.getBlock()) ||
                                    COMPACT_SNOW.contains(blockSouth.getBlock()) ||
                                    COMPACT_SNOW.contains(blockDown.getBlock()))) {
                        structureWorldAccess.setBlockState(mutable, Blocks.SNOW_BLOCK.getDefaultState(), 2);
                    }
                }
            }
        }

        for (int y = 117; y < 300; y++) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    int k = blockPos.getX() + x;
                    int l = blockPos.getZ() + z;
                    int m = blockPos.getY() + y;
                    mutable.set(k, m, l);
                    FluidState fluidState = structureWorldAccess.getFluidState(mutable);
                    BlockState blockState = structureWorldAccess.getBlockState(mutable);

                    if (fluidState.getFluid() == Fluids.WATER &&
                            blockState.getBlock() instanceof FluidBlock) {
                        structureWorldAccess.setBlockState(mutable, Blocks.ICE.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
}
