package net.hycrafthd.tutorialmod.item.tool;

import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.hycrafthd.tutorialmod.init.TutorialToolMaterials;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.ToolType;

public class ItemTutorialPickaxe extends ItemPickaxe {
	
	public ItemTutorialPickaxe() {
		super(TutorialToolMaterials.tutorial, 4, -2F, new Properties().group(TutorialItemGroups.group).addToolType(ToolType.PICKAXE, TutorialToolMaterials.tutorial.getHarvestLevel()));
	}
	
}
