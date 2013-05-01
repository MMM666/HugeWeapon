package net.minecraft.src;

import org.lwjgl.opengl.GL11;

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
		
		fBladePadding1 = new MMM_ModelRenderer(this);
		fBladePadding1.setTextureOffset(38, 14).addBox(-1.0F, -3.0F, 0.0F, 2, 3, 4, 0.05F);
		fBladePadding1.setRotationPoint(0.0F, -6.0F, 0.0F);
		fBladePadding1.setRotateAngleDegX(-8F);
		
		fBladePadding2 = new MMM_ModelRenderer(this);
		fBladePadding2.setTextureOffset(30, 12).addBox(-1.0F, -1.0F, 0.0F, 2, 2, 4, 0.05F);
		fBladePadding2.setRotationPoint(0.0F, 1.0F, 4.5F);
		
		fBladePadding3 = new MMM_ModelRenderer(this);
		fBladePadding3.setTextureOffset(38, 8).addBox(-1.0F, .0F, 0.0F, 2, 2, 4, 0.05F);
		fBladePadding3.setRotationPoint(0.0F, 6.0F, 0.0F);
		fBladePadding3.setRotateAngleDegX(11F);
		
		fBladePadding4 = new MMM_ModelRenderer(this);
		fBladePadding4.setTextureOffset(30, 6).addBox(-1.0F, .0F, 0.0F, 2, 2, 4, 0.05F);
		fBladePadding4.setRotationPoint(0.0F, 6.0F, 0.0F);
		fBladePadding4.setRotateAngleDegX(8F);
		
		fBladePadding5 = new MMM_ModelRenderer(this);
		fBladePadding5.setTextureOffset(38, 2).addBox(-1.0F, .0F, 0.0F, 2, 2, 4, 0.05F);
		fBladePadding5.setRotationPoint(0.0F, 7.0F, 0.0F);
		fBladePadding5.setRotateAngleDegX(6F);
		
		fBladePadding6 = new MMM_ModelRenderer(this);
		fBladePadding6.setTextureOffset(30, 0).addBox(-1.0F, .0F, 0.0F, 2, 2, 4, 0.05F);
		fBladePadding6.setRotationPoint(0.0F, 8.0F, 0.0F);
		fBladePadding6.setRotateAngleDegX(6F);
		
		
		fBlade1 = new MMM_ModelRenderer(this);
		fBlade1.setTextureOffset(0, 8).addBox(-1.0F, -6.0F, 0.0F, 2, 6, 2);
		fBlade1.setTextureOffset(8, 0).addBox(-0.5F, -7.5F, 2.0F, 1, 7, 3);
		fBlade1.setTextureOffset(24, 0).addBox(-1.0F, -2.5F, -0.8F, 2, 1, 1, 0.2F);
		fBlade1.setRotationPoint(0.0F, -1.0F, 0.0F);
		fBlade1.setRotateAngleDegX(-15F);
		
		fBlade2 = new MMM_ModelRenderer(this);
		fBlade2.setTextureOffset(0, 16).addBox(-1.0F, 0.0F, 0.0F, 2, 6, 2);
		fBlade2.setTextureOffset(0, 0).addBox(-0.5F, 0.5F, 2.0F, 1, 5, 3);
		fBlade2.setTextureOffset(24, 2).addBox(-1.0F, 1.5F, -0.8F, 2, 1, 1, 0.3F);
		fBlade2.setRotationPoint(0.0F, 1.0F, 0.0F);
		fBlade2.setRotateAngleDegX(15F);
		
		fBlade3 = new MMM_ModelRenderer(this);
		fBlade3.setTextureOffset(0, 24).addBox(-1.0F, 0.0F, 0.0F, 2, 6, 2);
		fBlade3.setTextureOffset(16, 0).addBox(-0.5F, 0.0F, 2.0F, 1, 6, 3);
		fBlade3.setTextureOffset(24, 4).addBox(-1.0F, 2.0F, -0.8F, 2, 1, 1, 0.3F);
		fBlade3.setTextureOffset(24, 10).addBox(-0.5F, 1.5F, -2.7F, 1, 2, 2, 0.1F);
		fBlade3.setRotationPoint(0.0F, 2.0F, 0.0F);
		fBlade3.setRotateAngleDegX(11F);
		
		fBlade4 = new MMM_ModelRenderer(this);
		fBlade4.setTextureOffset(8, 13).addBox(-1.0F, 0.0F, 0.0F, 2, 7, 2);
		fBlade4.setTextureOffset(16, 9).addBox(-0.5F, 0.0F, 2.0F, 1, 7, 3);
		fBlade4.setTextureOffset(24, 6).addBox(-1.0F, 3.0F, -0.8F, 2, 1, 1, 0.3F);
		fBlade4.setTextureOffset(24, 14).addBox(-0.5F, 2.5F, -2.7F, 1, 2, 2, 0.1F);
		fBlade4.setRotationPoint(0.0F, 2.0F, 0.0F);
		fBlade4.setRotateAngleDegX(8F);
		
		fBlade5 = new MMM_ModelRenderer(this);
		fBlade5.setTextureOffset(8, 22).addBox(-1.0F, 0.0F, 0.0F, 2, 8, 2);
		fBlade5.setTextureOffset(16, 19).addBox(-0.5F, 0.0F, 2.0F, 1, 9, 3);
		fBlade5.setTextureOffset(24, 8).addBox(-1.0F, 4.0F, -0.8F, 2, 1, 1, 0.3F);
		fBlade5.setTextureOffset(24, 18).addBox(-0.5F, 3.5F, -2.7F, 1, 2, 2, 0.1F);
		fBlade5.setRotationPoint(0.0F, 2.0F, 0.0F);
		fBlade5.setRotateAngleDegX(6F);
		
		fGrip = new MMM_ModelRenderer(this);
		fGrip.setTextureOffset(26, 22).addBox(-0.5F, -2.0F, -1.0F, 1, 6, 2, -0.2F);
		fGrip.setTextureOffset(32, 21).addBox(-1.0F, 3.0F, -1.0F, 2, 2, 3, 0.0F);
		fGrip.setTextureOffset(42, 21).addBox(-1.0F, -2.0F, 2.0F, 2, 7, 2, 0.1F);
		fGrip.setTextureOffset(30, 26).addBox(-1.0F, -4.0F, -1.0F, 2, 2, 4, 0.1F);
		fGrip.setTextureOffset(38, 26).addBox(-0.5F, -5.0F, 3.0F, 1, 3, 1, 0.1F);
		
		fRod = new MMM_ModelRenderer(this);
		fRod.setTextureOffset(46, 0).addBox(-0.5F, -4.0F, -0.5F, 1, 5, 1);
		fRod.setRotationPoint(0.0F, -4.5F, 3.0F);
		fRod.setRotateAngleDegX(35F);
		
		
		
		fGrip.addChild(fRod);
		fGrip.addChild(fBladePadding2);
		fBladePadding2.addChild(fBlade1);
		fBlade1.addChild(fBladePadding1);
		fBladePadding2.addChild(fBlade2);
		fBlade2.addChild(fBladePadding3);
		fBladePadding3.addChild(fBlade3);
		fBlade3.addChild(fBladePadding4);
		fBladePadding4.addChild(fBlade4);
		fBlade4.addChild(fBladePadding5);
		fBladePadding5.addChild(fBlade5);
		fBlade5.addChild(fBladePadding6);
		
		// ビームブレード
		MMM_ModelRenderer lbp3, lbp4, lbp5;
		fBeam1 = new MMM_ModelRenderer(this);
		fBeam1.setTextureOffset(59, 0).addPlate(0.7F, -7.5F, 2.0F, 5, 7, 1);
		fBeam1.setTextureOffset(59, 0).addPlate(-0.7F, -7.5F, 2.0F, 5, 7, 1);
		fBeam1.setRotationPoint(0.0F, -1.0F, 0.0F);
		fBeam1.setRotateAngleDegX(fBlade1.getRotateAngleDegX());
		
		fBeam = new MMM_ModelRenderer(this);
		fBeam.setRotationPoint(0.0F, 1.0F, 4.5F);
		
		fBeam2 = new MMM_ModelRenderer(this);
		fBeam2.setTextureOffset(59, 0).addPlate(0.7F, 0.5F, 2.0F, 5, 5, 1);
		fBeam2.setTextureOffset(59, 0).addPlate(-0.7F, 0.5F, 2.0F, 5, 5, 1);
		fBeam2.setRotationPoint(0.0F, 1.0F, 0.0F);
		fBeam2.setRotateAngleDegX(fBlade2.getRotateAngleDegX());
		
		lbp3 = new MMM_ModelRenderer(this);
		lbp3.setRotationPoint(0.0F, 6.0F, 0.0F);
		lbp3.setRotateAngleDegX(fBladePadding3.getRotateAngleDegX());
		
		fBeam3 = new MMM_ModelRenderer(this);
		fBeam3.setTextureOffset(59, 0).addPlate(0.7F, 0.0F, 2.0F, 5, 6, 1);
		fBeam3.setTextureOffset(59, 0).addPlate(-0.7F, 0.0F, 2.0F, 5, 6, 1);
		fBeam3.setRotationPoint(0.0F, 2.0F, 0.0F);
		fBeam3.setRotateAngleDegX(fBlade3.getRotateAngleDegX());
		
		lbp4 = new MMM_ModelRenderer(this);
		lbp4.setRotationPoint(0.0F, 6.0F, 0.0F);
		lbp4.setRotateAngleDegX(fBladePadding4.getRotateAngleDegX());
		
		fBeam4 = new MMM_ModelRenderer(this);
		fBeam4.setTextureOffset(59, 0).addPlate(0.7F, 0.0F, 2.0F, 5, 7, 1);
		fBeam4.setTextureOffset(59, 0).addPlate(-0.7F, 0.0F, 2.0F, 5, 7, 1);
		fBeam4.setRotationPoint(0.0F, 2.0F, 0.0F);
		fBeam4.setRotateAngleDegX(fBlade4.getRotateAngleDegX());
		
		lbp5 = new MMM_ModelRenderer(this);
		lbp5.setRotationPoint(0.0F, 7.0F, 0.0F);
		lbp5.setRotateAngleDegX(fBladePadding5.getRotateAngleDegX());
		
		fBeam5 = new MMM_ModelRenderer(this);
		fBeam5.setTextureOffset(59, 0).addPlate(0.7F, 0.0F, 2.0F, 5, 9, 1);
		fBeam5.setTextureOffset(59, 0).addPlate(-0.7F, 0.0F, 2.0F, 5, 9, 1);
		fBeam5.setRotationPoint(0.0F, 2.0F, 0.0F);
		fBeam5.setRotateAngleDegX(fBlade5.getRotateAngleDegX());
		
		fBeam.addChild(fBeam1);
		fBeam.addChild(fBeam2);
		fBeam2.addChild(lbp3);
		lbp3.addChild(fBeam3);
		fBeam3.addChild(lbp4);
		lbp4.addChild(fBeam4);
		fBeam4.addChild(lbp5);
		lbp5.addChild(fBeam5);
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, ItemStack pitem) {
	}

	public void renderItem(ItemStack pitem, EntityLiving pentity, int pThirdPersonView) {
		GL11.glPushMatrix();
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
		
		fGrip.render(1.0F);
		if (IHW_MoonLight.isENMode(pitem)) {
			float var4 = (float)pentity.ticksExisted + 0F;
			GL11.glMatrixMode(GL11.GL_TEXTURE);
			GL11.glLoadIdentity();
			float var6 = var4 * 0.125F;
			GL11.glTranslatef(0.0F, var6, 0.0F);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glEnable(GL11.GL_BLEND);
			float var7 = 0.5F;
			GL11.glColor4f(var7, var7, var7, 1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
			
			fBeam.render(1.0F);
			
			GL11.glMatrixMode(GL11.GL_TEXTURE);
			GL11.glLoadIdentity();
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			
		}
		
		GL11.glPopMatrix();
	}

}
