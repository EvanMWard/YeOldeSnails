package com.glyceron.yeoldesnails.util;

import com.glyceron.yeoldesnails.YeOldeSnails;
import com.glyceron.yeoldesnails.blocks.BlockItemBase;
import com.glyceron.yeoldesnails.blocks.FossilizedShellBlock;
import com.glyceron.yeoldesnails.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, YeOldeSnails.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, YeOldeSnails.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items
    public static final RegistryObject<Item> SNAIL_SHELL = ITEMS.register("snail_shell", ItemBase::new);

    //Blocks
    public static final RegistryObject<Block> FOSSILIZED_SHELL_BLOCK = BLOCKS.register("fossilized_shell_block", FossilizedShellBlock::new);

    //Block Items
    public static final RegistryObject<Item> FOSSILIZED_SHELL_BLOCK_ITEM = ITEMS.register("fossilized_shell_block", () -> new BlockItemBase(FOSSILIZED_SHELL_BLOCK.get()));
}
