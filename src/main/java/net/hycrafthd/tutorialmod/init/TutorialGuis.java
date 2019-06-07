package net.hycrafthd.tutorialmod.init;

import net.hycrafthd.tutorialmod.TutorialMod;
import net.hycrafthd.tutorialmod.gui.GuiTutorialStorage;
import net.hycrafthd.tutorialmod.tileentity.TileEntityTutorialStorage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;

@OnlyIn(Dist.CLIENT)
public class TutorialGuis {
	
	public static void construct() {
		ModLoadingContext.get().getActiveContainer().registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> openContainer -> {
			if (openContainer.getId().toString().equals(TutorialMod.modid + ":tutorialstorage")) {
				final EntityPlayerSP player = Minecraft.getInstance().player;
				final World world = player.getEntityWorld();
				final BlockPos pos = openContainer.getAdditionalData().readBlockPos();
				final TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity instanceof TileEntityTutorialStorage) {
					final TileEntityTutorialStorage tutorialStorage = (TileEntityTutorialStorage) tileEntity;
					return new GuiTutorialStorage(player.inventory, tutorialStorage);
				}
			}
			return null;
		});
	}
	
}
