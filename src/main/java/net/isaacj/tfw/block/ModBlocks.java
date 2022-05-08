package net.isaacj.tfw.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.isaacj.tfw.TFWmod;
import net.isaacj.tfw.item.ModItemGroups;
import net.isaacj.tfw.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block REDSTONE_INFUSED_OBSIDIAN = registerblock("redstone_infused_obsidian",
            new Block(FabricBlockSettings.of(Material.STONE).strength(50f, 6000f ).requiresTool()),
                    ModItemGroups.TFW);
    public static final Block COMPACT_SNOW = registerblock("compact_snow",
            new Block(FabricBlockSettings.of(Material.SNOW_BLOCK).sounds(BlockSoundGroup.SNOW).strength(0.4f, 2f ).requiresTool()),
            ModItemGroups.TFW);






    private static Block registerblock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(TFWmod.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block Block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(TFWmod.MOD_ID, name),
                new BlockItem(Block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks(){
        System.out.println("Registering Mod Blocks for " + TFWmod.MOD_ID);

    }
}
