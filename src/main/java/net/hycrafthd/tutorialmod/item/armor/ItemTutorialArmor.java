package net.hycrafthd.tutorialmod.item.armor;

import net.hycrafthd.tutorialmod.init.TutorialArmorMaterials;
import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemTutorialArmor extends ItemArmor {
	
	public ItemTutorialArmor(EntityEquipmentSlot slot) {
		super(TutorialArmorMaterials.tutorial, slot, new Properties().group(TutorialItemGroups.group));
	}
	
}
