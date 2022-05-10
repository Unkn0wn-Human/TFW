package net.isaacj.tfw;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.isaacj.tfw.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class TFWClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SYPH_DOOR, RenderLayer.getCutout());

    }
}
