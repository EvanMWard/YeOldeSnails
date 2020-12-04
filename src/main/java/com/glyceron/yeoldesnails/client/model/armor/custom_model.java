package com.glyceron.yeoldesnails.client.model.armor;// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

// THIS IS A TEST MODEL

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;

public class custom_model extends ModelArmor {
	private final ModelRenderer head;
	private final ModelRenderer helmet;

	public custom_model(EquipmentSlotType slot) {
		super(slot);

		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 11).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		helmet = new ModelRenderer(this);
		helmet.setRotationPoint(0.0F, 24.0F, 0.0F);
		helmet.setTextureOffset(0, 0).addBox(-5.0F, -33.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		helmet.setTextureOffset(30, 1).addBox(4.0F, -32.0F, -5.0F, 1.0F, 6.0F, 10.0F, 0.0F, false);
		helmet.setTextureOffset(24, 24).addBox(-5.0F, -32.0F, -5.0F, 1.0F, 6.0F, 10.0F, 0.0F, false);
		helmet.setTextureOffset(42, 0).addBox(-4.0F, -32.0F, 4.0F, 8.0F, 6.0F, 1.0F, 0.0F, false);
		helmet.setTextureOffset(36, 17).addBox(-3.0F, -40.0F, -3.0F, 6.0F, 7.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		helmet.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}