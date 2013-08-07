package net.minecraft.src;

import org.lwjgl.opengl.GL11;


public class IHW_ScytheAxe implements MMM_IItemRenderManager {

	public static final ResourceLocation fmodelTex = new ResourceLocation("textures/models/hugeweapon/ScytheAxe.png");
	public static IHW_ScytheAxe instance = new IHW_ScytheAxe();
	public static final IHW_ModelBase fModel;


	static {
		if (MMM_Helper.isClient) {
			fModel = new IHW_ModelScytheAxe();
		} else {
			fModel = null;
		}
	}

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
			ModLoader.setPrivateValue(Minecraft.class, MMM_Helper.mc, 30, Integer.valueOf(pvalue));
		} catch (Exception e) {
			
		}
	}

	public static void setMaxDamage(Item pItem) {
		pItem.setMaxDamage(260);
	}

	public static boolean checkMode(ItemStack pItemstack) {
		return ((IHW_IItemScytheAxe)pItemstack.getItem()).isScythe() == isScythe(pItemstack);
	}

	// 独自のアイテムレンダラ
	@Override
	public boolean renderItem(Entity pEntity, ItemStack pItemstack, int pIndex) {
		int lviewmode = MMM_Helper.mc.thePlayer == pEntity ? MMM_Helper.mc.gameSettings.thirdPersonView : VM_THERD_PERSON;
		if (lviewmode == VM_FIRST_PERSON) {
			// FirstPerson
			GL11.glScalef(0.14F, 0.14F, 0.14F);
			GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
			GL11.glRotatef(140.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-20.0F, 1.0F, 0.0F, 0.0F);
		} else {
			// TherdPerson
			GL11.glScalef(0.14F, 0.14F, 0.14F);
			GL11.glTranslatef(-1.0F, 0.0F, 0.0F);
			GL11.glRotatef(140.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-20.0F, 1.0F, 0.0F, 0.0F);
		}
		fModel.setRotationAngles(pItemstack, pEntity, lviewmode);
		fModel.renderItem(pItemstack, pEntity, lviewmode);
		return true;
	}

	@Override
	public boolean renderItemInFirstPerson(Entity pEntity,
			ItemStack pItemStack, float pDeltaTimepRenderPhatialTick) {
		return false;
	}


	@Override
	public ResourceLocation getRenderTexture(ItemStack pItemStack) {
		return fmodelTex;
	}

	public static boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
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

	@Override
	public boolean renderItemWorld(ItemStack pItemStack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRenderItemWorld(ItemStack pItemStack) {
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
