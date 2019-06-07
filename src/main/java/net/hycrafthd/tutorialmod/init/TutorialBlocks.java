package net.hycrafthd.tutorialmod.init;

import net.hycrafthd.tutorialmod.TutorialMod;
import net.hycrafthd.tutorialmod.block.BlockTutorial;
import net.hycrafthd.tutorialmod.block.BlockTutorialFacing;
import net.hycrafthd.tutorialmod.item.ItemBlockDefault;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(bus = Bus.MOD)
public class TutorialBlocks {
	
	public static final BlockTutorial tutorial = new BlockTutorial();
	
	public static final BlockTutorialFacing tutorialfacing = new BlockTutorialFacing();
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		
		tutorial.setRegistryName(TutorialMod.modid, "blocktutorial");
		registry.register(tutorial);
		
		tutorialfacing.setRegistryName(TutorialMod.modid, "blocktutorial_facing");
		registry.register(tutorialfacing);
	}
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		
		registry.register(new ItemBlockDefault(tutorial));
		registry.register(new ItemBlockDefault(tutorialfacing));
	}
	
}
