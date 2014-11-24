package jimmy.tutorial.block;

import java.util.List;
import java.util.Random;

import jimmy.tutorial.particle.EntityTreeFX;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModEffectLeaves extends BlockModLeaves
{
	public static final String[][] field_150130_N = new String[][] { { "effect_leaves" }, { "effect_leaves_opaque" } };
	public static final String[] field_150131_O = new String[] { "effect" };

	@SuppressWarnings("unused")
	private static final String __OBFID = "CL_00000280";

	public BlockModEffectLeaves(String blockName, String textureName) {
		this.setTickRandomly(true);
		this.setBlockName(blockName);
		this.setBlockTextureName(textureName);
	}

	@Override
	public void randomDisplayTick(World world, int posX, int posY, int posZ, Random rng) {
		for (int l = 0; l < 4; ++l){
			double d0 = (double) ((float) posX + rng.nextFloat());
			double d1 = (double) ((float) posY + rng.nextFloat());
			double d2 = (double) ((float) posZ + rng.nextFloat());
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			int i1 = rng.nextInt(2) * 2 - 1;
			d3 = ((double) rng.nextFloat() - 0.5D) * 0.5D;
			d4 = ((double) rng.nextFloat() - 0.5D) * 0.5D;
			d5 = ((double) rng.nextFloat() - 0.5D) * 0.5D;

			if (world.getBlock(posX - 1, posY, posZ) != this && world.getBlock(posX + 1, posY, posZ) != this){
				d0 = (double) posX + 0.5D + 0.25D * (double) i1;
				d3 = (double) (rng.nextFloat() * 2.0F * (float) i1);
			}else{
				d2 = (double) posZ + 0.5D + 0.25D * (double) i1;
				d5 = (double) (rng.nextFloat() * 2.0F * (float) i1);
			}
			Minecraft.getMinecraft().effectRenderer.addEffect(new EntityTreeFX(world, d0, d1, d2, d3, d4, d5));
		}
	}

	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied
	 * against the blocks color. Note only called when first determining what to
	 * render.
	 */
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_){
		int l = p_149720_1_.getBlockMetadata(p_149720_2_, p_149720_3_, p_149720_4_);
		return (l & 3) == 1 ? ColorizerFoliage.getFoliageColorPine() : ((l & 3) == 2 ? ColorizerFoliage.getFoliageColorBirch() : super.colorMultiplier(p_149720_1_, p_149720_2_, p_149720_3_, p_149720_4_));
	}

	protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_){
		if ((p_150124_5_ & 3) == 0 && p_150124_1_.rand.nextInt(p_150124_6_) == 0){
			this.dropBlockAsItem(p_150124_1_, p_150124_2_, p_150124_3_, p_150124_4_, new ItemStack(Items.apple, 1, 0));
		}
	}

	protected int func_150123_b(int p_150123_1_){
		int j = super.func_150123_b(p_150123_1_);

		if ((p_150123_1_ & 3) == 3){
			j = 40;
		}
		return j;
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		return (p_149691_2_ & 3) == 1 ? this.field_150129_M[this.field_150127_b][1] : ((p_149691_2_ & 3) == 3 ? this.field_150129_M[this.field_150127_b][3] : ((p_149691_2_ & 3) == 2 ? this.field_150129_M[this.field_150127_b][2]
				: this.field_150129_M[this.field_150127_b][0]));
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
	{
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		for (int i = 0; i < field_150130_N.length; ++i)
		{
			this.field_150129_M[i] = new IIcon[field_150130_N[i].length];

			for (int j = 0; j < field_150130_N[i].length; ++j)
			{
				this.field_150129_M[i][j] = p_149651_1_.registerIcon("tutorial:" + field_150130_N[i][j]);
			}
		}
	}

	public String[] func_150125_e()
	{
		return field_150131_O;
	}
}