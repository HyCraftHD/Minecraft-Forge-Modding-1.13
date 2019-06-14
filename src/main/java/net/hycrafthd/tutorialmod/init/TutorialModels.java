package net.hycrafthd.tutorialmod.init;

import net.hycrafthd.tutorialmod.entity.EntityTutorialGrenade;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSprite;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class TutorialModels {
	
	public static void contruct() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTutorialGrenade.class, manager -> {
			return new RenderSprite<>(manager, TutorialItems.tutorialGrenade, Minecraft.getInstance().getItemRenderer());
		});
	}
	
}
