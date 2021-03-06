package net.minecraft.src;


import java.util.List;

public class IHW_ItemScytheAxeA extends ItemAxe implements IHW_IItemScytheAxe {

	protected IHW_ItemScytheAxeA(int par1) {
		super(par1, EnumToolMaterial.IRON);
		setCreativeTab(CreativeTabs.tabCombat);
		IHW_ScytheAxe.setMaxDamage(this);
		try {
			ModLoader.setPrivateValue(ItemTool.class, this, 2, (float)9F);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isScythe() {
		return false;
	}

	@Override
	public boolean isFull3D() {
		return true;
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		// エンチャントによる特殊動作
		if (!par3EntityLiving.worldObj.isRemote) {
			if (EnchantmentHelper.getSilkTouchModifier(par3EntityLiving)) {
				
				// アイテムスティール
				int li = par2EntityLiving.getRNG().nextInt(5);
				ItemStack litemstack = par2EntityLiving.getCurrentItemOrArmor(li);
				par2EntityLiving.setCurrentItemOrArmor(li, null);
				if (litemstack != null) {
					par2EntityLiving.entityDropItem(litemstack, 0.0F);
//					System.out.println(String.format("Steel:%d", li));
				}
			}
		}
		return IHW_ScytheAxe.hitEntity(par1ItemStack, par2EntityLiving, par3EntityLiving);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (IHW_ScytheAxe.getCount(par1ItemStack) == 0) {
			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		}
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World,
			Entity par3Entity, int par4, boolean par5) {
		super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
		
		IHW_ScytheAxe.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("\u00a79Axe Mode");
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
	}

	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		return IHW_ScytheAxe.getIsRepairable(par1ItemStack, par1ItemStack) || super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

}
