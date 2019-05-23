package net.hycrafthd.tutorialmod.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(value = Dist.CLIENT)
public class EventHandlerTutorialClient {
	
	@SubscribeEvent
	public static void on(FOVUpdateEvent event) {
		final EntityPlayer player = event.getEntity();
		if (player.getHeldItemMainhand().getItem() == Items.GOLD_NUGGET) {
			event.setNewfov(event.getFov() * 1.3F);
		}
	}
	
}
