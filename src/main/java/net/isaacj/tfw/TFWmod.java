package net.isaacj.tfw;

import net.fabricmc.api.ModInitializer;
import net.isaacj.tfw.block.ModBlocks;
import net.isaacj.tfw.item.ModItems;
import net.isaacj.tfw.util.ModRegistries;
import net.isaacj.tfw.world.dimension.ModDimension;
import net.isaacj.tfw.world.dimension.ModPortals;
import net.isaacj.tfw.world.feature.ModConfiguredFeatures;

import net.isaacj.tfw.world.feature.features.ModFeatures;
import net.isaacj.tfw.world.gen.ModWorldGen;
import net.isaacj.tfw.world.structures.ModStructures;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TFWmod implements ModInitializer{


	//mod id
	public static final String MOD_ID = "tfw";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}



    @Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModFeatures.registerFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();

		ModPortals.registerPortals();

		ModDimension.register();

		ModWorldGen.generateModWorldGen();

		ModStructures.registerStructureFeatures();
	}

}
