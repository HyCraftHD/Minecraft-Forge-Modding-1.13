package net.hycrafthd.tutorialmod.init;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

public class TutorialToolMaterials {
	
	public static final IItemTier tutorial = new ToolMaterial(2, 100, 6, 5, 14, () -> Ingredient.fromItems(TutorialItems.tutorial));
	
	private static class ToolMaterial implements IItemTier {
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyLoadBase<Ingredient> repair;
		
		public ToolMaterial(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> supplier) {
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repair = new LazyLoadBase<Ingredient>(supplier);
		}
		
		@Override
		public int getMaxUses() {
			return maxUses;
		}
		
		@Override
		public float getEfficiency() {
			return efficiency;
		}
		
		@Override
		public float getAttackDamage() {
			return attackDamage;
		}
		
		@Override
		public int getHarvestLevel() {
			return harvestLevel;
		}
		
		@Override
		public int getEnchantability() {
			return enchantability;
		}
		
		@Override
		public Ingredient getRepairMaterial() {
			return repair.getValue();
		}
	}
}
