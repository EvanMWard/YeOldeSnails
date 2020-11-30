// Made with Blockbench 3.7.4
package com.glyceron.yeoldesnails.client.model;

import com.glyceron.yeoldesnails.entities.SnailEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SnailModel<T extends SnailEntity> extends EntityModel<T> {

	private final ModelRenderer shell;
	private final ModelRenderer snail;

	public SnailModel() {
		textureWidth = 64;
		textureHeight = 64;

		shell = new ModelRenderer(this);
		shell.setRotationPoint(-4.0F, 24.0F, -1.0F);
		shell.setTextureOffset(0, 0).addBox(1.0F, -8.0F, 1.0F, 5.0F, 8.0F, 7.0F, 0.0F, false);
		shell.setTextureOffset(12, 15).addBox(6.0F, -7.0F, 2.0F, 1.0F, 6.0F, 5.0F, 0.0F, false);
		shell.setTextureOffset(17, 0).addBox(7.0F, -6.0F, 3.0F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		shell.setTextureOffset(12, 15).addBox(0.0F, -7.0F, 2.0F, 1.0F, 6.0F, 5.0F, 0.0F, false);
		shell.setTextureOffset(17, 0).addBox(-1.0F, -6.0F, 3.0F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		shell.setTextureOffset(24, 7).addBox(1.0F, -7.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		shell.setTextureOffset(25, 0).addBox(2.0F, -7.0F, 8.0F, 3.0F, 6.0F, 1.0F, 0.0F, false);
		shell.setTextureOffset(0, 0).addBox(5.0F, -6.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		shell.setTextureOffset(0, 0).addBox(1.0F, -6.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		shell.setTextureOffset(24, 20).addBox(2.0F, -9.0F, 2.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);

		snail = new ModelRenderer(this);
		snail.setRotationPoint(-0.5F, 23.0F, 0.0F);
		snail.setTextureOffset(20, 11).addBox(-1.5F, -3.0F, -4.0F, 3.0F, 4.0F, 5.0F, 0.0F, false);
		snail.setTextureOffset(7, 15).addBox(-1.5F, -4.0F, -6.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		snail.setTextureOffset(24, 19).addBox(-1.5F, -6.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		snail.setTextureOffset(24, 19).addBox(0.5F, -6.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		snail.setTextureOffset(0, 15).addBox(0.5F, -6.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		snail.setTextureOffset(0, 15).addBox(-1.5F, -6.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		shell.render(matrixStack, buffer, packedLight, packedOverlay);
		snail.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}