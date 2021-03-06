package net.tslat.aoa3.entity.projectiles.cannon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.tslat.aoa3.entity.projectiles.HardProjectile;
import net.tslat.aoa3.entity.projectiles.gun.BaseBullet;
import net.tslat.aoa3.item.weapon.gun.BaseGun;

public class EntityMoonShot extends BaseBullet implements HardProjectile {
	public float yOffset1;
	public float yOffset2;
	public boolean toggle1;
	public boolean toggle2 = true;

	public EntityMoonShot(World world) {
		super(world);
	}

	public EntityMoonShot(EntityLivingBase shooter, BaseGun gun, EnumHand hand, int maxAge, int piercingValue) {
		super(shooter, gun, hand, maxAge, 1.0f, piercingValue);
	}

	public EntityMoonShot(World world, double x, double y, double z) {
		super(world, x, y, z);
	}
}
