package net.hycrafthd.tutorialmod.tileentity;

import net.hycrafthd.tutorialmod.init.TutorialTileEntityTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class TileEntityTutorialStorage extends TileEntity implements IInventory {
	
	private final NonNullList<ItemStack> stacks;
	
	public TileEntityTutorialStorage() {
		super(TutorialTileEntityTypes.tutorialstorage);
		stacks = NonNullList.withSize(18, ItemStack.EMPTY);
	}
	
	@Override
	public void read(NBTTagCompound compound) {
		ItemStackHelper.loadAllItems(compound, stacks);
		super.read(compound);
	}
	
	@Override
	public NBTTagCompound write(NBTTagCompound compound) {
		ItemStackHelper.saveAllItems(compound, stacks);
		return super.write(compound);
	}
	
	@Override
	public ITextComponent getName() {
		return new TextComponentTranslation("inventory.tutorialmod.tutorialstorage");
	}
	
	@Override
	public boolean hasCustomName() {
		return false;
	}
	
	@Override
	public ITextComponent getCustomName() {
		return null;
	}
	
	@Override
	public int getSizeInventory() {
		return stacks.size();
	}
	
	@Override
	public boolean isEmpty() {
		return stacks.parallelStream().allMatch(ItemStack::isEmpty);
	}
	
	@Override
	public ItemStack getStackInSlot(int index) {
		return stacks.get(index);
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) {
		final ItemStack itemstack = ItemStackHelper.getAndSplit(stacks, index, count);
		if (!itemstack.isEmpty()) {
			markDirty();
		}
		return itemstack;
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(stacks, index);
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		stacks.set(index, stack);
		if (stack.getCount() > getInventoryStackLimit()) {
			stack.setCount(getInventoryStackLimit());
		}
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return true;
	}
	
	@Override
	public void openInventory(EntityPlayer player) {
	}
	
	@Override
	public void closeInventory(EntityPlayer player) {
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}
	
	@Override
	public int getField(int id) {
		return 0;
	}
	
	@Override
	public void setField(int id, int value) {
	}
	
	@Override
	public int getFieldCount() {
		return 0;
	}
	
	@Override
	public void clear() {
		stacks.clear();
	}
	
}
