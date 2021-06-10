package io.github.lukegrahamlandry.cosmetics.model;

import io.github.lukegrahamlandry.cosmetics.CosmeticsMain;
import io.github.lukegrahamlandry.cosmetics.NullItem;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

// this model is simply an example
// the geometry and texture files are from geckolib's example mod: https://github.com/bernie-g/geckolib
// license: MIT

public class ExampleGeoArmor extends GeoArmorRenderer<NullItem> {
    public ExampleGeoArmor() {
        super(new Model());

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
        @Override
        public ResourceLocation getModelLocation(NullItem object) {
            return new ResourceLocation(CosmeticsMain.MODID, "geo/example.json");
        }

        @Override
        public ResourceLocation getTextureLocation(NullItem object) {
            return new ResourceLocation(CosmeticsMain.MODID, "textures/example.png");
        }

        @Override
        public ResourceLocation getAnimationFileLocation(NullItem animatable) {
            return null;
        }
    }
}
