package io.github.lukegrahamlandry.cosmetics;

import io.github.lukegrahamlandry.cosmetics.model.*;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import java.util.HashMap;
import java.util.UUID;

public class CosmeticArmorLayer extends LayerArmorBase<ModelBiped> {
    static final ModelBiped DEMO = new DemoArmorModel();
    static final ModelBiped SHADOW = new ShadowStalker();
    static final ModelBiped TEMPLATE = new TemplateModel();
    static final ModelBiped POTATO = new ExampleGeoArmor();

    static final ItemStack ANIM_ITEM = new ItemStack(new NullItem(ItemArmor.ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.HEAD));

    private final UUID id;
    public static HashMap<UUID, Parts> TO_DISPLAY = new HashMap<>();
    public static class Parts{
        public String head;
        public String chest;
        public String legs;
        public String feet;

        @Override
        public String toString() {
            return "Parts{" +
                    "head='" + head + '\'' +
                    ", chest='" + chest + '\'' +
                    ", legs='" + legs + '\'' +
                    ", feet='" + feet + '\'' +
                    '}';
        }
    }

    public final RenderLivingBase<?> renderer2;

    public CosmeticArmorLayer(RenderLivingBase<?> rendererIn, Entity entity) {
        super(rendererIn);
        this.renderer2 = rendererIn;
        this.id = entity.getUniqueID();
    }

    protected void initArmor() {
        // unused
    }

    private ModelBiped getModelByString(String name){
        if (name.equals("demo")) return DEMO;
        if (name.equals("shadow"))  return SHADOW;
        if (name.equals("potato"))  return POTATO;

        return null;
    }


    // each thing has all the [head, chest, legs, boots]
    // setModelSlotVisible sets them invisible based on the slot
    // idea being one type of

    public ModelBiped getModelFromSlot(EntityEquipmentSlot slotIn) {
        switch (slotIn) {
            case HEAD:
                return getModelByString(TO_DISPLAY.get(this.id).head);
            case CHEST:
                return getModelByString(TO_DISPLAY.get(this.id).chest);
            case LEGS:
                return getModelByString(TO_DISPLAY.get(this.id).legs);
            case FEET:
                return getModelByString(TO_DISPLAY.get(this.id).feet);
            default:
                return null;
        }
    }


    @SuppressWarnings("incomplete-switch")
    protected void setModelSlotVisible(ModelBiped p_188359_1_, EntityEquipmentSlot slotIn) {
        p_188359_1_.bipedHead.showModel = false;
        p_188359_1_.bipedHeadwear.showModel = false;
        p_188359_1_.bipedBody.showModel = false;
        p_188359_1_.bipedRightArm.showModel = false;
        p_188359_1_.bipedLeftArm.showModel = false;
        // p_188359_1_.bipedBody.showModel = false;
        p_188359_1_.bipedRightLeg.showModel = false;
        p_188359_1_.bipedLeftLeg.showModel = false;
        // p_188359_1_.bipedRightLeg.showModel = false;
        // p_188359_1_.bipedLeftLeg.showModel = false;

        if (slotIn == EntityEquipmentSlot.HEAD){
            p_188359_1_.bipedHead.showModel = true;
            p_188359_1_.bipedHeadwear.showModel = true;
        } else if (slotIn == EntityEquipmentSlot.CHEST){
            p_188359_1_.bipedBody.showModel = true;
            p_188359_1_.bipedRightArm.showModel = true;
            p_188359_1_.bipedLeftArm.showModel = true;
        } else if (slotIn == EntityEquipmentSlot.LEGS){
            p_188359_1_.bipedRightLeg.showModel = true;
            p_188359_1_.bipedLeftLeg.showModel = true;
        } else if (slotIn == EntityEquipmentSlot.FEET){
            p_188359_1_.bipedRightLeg.showModel = true;
            p_188359_1_.bipedLeftLeg.showModel = true;
        }
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
    
    private void renderArmorLayer(EntityLivingBase entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale, EntityEquipmentSlot slotIn) {
        ModelBiped t = this.getModelFromSlot(slotIn);
        if (t == null) return;
        // t = getArmorModelHook(entityLivingBaseIn, itemstack, slotIn, t);
        t.setModelAttributes(this.renderer2.getMainModel());

        if (t instanceof GeoArmorRenderer){
            // todo: figure out why sneaking is weird
            // ((GeoArmorRenderer) t).applyEntityStats();
            // t.isSneak = entityLivingBaseIn.isSneaking();
            ((GeoArmorRenderer) t).setCurrentItem(entityLivingBaseIn, ANIM_ITEM, slotIn);
            ((GeoArmorRenderer) t).applySlot(slotIn);
        } else {
            this.setModelSlotVisible(t, slotIn);
            t.setLivingAnimations(entityLivingBaseIn, limbSwing, limbSwingAmount, partialTicks);
        }
        // boolean flag = this.isLegSlot(slotIn);
        if (t instanceof IHasTexture){
            this.renderer2.bindTexture(((IHasTexture) t).getTexture());
        }
        t.render(entityLivingBaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }
}
