package net.hycrafthd.tutorialmod.block;

import net.hycrafthd.tutorialmod.init.TutorialTileEntityTypes;
import net.hycrafthd.tutorialmod.tileentity.TileEntityTutorialStorage;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

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
		return TutorialTileEntityTypes.tutorialStorage.create();
	}
	
	@Override
	public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (world.isRemote || !(player instanceof EntityPlayerMP)) {
			return true;
		} else {
			final EntityPlayerMP playermp = (EntityPlayerMP) player;
			final TileEntity tileEntity = world.getTileEntity(pos);
			if (!(tileEntity instanceof TileEntityTutorialStorage)) {
				return false;
			}
			
			final TileEntityTutorialStorage tutorialStorage = (TileEntityTutorialStorage) tileEntity;
			NetworkHooks.openGui(playermp, tutorialStorage, pos);
			return true;
		}
	}
	
	@Override
	public void onReplaced(IBlockState state, World world, BlockPos pos, IBlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			final TileEntity tileEntity = world.getTileEntity(pos);
			if (tileEntity instanceof TileEntityTutorialStorage) {
				InventoryHelper.dropInventoryItems(world, pos, (TileEntityTutorialStorage) tileEntity);
				world.updateComparatorOutputLevel(pos, this);
			}
			world.removeTileEntity(pos);
		}
	}
}
