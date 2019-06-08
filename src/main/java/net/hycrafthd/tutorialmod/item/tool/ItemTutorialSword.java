package net.hycrafthd.tutorialmod.item.tool;

import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.hycrafthd.tutorialmod.init.TutorialToolMaterials;
import net.minecraft.item.ItemSword;

public class ItemTutorialSword extends ItemSword {
	
	public ItemTutorialSword() {
		super(TutorialToolMaterials.tutorial, 6, 10, new Properties().group(TutorialItemGroups.group));
	}
}
