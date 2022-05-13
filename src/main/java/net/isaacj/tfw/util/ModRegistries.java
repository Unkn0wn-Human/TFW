package net.isaacj.tfw.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.isaacj.tfw.block.ModBlocks;

public class ModRegistries {

    public static void registerModStuffs(){

        registerStrippables();
    }

    private static void registerStrippables() {

        StrippableBlockRegistry.register(ModBlocks.SYPH_WOOD, ModBlocks.STRIPPED_SYPH_WOOD);
        StrippableBlockRegistry.register(ModBlocks.SYPH_LOG, ModBlocks.STRIPPED_SYPH_LOG);
    }
}
