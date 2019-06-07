package net.hycrafthd.tutorialmod.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

public class ContainerTutorialStorage extends Container {
	
	public ContainerTutorialStorage(IInventory playerInventory, IInventory storageInventory) {
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
}
