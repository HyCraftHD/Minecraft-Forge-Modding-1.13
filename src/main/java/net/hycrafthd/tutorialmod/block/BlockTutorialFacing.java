package net.hycrafthd.tutorialmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.EnumFacing;

public class BlockTutorialFacing extends Block {
	
	public static final DirectionProperty facing = BlockStateProperties.FACING;
	
	public BlockTutorialFacing() {
		super(Properties.create(Material.ROCK).hardnessAndResistance(5));
		setDefaultState(getDefaultState().with(facing, EnumFacing.NORTH));
	}
	
	@Override
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		return getDefaultState().with(facing, context.getNearestLookingDirection().getOpposite());
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, IBlockState> builder) {
		builder.add(facing);
	}
	
}
