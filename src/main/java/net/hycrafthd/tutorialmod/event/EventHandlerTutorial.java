package net.hycrafthd.tutorialmod.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

@EventBusSubscriber
public class EventHandlerTutorial {
	
	@SubscribeEvent
	public static void on(LivingFallEvent event) {
		event.setDamageMultiplier(0.2F);
	}
	
	@SubscribeEvent
	public static void on(RightClickBlock event) {
		final World world = event.getWorld();
		final BlockPos pos = event.getPos();
		if (world.isRemote) {
			return;
		}
		if (world.getBlockState(pos).getBlock() == Blocks.GOLD_ORE) {
			final EntityPlayer player = event.getEntityPlayer();
			player.addExperienceLevel(2);
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public static void on(PlayerLoggedInEvent event) {
		final EntityPlayer player = event.getPlayer();
		player.sendMessage(new TextComponentString("Hello world."));
	}
}
