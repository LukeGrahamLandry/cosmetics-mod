package io.github.lukegrahamlandry.cosmetics;

import io.github.lukegrahamlandry.cosmetics.model.DemoArmorModel;
import io.github.lukegrahamlandry.cosmetics.model.IHasTexture;
import io.github.lukegrahamlandry.cosmetics.model.ShadowStalker;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.UUID;

public class CosmeticArmorLayer extends LayerArmorBase<ModelBiped> {
    static final ModelBiped DEMO = new DemoArmorModel();
    static final ModelBiped SHADOW = new ShadowStalker();

    private final UUID id;
    public static HashMap<UUID, Parts> TO_DISPLAY = new HashMap<>();
    public static class Parts{
        public String head;
        public String chest;
        public String legs;
        public String feet;
    }

    private final RenderLivingBase<?> renderer2;

    public CosmeticArmorLayer(RenderLivingBase<?> rendererIn, Entity entity) {
        super(rendererIn);
        this.renderer2 = rendererIn;
        this.id = entity.getUniqueID();
    }

    protected void initArmor() {
        // unused
    }

    private ModelBiped getModelByString(String name){
        if (name.equals("demo")){
            return DEMO;
        }
        if (name.equals("shadow")){
            return SHADOW;
        }

        return new ModelBiped();
    }


    // each thing has all the [head, chest, legs, boots]
    // setModelSlotVisible sets them invisible based on the slot
    // idea being one type of

    public ModelBiped getModelFromSlot(EntityEquipmentSlot slotIn) {
        return SHADOW;
        /*
        switch (slotIn) {
            case HEAD:
                return getModelByString(TO_DISPLAY.get(this.id).head);
            case CHEST:
                return getModelByString(TO_DISPLAY.get(this.id).chest);
            case LEGS:
                return getModelByString(TO_DISPLAY.get(this.id).legs);
            case FEET:
                return getModelByString(TO_DISPLAY.get(this.id).feet);
        }

        // never happens
        return new ModelBiped(1.0F);

         */
    }


    @SuppressWarnings("incomplete-switch")
    protected void setModelSlotVisible(ModelBiped p_188359_1_, EntityEquipmentSlot slotIn) {
        this.setModelVisible(p_188359_1_);

        switch (slotIn)
        {
            case HEAD:
                p_188359_1_.bipedHead.showModel = true;
                p_188359_1_.bipedHeadwear.showModel = true;
                break;
            case CHEST:
                p_188359_1_.bipedBody.showModel = true;
                p_188359_1_.bipedRightArm.showModel = true;
                p_188359_1_.bipedLeftArm.showModel = true;
                break;
            case LEGS:
                p_188359_1_.bipedBody.showModel = true;
                p_188359_1_.bipedRightLeg.showModel = true;
                p_188359_1_.bipedLeftLeg.showModel = true;
                break;
            case FEET:
                p_188359_1_.bipedRightLeg.showModel = true;
                p_188359_1_.bipedLeftLeg.showModel = true;
        }
    }

    protected void setModelVisible(ModelBiped model)
    {
        model.setVisible(false);
    }

    @Override
    protected ModelBiped getArmorModelHook(net.minecraft.entity.EntityLivingBase entity, net.minecraft.item.ItemStack itemStack, EntityEquipmentSlot slot, ModelBiped model) {
        return model; // net.minecraftforge.client.ForgeHooksClient.getArmorModel(entity, itemStack, slot, model);
    }

    @Override
    public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.renderArmorLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale, EntityEquipmentSlot.CHEST);
        this.renderArmorLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale, EntityEquipmentSlot.LEGS);
        this.renderArmorLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale, EntityEquipmentSlot.FEET);
        this.renderArmorLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale, EntityEquipmentSlot.HEAD);
    }
    
    private void renderArmorLayer(EntityLivingBase entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale, EntityEquipmentSlot slotIn)
    {
        ModelBiped t = this.getModelFromSlot(slotIn);
        // t = getArmorModelHook(entityLivingBaseIn, itemstack, slotIn, t);
        t.setModelAttributes(this.renderer2.getMainModel());
        t.setLivingAnimations(entityLivingBaseIn, limbSwing, limbSwingAmount, partialTicks);
        this.setModelSlotVisible(t, slotIn);
        // boolean flag = this.isLegSlot(slotIn);
        if (t instanceof IHasTexture){
            this.renderer2.bindTexture(((IHasTexture) t).getTexture());
        }
        t.render(entityLivingBaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }
}
