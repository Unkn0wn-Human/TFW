package net.isaacj.tfw.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.isaacj.tfw.TFWmod;
import net.isaacj.tfw.block.custom.ModDoorBlock;
import net.isaacj.tfw.block.custom.ModPressurePlateBlock;
import net.isaacj.tfw.block.custom.ModStairsBlock;
import net.isaacj.tfw.block.custom.RedstoneInfusedObsidianBlock;
import net.isaacj.tfw.item.ModItemGroups;
import net.isaacj.tfw.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block REDSTONE_INFUSED_OBSIDIAN = registerBlock("redstone_infused_obsidian",
            new RedstoneInfusedObsidianBlock(FabricBlockSettings.of(Material.STONE).strength(50f, 6000f ).requiresTool()
            .luminance((state) -> state.get(RedstoneInfusedObsidianBlock.ON) ? 10 : 0 )),
                    ModItemGroups.TFW);

    public static final Block COMPACT_SNOW = registerBlock("compact_snow",
            new Block(FabricBlockSettings.of(Material.SNOW_BLOCK).sounds(BlockSoundGroup.SNOW).strength(0.4f, 2f ).requiresTool()),
            ModItemGroups.TFW);

    public static final Block SYPH_LOG = registerBlock("syph_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2f, 10f )),
            ModItemGroups.TFW);

    public static final Block SYPH_PLANKS = registerBlock("syph_planks",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2f, 15f )),
            ModItemGroups.TFW);

    public static final Block SYPH_LEAVES = registerBlock("syph_leaves",
            new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque().strength(0.2f, 1f )),
            ModItemGroups.TFW);

    public static final Block BLUE_SYPH_LEAVES = registerBlock("blue_syph_leaves",
            new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque().strength(0.2f, 1f )),
            ModItemGroups.TFW);

    public static final Block SYPH_STAIRS = registerBlock("syph_stairs",
            new ModStairsBlock(ModBlocks.SYPH_PLANKS.getDefaultState(),FabricBlockSettings.of(Material.WOOD).
                    sounds(BlockSoundGroup.WOOD).strength(2f, 15f )),
            ModItemGroups.TFW);

    public static final Block SYPH_SLAB = registerBlock("syph_slab",
            new SlabBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).
                    strength(2f, 15f )),
            ModItemGroups.TFW);

    public static final Block SYPH_PRESSURE_PLATE = registerBlock("syph_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING ,FabricBlockSettings.of(Material.WOOD)
                    .sounds(BlockSoundGroup.WOOD).
                    strength(0.5f, 2.5f )),
            ModItemGroups.TFW);

    public static final Block SYPH_FENCE = registerBlock("syph_fence",
            new FenceBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).
                            strength(0.5f, 2.5f )),
            ModItemGroups.TFW);

    public static final Block SYPH_FENCE_GATE = registerBlock("syph_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).
                            strength(0.5f, 2.5f )),
            ModItemGroups.TFW);

    public static final Block SYPH_DOOR = registerBlock("syph_door",
            new ModDoorBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).nonOpaque()
                    .strength(2f, 15f )),
            ModItemGroups.TFW);

    public static final Block BLUE_MUMBADE = registerBlock("blue_mumbade",
            new FlowerBlock(StatusEffects.GLOWING, 8, FabricBlockSettings.copy(Blocks.POPPY)),
            ModItemGroups.TFW);

    public static final Block PURPLE_MUMBADE = registerBlock("purple_mumbade",
            new FlowerBlock(StatusEffects.GLOWING, 8, FabricBlockSettings.copy(Blocks.POPPY)),
            ModItemGroups.TFW);

    public static final Block GOLD_MUMBADE = registerBlock("gold_mumbade",
            new FlowerBlock(StatusEffects.GLOWING, 8, FabricBlockSettings.copy(Blocks.POPPY)),
            ModItemGroups.TFW);

    public static final Block POTTED_BLUE_MUMBADE = registerBlockWithoutBlockItem("potted_blue_mumbade",
            new FlowerPotBlock(ModBlocks.BLUE_MUMBADE, FabricBlockSettings.copy(Blocks.POTTED_POPPY)));

    public static final Block POTTED_GOLD_MUMBADE = registerBlockWithoutBlockItem("potted_gold_mumbade",
            new FlowerPotBlock(ModBlocks.GOLD_MUMBADE, FabricBlockSettings.copy(Blocks.POTTED_POPPY)));

    public static final Block POTTED_PURPLE_MUMBADE = registerBlockWithoutBlockItem("potted_purple_mumbade",
            new FlowerPotBlock(ModBlocks.PURPLE_MUMBADE, FabricBlockSettings.copy(Blocks.POTTED_POPPY)));






    private static Block registerBlockWithoutBlockItem(String name, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(TFWmod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group){
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
