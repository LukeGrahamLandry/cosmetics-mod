package io.github.lukegrahamlandry.cosmetics;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class TestHelmet extends ModelBase {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;

	public TestHelmet() {
		textureWidth = 48;
		textureHeight = 48;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0333F, -5.8F, -1.5667F);
		Head.setTextureOffset(0, 0).addBox(-4.0333F, -2.2F, -3.4333F, 8, 8, 8, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setRotationPoint(-0.0333F, 1.8F, -0.2333F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, -0.3927F, 0.0F, 0.0F);
		Head_r1.setTextureOffset(37, 21).addBox(-0.4F, -5.9F, -4.2F, 1, 4, 8, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setRotationPoint(-0.0333F, 1.8F, -0.1333F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, -0.3927F, 0.0F, 0.0F);
		Head_r2.setTextureOffset(0, 16).addBox(-3.9F, -3.9F, -4.0F, 7, 2, 7, false);

		/*
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0333F, 12.2F, -1.5667F);
		Head.setTextureOffset(0, 0).addBox(-4.0333F, -1.2F, -3.4333F, 8, 8, 8, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setRotationPoint(-0.0333F, 1.8F, -0.2333F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, -0.3927F, 0.0F, 0.0F);
		Head_r1.setTextureOffset(37, 21).addBox(-0.4F, -5.9F, -4.2F, 1, 4, 8, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setRotationPoint(-0.0333F, 1.8F, -0.1333F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, -0.3927F, 0.0F, 0.0F);
		Head_r2.setTextureOffset(0, 16).addBox(-3.9F, -3.9F, -4.0F, 7, 2, 7, false);

		 */
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

		Head.render(scale);
	}

	// todo: override the thing
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public ResourceLocation getTexture() {
		return new ResourceLocation("textures/test_helmet.png"); //  CosmeticsMain.MODID,
		// some weird error with loading the domain lukescosmetics:
		// related to mcmod.info not loading?
	}
}