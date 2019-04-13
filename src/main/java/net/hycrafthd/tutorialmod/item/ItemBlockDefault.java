package net.hycrafthd.tutorialmod.item;

import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockDefault extends ItemBlock {

	public ItemBlockDefault(Block block) {
		super(block, new Properties().group(TutorialItemGroups.group));
		setRegistryName(block.getRegistryName());
	}
}
