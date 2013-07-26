package net.minecraft.src;

public abstract class IHW_ModelBase extends MMM_ModelBase {

	public abstract void setRotationAngles(ItemStack pitem, Entity pentity, int pThirdPersonView);
	public abstract void renderItem(ItemStack pitem, Entity pentity, int pThirdPersonView);
	public abstract void renderSpecial(ItemStack pitem, Entity pentity, int pThirdPersonView);

	/**
	 * Entity���v���[���[�̏ꍇ�A�A�N�V�������擾����B
	 * @param pEntity
	 * @return
	 */
	public EnumAction getAction(Entity pEntity) {
		if (pEntity instanceof EntityPlayer) {
			EntityPlayer lplayer = (EntityPlayer)pEntity;
			if (lplayer.getItemInUse() != null) {
				return lplayer.getItemInUse().getItemUseAction();
			}
		}
		return null;
	}

}
