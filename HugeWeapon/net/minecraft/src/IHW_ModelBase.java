package net.minecraft.src;

public abstract class IHW_ModelBase extends ModelBase {

	public abstract void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, ItemStack pitem);
	public abstract void renderItem(ItemStack pitem, EntityLiving pentity, int pThirdPersonView);

	public EnumAction getAction(EntityLiving pEntity) {
		if (pEntity instanceof EntityPlayer) {
			EntityPlayer lplayer = (EntityPlayer)pEntity;
			if (lplayer.getItemInUse() != null) {
				return lplayer.getItemInUse().getItemUseAction();
			}
		}
		return null;
	}

}
