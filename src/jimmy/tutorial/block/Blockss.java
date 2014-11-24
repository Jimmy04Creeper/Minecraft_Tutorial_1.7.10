package jimmy.tutorial.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class Blockss {
	
	public static Block lightStone, lightForestGrass, lightForestDirt, lightLog, lightLeaves, lightSapling, effectLeaves;
	public static BlockModPortal lightPortal;
	public static BlockModFire lightFire;
	
	/**
	 * Load Blocks.
	 */
	public static void loadBlocks(){
		lightForestDirt = new BlockBasic(Material.rock, "lightForestDirt", "lightForestDirt", Block.soundTypeGrass);
		lightForestGrass = new BlockModLightGrass(Material.rock, "lightForestGrass", Block.soundTypeGrass);
		lightStone = new BlockBasic(Material.rock, "lightStone", "lightStone", Block.soundTypeStone);
		lightLog = new BlockModLightLog("lightLog", "log");
		lightLeaves = new BlockModLightLeaves("lightLeaves", "light");
		//Testing for my tree particle effect
		effectLeaves = new BlockModEffectLeaves("effectLeaves", "effect");
		lightSapling = new BlockModLightSapling("lightSapling", "light");
		lightPortal = new BlockModPortal("lightPortal");
		lightFire  = new BlockModFire("lightFire");
		registerBlocks();
	}

	/**
	 * Register Blocks.
	 */
	private static void registerBlocks(){
		GameRegistry.registerBlock(lightForestDirt, "lightForestDirt");
		GameRegistry.registerBlock(lightForestGrass, "lightForestGrass");
		GameRegistry.registerBlock(lightStone, "lightStone");
		GameRegistry.registerBlock(lightPortal, "lightPortal");
		GameRegistry.registerBlock(lightFire, "lightFire");
		GameRegistry.registerBlock(lightLog, "lightLog");
		GameRegistry.registerBlock(lightLeaves, "lightLeaves");
		GameRegistry.registerBlock(effectLeaves, "effectLeaves");
		GameRegistry.registerBlock(lightSapling, "lightSapling");
	}
}
