package com.glyceron.yeoldesnails.client.model;// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Snail extends EntityModel<Entity> {
	private final ModelRenderer Shell;
	private final ModelRenderer Snail;

	public snail() {
		textureWidth = 64;
		textureHeight = 64;

		Shell = new ModelRenderer(this);
		Shell.setRotationPoint(-4.0F, 24.0F, -1.0F);
		Shell.setTextureOffset(0, 0).addBox(1.0F, -8.0F, 1.0F, 5.0F, 8.0F, 7.0F, 0.0F, false);
		Shell.setTextureOffset(12, 15).addBox(6.0F, -7.0F, 2.0F, 1.0F, 6.0F, 5.0F, 0.0F, false);
		Shell.setTextureOffset(17, 0).addBox(7.0F, -6.0F, 3.0F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		Shell.setTextureOffset(12, 15).addBox(0.0F, -7.0F, 2.0F, 1.0F, 6.0F, 5.0F, 0.0F, false);
		Shell.setTextureOffset(17, 0).addBox(-1.0F, -6.0F, 3.0F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		Shell.setTextureOffset(24, 7).addBox(1.0F, -7.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		Shell.setTextureOffset(25, 0).addBox(2.0F, -7.0F, 8.0F, 3.0F, 6.0F, 1.0F, 0.0F, false);
		Shell.setTextureOffset(0, 0).addBox(5.0F, -6.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		Shell.setTextureOffset(0, 0).addBox(1.0F, -6.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		Shell.setTextureOffset(24, 20).addBox(2.0F, -9.0F, 2.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);

		Snail = new ModelRenderer(this);
		Snail.setRotationPoint(-0.5F, 23.0F, 0.0F);
		Snail.setTextureOffset(20, 11).addBox(-1.5F, -3.0F, -4.0F, 3.0F, 4.0F, 5.0F, 0.0F, false);
		Snail.setTextureOffset(7, 15).addBox(-1.5F, -4.0F, -6.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Snail.setTextureOffset(24, 19).addBox(-1.5F, -6.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Snail.setTextureOffset(24, 19).addBox(0.5F, -6.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Snail.setTextureOffset(0, 15).addBox(0.5F, -6.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Snail.setTextureOffset(0, 15).addBox(-1.5F, -6.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Shell.render(matrixStack, buffer, packedLight, packedOverlay);
		Snail.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}