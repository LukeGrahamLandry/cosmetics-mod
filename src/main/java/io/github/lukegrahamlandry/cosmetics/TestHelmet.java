package io.github.lukegrahamlandry.cosmetics;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Vector3d;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

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
		setBaseRotationAngle(Head_r1, -0.3927F, 0.0F, 0.0F);
		Head_r1.setTextureOffset(37, 21).addBox(-0.4F, -5.9F, -4.2F, 1, 4, 8, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setRotationPoint(-0.0333F, 1.8F, -0.1333F);
		Head.addChild(Head_r2);
		setBaseRotationAngle(Head_r2, -0.3927F, 0.0F, 0.0F);
		Head_r2.setTextureOffset(0, 16).addBox(-3.9F, -3.9F, -4.0F, 7, 2, 7, false);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		Head.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		/*
		float partialTicks = limbSwing; // ???
		float testpitch = entityIn.prevRotationPitch + (entityIn.rotationPitch - entityIn.prevRotationPitch) * partialTicks;
		float f = this.interpolateRotation(((EntityLivingBase)entityIn).prevRenderYawOffset, ((EntityLivingBase)entityIn).renderYawOffset, partialTicks);
		float f1 = this.interpolateRotation(((EntityLivingBase)entityIn).prevRotationYawHead, ((EntityLivingBase)entityIn).rotationYawHead, partialTicks);
		float testyaw = f1 - f;
		 */

		/* try to calculate head rotation from look vec didnt work
		Vec3d d = entityIn.getLookVec();
		float pitch = (float) Math.asin(-d.y);
		float yaw = (float) Math.atan2(d.x, d.z);

		 */

		/* does it based on body not head
		boolean flag = entityIn instanceof EntityLivingBase && ((EntityLivingBase)entityIn).getTicksElytraFlying() > 4;

		this.Head.rotateAngleY = netHeadYaw * 0.017453292F;

		if (flag) {
			this.Head.rotateAngleX = -((float)Math.PI / 4F);
		}
		else {
			this.Head.rotateAngleX = headPitch * 0.017453292F;
		}

		if (entityIn.isSneaking()) {
			this.Head.rotationPointY = 1.0F -5.8F;
		}
		else {
			this.Head.rotationPointY = 0.0F -5.8F;
		}

		 */
	}

	// todo: override the thing
	public void setBaseRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public ResourceLocation getTexture() {
		return new ResourceLocation("textures/test_helmet.png"); //  CosmeticsMain.MODID,
		// some weird error with loading the domain lukescosmetics:
		// related to mcmod.info not loading?
	}

	public void render(RenderLivingBase renderPlayer, float scale) {
		ModelPlayer modelplayer = (ModelPlayer) renderPlayer.getMainModel();

		copyModelRotation(modelplayer.bipedHeadwear, this.Head);
		this.Head.render(scale);
	}

	public static void copyModelRotation(ModelRenderer source, ModelRenderer dest)
	{
		dest.rotateAngleX = source.rotateAngleX;
		dest.rotateAngleY = source.rotateAngleY;
		dest.rotateAngleZ = source.rotateAngleZ;
	}
}