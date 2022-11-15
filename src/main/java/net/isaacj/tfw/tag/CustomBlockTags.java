package net.isaacj.tfw.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CustomBlockTags {

    public static final TagKey<Block> HEIGHTMAP_IGNORE = register("heightmap_ignore");
    public static final TagKey<Block> LEAVES = register("leaves");

    private CustomBlockTags() {
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(id));
    }
}
