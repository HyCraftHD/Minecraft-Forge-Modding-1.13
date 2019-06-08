package net.hycrafthd.tutorialmod.init;

import java.util.function.Supplier;

import net.hycrafthd.tutorialmod.TutorialMod;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TutorialArmorMaterials {
	
	public static final IArmorMaterial tutorial = new ArmorMaterial(TutorialMod.modid + ":tutorial", 5, new int[] { 2, 5, 8, 2 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, () -> Ingredient.fromItems(TutorialItems.tutorial));
	
	private static class ArmorMaterial implements IArmorMaterial {
		
		private static final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyLoadBase<Ingredient> repairMaterial;
		
		private ArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> supplier) {
			this.name = name;
			this.maxDamageFactor = maxDamageFactor;
			this.damageReductionAmountArray = damageReductionAmountArray;
			this.enchantability = enchantability;
			this.soundEvent = soundEvent;
			this.toughness = toughness;
			this.repairMaterial = new LazyLoadBase<>(supplier);
		}
		
		public int getDurability(EntityEquipmentSlot slot) {
			return MAX_DAMAGE_ARRAY[slot.getIndex()] * maxDamageFactor;
		}
		
		public int getDamageReductionAmount(EntityEquipmentSlot slotIn) {
			return damageReductionAmountArray[slotIn.getIndex()];
		}
		
		public int getEnchantability() {
			return enchantability;
		}
		
		public SoundEvent getSoundEvent() {
			return soundEvent;
		}
		
		public Ingredient getRepairMaterial() {
			return repairMaterial.getValue();
		}
		
		@OnlyIn(Dist.CLIENT)
		public String getName() {
			return name;
		}
		
		public float getToughness() {
			return toughness;
		}
	}
}
