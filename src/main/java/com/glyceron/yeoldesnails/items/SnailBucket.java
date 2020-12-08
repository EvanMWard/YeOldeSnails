package com.glyceron.yeoldesnails.items;

import com.glyceron.yeoldesnails.YeOldeSnails;
import com.glyceron.yeoldesnails.entities.SnailEntity;
import com.glyceron.yeoldesnails.init.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.function.Supplier;


public class SnailBucket extends Item{

    public SnailBucket() {
        super(new Item.Properties()
        .group(YeOldeSnails.TAB)
        .maxStackSize(1));
    }

    public void onLiquidPlaced(World worldIn, ItemStack stack, BlockPos pos){
        if(worldIn instanceof ServerWorld){
            Entity entity = ModEntityTypes.SNAIL.get().spawn((ServerWorld) worldIn, stack, (PlayerEntity) null, pos, SpawnReason.BUCKET, true, false);
        }
    }
}
