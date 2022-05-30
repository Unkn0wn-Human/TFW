package net.isaacj.tfw;

import net.fabricmc.api.ModInitializer;
import net.isaacj.tfw.block.ModBlocks;
import net.isaacj.tfw.item.ModItems;
import net.isaacj.tfw.util.ModRegistries;
import net.isaacj.tfw.world.dimension.ModDimension;
import net.isaacj.tfw.world.dimension.ModPortals;
import net.isaacj.tfw.world.feature.ModConfiguredFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TFWmod implements ModInitializer{


	//mod id
	public static final String MOD_ID = "tfw";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



    @Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModStuffs();

		ModPortals.registerPortals();

		ModDimension.register();
	}

}
