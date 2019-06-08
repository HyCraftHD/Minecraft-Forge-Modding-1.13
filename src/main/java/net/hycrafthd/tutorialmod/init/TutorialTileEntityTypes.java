package net.hycrafthd.tutorialmod.init;

import net.hycrafthd.tutorialmod.TutorialMod;
import net.hycrafthd.tutorialmod.tileentity.TileEntityTutorialStorage;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(bus = Bus.MOD)
public class TutorialTileEntityTypes {
	
	public static final TileEntityType<TileEntityTutorialStorage> tutorialStorage = TileEntityType.Builder.create(TileEntityTutorialStorage::new).build(null);
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<TileEntityType<?>> event) {
		IForgeRegistry<TileEntityType<?>> registry = event.getRegistry();
		
		tutorialStorage.setRegistryName(TutorialMod.modid, "tutorialstorage");
		registry.register(tutorialStorage);
	}
}
