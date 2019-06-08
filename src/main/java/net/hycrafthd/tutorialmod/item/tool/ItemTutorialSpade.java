package net.hycrafthd.tutorialmod.item.tool;

import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.hycrafthd.tutorialmod.init.TutorialToolMaterials;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.common.ToolType;

public class ItemTutorialSpade extends ItemSpade {
	
	public ItemTutorialSpade() {
		super(TutorialToolMaterials.tutorial, 3, 0, new Properties().group(TutorialItemGroups.group).addToolType(ToolType.SHOVEL, TutorialToolMaterials.tutorial.getHarvestLevel()));
	}
	
}
