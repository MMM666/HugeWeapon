package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class IHW_ScytheAxe {

	public static final IHW_ModelScytheAxe fModel = new IHW_ModelScytheAxe();


	public static void setScythe(ItemStack pitem, boolean pflag) {
		if (!pitem.hasTagCompound()) {
			pitem.setTagCompound(new NBTTagCompound());
		}
		NBTTagCompound ltc = pitem.getTagCompound();
		ltc.setBoolean("Scythe", pflag);
	}

	public static boolean isScythe(ItemStack pitem) {
		if (pitem.hasTagCompound()) {
			NBTTagCompound ltc = pitem.getTagCompound();
			return ltc.getBoolean("Scythe");
		}
		return false;
	}

	public static int getCount(ItemStack pitem) {
		if (pitem.hasTagCompound()) {
			NBTTagCompound ltc = pitem.getTagCompound();
			return ltc.getInteger("Count");
		}
		return 0;
	}

	public static void setCount(ItemStack pitem, int pcount) {
		if (!pitem.hasTagCompound()) {
			pitem.setTagCompound(new NBTTagCompound());
		}
		NBTTagCompound ltc = pitem.getTagCompound();
		ltc.setInteger("Count",	pcount);
	}

	public static void setLeftClickCounter(int pvalue) {
		// クリック動作封印用
		try {
			// leftClickCounter
			ModLoader.setPrivateValue(Minecraft.class, MMM_Helper.mc, 28, Integer.valueOf(pvalue));
		} catch (Exception e) {
			
		}
	}

	public static void setMaxDamage(Item pItem) {
		pItem.setMaxDamage(375);
	}

	public static boolean checkMode(ItemStack pItemstack) {
		return ((IHW_IItemScytheAxe)pItemstack.getItem()).isScythe() == isScythe(pItemstack);
	}

	public static boolean renderItem(EntityLiving pEntity, ItemStack pItemstack, int pIndex) {
		// 独自のアイテムレンダラ
		fModel.setRotationAngles(0, 0, 0, 0, 0, 0, pItemstack);
		fModel.renderItem(pItemstack, pEntity, MMM_Helper.mc.gameSettings.thirdPersonView);
		return true;
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
		int lc = getCount(par1ItemStack);
		boolean lf = lc > 0;
		setCount(par1ItemStack, lf ? --lc : 0);
		if (par3Entity instanceof EntityPlayer) {
			EntityPlayer lep = (EntityPlayer)par3Entity;
			if (!par2World.isRemote) {
				// Server
				// 変形動作カウンター
				if (lf) {
					MMM_Helper.updateCheckinghSlot(lep, par1ItemStack);
				}
			} else {
				// Client
				if (lep == MMM_Helper.mc.thePlayer) {
					// 変形中の攻撃動作禁止
					if (lc > 0 && !lep.isUsingItem()) {
						setLeftClickCounter(10);
						lep.clearItemInUse();
					}
					
					// 変形
					if (lep.getItemInUse() == par1ItemStack) {
						// 一定時間ガードで変形
						if (lep.getItemInUseDuration() > 40 && checkMode(par1ItemStack)) {
							ModLoader.clientSendPacket(new Packet250CustomPayload("IHW", new byte[] {0x00}));
						}
/*
						// ガード中にクリックで変形
						if (MMM_Helper.mc.gameSettings.keyBindAttack.pressed) {
							ModLoader.clientSendPacket(new Packet250CustomPayload("IHW", new byte[] {0x00}));
						}
*/
					}
				}
			}
			if (!(lep.isUsingItem() && par5)) {
//			if (lep.getItemInUse() != par1ItemStack) {
				// 使用状態解除
				if (lc == 0) {
					if (isScythe(par1ItemStack)) {
						if (par1ItemStack.getItem() instanceof IHW_ItemScytheAxeA) {
							par1ItemStack.itemID = mod_IHW_HugeWeapon.ScytheAxeS.itemID;
						}
					} else {
						if (par1ItemStack.getItem() instanceof IHW_ItemScytheAxeS) {
							par1ItemStack.itemID = mod_IHW_HugeWeapon.ScytheAxeA.itemID;
						}
					}
				}
			}
		}
	}

}
