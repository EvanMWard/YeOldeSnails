package com.glyceron.yeoldesnails.items;

import com.glyceron.yeoldesnails.YeOldeSnails;
import com.glyceron.yeoldesnails.init.ModEntityTypes;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;



public class SnailBucket extends Item{


    public SnailBucket(Properties properties) {
        super(new Item.Properties()
                .group(YeOldeSnails.TAB)
                .containerItem(Items.BUCKET)
                .maxStackSize(1)
        );
    }

    @Override
    @MethodsReturnNonnullByDefault
    public ActionResultType onItemUse(ItemUseContext context) {
        ActionResultType result = ActionResultType.PASS;

        World worldIn = context.getWorld();
        PlayerEntity playerIn = context.getPlayer();
        ItemStack itemstack = context.getItem();

        if (playerIn != null) {
            BlockRayTraceResult blockraytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
            BlockPos blockpos = blockraytraceresult.getPos();
            Direction direction = blockraytraceresult.getFace();
            BlockPos pos = blockpos.offset(direction);

            if (worldIn instanceof ServerWorld) {
                Entity entity = ModEntityTypes.SNAIL.get().spawn((ServerWorld) worldIn, itemstack, (PlayerEntity) null, pos, SpawnReason.BUCKET, true, false);
                playerIn.playSound(SoundEvents.ITEM_BUCKET_EMPTY_FISH, 1.0F, 1.0F);
                itemstack.shrink(1);
                playerIn.addItemStackToInventory(new ItemStack(Items.BUCKET));
            }
            result = ActionResultType.SUCCESS;
        }
        return result;
    }
}


















