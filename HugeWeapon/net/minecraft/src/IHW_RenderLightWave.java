package net.minecraft.src;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class IHW_RenderLightWave extends Render {

	public static final ResourceLocation fmodelTex = new ResourceLocation("textures/models/hugeweapon/LightWave.png");


	public void renderLightWave(IHW_EntityLightWave pEntity,
			double pX, double pY, double pZ, float var8, float var9) {
		func_110776_a(this.func_110775_a(pEntity));
		GL11.glPushMatrix();
		MMM_Helper.mc.entityRenderer.disableLightmap(0D);
		
		GL11.glTranslatef((float)pX, (float)pY, (float)pZ);
		GL11.glRotatef(pEntity.prevRotationYaw + (pEntity.rotationYaw - pEntity.prevRotationYaw) * var9, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(pEntity.prevRotationPitch + (pEntity.rotationPitch - pEntity.prevRotationPitch) * var9, 1.0F, 0.0F, 0.0F);
		Tessellator var10 = Tessellator.instance;
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		
		float lscale = 0.05625F;
		GL11.glScalef(lscale, lscale, lscale);
		
		float lcolor = 0.5F;
		GL11.glColor4f(lcolor, lcolor, lcolor, 1.0F);
		double lpx[] = new double[] {18.0D, 12.0D, 6.0D, 3.0D};
		double lpy[] = new double[] {4.0D, 2.6D, 1.3D, 0.4D};
		double lpz[] = new double[] {8.0D, 12.0D, 18.0D, 25.0D};
		
		for (int li = 0; li < 4; li++) {
//			GL11.glNormal3f(0.0F, lscale, 0.0F);
			GL11.glNormal3f(-lscale, 0.0F, 0.0F);
			var10.startDrawing(GL11.GL_TRIANGLE_FAN);
			var10.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.5D, 0.0D);
			var10.addVertexWithUV(-lpx[li], 0.0D, -lpz[li], 0.0D, 1.0D);
			var10.addVertexWithUV(0.0D, lpy[li], -lpz[li], 0.5D, 1.0D);
			var10.addVertexWithUV(lpx[li], 0.0D, -lpz[li], 1.0D, 1.0D);
			var10.addVertexWithUV(0.0D, -lpy[li], -lpz[li], 0.5D, 1.0D);
			var10.addVertexWithUV(-lpx[li], 0.0D, -lpz[li], 0.0D, 1.0D);
			var10.draw();
		}
		
		for (int li = 3; li >= 0; li--) {
			GL11.glNormal3f(0.0F, lscale, 0.0F);
			var10.startDrawing(GL11.GL_TRIANGLE_FAN);
			var10.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.5D, 0.0D);
			var10.addVertexWithUV(lpx[li], 0.0D, -lpz[li], 0.0D, 1.0D);
			var10.addVertexWithUV(0.0D, lpy[li], -lpz[li], 0.5D, 1.0D);
			var10.addVertexWithUV(-lpx[li], 0.0D, -lpz[li], 1.0D, 1.0D);
			var10.addVertexWithUV(0.0D, -lpy[li], -lpz[li], 0.5D, 1.0D);
			var10.addVertexWithUV(lpx[li], 0.0D, -lpz[li], 0.0D, 1.0D);
			var10.draw();
		}
		
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		
		MMM_Helper.mc.entityRenderer.enableLightmap(0D);
		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		renderLightWave((IHW_EntityLightWave)var1, var2, var4, var6, var8, var9);
	}

	@Override
	protected ResourceLocation func_110775_a(Entity var1) {
		return fmodelTex;
	}

}
