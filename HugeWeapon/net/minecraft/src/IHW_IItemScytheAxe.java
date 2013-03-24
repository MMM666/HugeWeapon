package net.minecraft.src;

public interface IHW_IItemScytheAxe {

	public boolean isScythe();
	public boolean renderItem(EntityLiving pEntity, ItemStack pItemstack, int pIndex);
	public boolean renderItemInFirstPerson(float pDelta, MMM_IItemRenderer pItemRenderer);
	public String getRenderTexture();
	public boolean isRenderItemWorld();

}
