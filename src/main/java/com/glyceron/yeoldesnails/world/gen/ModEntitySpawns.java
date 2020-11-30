package com.glyceron.yeoldesnails.world.gen;

import com.glyceron.yeoldesnails.YeOldeSnails;
import com.glyceron.yeoldesnails.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = YeOldeSnails.MOD_ID)
public class ModEntitySpawns {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void spawnEntities(BiomeLoadingEvent event){
        for(Biome biome : ForgeRegistries.BIOMES){
            Biome.Category category = biome.getCategory();
            if(category == Biome.Category.SWAMP || category == Biome.Category.FOREST){
                event.getSpawns().getSpawner(EntityClassification.CREATURE)
                        .add(new MobSpawnInfo.Spawners(ModEntityTypes.SNAIL.get(), 10, 3, 5));
            }
        }
    }
}
