package net.minecraft.src;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;

public class IHW_MoonLight {

	public static final IHW_ModelBase fModel = new IHW_ModelMoonLight();


	public static void setENMode(ItemStack pItemstack, boolean pFlag) {
		pItemstack.setTagInfo("ENMode", new NBTTagByte("ENMode", (byte)(pFlag ? 1 : 0)));
		pItemstack.itemID = pFlag ? mod_IHW_HugeWeapon.MoonLightB.itemID : mod_IHW_HugeWeapon.MoonLightN.itemID;
	}

	public static boolean isENMode(ItemStack pItemstack) {
		if (pItemstack.hasTagCompound()) {
			return pItemstack.getTagCompound().getBoolean("ENMode");
		}
		return false;
	}

	public static boolean renderItem(EntityLiving pEntity, ItemStack pItemstack, int pIndex) {
		// 独自のアイテムレンダラ
		fModel.setRotationAngles(pItemstack, pEntity, MMM_Helper.mc.gameSettings.thirdPersonView);
		if (pIndex == 0) {
			fModel.renderItem(pItemstack, pEntity, MMM_Helper.mc.gameSettings.thirdPersonView);
		} else {
			fModel.renderSpecial(pItemstack, pEntity, MMM_Helper.mc.gameSettings.thirdPersonView);
		}
		return true;
	}

	public static boolean isRenderItemWorld() {
		return false;
	}

}
