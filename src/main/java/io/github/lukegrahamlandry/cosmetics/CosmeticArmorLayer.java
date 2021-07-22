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
import java.util.Map;
import java.util.UUID;

public class CosmeticArmorLayer extends LayerArmorBase<ModelBiped> {
    static Map<String, ModelBiped> geoModels = new HashMap();
    static {
        // add $NAME to this list
        // texture must be in src/main/resources/assets/lukescosmetics/textures/$NAME.png
        // geo model file must be in src/main/resources/assets/lukescosmetics/geo/$NAME.json
        // use the model ingame with /cosmetic SBODY_PART $NAME
        String[] geoFilePaths = new String[]{
                "potato"
        };

        for (String path : geoFilePaths){
            geoModels.put(path, new ExampleGeoArmor(path));
        }
    }




    static final ModelBiped DEMO = new DemoArmorModel();
    static final ModelBiped SHADOW = new ShadowStalker();
    static final ModelBiped TEMPLATE = new TemplateModel();

    static final Map<EntityEquipmentSlot, ItemStack> ANIM_ITEM = new HashMap<>();
    static {
        ANIM_ITEM.put(EntityEquipmentSlot.HEAD, new ItemStack(new NullItem(ItemArmor.ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.HEAD)));
        ANIM_ITEM.put(EntityEquipmentSlot.CHEST, new ItemStack(new NullItem(ItemArmor.ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.CHEST)));
        ANIM_ITEM.put(EntityEquipmentSlot.LEGS, new ItemStack(new NullItem(ItemArmor.ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.LEGS)));
        ANIM_ITEM.put(EntityEquipmentSlot.FEET, new ItemStack(new NullItem(ItemArmor.ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.FEET)));
    }

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

    public CosmeticArmorLayer(RenderLivingBase<?> rendererIn) {
        super(rendererIn);
        this.renderer2 = rendererIn;
    }

    protected void initArmor() {
        // unused
    }

    // "none" is reserved 
    private ModelBiped getModelByString(String name){
        if (name.equals("demo")) return DEMO;
        if (name.equals("shadow"))  return SHADOW;

        if (geoModels.containsKey(name)) return geoModels.get(name);

        return null;
    }


    // each thing has all the [head, chest, legs, boots]
    // setModelSlotVisible sets them invisible based on the slot
    // idea being one type of

    public ModelBiped getModelFromSlot(EntityEquipmentSlot slotIn, UUID id) {
        if (!TO_DISPLAY.containsKey(id)) return null;
        switch (slotIn) {
            case HEAD:
                return getModelByString(TO_DISPLAY.get(id).head);
            case CHEST:
                return getModelByString(TO_DISPLAY.get(id).chest);
            case LEGS:
                return getModelByString(TO_DISPLAY.get(id).legs);
            case FEET:
                return getModelByString(TO_DISPLAY.get(id).feet);
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
    public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.renderArmorLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale, EntityEquipmentSlot.CHEST);
        this.renderArmorLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale, EntityEquipmentSlot.LEGS);
        this.renderArmorLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale, EntityEquipmentSlot.FEET);
        this.renderArmorLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale, EntityEquipmentSlot.HEAD);
    }
    
    private void renderArmorLayer(EntityLivingBase entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale, EntityEquipmentSlot slotIn) {
        ModelBiped t = this.getModelFromSlot(slotIn, entityLivingBaseIn.getUniqueID());
        if (t == null) return;

        // t = getArmorModelHook(entityLivingBaseIn, itemstack, slotIn, t);
        t.setModelAttributes(this.renderer2.getMainModel());

        if (t instanceof GeoArmorRenderer){
            // todo: figure out why sneaking is weird
            ((GeoArmorRenderer) t).applyEntityStats((ModelBiped) this.renderer2.getMainModel());
            // t.isSneak = entityLivingBaseIn.isSneaking();
            // t.isRiding = entityLivingBaseIn.isRiding();

            ((GeoArmorRenderer) t).applySlot(slotIn);
            ((GeoArmorRenderer) t).setCurrentItem(entityLivingBaseIn, ANIM_ITEM.get(slotIn), slotIn);
        } else {
            this.setModelSlotVisible(t, slotIn);
            t.setLivingAnimations(entityLivingBaseIn, limbSwing, limbSwingAmount, partialTicks);
        }
        // boolean flag = this.isLegSlot(slotIn);
        if (t instanceof IHasTexture){
            this.renderer2.bindTexture(((IHasTexture) t).getTexture());
        }
        // System.out.println(entityLivingBaseIn.isSneaking() + " " + t.isSneak);
        t.render(entityLivingBaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }
}
