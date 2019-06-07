package net.hycrafthd.tutorialmod.block;

import net.hycrafthd.tutorialmod.init.TutorialTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockTutorialStorage extends Block {
	
	public static final DirectionProperty facing = BlockStateProperties.HORIZONTAL_FACING;
	
	public BlockTutorialStorage() {
		super(Properties.create(Material.WOOD).hardnessAndResistance(2));
	}
	
	@Override
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		return getDefaultState().with(facing, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, IBlockState> builder) {
		builder.add(facing);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
		return TutorialTileEntityTypes.tutorialstorage.create();
	}
	
}
