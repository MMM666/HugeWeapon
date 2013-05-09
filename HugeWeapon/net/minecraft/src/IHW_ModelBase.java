package net.minecraft.src;

public abstract class IHW_ModelBase extends MMM_ModelBase {

	public abstract void setRotationAngles(ItemStack pitem, EntityLiving pentity, int pThirdPersonView);
	public abstract void renderItem(ItemStack pitem, EntityLiving pentity, int pThirdPersonView);
	public abstract void renderSpecial(ItemStack pitem, EntityLiving pentity, int pThirdPersonView);

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
