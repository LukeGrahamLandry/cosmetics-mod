package io.github.lukegrahamlandry.cosmetics.model;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ShadowStalker extends ModelBiped implements IHasTexture{
	private final ModelRenderer bone;
	private final ModelRenderer ombreira;
	private final ModelRenderer ombreira2;
	private final ModelRenderer armadura;
	private final ModelRenderer armadura_top;
	private final ModelRenderer body_r1;
	private final ModelRenderer body_r2;
	private final ModelRenderer body_r3;
	private final ModelRenderer body_r4;
	private final ModelRenderer body_r5;
	private final ModelRenderer body_r6;
	private final ModelRenderer armadura_inferior;
	private final ModelRenderer body_r7;
	private final ModelRenderer body_r8;
	private final ModelRenderer body_r9;
	private final ModelRenderer body_r10;
	private final ModelRenderer body_r11;
	private final ModelRenderer body_r12;
	private final ModelRenderer elmo;
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg2;
	private final ModelRenderer RightLeg_r2;

	public ShadowStalker() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 3.1416F, 0.0F);
		

		ombreira = new ModelRenderer(this);
		ombreira.setRotationPoint(0.0F, -8.0F, 0.0F);
		bone.addChild(ombreira);
		ombreira.cubeList.add(new ModelBox(ombreira, 54, 54, 5.9F, -12.25F, -3.4F, 4, 1, 6, 0.0F, false));
		ombreira.cubeList.add(new ModelBox(ombreira, 16, 45, 5.5F, -16.75F, -3.0F, 4, 5, 6, 0.0F, false));
		ombreira.cubeList.add(new ModelBox(ombreira, 34, 56, 5.25F, -17.15F, -3.4F, 1, 5, 6, 0.0F, false));
		ombreira.cubeList.add(new ModelBox(ombreira, 20, 29, 5.252F, -13.251F, 1.45F, 2, 2, 2, 0.0F, false));
		ombreira.cubeList.add(new ModelBox(ombreira, 0, 29, 5.252F, -13.251F, -3.45F, 2, 2, 2, 0.0F, false));

		ombreira2 = new ModelRenderer(this);
		ombreira2.setRotationPoint(0.0F, -8.0F, 0.0F);
		bone.addChild(ombreira2);
		ombreira2.cubeList.add(new ModelBox(ombreira2, 54, 54, -10.7F, -12.25F, -3.4F, 4, 1, 6, 0.0F, true));
		ombreira2.cubeList.add(new ModelBox(ombreira2, 16, 45, -10.2F, -16.75F, -3.0F, 4, 5, 6, 0.0F, true));
		ombreira2.cubeList.add(new ModelBox(ombreira2, 34, 56, -6.25F, -17.15F, -3.4F, 1, 5, 6, 0.0F, true));
		ombreira2.cubeList.add(new ModelBox(ombreira2, 20, 29, -7.252F, -13.251F, 1.45F, 2, 2, 2, 0.0F, true));
		ombreira2.cubeList.add(new ModelBox(ombreira2, 0, 29, -7.252F, -13.251F, -3.45F, 2, 2, 2, 0.0F, true));

		armadura = new ModelRenderer(this);
		armadura.setRotationPoint(-0.025F, -22.4F, -0.15F);
		bone.addChild(armadura);
		armadura.cubeList.add(new ModelBox(armadura, 32, 0, -4.975F, 2.9F, -2.6F, 9, 4, 5, 0.0F, false));

		armadura_top = new ModelRenderer(this);
		armadura_top.setRotationPoint(4.25F, 0.2F, 8.225F);
		armadura.addChild(armadura_top);
		armadura_top.cubeList.add(new ModelBox(armadura_top, 0, 17, -9.475F, -0.3F, -11.675F, 10, 5, 7, 0.0F, false));
		armadura_top.cubeList.add(new ModelBox(armadura_top, 0, 0, -8.315F, -2.03F, -5.585F, 1, 2, 3, 0.0F, false));
		armadura_top.cubeList.add(new ModelBox(armadura_top, 0, 0, -1.135F, -2.03F, -5.585F, 1, 2, 3, 0.0F, false));

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(-9.45F, 0.0F, -3.8F);
		armadura_top.addChild(body_r1);
		setRotationAngle(body_r1, -0.7854F, 0.0F, 0.0F);
		body_r1.cubeList.add(new ModelBox(body_r1, 30, 45, 1.125F, -2.4F, -0.475F, 8, 2, 1, 0.0F, false));

		body_r2 = new ModelRenderer(this);
		body_r2.setRotationPoint(-4.25F, 0.0F, -8.125F);
		armadura_top.addChild(body_r2);
		setRotationAngle(body_r2, 0.7854F, 0.0F, 0.0F);
		body_r2.cubeList.add(new ModelBox(body_r2, 48, 37, -5.224F, -2.5F, -2.5F, 10, 4, 2, 0.0F, false));

		body_r3 = new ModelRenderer(this);
		body_r3.setRotationPoint(-4.25F, -0.4F, -6.825F);
		armadura_top.addChild(body_r3);
		setRotationAngle(body_r3, 0.3927F, 0.0F, 0.0F);
		body_r3.cubeList.add(new ModelBox(body_r3, 50, 23, -5.224F, -2.476F, -2.23F, 10, 4, 2, 0.0F, false));

		body_r4 = new ModelRenderer(this);
		body_r4.setRotationPoint(-4.25F, 0.0F, -6.725F);
		armadura_top.addChild(body_r4);
		setRotationAngle(body_r4, -0.7854F, 0.0F, 0.0F);
		body_r4.cubeList.add(new ModelBox(body_r4, 16, 56, -5.224F, -2.5F, -0.1F, 10, 4, 2, 0.0F, false));

		body_r5 = new ModelRenderer(this);
		body_r5.setRotationPoint(-4.25F, -0.4F, -8.025F);
		armadura_top.addChild(body_r5);
		setRotationAngle(body_r5, -0.3927F, 0.0F, 0.0F);
		body_r5.cubeList.add(new ModelBox(body_r5, 53, 9, -5.224F, -2.476F, -0.37F, 10, 4, 2, 0.0F, false));

		body_r6 = new ModelRenderer(this);
		body_r6.setRotationPoint(-4.25F, 0.9F, -7.5F);
		armadura_top.addChild(body_r6);
		setRotationAngle(body_r6, -0.3927F, 0.0F, 0.0F);
		body_r6.cubeList.add(new ModelBox(body_r6, 22, 37, -5.22F, -2.48F, 0.375F, 10, 5, 3, 0.0F, false));

		armadura_inferior = new ModelRenderer(this);
		armadura_inferior.setRotationPoint(-5.175F, 9.95F, -2.85F);
		armadura.addChild(armadura_inferior);
		armadura_inferior.cubeList.add(new ModelBox(armadura_inferior, 27, 11, -0.05F, -3.05F, 0.09F, 10, 6, 6, 0.0F, false));

		body_r7 = new ModelRenderer(this);
		body_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
		armadura_inferior.addChild(body_r7);
		setRotationAngle(body_r7, 0.0F, 0.0F, 0.3927F);
		body_r7.cubeList.add(new ModelBox(body_r7, 0, 60, 0.0F, 0.0F, 0.12F, 1, 2, 6, 0.0F, false));

		body_r8 = new ModelRenderer(this);
		body_r8.setRotationPoint(0.0F, -1.5F, -0.1F);
		armadura_inferior.addChild(body_r8);
		setRotationAngle(body_r8, 0.0F, 0.0F, 0.3927F);
		body_r8.cubeList.add(new ModelBox(body_r8, 60, 0, 0.0F, 0.0F, 0.209F, 1, 2, 6, 0.0F, false));

		body_r9 = new ModelRenderer(this);
		body_r9.setRotationPoint(0.0F, -3.1F, 0.0F);
		armadura_inferior.addChild(body_r9);
		setRotationAngle(body_r9, 0.0F, 0.0F, 0.3927F);
		body_r9.cubeList.add(new ModelBox(body_r9, 60, 43, 0.0F, 0.0F, 0.1F, 1, 2, 6, 0.0F, false));

		body_r10 = new ModelRenderer(this);
		body_r10.setRotationPoint(10.4F, 0.0F, 0.0F);
		armadura_inferior.addChild(body_r10);
		setRotationAngle(body_r10, 0.0F, 0.0F, -0.3927F);
		body_r10.cubeList.add(new ModelBox(body_r10, 12, 29, -1.45F, 0.0F, 0.12F, 1, 2, 6, 0.0F, false));

		body_r11 = new ModelRenderer(this);
		body_r11.setRotationPoint(10.4F, -1.5F, -0.1F);
		armadura_inferior.addChild(body_r11);
		setRotationAngle(body_r11, 0.0F, 0.0F, -0.3927F);
		body_r11.cubeList.add(new ModelBox(body_r11, 58, 29, -1.45F, 0.0F, 0.209F, 1, 2, 6, 0.0F, false));

		body_r12 = new ModelRenderer(this);
		body_r12.setRotationPoint(10.4F, -3.1F, 0.0F);
		armadura_inferior.addChild(body_r12);
		setRotationAngle(body_r12, 0.0F, 0.0F, -0.3927F);
		body_r12.cubeList.add(new ModelBox(body_r12, 59, 15, -1.45F, 0.0F, 0.1F, 1, 2, 6, 0.0F, false));

		elmo = new ModelRenderer(this);
		elmo.setRotationPoint(8.0F, 17.0F, -9.0F);
		setRotationAngle(elmo, 0.0F, 3.1416F, 0.0F);
		

		Head = new ModelRenderer(this);
		Head.setRotationPoint(16.0F, -20.0F, 0.0F);
		elmo.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -12.44F, -4.744F, -12.34F, 8, 9, 8, 0.0F, false));

		Head_r1 = new ModelRenderer(this);
		Head_r1.setRotationPoint(-7.96F, -1.344F, -6.964F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.3927F, 0.0F, 0.0F);
		Head_r1.cubeList.add(new ModelBox(Head_r1, 0, 29, -0.448F, -6.656F, -5.296F, 1, 5, 10, 0.0F, false));

		Head_r2 = new ModelRenderer(this);
		Head_r2.setRotationPoint(-7.96F, -1.344F, -7.076F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.3927F, 0.0F, 0.0F);
		Head_r2.cubeList.add(new ModelBox(Head_r2, 26, 26, -4.368F, -4.68F, -3.808F, 8, 3, 8, 0.0F, false));

		Head_r3 = new ModelRenderer(this);
		Head_r3.setRotationPoint(-2.68F, -0.224F, -2.58F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.0F, -0.7854F, 0.0F);
		Head_r3.cubeList.add(new ModelBox(Head_r3, 71, 8, -2.13F, -4.466F, -3.0F, 1, 7, 3, 0.0F, false));

		Head_r4 = new ModelRenderer(this);
		Head_r4.setRotationPoint(-12.42F, -0.224F, -3.38F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, 0.0F, 0.7854F, 0.0F);
		Head_r4.cubeList.add(new ModelBox(Head_r4, 75, 18, -0.017F, -4.466F, -3.017F, 1, 7, 3, 0.0F, false));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 44, 44, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
		RightLeg.cubeList.add(new ModelBox(RightLeg, 48, 61, -2.0F, 9.0F, -5.0F, 4, 3, 3, 0.0F, false));

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setRotationPoint(1.9F, 12.0F, 0.0F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.0F, -0.7854F, 0.0F);
		RightLeg_r1.cubeList.add(new ModelBox(RightLeg_r1, 33, 68, -4.155F, -12.0F, -1.465F, 4, 9, 4, 0.0F, false));

		RightLeg2 = new ModelRenderer(this);
		RightLeg2.setRotationPoint(1.9F, 12.0F, 0.0F);
		RightLeg2.cubeList.add(new ModelBox(RightLeg2, 44, 44, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));
		RightLeg2.cubeList.add(new ModelBox(RightLeg2, 48, 61, -2.0F, 9.0F, -5.0F, 4, 3, 3, 0.0F, true));

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg2.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, 0.0F, 0.7854F, 0.0F);
		RightLeg_r2.cubeList.add(new ModelBox(RightLeg_r2, 33, 68, 0.155F, -12.0F, -1.465F, 4, 9, 4, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
		elmo.render(f5);
		RightLeg.render(f5);
		RightLeg2.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}


	@Override
	public ResourceLocation getTexture() {
		return new ResourceLocation("textures/shadow_stalker.png");
	}
}