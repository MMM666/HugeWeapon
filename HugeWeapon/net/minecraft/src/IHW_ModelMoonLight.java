package net.minecraft.src;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

public class IHW_ModelMoonLight extends IHW_ModelBase {

	public MMM_ModelRenderer fGrip;
	public MMM_ModelRenderer fRod;
	public MMM_ModelRenderer fBladePadding1;
	public MMM_ModelRenderer fBladePadding2;
	public MMM_ModelRenderer fBladePadding3;
	public MMM_ModelRenderer fBladePadding4;
	public MMM_ModelRenderer fBladePadding5;
	public MMM_ModelRenderer fBladePadding6;
	public MMM_ModelRenderer fBlade1;
	public MMM_ModelRenderer fBlade2;
	public MMM_ModelRenderer fBlade3;
	public MMM_ModelRenderer fBlade4;
	public MMM_ModelRenderer fBlade5;
	public MMM_ModelRenderer fBeam;
	public MMM_ModelRenderer fBeam1;
	public MMM_ModelRenderer fBeam2;
	public MMM_ModelRenderer fBeam3;
	public MMM_ModelRenderer fBeam4;
	public MMM_ModelRenderer fBeam5;



	public IHW_ModelMoonLight() {
		// ソリッドブレード
		fBladePadding1 = new MMM_ModelRenderer(this);
		fBladePadding1.setTextureOffsetMM(38, 14).addBoxMM(-1.0F, -3.0F, 0.0F, 2, 3, 4, 0.05F);
		fBladePadding1.setRotationPointMM(0.0F, -6.0F, 0.0F);
		fBladePadding1.setRotateAngleDegX(-8F);
		
		fBladePadding2 = new MMM_ModelRenderer(this);
		fBladePadding2.setTextureOffsetMM(30, 12).addBoxMM(-1.0F, -1.0F, 0.0F, 2, 2, 4, 0.05F);
		fBladePadding2.setRotationPointMM(0.0F, 1.0F, 4.5F);
		
		fBladePadding3 = new MMM_ModelRenderer(this);
		fBladePadding3.setTextureOffsetMM(38, 8).addBoxMM(-1.0F, .0F, 0.0F, 2, 2, 4, 0.05F);
		fBladePadding3.setRotationPointMM(0.0F, 6.0F, 0.0F);
		fBladePadding3.setRotateAngleDegX(11F);
		
		fBladePadding4 = new MMM_ModelRenderer(this);
		fBladePadding4.setTextureOffsetMM(30, 6).addBoxMM(-1.0F, .0F, 0.0F, 2, 2, 4, 0.05F);
		fBladePadding4.setRotationPointMM(0.0F, 6.0F, 0.0F);
		fBladePadding4.setRotateAngleDegX(8F);
		
		fBladePadding5 = new MMM_ModelRenderer(this);
		fBladePadding5.setTextureOffsetMM(38, 2).addBoxMM(-1.0F, .0F, 0.0F, 2, 2, 4, 0.05F);
		fBladePadding5.setRotationPointMM(0.0F, 7.0F, 0.0F);
		fBladePadding5.setRotateAngleDegX(6F);
		
		fBladePadding6 = new MMM_ModelRenderer(this);
		fBladePadding6.setTextureOffsetMM(30, 0).addBoxMM(-1.0F, .0F, 0.0F, 2, 2, 4, 0.05F);
		fBladePadding6.setRotationPointMM(0.0F, 8.0F, 0.0F);
		fBladePadding6.setRotateAngleDegX(6F);
		
		
		fBlade1 = new MMM_ModelRenderer(this);
		fBlade1.setTextureOffsetMM(0, 8).addBoxMM(-1.0F, -6.0F, 0.0F, 2, 6, 2);
		fBlade1.setTextureOffsetMM(8, 0).addBoxMM(-0.5F, -7.5F, 2.0F, 1, 7, 3);
		fBlade1.setTextureOffsetMM(24, 0).addBoxMM(-1.0F, -2.5F, -0.8F, 2, 1, 1, 0.2F);
		fBlade1.setRotationPointMM(0.0F, -1.0F, 0.0F);
		fBlade1.setRotateAngleDegX(-15F);
		
		fBlade2 = new MMM_ModelRenderer(this);
		fBlade2.setTextureOffsetMM(0, 16).addBoxMM(-1.0F, 0.0F, 0.0F, 2, 6, 2);
		fBlade2.setTextureOffsetMM(0, 0).addBoxMM(-0.5F, 0.5F, 2.0F, 1, 5, 3);
		fBlade2.setTextureOffsetMM(24, 2).addBoxMM(-1.0F, 1.5F, -0.8F, 2, 1, 1, 0.3F);
		fBlade2.setRotationPointMM(0.0F, 1.0F, 0.0F);
		fBlade2.setRotateAngleDegX(15F);
		
		fBlade3 = new MMM_ModelRenderer(this);
		fBlade3.setTextureOffsetMM(0, 24).addBoxMM(-1.0F, 0.0F, 0.0F, 2, 6, 2);
		fBlade3.setTextureOffsetMM(16, 0).addBoxMM(-0.5F, 0.0F, 2.0F, 1, 6, 3);
		fBlade3.setTextureOffsetMM(24, 4).addBoxMM(-1.0F, 2.0F, -0.8F, 2, 1, 1, 0.3F);
		fBlade3.setTextureOffsetMM(24, 10).addBoxMM(-0.5F, 1.5F, -2.7F, 1, 2, 2, 0.1F);
		fBlade3.setRotationPointMM(0.0F, 2.0F, 0.0F);
		fBlade3.setRotateAngleDegX(11F);
		
		fBlade4 = new MMM_ModelRenderer(this);
		fBlade4.setTextureOffsetMM(8, 13).addBoxMM(-1.0F, 0.0F, 0.0F, 2, 7, 2);
		fBlade4.setTextureOffsetMM(16, 9).addBoxMM(-0.5F, 0.0F, 2.0F, 1, 7, 3);
		fBlade4.setTextureOffsetMM(24, 6).addBoxMM(-1.0F, 3.0F, -0.8F, 2, 1, 1, 0.3F);
		fBlade4.setTextureOffsetMM(24, 14).addBoxMM(-0.5F, 2.5F, -2.7F, 1, 2, 2, 0.1F);
		fBlade4.setRotationPointMM(0.0F, 2.0F, 0.0F);
		fBlade4.setRotateAngleDegX(8F);
		
		fBlade5 = new MMM_ModelRenderer(this);
		fBlade5.setTextureOffsetMM(8, 22).addBoxMM(-1.0F, 0.0F, 0.0F, 2, 8, 2);
		fBlade5.setTextureOffsetMM(16, 19).addBoxMM(-0.5F, 0.0F, 2.0F, 1, 9, 3);
		fBlade5.setTextureOffsetMM(24, 8).addBoxMM(-1.0F, 4.0F, -0.8F, 2, 1, 1, 0.3F);
		fBlade5.setTextureOffsetMM(24, 18).addBoxMM(-0.5F, 3.5F, -2.7F, 1, 2, 2, 0.1F);
		fBlade5.setRotationPointMM(0.0F, 2.0F, 0.0F);
		fBlade5.setRotateAngleDegX(6F);
		
		fGrip = new MMM_ModelRenderer(this);
		fGrip.setTextureOffsetMM(26, 22).addBoxMM(-0.5F, -2.0F, -1.0F, 1, 6, 2, -0.2F);
		fGrip.setTextureOffsetMM(32, 21).addBoxMM(-1.0F, 3.0F, -1.0F, 2, 2, 3, 0.0F);
		fGrip.setTextureOffsetMM(42, 21).addBoxMM(-1.0F, -2.0F, 2.0F, 2, 7, 2, 0.1F);
		fGrip.setTextureOffsetMM(30, 26).addBoxMM(-1.0F, -4.0F, -1.0F, 2, 2, 4, 0.1F);
		fGrip.setTextureOffsetMM(38, 26).addBoxMM(-0.5F, -5.0F, 3.0F, 1, 3, 1, 0.1F);
		
		fRod = new MMM_ModelRenderer(this);
		fRod.setTextureOffsetMM(46, 0).addBoxMM(-0.5F, -4.0F, -0.5F, 1, 5, 1);
		fRod.setRotationPointMM(0.0F, -4.5F, 3.0F);
		fRod.setRotateAngleDegX(35F);
		
		fGrip.addChildMM(fRod);
		fGrip.addChildMM(fBladePadding2);
		fBladePadding2.addChildMM(fBlade1);
		fBlade1.addChildMM(fBladePadding1);
		fBladePadding2.addChildMM(fBlade2);
		fBlade2.addChildMM(fBladePadding3);
		fBladePadding3.addChildMM(fBlade3);
		fBlade3.addChildMM(fBladePadding4);
		fBladePadding4.addChildMM(fBlade4);
		fBlade4.addChildMM(fBladePadding5);
		fBladePadding5.addChildMM(fBlade5);
		fBlade5.addChildMM(fBladePadding6);
		
		// ビームブレード
		MMM_ModelRenderer lbp3, lbp4, lbp5;
		fBeam1 = new MMM_ModelRenderer(this);
		fBeam1.setTextureOffsetMM(59, 0).addPlate(0.7F, -7.5F, 2.0F, 5, 7, 1);
		fBeam1.setTextureOffsetMM(59, 0).addPlate(-0.7F, -7.5F, 2.0F, 5, 7, 1);
		fBeam1.setRotationPointMM(0.0F, -1.0F, 0.0F);
		fBeam1.setRotateAngleDegX(fBlade1.getRotateAngleDegX());
		
		fBeam = new MMM_ModelRenderer(this);
		fBeam.setRotationPointMM(0.0F, 1.0F, 4.5F);
		
		fBeam2 = new MMM_ModelRenderer(this);
		fBeam2.setTextureOffsetMM(59, 0).addPlate(0.7F, 0.5F, 2.0F, 5, 5, 1);
		fBeam2.setTextureOffsetMM(59, 0).addPlate(-0.7F, 0.5F, 2.0F, 5, 5, 1);
		fBeam2.setRotationPointMM(0.0F, 1.0F, 0.0F);
		fBeam2.setRotateAngleDegX(fBlade2.getRotateAngleDegX());
		
		lbp3 = new MMM_ModelRenderer(this);
		lbp3.setRotationPointMM(0.0F, 6.0F, 0.0F);
		lbp3.setRotateAngleDegX(fBladePadding3.getRotateAngleDegX());
		
		fBeam3 = new MMM_ModelRenderer(this);
		fBeam3.setTextureOffsetMM(59, 0).addPlate(0.7F, 0.0F, 2.0F, 5, 6, 1);
		fBeam3.setTextureOffsetMM(59, 0).addPlate(-0.7F, 0.0F, 2.0F, 5, 6, 1);
		fBeam3.setRotationPointMM(0.0F, 2.0F, 0.0F);
		fBeam3.setRotateAngleDegX(fBlade3.getRotateAngleDegX());
		
		lbp4 = new MMM_ModelRenderer(this);
		lbp4.setRotationPointMM(0.0F, 6.0F, 0.0F);
		lbp4.setRotateAngleDegX(fBladePadding4.getRotateAngleDegX());
		
		fBeam4 = new MMM_ModelRenderer(this);
		fBeam4.setTextureOffsetMM(59, 0).addPlate(0.7F, 0.0F, 2.0F, 5, 7, 1);
		fBeam4.setTextureOffsetMM(59, 0).addPlate(-0.7F, 0.0F, 2.0F, 5, 7, 1);
		fBeam4.setRotationPointMM(0.0F, 2.0F, 0.0F);
		fBeam4.setRotateAngleDegX(fBlade4.getRotateAngleDegX());
		
		lbp5 = new MMM_ModelRenderer(this);
		lbp5.setRotationPointMM(0.0F, 7.0F, 0.0F);
		lbp5.setRotateAngleDegX(fBladePadding5.getRotateAngleDegX());
		
		fBeam5 = new MMM_ModelRenderer(this);
		fBeam5.setTextureOffsetMM(59, 0).addPlate(0.7F, 0.0F, 2.0F, 5, 9, 1);
		fBeam5.setTextureOffsetMM(59, 0).addPlate(-0.7F, 0.0F, 2.0F, 5, 9, 1);
		fBeam5.setRotationPointMM(0.0F, 2.0F, 0.0F);
		fBeam5.setRotateAngleDegX(fBlade5.getRotateAngleDegX());
		
		fBeam.addChildMM(fBeam1);
		fBeam.addChildMM(fBeam2);
		fBeam2.addChildMM(lbp3);
		lbp3.addChildMM(fBeam3);
		fBeam3.addChildMM(lbp4);
		lbp4.addChildMM(fBeam4);
		fBeam4.addChildMM(lbp5);
		lbp5.addChildMM(fBeam5);
	}

