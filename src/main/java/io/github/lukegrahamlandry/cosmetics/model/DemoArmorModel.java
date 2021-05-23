package io.github.lukegrahamlandry.cosmetics.model;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class DemoArmorModel extends ModelBiped {
	private final ModelRenderer armorHead;
	private final ModelRenderer armorHeadBottom;
	private final ModelRenderer armorBody;
	private final ModelRenderer armorRightArm;
	private final ModelRenderer armorLeftArm;
	private final ModelRenderer armorRightLeg;
	private final ModelRenderer armorRightBoot;
	private final ModelRenderer armorLeftLeg;
	private final ModelRenderer armorLeftBoot;

	public DemoArmorModel() {
		textureWidth = 128;
		textureHeight = 128;

		armorHead = new ModelRenderer(this);
		armorHead.setRotationPoint(0.0F, 0.0F, -2.0F);
		bipedHead.addChild(armorHead);
		armorHead.cubeList.add(new ModelBox(armorHead, 0, 0, -4.5F, -10.0F, -7.0F, 9, 4, 10, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 53, 13, 3.5F, -9.75F, 4.0F, 3, 3, 9, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 45, 51, -6.5F, -9.75F, 4.0F, 3, 3, 9, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 60, 42, 3.5F, -2.75F, 4.0F, 2, 2, 9, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 0, 14, 3.5F, -0.75F, 11.0F, 2, 4, 2, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 0, 54, -5.5F, -2.75F, 4.0F, 2, 2, 9, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 0, 0, -5.5F, -0.75F, 11.0F, 2, 4, 2, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 40, 79, 3.5F, -15.75F, 10.0F, 3, 6, 3, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 28, 79, -6.5F, -15.75F, 10.0F, 3, 6, 3, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 33, 36, -4.5F, -10.0F, 3.0F, 9, 10, 5, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 0, 26, -4.5F, -6.0F, -6.75F, 9, 2, 10, 0.0F, false));

		armorHeadBottom = new ModelRenderer(this);
		armorHeadBottom.setRotationPoint(0.0F, -2.0F, 1.0F);
		armorHead.addChild(armorHeadBottom);
		setRotationAngle(armorHeadBottom, 0.2618F, 0.0F, 0.0F);
		armorHeadBottom.cubeList.add(new ModelBox(armorHeadBottom, 28, 26, -4.5F, 0.0F, -6.75F, 9, 1, 9, 0.0F, false));
		armorHeadBottom.cubeList.add(new ModelBox(armorHeadBottom, 0, 14, -4.5F, 1.0F, -7.0F, 9, 2, 10, 0.0F, false));

		armorBody = new ModelRenderer(this);
		armorBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addChild(armorBody);
		armorBody.cubeList.add(new ModelBox(armorBody, 32, 39, -4.0F, 1.0F, -2.5F, 8, 6, 5, 0.2F, false));
		armorBody.cubeList.add(new ModelBox(armorBody, 55, 2, -4.0F, 6.0F, -2.0F, 8, 6, 4, 0.2F, false));

		armorRightArm = new ModelRenderer(this);
		armorRightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightArm.addChild(armorRightArm);
		armorRightArm.cubeList.add(new ModelBox(armorRightArm, 55, 25, -6.0F, -3.0F, -3.0F, 6, 3, 6, 0.0F, false));
		armorRightArm.cubeList.add(new ModelBox(armorRightArm, 73, 20, -4.5F, 5.0F, -2.5F, 5, 2, 5, 0.0F, false));
		armorRightArm.cubeList.add(new ModelBox(armorRightArm, 74, 27, -4.0F, 0.0F, -2.0F, 4, 10, 4, 0.2F, false));

		armorLeftArm = new ModelRenderer(this);
		armorLeftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedLeftArm.addChild(armorLeftArm);
		armorLeftArm.cubeList.add(new ModelBox(armorLeftArm, 52, 78, 0.0F, 0.0F, -2.0F, 4, 10, 4, 0.2F, false));
		armorLeftArm.cubeList.add(new ModelBox(armorLeftArm, 63, 57, 0.0F, -3.0F, -3.0F, 5, 3, 6, 0.0F, false));

		armorRightLeg = new ModelRenderer(this);
		armorRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightLeg.addChild(armorRightLeg);
		armorRightLeg.cubeList.add(new ModelBox(armorRightLeg, 12, 78, -2.0F, 0.0F, -2.0F, 4, 9, 4, 0.1F, false));
		armorRightLeg.cubeList.add(new ModelBox(armorRightLeg, 74, 6, -2.0F, 0.0F, -2.0F, 4, 9, 4, 0.1F, false));

		armorRightBoot = new ModelRenderer(this);
		armorRightBoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightLeg.addChild(armorRightBoot);
		

		armorLeftLeg = new ModelRenderer(this);
		armorLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(armorLeftLeg);
		

		armorLeftBoot = new ModelRenderer(this);
		armorLeftBoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(armorLeftBoot);
		
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}