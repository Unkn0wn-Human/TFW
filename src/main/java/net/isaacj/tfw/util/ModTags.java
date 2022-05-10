package net.isaacj.tfw.util;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.isaacj.tfw.TFWmod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;


public class ModTags {

    public static class Blocks {


        public static final Tag.Identified<Block> SYPH_LOGS =
                createCommonTag("syph_wood");

        private static Tag.Identified<Block> createTag(String name) {
            return TagFactory.BLOCK.create(new Identifier(TFWmod.MOD_ID, name));
        }


        private static Tag.Identified<Block> createCommonTag(String name) {
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }
    }


    public static class Items {

        private static Tag.Identified<Item> createTag(String name) {
            return TagFactory.ITEM.create(new Identifier(TFWmod.MOD_ID, name));
        }


        private static Tag.Identified<Item> createCommonTag(String name){
            return TagFactory.ITEM.create(new Identifier("c", name));
        }

    }
}




