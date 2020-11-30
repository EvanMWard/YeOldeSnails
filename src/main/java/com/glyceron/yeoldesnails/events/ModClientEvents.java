package com.glyceron.yeoldesnails.events;

import com.glyceron.yeoldesnails.YeOldeSnails;
import com.glyceron.yeoldesnails.util.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = YeOldeSnails.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onLanceHitWhileMounted(AttackEntityEvent event){
        PlayerEntity player = event.getPlayer();
        Entity target = event.getTarget();
        if(target instanceof PlayerEntity){
            Entity horse = target.getRidingEntity();
            if(horse instanceof HorseEntity){
                if(player.getHeldItemMainhand().getItem() == RegistryHandler.KNIGHTS_LANCE.get())
                    target.dismount();
            }
        }
    }
}
