package net.hycrafthd.tutorialmod.init;

import net.hycrafthd.tutorialmod.TutorialMod;
import net.hycrafthd.tutorialmod.item.ItemTutorial;
import net.hycrafthd.tutorialmod.item.ItemTutorialFood;
import net.hycrafthd.tutorialmod.item.ItemTutorialFoodSpecial;
import net.hycrafthd.tutorialmod.item.ItemTutorialHammer;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(bus = Bus.MOD)
public class TutorialItems {
	
	public static final ItemTutorial tutorial = new ItemTutorial();
	
	public static final ItemTutorialFood tutorialFood = new ItemTutorialFood();
	public static final ItemTutorialFoodSpecial tutorialFoodSpecial = new ItemTutorialFoodSpecial();
	
	public static final ItemTutorialHammer tutorialHammer = new ItemTutorialHammer();
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		
		tutorial.setRegistryName(TutorialMod.modid, "itemtutorial");
		registry.register(tutorial);
		
		tutorialFood.setRegistryName(TutorialMod.modid, "itemtutorial_food");
		registry.register(tutorialFood);
		
		tutorialFoodSpecial.setRegistryName(TutorialMod.modid, "itemtutorial_food_special");
		registry.register(tutorialFoodSpecial);
		
		tutorialHammer.setRegistryName(TutorialMod.modid, "itemtutorial_hammer");
		registry.register(tutorialHammer);
	}
	
}
