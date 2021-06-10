package io.github.lukegrahamlandry.cosmetics.model;

import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;


// this model is simply an example
// you may NOT use it when the mod distributed
// license: ALL RIGHTS RESERVED

public class DemoArmorModel extends ModelBiped implements IHasTexture {
	private final ModelRenderer armorHead;
	private final ModelRenderer armorHeadBottom;
	private final ModelRenderer armorBody;
	private final ModelRenderer armorRightWing;
	private final ModelRenderer armorRightWing2;
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
		armorHead.cubeList.add(new ModelBox(armorHead, 53, 13, -6.5F, -9.75F, 4.0F, 3, 3, 9, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 61, 35, 3.5F, -2.75F, 4.0F, 2, 2, 9, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 0, 0, 3.5F, -0.75F, 11.0F, 2, 4, 2, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 37, 62, -5.5F, -2.75F, 4.0F, 2, 2, 9, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 0, 0, -5.5F, -0.75F, 11.0F, 2, 4, 2, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 84, 7, 3.5F, -15.75F, 10.0F, 3, 6, 3, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 13, 83, -6.5F, -15.75F, 10.0F, 3, 6, 3, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 33, 36, -4.5F, -10.0F, 3.0F, 9, 10, 5, 0.0F, false));
		armorHead.cubeList.add(new ModelBox(armorHead, 0, 26, -4.5F, -6.0F, -6.75F, 9, 2, 10, 0.0F, false));

		armorHeadBottom = new ModelRenderer(this);
		armorHeadBottom.setRotationPoint(0.0F, -2.0F, 1.0F);
		armorHead.addChild(armorHeadBottom);
		setRotationAngle(armorHeadBottom, 0.2618F, 0.0F, 0.0F);
		armorHeadBottom.cubeList.add(new ModelBox(armorHeadBottom, 19, 26, -4.5F, 0.0F, -6.75F, 9, 1, 9, 0.0F, false));
		armorHeadBottom.cubeList.add(new ModelBox(armorHeadBottom, 0, 14, -4.5F, 1.0F, -7.0F, 9, 2, 10, 0.0F, false));

		armorBody = new ModelRenderer(this);
		armorBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addChild(armorBody);
		armorBody.cubeList.add(new ModelBox(armorBody, 46, 51, -4.0F, 1.0F, -2.5F, 8, 6, 5, 0.2F, false));
		armorBody.cubeList.add(new ModelBox(armorBody, 55, 25, -4.0F, 6.0F, -2.0F, 8, 6, 4, 0.2F, false));

		armorRightWing = new ModelRenderer(this);
		armorRightWing.setRotationPoint(0.0F, 0.0F, 0.0F);
		armorBody.addChild(armorRightWing);
		armorRightWing.cubeList.add(new ModelBox(armorRightWing, 0, 29, -3.0F, 0.0F, 2.0F, 0, 7, 10, 0.0F, false));

		armorRightWing2 = new ModelRenderer(this);
		armorRightWing2.setRotationPoint(0.0F, 0.0F, 0.0F);
		armorBody.addChild(armorRightWing2);
		armorRightWing2.cubeList.add(new ModelBox(armorRightWing2, 2, 38, 3.0F, 0.0F, 2.0F, 0, 7, 10, 0.0F, true));

		armorRightArm = new ModelRenderer(this);
		armorRightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightArm.addChild(armorRightArm);
		armorRightArm.cubeList.add(new ModelBox(armorRightArm, 0, 61, -6.0F, -3.0F, -3.0F, 6, 3, 6, 0.0F, false));
		armorRightArm.cubeList.add(new ModelBox(armorRightArm, 69, 0, -4.5F, 5.0F, -2.5F, 5, 2, 5, 0.0F, false));
		armorRightArm.cubeList.add(new ModelBox(armorRightArm, 71, 74, -4.0F, 0.0F, -2.0F, 4, 10, 4, 0.2F, false));

		armorLeftArm = new ModelRenderer(this);
		armorLeftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedLeftArm.addChild(armorLeftArm);
		armorLeftArm.cubeList.add(new ModelBox(armorLeftArm, 36, 73, 0.0F, 0.0F, -2.0F, 4, 10, 4, 0.2F, true));
		armorLeftArm.cubeList.add(new ModelBox(armorLeftArm, 68, 12, 0.0F, -3.0F, -3.0F, 5, 3, 6, 0.0F, true));

		armorRightLeg = new ModelRenderer(this);
		armorRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightLeg.addChild(armorRightLeg);
		armorRightLeg.cubeList.add(new ModelBox(armorRightLeg, 75, 31, -2.0F, 0.0F, -2.0F, 4, 9, 4, 0.1F, false));

		armorRightBoot = new ModelRenderer(this);
		armorRightBoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightLeg.addChild(armorRightBoot);
		armorRightBoot.cubeList.add(new ModelBox(armorRightBoot, 75, 62, -2.0F, 6.0F, -2.0F, 4, 6, 4, 0.3F, false));

		armorLeftLeg = new ModelRenderer(this);
		armorLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(armorLeftLeg);
		armorLeftLeg.cubeList.add(new ModelBox(armorLeftLeg, 52, 78, -2.0F, 0.0F, -2.0F, 4, 9, 4, 0.1F, false));

		armorLeftBoot = new ModelRenderer(this);
		armorLeftBoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(armorLeftBoot);
		armorLeftBoot.cubeList.add(new ModelBox(armorLeftBoot, 79, 21, -2.0F, 6.0F, -2.0F, 4, 6, 4, 0.3F, false));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public ResourceLocation getTexture() {
		return new ResourceLocation(CosmeticsMain.MODID, "textures/demo.png");
	}
}