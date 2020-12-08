package com.glyceron.yeoldesnails.items;

import com.glyceron.yeoldesnails.YeOldeSnails;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class EscargotBucket extends Item {

    public EscargotBucket(){
        super(new Item.Properties()
              .group(YeOldeSnails.TAB)
              .food((new Food.Builder())
                    .hunger(4)
                    .saturation(8f)
                    .effect(() -> new EffectInstance(Effects.RESISTANCE, 1200, 0), 1.0f)
                    .build())
              .containerItem(Items.BUCKET)
              .maxStackSize(1)
        );
    }

    @ParametersAreNonnullByDefault
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
        return entityLiving instanceof PlayerEntity && ((PlayerEntity)entityLiving).abilities.isCreativeMode ? itemstack : new ItemStack(Items.BUCKET);
    }
}
