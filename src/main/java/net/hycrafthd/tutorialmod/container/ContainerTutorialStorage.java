package net.hycrafthd.tutorialmod.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTutorialStorage extends Container {
	
	public ContainerTutorialStorage(IInventory playerInventory, IInventory storageInventory) {
		for (int inventoryHeight = 0; inventoryHeight < 2; inventoryHeight++) {
			for (int inventoryWidth = 0; inventoryWidth < 9; inventoryWidth++) {
				addSlot(new Slot(storageInventory, inventoryWidth + inventoryHeight * 9, 8 + inventoryWidth * 18, 18 + inventoryHeight * 18));
			}
		}
		
		for (int inventoryHeight = 0; inventoryHeight < 3; inventoryHeight++) {
			for (int inventoryWidth = 0; inventoryWidth < 9; inventoryWidth++) {
				addSlot(new Slot(playerInventory, inventoryWidth + inventoryHeight * 9 + 9, 8 + inventoryWidth * 18, 68 + inventoryHeight * 18));
			}
		}
		
		for (int inventoryWidth = 0; inventoryWidth < 9; inventoryWidth++) {
			addSlot(new Slot(playerInventory, inventoryWidth, 8 + inventoryWidth * 18, 126));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index < 18) {
				if (!this.mergeItemStack(itemstack1, 19, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, 19, false)) {
				return ItemStack.EMPTY;
			}
			
			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}
	
}
