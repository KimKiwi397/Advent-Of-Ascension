package net.tslat.aoa3.item.weapon.cannon;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.tslat.aoa3.common.registration.SoundsRegister;
import net.tslat.aoa3.common.registration.WeaponRegister;
import net.tslat.aoa3.entity.projectiles.cannon.EntityRPG;
import net.tslat.aoa3.entity.projectiles.gun.BaseBullet;
import net.tslat.aoa3.item.weapon.AdventWeapon;
import net.tslat.aoa3.item.weapon.gun.BaseGun;
import net.tslat.aoa3.library.Enums;
import net.tslat.aoa3.utils.EntityUtil;
import net.tslat.aoa3.utils.ItemUtil;
import net.tslat.aoa3.utils.ModUtil;
import net.tslat.aoa3.utils.StringUtil;

import javax.annotation.Nullable;
import java.util.List;

public class RPG extends BaseCannon implements AdventWeapon {
	private double dmg;
	private int firingDelay;

	public RPG(double dmg, int durability, int firingDelayTicks, float recoil) {
		super(dmg, durability, firingDelayTicks, recoil);
		setTranslationKey("RPG");
		setRegistryName("aoa3:rpg");
		this.dmg = dmg;
		this.firingDelay = firingDelayTicks;
	}

	@Nullable
	@Override
	public SoundEvent getFiringSound() {
		return SoundsRegister.gunRPG;
	}

	@Override
	public BaseBullet findAndConsumeAmmo(EntityPlayer player, BaseGun gun, EnumHand hand) {
		Item ammo = ItemUtil.findAndConsumeSpecialBullet(player, gun, true, WeaponRegister.throwableGrenade, player.getHeldItem(hand));

		if (ammo != null)
			return new EntityRPG(player, gun, hand, 120, 0);

		return null;
	}

	@Override
	public void doImpactDamage(Entity target, EntityLivingBase shooter, BaseBullet bullet, float bulletDmgMultiplier) {
		if (target != null) {
			if (target instanceof EntityLivingBase)
				bulletDmgMultiplier *= 1 + (((EntityLivingBase)target).getEntityAttribute(SharedMonsterAttributes.ARMOR).getAttributeValue() * 6.66) / 100;

			if (EntityUtil.dealGunDamage(target, shooter, bullet, (float)dmg * bulletDmgMultiplier) && shooter instanceof EntityPlayerMP) {
				if (target instanceof EntityLivingBase && ((EntityLivingBase)target).getHealth() == 0 && target.isAirBorne) {
					if (target.world.isAirBlock(target.getPosition().down()) && target.world.isAirBlock(target.getPosition().down(2)))
						ModUtil.completeAdvancement((EntityPlayerMP)shooter, "overworld/surface_to_air", "rpg_air_kill");
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(1, ItemUtil.getFormattedDescriptionText("items.description.damage.gun", Enums.ItemDescriptionType.ITEM_DAMAGE, Double.toString(dmg)));
		tooltip.add(ItemUtil.getFormattedDescriptionText("item.RPG.desc.1", Enums.ItemDescriptionType.POSITIVE));
		tooltip.add(ItemUtil.getFormattedDescriptionText("items.description.cannon.damage", Enums.ItemDescriptionType.ITEM_TYPE_INFO));
		tooltip.add(StringUtil.getLocaleStringWithArguments("items.description.gun.speed", Double.toString((2000 / firingDelay) / (double)100)));
		tooltip.add(ItemUtil.getFormattedDescriptionText("items.description.ammo.grenades", Enums.ItemDescriptionType.ITEM_AMMO_COST));
	}
}
