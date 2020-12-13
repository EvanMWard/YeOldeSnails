package com.glyceron.yeoldesnails.items;

import com.glyceron.yeoldesnails.YeOldeSnails;
import com.glyceron.yeoldesnails.entities.SnailEntity;
import com.glyceron.yeoldesnails.init.ModEntityTypes;
import com.glyceron.yeoldesnails.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.function.Supplier;


public class SnailBucket extends Item{


    public SnailBucket(Properties properties) {
        super(new Item.Properties()
                .group(YeOldeSnails.TAB)
                .containerItem(Items.BUCKET)
                .maxStackSize(1)
        );
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {

        World worldIn =  context.getWorld();
        PlayerEntity playerIn = context.getPlayer();
        ItemStack itemstack = context.getItem();

        // gets BlockPos and face to spawn in the snail
        RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
        BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)raytraceresult;
        BlockPos blockpos = blockraytraceresult.getPos();
        Direction direction = blockraytraceresult.getFace();
        BlockPos pos = blockpos.offset(direction);

        if(worldIn instanceof ServerWorld) {
            Entity entity = ModEntityTypes.SNAIL.get().spawn((ServerWorld) worldIn, itemstack, (PlayerEntity) null, pos, SpawnReason.BUCKET, true, false);
            itemstack.shrink(1);
            playerIn.addItemStackToInventory(new ItemStack(Items.BUCKET));
        }
        return ActionResultType.SUCCESS;
    }
}


















