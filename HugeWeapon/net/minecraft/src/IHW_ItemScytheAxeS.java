package net.minecraft.src;


import java.util.List;

import com.google.common.collect.Multimap;

public class IHW_ItemScytheAxeS extends ItemShears implements IHW_IItemScytheAxe {

	protected float weaponDamage;


	protected IHW_ItemScytheAxeS(int par1) {
		super(par1);
		setCreativeTab(null);
		IHW_ScytheAxe.setMaxDamage(this);
		weaponDamage = 5;
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
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
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
		EntityPlayer lep = null;
		Entity lentity = null;
		boolean fcanattack = false;
		if (par3Entity instanceof EntityPlayer) {
			if (par2World.isRemote) {
				// Client
				lep = (EntityPlayer)par3Entity;
				// ターゲットは除外
				Minecraft lmc = MMM_Helper.mc;
				if (lmc != null && lmc.objectMouseOver != null) {
					lentity = lmc.objectMouseOver.entityHit;
				}
				if (lep.getHeldItem() == par1ItemStack) {
					// 腕の振り始めを検出して判定開始
					if (lep.isSwingInProgress) {
						if (lep.field_110158_av == -1) {
							fcanattack = true;
						}
					}
				}
				if (par3Entity == lmc.thePlayer) {
					IHW_ScytheAxe.setLeftClickCounter(lep.attackTime);
				}
			}
		} else if (par3Entity instanceof EntityLiving) {
			if (!par2World.isRemote) {
				// Server
				lep = (EntityPlayer)MMM_Helper.getAvatarPlayer(par3Entity);
				if (lep != par3Entity) {
					// メイドさんである
					lentity = ((EntityLiving)par3Entity).getAttackTarget();
					if (lentity == null) {
						lentity = ((EntityCreature)par3Entity).getEntityToAttack();
					}
					if (lep.getHeldItem() == par1ItemStack) {
						// 腕の振り始めを検出して判定開始
						if (lep.isSwingInProgress) {
							if (lep.field_110158_av == -1) {
								fcanattack = true;
							}
						}
					}
				} else {
					fcanattack = ((EntityLiving)par3Entity).attackTime == 0;
				}
			}
		}
		
		if (fcanattack) {
			// 自身の周囲のMOBを獲得
			List llist = par2World.getEntitiesWithinAABB(EntityLivingBase.class, par3Entity.boundingBox.expand(5D, 0D, 5D));
//			System.out.println(String.format("AttackAround: %d", llist.size()));
			for (int lj = 0; lj < llist.size(); lj++) {
				// 自分と通常の処理対象は除外
				EntityLivingBase lel = (EntityLivingBase)llist.get(lj);
				if (lel == par3Entity || lel == lentity || lel == lep) continue;
				// 射程距離の判定、MOBの大きさを考慮
				double lln = 3.0D + (double)lel.width;
				lln *= lln;
				if (par3Entity.getDistanceSqToEntity(lel) <= lln) {
					// 範囲攻撃の対象
					double lvx = lel.posX - par3Entity.posX;
					double lvz = par3Entity.posZ - lel.posZ;
					float lyaw = (float)Math.toDegrees(Math.atan2(lvx, lvz));
					float lf = par3Entity.rotationYaw - lyaw;
					for (;lf > 360F; lf -= 360);
					for (;lf < 0F; lf += 360);
					// 左230dig - 正面180deg - 右100dig
//					if (lep != null) {
//						System.out.println(String.format("%s, %d : %d : %f/%f : %f/%f", lel.getClass().getSimpleName(), lep.swingProgressInt, lep.attackTime, lep.getDistanceSqToEntity(lel), lln, lep.rotationYawHead, lf));
//					}
					if (lf > 100F && lf < 230F) {
						// 攻撃判定
//						System.out.println(String.format("Attack"));
//						System.out.println(String.format("%s, %d : %d : %f/%f : %f/%f", lel.getClass().getSimpleName(), lep.swingProgressInt, lep.attackTime, lep.getDistanceSqToEntity(lel), lln, lep.rotationYawHead, lf));
						if (par2World.isRemote) {
							ModLoader.clientSendPacket(new Packet7UseEntity(lep.entityId, lel.entityId, 1));
						}
						if (lep != null) {
							lep.attackTargetEntityWithCurrentItem(lel);
						} else {
							((EntityLivingBase)par3Entity).attackEntityAsMob(lel);
						}
					}
				}
			}
			
			// クールタイム
			lep.attackTime = 15;
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

	public Multimap func_111205_h() {
		Multimap var1 = super.func_111205_h();
		var1.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Tool modifier", (double)weaponDamage, 0));
		return var1;
	}

}
