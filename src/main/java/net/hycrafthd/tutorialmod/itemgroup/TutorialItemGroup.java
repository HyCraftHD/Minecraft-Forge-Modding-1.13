package net.hycrafthd.tutorialmod.itemgroup;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TutorialItemGroup extends ItemGroup {
	
	public TutorialItemGroup() {
		super("tutorial");
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public ItemStack createIcon() {
		return new ItemStack(Blocks.CHISELED_RED_SANDSTONE);
	}
	
}
