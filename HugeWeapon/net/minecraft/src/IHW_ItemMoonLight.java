package net.minecraft.src;

import java.util.List;

public class IHW_ItemMoonLight extends ItemSword {

	public IHW_ItemMoonLight(int pItemID) {
		super(pItemID, EnumToolMaterial.IRON);
		setMaxDamage(420);
	}

	
	
	
	@Override
	public int getDamageVsEntity(Entity par1Entity) {
		return 10;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World,
			Entity par3Entity, int par4, boolean par5) {
		super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
		if (IHW_MoonLight.isENMode(par1ItemStack) || true) {
			if (par3Entity instanceof EntityPlayer) {
				EntityPlayer lPlayer = (EntityPlayer)par3Entity;
				if (lPlayer.foodStats.getFoodLevel() > 0) {
					mod_IHW_HugeWeapon.Debug("%b", par2World.isRemote);
//					lPlayer.addExhaustion(0.1F);
				} else {
					// 空腹状態ではエネルギー放出を停止
					IHW_MoonLight.setENMode(par1ItemStack, false);
				}
			}
		}
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
//		par3List.add("\u00a79Axe Mode");
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
	}

	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		return EnumToolMaterial.IRON.getToolCraftingMaterial() == par2ItemStack.itemID || super.getIsRepairable(par1ItemStack, par2ItemStack);
	}


	// 独自のアイテムレンダラ
	public boolean renderItem(EntityLiving pEntity, ItemStack pItemstack, int pIndex) {
		return IHW_MoonLight.renderItem(pEntity, pItemstack, pIndex);
	}
	public boolean renderItemInFirstPerson(float pDelta, MMM_IItemRenderer pItemRenderer) {
		return false;
	}
	public String getRenderTexture() {
		return "/item/MoonLight.png";
	}

	public boolean isRenderItemWorld() {
		return IHW_MoonLight.isRenderItemWorld();
	}



}
