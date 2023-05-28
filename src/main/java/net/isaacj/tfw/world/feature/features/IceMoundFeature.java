package net.isaacj.tfw.world.feature.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class IceMoundFeature extends Feature<DefaultFeatureConfig> {
    private static final Block ICE_BLOCK = Blocks.ICE;
    private static final Block SNOW_BLOCK = Blocks.SNOW_BLOCK;
    private static final Block BLUE_ICE_BLOCK = Blocks.BLUE_ICE;

    public IceMoundFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }


    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();

        System.out.println("Generating Ice Mound");
        int moundHeight = context.getRandom().nextInt(10) + 10; // Adjust the height of the mound
        int radius = moundHeight / 2;

        for (int y = 0; y < moundHeight; y++) {
            int layerWidth = radius - y / 4; // The width of the layer decreases as we go up to create a jagged look

            for (int xOffset = -layerWidth; xOffset <= layerWidth; xOffset++) {
                for (int zOffset = -layerWidth; zOffset <= layerWidth; zOffset++) {
                    double distance = Math.sqrt(xOffset * xOffset + zOffset * zOffset);
                    double noiseValue = context.getRandom().nextDouble();
                    if (noiseValue < ((double) layerWidth - distance) / layerWidth) {
                        BlockPos blockPos = new BlockPos(pos.getX() + xOffset, pos.getY() + y, pos.getZ() + zOffset);

                        // Choose block type based on height to make the outer layers snow
                        Block block = y >= moundHeight - 3 ? SNOW_BLOCK : ICE_BLOCK;

                        // Add some blue ice veins
                        if (context.getRandom().nextInt(100) < 10 && distance > 2 && distance < layerWidth - 2) {
                            block = BLUE_ICE_BLOCK;
                        }

                        ;
                        if (!world.getBlockState(blockPos.down()).isAir()) {
                            world.setBlockState(blockPos, block.getDefaultState(), 2);
                        }
                    }
                }
            }
        }

        return true;
    }
}
