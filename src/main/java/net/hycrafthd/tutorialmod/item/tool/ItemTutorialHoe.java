package net.hycrafthd.tutorialmod.item.tool;

import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.hycrafthd.tutorialmod.init.TutorialToolMaterials;
import net.minecraft.item.ItemHoe;

public class ItemTutorialHoe extends ItemHoe {
	
	public ItemTutorialHoe() {
		super(TutorialToolMaterials.tutorial, 0, new Properties().group(TutorialItemGroups.group));
	}
}