	@Override
	public void setRotationAngles(ItemStack pitem, EntityLiving pentity, int pThirdPersonView) {
		float lscale = 0.10F;
		EnumAction laction = getAction(pentity);
		if (pThirdPersonView == 0 && MMM_Helper.mc.thePlayer == pentity) {
			// FirstPerson
			GL11.glScalef(lscale, lscale, lscale);
			GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
			GL11.glRotatef(140.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-20.0F, 1.0F, 0.0F, 0.0F);
			if (laction == EnumAction.block) {
				GL11.glRotatef(-30.0F, 1.0F, 0.0F, 0.0F);
			}
		} else {
			// TherdPerson
			GL11.glScalef(lscale, lscale, lscale);
			if (laction == EnumAction.block) {
				GL11.glTranslatef(-1.0F, -1.0F, -1.0F);
				GL11.glRotatef(140.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-60.0F, 1.0F, 0.0F, 0.0F);
			} else {
				GL11.glTranslatef(-1.0F, 0.0F, 0.0F);
				GL11.glRotatef(140.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-20.0F, 1.0F, 0.0F, 0.0F);
			}
		}
	}

	public void renderItem(ItemStack pitem, EntityLiving pentity, int pThirdPersonView) {
		fGrip.render(1.0F);
	}

	@Override
	public void renderSpecial(ItemStack pitem, EntityLiving pentity, int pThirdPersonView) {
		if (IHW_MoonLight.isENMode(pitem)) {
			GL11.glPushMatrix();
			
			float var4 = (float)pentity.ticksExisted + 0F;
			GL11.glMatrixMode(GL11.GL_TEXTURE);
			GL11.glLoadIdentity();
			float var6 = var4 * 0.125F;
			GL11.glTranslatef(0.0F, var6, 0.0F);
			
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
			MMM_Helper.mc.entityRenderer.disableLightmap(0D);
			
			float var7 = 0.8F;
			GL11.glColor4f(var7, var7, var7, 1.0F);
			
			fBeam.render(1.0F);
			
			MMM_Helper.mc.entityRenderer.enableLightmap(0D);
			GL11.glMatrixMode(GL11.GL_TEXTURE);
			GL11.glLoadIdentity();
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			
			GL11.glPopMatrix();
		}
	}

}
