package com.glyceron.yeoldesnails.client.render;

import com.glyceron.yeoldesnails.YeOldeSnails;
import com.glyceron.yeoldesnails.client.model.SnailModel;
import com.glyceron.yeoldesnails.entities.SnailEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SnailRenderer extends MobRenderer<SnailEntity, SnailModel<SnailEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(YeOldeSnails.MOD_ID, "textures/entity/snail.png");
    public SnailRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SnailModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(SnailEntity entity) {
        return TEXTURE;
    }
}
