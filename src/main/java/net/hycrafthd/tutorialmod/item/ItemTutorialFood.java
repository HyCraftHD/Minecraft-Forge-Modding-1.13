package net.hycrafthd.tutorialmod.item;

import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;

public class ItemTutorialFood extends ItemFood {
	
	public ItemTutorialFood() {
		super(4, 8, false, new Properties().group(TutorialItemGroups.group));
		setPotionEffect(new PotionEffect(MobEffects.HASTE, 100, 1, false, true), 1);
	}
	
}
