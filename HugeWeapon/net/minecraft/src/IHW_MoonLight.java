package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class IHW_MoonLight {

	public static final IHW_ModelBase fModel = new IHW_ModelMoonLight();



	public static void setENMode(ItemStack pItemstack, boolean pFlag) {
		pItemstack.setTagInfo("ENMode", new NBTTagByte("ENMode", (byte)(pFlag ? 1 : 0)));
	}

	public static boolean isENMode(ItemStack pItemstack) {
		if (pItemstack.hasTagCompound()) {
			return pItemstack.getTagCompound().getBoolean("ENMode");
		}
		return false;
	}

	public static void setMaxDamage(Item pItem) {
		pItem.setMaxDamage(420);
	}

	public static boolean checkMode(ItemStack pItemstack) {
		return ((IHW_IItemScytheAxe)pItemstack.getItem()).isScythe() == isENMode(pItemstack);
	}

	public static boolean renderItem(EntityLiving pEntity, ItemStack pItemstack, int pIndex) {
		// 独自のアイテムレンダラ
		fModel.setRotationAngles(0, 0, 0, 0, 0, 0, pItemstack);
		fModel.renderItem(pItemstack, pEntity, MMM_Helper.mc.gameSettings.thirdPersonView);
		return true;
	}

	public static boolean isRenderItemWorld() {
		return false;
	}



	public static boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
		par1ItemStack.damageItem(1, par3EntityLiving);
		return true;
	}

	public static boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		return EnumToolMaterial.IRON.getToolCraftingMaterial() == par2ItemStack.itemID;
	}

	public static void onUpdate(ItemStack par1ItemStack, World par2World,
			Entity par3Entity, int par4, boolean par5) {
		// 共通動作
	}


}
