package net.hycrafthd.tutorialmod.init;

import net.hycrafthd.tutorialmod.TutorialMod;
import net.hycrafthd.tutorialmod.entity.EntityTutorialGrenade;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(bus = Bus.MOD)
public class TutorialEntityTypes {
	
	public static final EntityType<EntityTutorialGrenade> tutorialGrenade = EntityType.Builder.create(EntityTutorialGrenade.class, EntityTutorialGrenade::new).tracker(128, 20, true).build("");
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<EntityType<?>> event) {
		IForgeRegistry<EntityType<?>> registry = event.getRegistry();
		
		tutorialGrenade.setRegistryName(TutorialMod.modid, "tutorial_grenade");
		registry.register(tutorialGrenade);
		
	}
}
