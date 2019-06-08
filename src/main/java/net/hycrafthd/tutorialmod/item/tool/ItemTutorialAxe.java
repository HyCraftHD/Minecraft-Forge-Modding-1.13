package net.hycrafthd.tutorialmod.item.tool;

import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.hycrafthd.tutorialmod.init.TutorialToolMaterials;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.common.ToolType;

public class ItemTutorialAxe extends ItemAxe {
	
	public ItemTutorialAxe() {
		super(TutorialToolMaterials.tutorial, 10, -3.5F, new Properties().group(TutorialItemGroups.group).addToolType(ToolType.AXE, TutorialToolMaterials.tutorial.getHarvestLevel()));
	}
	
}
