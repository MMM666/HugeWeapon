package net.minecraft.src;


public class IHW_MoonLight implements MMM_IItemRenderManager {

	public static final ResourceLocation fmodelTex = new ResourceLocation("textures/models/hugeweapon/MoonLight.png");
	public static IHW_MoonLight instance = new IHW_MoonLight();
	public static final IHW_ModelBase fModel;


	static {
		if (MMM_Helper.isClient) {
			fModel = new IHW_ModelMoonLight();
		} else {
			fModel = null;
		}
	}

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

	@Override
	public boolean renderItem(Entity pEntity, ItemStack pItemstack, int pIndex) {
		// 独自のアイテムレンダラ
		fModel.setRotationAngles(pItemstack, pEntity, MMM_Helper.mc.gameSettings.thirdPersonView);
		if (pIndex == 0) {
			fModel.renderItem(pItemstack, pEntity, MMM_Helper.mc.gameSettings.thirdPersonView);
		} else {
			fModel.renderSpecial(pItemstack, pEntity, MMM_Helper.mc.gameSettings.thirdPersonView);
		}
		return true;
	}

	@Override
	public boolean renderItemInFirstPerson(Entity pEntity,
			ItemStack pItemStack, float pDeltaTimepRenderPhatialTick) {
		return false;
	}

	@Override
	public boolean isRenderItemWorld(ItemStack pItemStack) {
		return false;
	}

	@Override
	public ResourceLocation getRenderTexture(ItemStack pItemStack) {
		return fmodelTex;
	}

	@Override
	public boolean renderItemWorld(ItemStack pItemStack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRenderItem(ItemStack pItemStack) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isRenderItemInFirstPerson(ItemStack pItemStack) {
		// TODO Auto-generated method stub
		return true;
	}

}
