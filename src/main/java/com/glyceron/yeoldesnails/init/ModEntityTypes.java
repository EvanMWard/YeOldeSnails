package com.glyceron.yeoldesnails.init;

import com.glyceron.yeoldesnails.YeOldeSnails;
import com.glyceron.yeoldesnails.entities.SnailEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, YeOldeSnails.MOD_ID);

    // Entity Types
    public static final RegistryObject<EntityType<SnailEntity>> SNAIL = ENTITY_TYPES.register("snail",
            () -> EntityType.Builder.create(SnailEntity::new, EntityClassification.CREATURE)
            .size(1.0f, 1.0f)
            .build(new ResourceLocation(YeOldeSnails.MOD_ID, "snail").toString())
    );
}
