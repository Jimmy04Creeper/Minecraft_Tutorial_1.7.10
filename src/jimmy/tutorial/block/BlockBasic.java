package jimmy.tutorial.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBasic extends Block {

	String blockName;
	String blockTexture;
	SoundType blockSound;

	/**
	 * Create a block with the material.
	 * @param material
	 */
	protected BlockBasic(Material p_i45394_1_) {
		super(p_i45394_1_);
	}

	/**
	 * Creates a basic block.
	 * @param material
	 * @param name
	 * @param textureName
	 * @param sound
	 */
	public BlockBasic(Material material, String name, String textureName, SoundType sound){
		super(material);
		this.blockName = name;
		this.blockTexture = textureName;
		this.blockSound = sound;

		this.setBlockName(name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockTextureName("tutorial:" + textureName);
		this.setStepSound(blockSound);
	}

	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
		if(world.getBlock(x, y, z) == Blockss.lightForestDirt){
			return true;
		}
		if(world.getBlock(x, y, z) == Blockss.lightForestGrass){
			return true;
		}
		else{
			return false;
		}
	}



	@Override
	public void onPlantGrow(World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ) {
		if (this == Blockss.lightForestDirt || this == Blockss.lightForestGrass)
		{
			world.setBlock(x, y, z, Blockss.lightForestDirt, 0, 2);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Registers the Blocks icon in the player GUI inventory.
	 */
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("tutorial:" + blockTexture);
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Gets the Blocks icon in the player GUI inventory.
	 */
	public IIcon getIcon(int side, int meta)
	{
		return blockIcon;
	}

	@Override
	/**
	 * Is block see through.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	/**
	 * Returns the items to drop on destruction.
	 */
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return Item.getItemFromBlock(Blockss.lightForestDirt);
	}

	@Override
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random random)
	{
		return 1;
	}

	@Override
	@SuppressWarnings("static-access")
	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return world.doesBlockHaveSolidTopSurface(world, x, y - 1, z);
	}
}
