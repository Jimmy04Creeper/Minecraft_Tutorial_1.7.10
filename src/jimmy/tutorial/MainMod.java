package jimmy.tutorial;

import jimmy.tutorial.block.Blockss;
import jimmy.tutorial.config.ModConfig;
import jimmy.tutorial.events.EventHelper;
import jimmy.tutorial.proxys.ServerProxy;
import jimmy.tutorial.util.Details;
import jimmy.tutorial.util.GameLogger;
import jimmy.tutorial.util.Recpies;
import jimmy.tutorial.world.Dimension;
import jimmy.tutorial.world.WorldTypesTutorial;
import jimmy.tutorial.world.biomes.ModBiomes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Main Tutorial Mod File.
 * @author Jimmy04Creeper
 */
@Mod(modid = Details.MODID, version = Details.VERSION)
public class MainMod{
	
	/**
	 * This is the Main mod file, this is were all the mod stuff is loaded.
	 * This mod/tutorial has some cutom/changed stuff as i like things done my way.
	 * The Log file creates its own foleder and log file the .minecraft folder.
	 * Log file is not used yet so will be removed from the download/github.
	 * The Config creates its own cfg file in the TutorialConfig folder in Tutorial folder in .minecraft.(.minecraft/Tutorial/Configs/ConfigurationFile.cfg).
	 * The Loh creates its own log file in the Tutorial folder in TutorialLog folder in .minecraft.(.minecraft/Tutorial/TutorialLog/TutorialLog.log).
	 * I like to keep classes clean as i can and will create new classes if i want/need to.
	 * Note i do not use Proxys, as i dont really need them in this code, however, it may be best to use them if ur adding mobs ?..
	 * Added a basic custom world type.
	 * Added Trees and one tree has a partcle effect to it.
	 * 
	 * To make your dimension sky like overworld, remove methods skyRenderer and cloudRenderer from WorldProviderForest
	 */
	
	@Instance(Details.MODID)
	public static MainMod instance;
	
	@SidedProxy(clientSide="jimmy.tutorial.proxys.ClientProxy", serverSide="jimmy.tutorial.proxys.ServerProxy")
	private static ServerProxy proxy;

	/**
	 * Preload event.
	 * @param evt
	 */
	@EventHandler
	public static void preLoad(FMLPreInitializationEvent evt){
		GameLogger.createFolders();
		ModConfig.createTutConfig();
	}

	/**
	 * Load Event.
	 * @param evt
	 */
	@EventHandler
	public static void load(FMLInitializationEvent evt){
		Blockss.loadBlocks();
		ModBiomes.registerWithBiomeDictionary();
		Dimension.registerWorldProvider();
		Dimension.registerDimensions();
		WorldTypesTutorial.addCustomWorldTypes();
		EventHelper.registerEvents();
		
		proxy.registerRenderers();
	}

	/**
	 * Post Load Event.
	 * @param evt
	 */
	@EventHandler
	public static void postLoad(FMLPostInitializationEvent evt){
		Recpies.registerRecpies();
	}
}