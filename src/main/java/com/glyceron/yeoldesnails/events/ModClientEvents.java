package com.glyceron.yeoldesnails.events;

import com.glyceron.yeoldesnails.YeOldeSnails;
import com.glyceron.yeoldesnails.entities.SnailEntity;
import com.glyceron.yeoldesnails.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = YeOldeSnails.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    //Jousting event
    @SubscribeEvent
    public static void onLanceHitWhileMounted(AttackEntityEvent event){
        PlayerEntity player = event.getPlayer();
        Entity target = event.getTarget();
        if(target instanceof PlayerEntity){
            Entity horse = target.getRidingEntity();
            if(horse instanceof HorseEntity){
                if(player.getHeldItemMainhand().getItem() == ModItems.KNIGHTS_LANCE.get())
                    target.dismount();
            }
        }
    }

    //Snail in a bucket events
    /*@SubscribeEvent
    public static void rightClickSnailWithBucket(PlayerInteractEvent.EntityInteract event){
        PlayerEntity player = event.getPlayer();
        Entity target = event.getTarget();
        if(target instanceof SnailEntity){
            if(player.getHeldItemMainhand().getItem() == Items.BUCKET){
                target.remove();
                player.addItemStackToInventory(new ItemStack(ModItems.SNAIL_BUCKET.get()));
            }
        }
    }*/

    /*@SubscribeEvent
    public static void rightClickBlockWithSnailBucket(PlayerInteractEvent.RightClickBlock event){
        PlayerEntity player = event.getPlayer();
        if(player.getHeldItemMainhand().getItem() == ModItems.SNAIL_BUCKET.get()){

        }
    }*/
}
