package net.hycrafthd.tutorialmod.gui;

import net.hycrafthd.tutorialmod.container.ContainerTutorialStorage;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiTutorialStorage extends GuiContainer {
	
	public GuiTutorialStorage(IInventory playerInventory, IInventory storageInventory) {
		super(new ContainerTutorialStorage(playerInventory, storageInventory));
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
	}
	
}
