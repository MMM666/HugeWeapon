package net.minecraft.src;

/**
 * Œõ”g
 */
public class IHW_EntityLightWave extends EntityThrowable {

	public int fliveTime;
	public double fmotionX;
	public double fmotionY;
	public double fmotionZ;


	public IHW_EntityLightWave(World par1World) {
		super(par1World);
	}

	public IHW_EntityLightWave(World par1World, EntityLivingBase par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public IHW_EntityLightWave(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		fliveTime = 0;
		setSize(1.95F, 0.5F);
	}

	@Override
	public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
		super.setThrowableHeading(par1, par3, par5, par7, par8);
	}

	@Override
	protected float getGravityVelocity() {
		// ©—R—‰º‚Í‚µ‚È‚¢
		return 0.0F;
	}

	@Override
	public void onUpdate() {
		fmotionX = motionX;
		fmotionY = motionY;
		fmotionZ = motionZ;
		
		super.onUpdate();
		
		if (fliveTime++ > 20) {
			// Ë’ö‹——£
			setDead();
		}
		// ‘¬“xŒ¸Š‚È‚µ
		motionX = fmotionX;
		motionY = fmotionY;
		motionZ = fmotionZ;
	}

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if (!worldObj.isRemote) {
			// Server
			setDead();
			// ’…’e‚É”š”­
			float lpower = 1.0F;
			this.worldObj.createExplosion(this,
					var1.hitVec.xCoord, var1.hitVec.yCoord, var1.hitVec.zCoord, lpower, false);
		}
	}

}
