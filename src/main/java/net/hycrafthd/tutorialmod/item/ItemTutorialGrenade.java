package net.hycrafthd.tutorialmod.item;

import net.hycrafthd.tutorialmod.entity.EntityTutorialGrenade;
import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemTutorialGrenade extends Item {
	
	public ItemTutorialGrenade() {
		super(new Properties().group(TutorialItemGroups.group));
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		final ItemStack stack = player.getHeldItem(hand);
		if (!player.abilities.isCreativeMode) {
			stack.shrink(1);
		}
		
		player.getCooldownTracker().setCooldown(this, 30);
		
		if (!world.isRemote) {
			EntityTutorialGrenade entityGrenade = new EntityTutorialGrenade(world, player);
			entityGrenade.shoot(player, player.rotationPitch, player.rotationYaw, 0F, 2F, 1.0F);
			world.spawnEntity(entityGrenade);
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
	
}
