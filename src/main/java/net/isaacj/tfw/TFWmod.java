package net.isaacj.tfw;

import net.fabricmc.api.ModInitializer;
import net.isaacj.tfw.block.ModBlocks;
import net.isaacj.tfw.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TFWmod implements ModInitializer {


	//mod id
	public static final String MOD_ID = "tfw";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
