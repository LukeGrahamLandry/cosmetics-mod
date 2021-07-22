package io.github.lukegrahamlandry.cosmetics.model;

import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import io.github.lukegrahamlandry.cosmetics.NullItem;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

// the potato example the geometry and texture files are from geckolib's example mod: https://github.com/bernie-g/geckolib
// license: MIT

public class ExampleGeoArmor extends GeoArmorRenderer<NullItem> {
    public ExampleGeoArmor(String name) {
        super(new Model(name));

        this.headBone = "bipedHead";
        this.bodyBone = "bipedBody";
        this.rightArmBone = "bipedRightArm";
        this.leftArmBone = "bipedLeftArm";
        this.rightLegBone = "bipedRightLeg";
        this.leftLegBone = "bipedLeftLeg";
        this.rightBootBone = "bipedRightBoot";
        this.leftBootBone = "bipedLeftBoot";
    }

    @Override
    public Integer getUniqueID(NullItem animatable) {
        return 3141492;
    }

    static class Model extends AnimatedGeoModel<NullItem> {
        String name;
        public Model(String name){
            this.name = name;
        }

        @Override
        public ResourceLocation getModelLocation(NullItem object) {
            return new ResourceLocation(CosmeticsMain.MODID, "geo/" + this.name + ".json");
        }

        @Override
        public ResourceLocation getTextureLocation(NullItem object) {
            return new ResourceLocation(CosmeticsMain.MODID, "textures/" + this.name + ".png");
        }

        @Override
        public ResourceLocation getAnimationFileLocation(NullItem animatable) {
            return null;
        }
    }
}
