package com.glyceron.yeoldesnails.items;

import com.glyceron.yeoldesnails.YeOldeSnails;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class Escargot extends Item {

    public Escargot(){
        super(new Item.Properties()
              .group(YeOldeSnails.TAB)
              .food(new Food.Builder()
                    .hunger(4)
                    .saturation(8.0f)
                    .effect(() -> new EffectInstance(Effects.RESISTANCE, 1200, 0), 1.0f)
                    .build())
        );
    }

    @MethodsReturnNonnullByDefault
    @ParametersAreNonnullByDefault
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)entityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
            serverplayerentity.addStat(Stats.ITEM_USED.get(this));
        }

        if (entityLiving instanceof PlayerEntity && !((PlayerEntity)entityLiving).abilities.isCreativeMode) {
            stack.shrink(1);
        }

        return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
    }
}
