package net.minecraft.src;


import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;

public class IHW_ItemScytheAxeS extends ItemShears implements MMM_IItemRender, IHW_IItemScytheAxe {

	protected IHW_ItemScytheAxeS(int par1) {
		super(par1);
		setCreativeTab(null);
		IHW_ScytheAxe.setMaxDamage(this);
	}

	@Override
	public boolean isScythe() {
		return true;
	}

	@Override
	public boolean isFull3D() {
		return true;
	}

	@Override
	public int getDamageVsEntity(Entity par1Entity) {
		return 6;
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
		// 攻撃時の減り具合
		
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
		
		// 範囲攻撃
		if (par2World.isRemote) {
			// Client
			if (par3Entity instanceof EntityPlayer) {
				EntityPlayer lep = (EntityPlayer)par3Entity;
				if (lep.getHeldItem() == par1ItemStack) {
					// 腕の振り始めを検出して判定開始
					if (lep.isSwingInProgress) {
						Minecraft lmc = MMM_Helper.mc;
						if (lep.swingProgressInt == -1) {
							// 攻撃判定
							Entity lentity = null;
							if (lmc.thePlayer == lep) {
								// ターゲットは除外
								if (lmc != null && lmc.objectMouseOver != null) {
									lentity = lmc.objectMouseOver.entityHit;
								}
							} else if (lep.getClass().getSimpleName().equals("LMM_EntityLittleMaidAvatar")) {
								// LMM用特殊除外処理
								try {
									lentity = (Entity)lep.getClass().getField("avatar").get(lep);
								} catch (Exception e) {
								}
							}
							// 自身の周囲のMOBを獲得
							List llist = par2World.getEntitiesWithinAABB(EntityLiving.class, par3Entity.boundingBox.expand(5D, 0D, 5D));
							for (int lj = 0; lj < llist.size(); lj++) {
								// 自分と通常の処理対象は除外
								EntityLiving lel = (EntityLiving)llist.get(lj);
								if (lel == lentity || lel == lep) continue;
								// 射程距離の判定、MOBの大きさを考慮
								double lln = 3.0D + (double)lel.width;
								lln *= lln;
								if (lep.getDistanceSqToEntity(lel) <= lln) {
									// 範囲攻撃の対象
									double lvx = lel.posX - lep.posX;
									double lvz = lep.posZ - lel.posZ;
									float lyaw = (float)Math.toDegrees(Math.atan2(lvx, lvz));
									float lf = lep.rotationYaw - lyaw;
									for (;lf > 360F; lf -= 360);
									for (;lf < 0F; lf += 360);
									// 左230dig - 正面180deg - 右100dig
									if (lf > 100F && lf < 230F) {
										// 攻撃判定
//										System.out.println(String.format("%s, %d : %d : %f/%f : %f/%f", lel.getClass().getSimpleName(), lep.swingProgressInt, lep.attackTime, lep.getDistanceSqToEntity(lel), lln, lep.rotationYawHead, lf));
										ModLoader.clientSendPacket(new Packet7UseEntity(lep.entityId, lel.entityId, 1));
										lep.attackTargetEntityWithCurrentItem(lel);
									}
								}
							}
							
							// クールタイム
							lep.attackTime = 20;
						}
					}
					if (par3Entity == MMM_Helper.mc.thePlayer) {
						IHW_ScytheAxe.setLeftClickCounter(lep.attackTime);
					}
				}
			}
			
		}
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	public boolean renderItem(EntityLiving pEntity, ItemStack pItemstack, int pIndex) {
		// 独自のアイテムレンダラ
		return IHW_ScytheAxe.renderItem(pEntity, pItemstack, pIndex);
	}

	@Override
	public boolean renderItemInFirstPerson(float pDelta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getRenderTexture() {
		return "/item/ScytheAxe.png";
	}

	@Override
	public boolean canHarvestBlock(Block par1Block) {
		return super.canHarvestBlock(par1Block) || par1Block instanceof BlockLeaves;
	}

	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		float lf = super.getStrVsBlock(par1ItemStack, par2Block);
		return lf > 10.0F ? 120.0F : lf;
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("\u00a79Scythe Mode");
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
	}

	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		return IHW_ScytheAxe.getIsRepairable(par1ItemStack, par1ItemStack) || super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

}
