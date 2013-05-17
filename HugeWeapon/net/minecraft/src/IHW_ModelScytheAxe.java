package net.minecraft.src;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class IHW_ModelScytheAxe extends IHW_ModelBase {

	public MMM_ModelRenderer fGrip;
	public MMM_ModelRenderer fPole;
	public MMM_ModelRenderer fBase;
	public MMM_ModelRenderer fBladeF10;
	public MMM_ModelRenderer fBladeF11;
	public MMM_ModelRenderer fBladeF20;
	public MMM_ModelRenderer fBladeF21;
	public MMM_ModelRenderer fBladeB10;



	public IHW_ModelScytheAxe() {
		
		fBladeF21 = new MMM_ModelRenderer(this);
		fBladeF21.setTextureOffset(22, 0).addBox(-0.5F, -10.1F, 0.0F, 1, 12, 5);
		fBladeF21.setTextureOffset(25, 17).addBox(-0.5F, -14.1F, 2.0F, 1, 4, 2);
		
		fBladeF20 = new MMM_ModelRenderer(this);
		fBladeF20.setTextureOffset(13, 0).addBox(-1.25F, -2.25F, -1.0F, 1, 4, 3, -0.25F);
		fBladeF20.setTextureOffset(13, 0).addBox(0.25F, -2.25F, -1.0F, 1, 4, 3, -0.25F);
		fBladeF20.setTextureOffset(12, 7).addBox(-1.0F, -10.0F, 0.0F, 2, 8, 3);
		fBladeF20.setRotationPoint(0.0F, 10.0F, 2.0F);
		fBladeF20.addChild(fBladeF21);
		
		fBladeF11 = new MMM_ModelRenderer(this);
		fBladeF11.setTextureOffset(47, 15).addBox(-0.5F, 0.0F, 0.0F, 1, 10, 2, -0.1F);
		
		fBladeF10 = new MMM_ModelRenderer(this);
		fBladeF10.setTextureOffset(46, 0).addBox(-1.0F, 0.0F, 0.0F, 2, 8, 2);
		fBladeF10.setTextureOffset(47, 10).addBox(-0.5F, 8.0F, 0.0F, 1, 3, 2);
		fBladeF10.setRotationPoint(0.0F, 19.0F, 0.5F);
		fBladeF10.addChild(fBladeF11);
		fBladeF10.addChild(fBladeF20);
		
		fBladeB10 = new MMM_ModelRenderer(this);
		fBladeB10.setTextureOffset(54, 0).addBox(-1.0F, 0.0F, -1.0F, 2, 7, 1);
		fBladeB10.setTextureOffset(54, 8).addBox(-0.5F, 1.0F, -2.8F, 1, 9, 2);
		fBladeB10.setRotationPoint(0.0F, 19.0F, -0.5F);
		
		
		fBase = new MMM_ModelRenderer(this);
		fBase.rotateAngleY = -(float)(Math.PI / 4D);
		fBase.addChild(fBladeF10);
		fBase.addChild(fBladeB10);
		
		fPole = new MMM_ModelRenderer(this);
		fPole.setTextureOffset(60, 0).addBox(-0.5F, 4.0F, -0.5F, 1, 24, 1);
		fPole.rotateAngleY = (float)(Math.PI / 4D);
		fPole.addChild(fBase);
		
		
		fGrip = new MMM_ModelRenderer(this);
		fGrip.setTextureOffset(3, 0).addBox(-0.5F, -5.0F, -1.0F, 1, 8, 2);
		fGrip.setTextureOffset(0, 10).addBox(-1.0F, 3.0F, -2.0F, 2, 1, 4);
		fGrip.setTextureOffset(0, 15).addBox(-1.0F, -7.0F, -2.0F, 2, 2, 4);
		fGrip.addChild(fPole);
		
		
	}

	@Override
	public void setRotationAngles(ItemStack pitem, EntityLiving pentity, int pThirdPersonView) {
		// 形状
		int lc = IHW_ScytheAxe.getCount(pitem);
		if (lc > 0) {
			// 変形
			if (IHW_ScytheAxe.isScythe(pitem)) {
				float lf1 = 0.0F;
				float lf2 = 1.0F;
				if (lc < 5) {
					lf1 = (float)(4 - lc) / 4F;
				}
				if (lc > 4) {
					lf2 = (float)(10 - lc) / 6F;
				}
				fBladeF20.rotateAngleX = -3F * lf1;
				fBladeF21.setRotationPoint(0.0F, -3.8F * lf1, -1.0F * lf1);
				fBladeF10.rotateAngleX = 1.6F * lf1;
				fBladeF11.setRotationPoint(0.0F, 1.0F * lf1, 1.8F * lf1);
				fBladeB10.rotateAngleX = -1.6F * lf1;
				fBase.rotationPointY = 8F * lf2;
				
			} else {
				float lf = (float)lc / 10F;
				fBladeF20.rotateAngleX = -3F * lf;
				fBladeF21.setRotationPoint(0.0F, -3.8F * lf, -1.0F * lf);
				fBladeF10.rotateAngleX = 1.6F * lf;
				fBladeF11.setRotationPoint(0.0F, 1.0F * lf, 1.8F * lf);
				fBladeB10.rotateAngleX = -1.6F * lf;
				fBase.rotationPointY = 8F * lf;
			}
		} else {
			// 数値固定表示
			if (IHW_ScytheAxe.isScythe(pitem)) {
				fBladeF20.rotateAngleX = -3F;
				fBladeF21.setRotationPoint(0.0F, -3.8F, -1.0F);
				fBladeF10.rotateAngleX = 1.6F;
				fBladeF11.setRotationPoint(0.0F, 1.0F, 1.8F);
				fBladeB10.rotateAngleX = -1.6F;
				fBase.rotationPointY = 8F;
			} else {
				fBladeF20.rotateAngleX = 0F;
				fBladeF21.setRotationPoint(0.0F, 0.0F, 0.0F);
				fBladeF10.rotateAngleX = 0F;
				fBladeF11.setRotationPoint(0.0F, 0.0F, 0.0F);
				fBladeB10.rotateAngleX = 0F;
				fBase.rotationPointY = 0F;
			}
		}
		
		if (pThirdPersonView == 0 && MMM_Helper.mc.thePlayer == pentity) {
			// FirstPerson
			GL11.glScalef(0.14F, 0.14F, 0.14F);
			GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
			GL11.glRotatef(140.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-20.0F, 1.0F, 0.0F, 0.0F);
		} else {
			// TherdPerson
			GL11.glScalef(0.14F, 0.14F, 0.14F);
			GL11.glTranslatef(-1.0F, 0.0F, 0.0F);
			GL11.glRotatef(140.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-20.0F, 1.0F, 0.0F, 0.0F);
		}
	}

	public void renderItem(ItemStack pitem, EntityLiving pentity, int pThirdPersonView) {
		fGrip.render(1.0F);
	}

	@Override
	public void renderSpecial(ItemStack pitem, EntityLiving pentity, int pThirdPersonView) {
	}

}
