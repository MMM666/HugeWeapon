package net.minecraft.src;


public class IHW_PacketLightWaveSpawn extends Packet23VehicleSpawn {

	public IHW_PacketLightWaveSpawn(Entity par1Entity, int par2, int par3) {
		super(par1Entity, par2, par3);
	}

	@Override
	public void processPacket(NetHandler par1NetHandler) {
		if (par1NetHandler instanceof NetClientHandler) {
			Minecraft mc = MMM_Helper.mc;
			WorldClient lworld = mc.theWorld;
			double lx = (double)this.xPosition / 32.0D;
			double ly = (double)this.yPosition / 32.0D;
			double lz = (double)this.zPosition / 32.0D;
			
			Entity le = (mc.thePlayer.entityId == throwerEntityId) ? mc.thePlayer : lworld.getEntityByID(throwerEntityId);
			if (le instanceof EntityLivingBase) {
				IHW_EntityLightWave lentity = new IHW_EntityLightWave(lworld, lx, ly, lz);
				lentity.serverPosX = this.xPosition;
				lentity.serverPosY = this.yPosition;
				lentity.serverPosZ = this.zPosition;
				lentity.rotationYaw = 0.0F;
				lentity.rotationPitch = 0.0F;
				lentity.entityId = this.entityId;
//				lentity.thrower = (EntityLiving)le;
				lentity.setVelocity((double)speedX / 8000.0D, (double)speedY / 8000.0D, (double)speedZ / 8000.0D);
				lworld.addEntityToWorld(this.entityId, lentity);
			}
		}
	}

}
