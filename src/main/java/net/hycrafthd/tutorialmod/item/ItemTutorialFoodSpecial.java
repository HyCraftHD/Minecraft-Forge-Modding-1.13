package net.hycrafthd.tutorialmod.item;

import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemTutorialFoodSpecial extends ItemFood {
	
	public ItemTutorialFoodSpecial() {
		super(4, 8, false, new Properties().group(TutorialItemGroups.group));
		setAlwaysEdible();
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote) {
			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 400, 1));
			player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 3));
		}
	}
}
