package jimmy.tutorial.world;

import net.minecraftforge.common.DimensionManager;

public class Dimension {
	
	/**
	 * Register dimensions.
	 * @param register
	 */
	public static void registerDimensions(){
		DimensionManager.registerDimension(DimensionIDs.LIGHTFORESTDIMENSION, DimensionIDs.LIGHTFORESTDIMENSION);
	}
	
	/**
	 * Regster dimension world providers with the dimension manager.
	 */
	public static void registerWorldProvider(){
		DimensionManager.registerProviderType(DimensionIDs.LIGHTFORESTDIMENSION, WorldProviderForest.class, true);
	}
}
