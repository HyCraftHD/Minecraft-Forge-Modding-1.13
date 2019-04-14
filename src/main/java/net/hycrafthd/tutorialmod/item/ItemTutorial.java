package net.hycrafthd.tutorialmod.item;

import net.hycrafthd.tutorialmod.init.TutorialItemGroups;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemTutorial extends Item {
	
	public ItemTutorial() {
		super(new Properties().group(TutorialItemGroups.group).defaultMaxDamage(20).rarity(EnumRarity.UNCOMMON));
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if (!world.isRemote) {
			world.setBlockState(player.getPosition().down(), Blocks.DIAMOND_BLOCK.getDefaultState());
		}
		stack.damageItem(1, player);
		player.jump();
		player.fallDistance = 0;
		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}
}
