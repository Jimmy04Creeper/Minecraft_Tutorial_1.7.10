package jimmy.tutorial.events;

import jimmy.tutorial.block.BlockModLightSapling;
import jimmy.tutorial.block.Blockss;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHelper {

	/** Used to make the sapling grow the tree **/
	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event) {
		if(event.world.getBlock(event.x, event.y, event.z) == Blockss.lightSapling) {
			((BlockModLightSapling)Blockss.lightSapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
		}
	}

	/**
	 * Register this event helper
	 */
	public static void registerEvents() {
		 MinecraftForge.EVENT_BUS.register(new EventHelper());
	}
}
