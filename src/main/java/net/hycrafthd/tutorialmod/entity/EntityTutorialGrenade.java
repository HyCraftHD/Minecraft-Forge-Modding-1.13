package net.hycrafthd.tutorialmod.entity;

import net.hycrafthd.tutorialmod.init.TutorialEntityTypes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntityTutorialGrenade extends EntityThrowable {
	
	public EntityTutorialGrenade(World world) {
		super(TutorialEntityTypes.tutorialGrenade, world);
	}
	
	public EntityTutorialGrenade(World world, EntityLivingBase thrower) {
		super(TutorialEntityTypes.tutorialGrenade, thrower, world);
	}
	
	@OnlyIn(Dist.CLIENT)
	public EntityTutorialGrenade(World world, double x, double y, double z) {
		super(TutorialEntityTypes.tutorialGrenade, x, y, z, world);
	}
	
	@Override
	protected void onImpact(RayTraceResult result) {
		final BlockPos pos = result.getBlockPos();
		world.createExplosion(null, DamageSource.MAGIC, pos.getX(), pos.getY(), pos.getZ(), 5, false, true);
		remove();
	}
	
}
