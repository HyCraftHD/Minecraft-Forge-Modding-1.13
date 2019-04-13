package net.hycrafthd.tutorialmod.item;

import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.minecraft.item.Item;

public class ItemTutorial extends Item {
	
	public ItemTutorial() {
		super(new Properties().group(TutorialItemGroups.group));
	}
}
