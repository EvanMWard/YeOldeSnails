package com.glyceron.yeoldesnails.init;

import com.glyceron.yeoldesnails.YeOldeSnails;
import com.glyceron.yeoldesnails.blocks.FossilizedShellBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, YeOldeSnails.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> FOSSILIZED_SHELL_BLOCK = BLOCKS.register("fossilized_shell_block", FossilizedShellBlock::new);
}
