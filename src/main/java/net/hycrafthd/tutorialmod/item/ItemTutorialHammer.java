package net.hycrafthd.tutorialmod.item;

import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemTutorialHammer extends Item {
	
	public ItemTutorialHammer() {
		super(new Properties().group(TutorialItemGroups.group).defaultMaxDamage(10));
	}
	
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		final ItemStack copy = itemStack.copy();
		if (copy.attemptDamageItem(1, Item.random, null)) {
			copy.shrink(1);
			copy.setDamage(0);
		}
		return copy;
	}
	
}
