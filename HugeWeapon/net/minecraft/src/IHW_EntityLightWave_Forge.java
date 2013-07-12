package net.minecraft.src;

import cpw.mods.fml.common.registry.IThrowableEntity;

public class IHW_EntityLightWave_Forge extends IHW_EntityLightWave implements IThrowableEntity {

	public IHW_EntityLightWave_Forge(World par1World) {
		super(par1World);
	}

	public IHW_EntityLightWave_Forge(World par1World, EntityLivingBase par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public IHW_EntityLightWave_Forge(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	public void setThrower(Entity entity) {
		// TODO Auto-generated method stub
	}

}
