package jimmy.tutorial.util;

import jimmy.tutorial.block.Blockss;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recpies {

	/**
	 * Regster Recpes with Game Registery.
	 */
	public static void registerRecpies(){
		addShaplessRecpies();
		addShapedRecpies();
	}

	/**
	 * Add Shaped Recpies.
	 */
	private static void addShapedRecpies(){
		//GameRegistry.addRecipe(new ItemStack(TutorialBlocks.darkStone), new Object[]{ "   ", " X ", "   ", 'X', Blocks.stone});
	}

	/**
	 * Add Shapless Recpies.
	 */
	private static void addShaplessRecpies(){
		GameRegistry.addShapelessRecipe(new ItemStack(Blockss.lightStone, 1), new Object[] {new ItemStack(Blocks.dirt, 2), new ItemStack(Blocks.cobblestone, 2)});
	}
}