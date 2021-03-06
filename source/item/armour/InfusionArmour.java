package net.tslat.aoa3.item.armour;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.tslat.aoa3.item.SkillItem;
import net.tslat.aoa3.library.Enums;
import net.tslat.aoa3.utils.ItemUtil;
import net.tslat.aoa3.utils.StringUtil;
import net.tslat.aoa3.utils.player.PlayerDataManager;

import javax.annotation.Nullable;
import java.util.List;

import static net.tslat.aoa3.common.registration.MaterialsRegister.ARMOUR_INFUSION;

public class InfusionArmour extends AdventArmour implements SkillItem {
	public InfusionArmour(String name, String registryName, EntityEquipmentSlot slot) {
		super(ARMOUR_INFUSION, name, registryName, slot);
	}

	@Override
	public Enums.ArmourSets setType() {
		return Enums.ArmourSets.INFUSION;
	}

	@Override
	public Enums.Skills getSkill() {
		return Enums.Skills.INFUSION;
	}

	@Override
	public int getLevelReq() {
		return 100;
	}

	@Override
	public void addBuffs(PlayerDataManager.PlayerBuffs plBuffs, @Nullable EntityEquipmentSlot slot) {
		if (slot == null)
			plBuffs.addXpModifier(Enums.Skills.INFUSION, 0.3f);
	}

	@Override
	public void removeBuffs(PlayerDataManager.PlayerBuffs plBuffs, @Nullable EntityEquipmentSlot slot) {
		if (slot == null)
			plBuffs.removeXpModifier(Enums.Skills.INFUSION, 0.3f);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(setEffectHeader());
		tooltip.add(ItemUtil.getFormattedDescriptionText("item.InfusionArmour.desc.1", Enums.ItemDescriptionType.POSITIVE));
		tooltip.add(ItemUtil.getFormattedDescriptionText("item.InfusionArmour.desc.2", Enums.ItemDescriptionType.POSITIVE));
		tooltip.add(ItemUtil.getFormattedDescriptionText("items.description.skillXpBonus", Enums.ItemDescriptionType.POSITIVE, Integer.toString(30), StringUtil.getLocaleString("skills.infusion.name")));
		tooltip.add(ItemUtil.getFormattedLevelRestrictedDescriptionText(Enums.Skills.INFUSION, 100));
	}
}
