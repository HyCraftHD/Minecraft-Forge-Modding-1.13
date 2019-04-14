package net.hycrafthd.tutorialmod.block;

import java.util.Random;

import net.hycrafthd.tutorialmod.init.TutorialItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockTutorial extends Block {
	
	public BlockTutorial() {
		super(Properties.create(Material.ROCK).lightValue(10).slipperiness(1).hardnessAndResistance(5).sound(SoundType.GLASS));
	}
	
	@Override
	public ToolType getHarvestTool(IBlockState state) {
		return ToolType.PICKAXE;
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return 2;
	}
	
	@Override
	public IItemProvider getItemDropped(IBlockState state, World world, BlockPos pos, int fortune) {
		return TutorialItems.tutorial;
	}
	
	@Override
	public int quantityDropped(IBlockState state, Random random) {
		return random.nextInt(5) + 1;
	}
}
