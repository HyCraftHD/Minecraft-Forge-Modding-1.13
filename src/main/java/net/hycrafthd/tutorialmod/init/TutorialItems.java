package net.hycrafthd.tutorialmod.init;

import net.hycrafthd.tutorialmod.TutorialMod;
import net.hycrafthd.tutorialmod.item.ItemTutorial;
import net.hycrafthd.tutorialmod.item.ItemTutorialFood;
import net.hycrafthd.tutorialmod.item.ItemTutorialFoodSpecial;
import net.hycrafthd.tutorialmod.item.ItemTutorialHammer;
import net.hycrafthd.tutorialmod.item.tool.ItemTutorialAxe;
import net.hycrafthd.tutorialmod.item.tool.ItemTutorialHoe;
import net.hycrafthd.tutorialmod.item.tool.ItemTutorialPickaxe;
import net.hycrafthd.tutorialmod.item.tool.ItemTutorialSpade;
import net.hycrafthd.tutorialmod.item.tool.ItemTutorialSword;
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
	
	public static final ItemTutorialAxe tutorialAxe = new ItemTutorialAxe();
	public static final ItemTutorialHoe tutorialHoe = new ItemTutorialHoe();
	public static final ItemTutorialPickaxe tutorialPickaxe = new ItemTutorialPickaxe();
	public static final ItemTutorialSpade tutorialSpade = new ItemTutorialSpade();
	public static final ItemTutorialSword tutorialSword = new ItemTutorialSword();
	
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
		
		tutorialAxe.setRegistryName(TutorialMod.modid, "itemtutorial_axe");
		tutorialHoe.setRegistryName(TutorialMod.modid, "itemtutorial_hoe");
		tutorialPickaxe.setRegistryName(TutorialMod.modid, "itemtutorial_pickaxe");
		tutorialSpade.setRegistryName(TutorialMod.modid, "itemtutorial_shovel");
		tutorialSword.setRegistryName(TutorialMod.modid, "itemtutorial_sword");
		registry.registerAll(tutorialAxe, tutorialHoe, tutorialPickaxe, tutorialSpade, tutorialSword);
	}
	
}
