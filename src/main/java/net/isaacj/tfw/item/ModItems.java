package net.isaacj.tfw.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.isaacj.tfw.TFWmod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {


    //public static final Item REDSTONE_INFUSED_OBSIDIAN = registerItem("redstone_infused_obsidian",
            //new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item SYPH_NUT = registerItem("syph_nut",
            new Item(new FabricItemSettings().group(ModItemGroups.TFW)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(TFWmod.MOD_ID, name), item);

    }


    public static void registerModItems(){
        System.out.println("Registering Mod Items for" + TFWmod.MOD_ID);

    }
}
