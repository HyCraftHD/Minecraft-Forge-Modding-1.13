package net.hycrafthd.tutorialmod.gui;

import net.hycrafthd.tutorialmod.TutorialMod;
import net.hycrafthd.tutorialmod.container.ContainerTutorialStorage;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiTutorialStorage extends GuiContainer {
	
	private static final ResourceLocation background = new ResourceLocation(TutorialMod.modid, "textures/gui/tutorialstorage.png");
	
	private final IInventory playerInventory;
	private final IInventory storageInventory;
	
	public GuiTutorialStorage(IInventory playerInventory, IInventory storageInventory) {
		super(new ContainerTutorialStorage(playerInventory, storageInventory));
		this.playerInventory = playerInventory;
		this.storageInventory = storageInventory;
		xSize = 176;
		ySize = 150;
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		super.render(mouseX, mouseY, partialTicks);
		renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color4f(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(background);
		
		final int xStart = (width - xSize) / 2;
		final int yStart = (height - ySize) / 2;
		
		drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		fontRenderer.drawString(storageInventory.getDisplayName().getFormattedText(), 8, 6, 4210752);
		fontRenderer.drawString(playerInventory.getDisplayName().getFormattedText(), 8, (float) (ySize - 96 + 2), 4210752);
	}
	
}
