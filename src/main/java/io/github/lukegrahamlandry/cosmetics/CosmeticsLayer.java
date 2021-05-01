package io.github.lukegrahamlandry.cosmetics;

import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;

public class CosmeticsLayer implements LayerRenderer<EntityLivingBase> {
    static TestHelmet model = new TestHelmet();
    private final RenderLivingBase renderPlayer;


    public CosmeticsLayer(RenderLivingBase renderPlayerIn){
        this.renderPlayer = renderPlayerIn;
    }

    @Override
    public void doRenderLayer(EntityLivingBase entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.renderPlayer.bindTexture(model.getTexture());
        model.render(this.renderPlayer, scale); // .render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
