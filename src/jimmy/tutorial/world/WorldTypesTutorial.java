package jimmy.tutorial.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldTypesTutorial extends WorldType{
	
	private boolean hasNotificationData;
	
	public static WorldType tutDimOverWorld;

	public WorldTypesTutorial(String name) {
		super(name);
	}
	
	public static void addCustomWorldTypes(){
		tutDimOverWorld = new WorldTypesTutorial("TUTORIAL").setNotificationData();
	}

	@Override
	public WorldChunkManager getChunkManager(World world) {
		return new WorldChunkManagerHell(BiomeGenBase.megaTaiga, 0.5F);
	}

	@Override
	public IChunkProvider getChunkGenerator(World world, String generatorOptions) {
		return new ChunkProviderGenerate(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
	}

	@Override
	public int getMinimumSpawnHeight(World world) {
		return 64;
	} 
	
	/**
     * enables the display of generator.[worldtype].info message on the customize world menu
     */
    private WorldType setNotificationData()
    {
        this.hasNotificationData = true;
        return this;
    }
    
    /**
     * returns true if selecting this worldtype from the customize menu should display the generator.[worldtype].info
     * message
     */
    @SideOnly(Side.CLIENT)
    @Override
    public boolean showWorldInfoNotice()
    {
        return this.hasNotificationData;
    }
}
