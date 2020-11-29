package com.glyceron.yeoldesnails.util;

import com.glyceron.yeoldesnails.YeOldeSnails;
import com.glyceron.yeoldesnails.armor.ModArmorMaterial;
import com.glyceron.yeoldesnails.blocks.BlockItemBase;
import com.glyceron.yeoldesnails.blocks.FossilizedShellBlock;
import com.glyceron.yeoldesnails.items.Escargot;
import com.glyceron.yeoldesnails.items.ItemBase;
import com.glyceron.yeoldesnails.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
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
    public static final RegistryObject<Escargot> ESCARGOT = ITEMS.register("escargot", Escargot::new);

    //Tools
    public static final RegistryObject<SwordItem> KNIGHTS_LANCE = ITEMS.register("knights_lance", () ->
            new SwordItem(ModItemTier.KNIGHT, 2, -2.4F, new Item.Properties().group(YeOldeSnails.TAB))
    );
    public static final RegistryObject<SwordItem> KNIGHTS_MACE = ITEMS.register("knights_mace", () ->
            new SwordItem(ModItemTier.KNIGHT, 4, -3.2F, new Item.Properties().group(YeOldeSnails.TAB))
    );
    public static final RegistryObject<AxeItem> KNIGHTS_BATTLEAXE = ITEMS.register("knights_battleaxe", () ->
            new AxeItem(ModItemTier.KNIGHT, 3, -2.8F, new Item.Properties().group(YeOldeSnails.TAB))
    );

    //Armor
    public static final RegistryObject<ArmorItem> SNAIL_MAIL_HELMET = ITEMS.register("snail_mail_helmet", () ->
            new ArmorItem(ModArmorMaterial.SNAIL_MAIL, EquipmentSlotType.HEAD, new Item.Properties().group(YeOldeSnails.TAB))
    );
    public static final RegistryObject<ArmorItem> SNAIL_MAIL_CHESTPLATE = ITEMS.register("snail_mail_chestplate", () ->
            new ArmorItem(ModArmorMaterial.SNAIL_MAIL, EquipmentSlotType.CHEST, new Item.Properties().group(YeOldeSnails.TAB))
    );
    public static final RegistryObject<ArmorItem> SNAIL_MAIL_LEGGINGS = ITEMS.register("snail_mail_leggings", () ->
            new ArmorItem(ModArmorMaterial.SNAIL_MAIL, EquipmentSlotType.LEGS, new Item.Properties().group(YeOldeSnails.TAB))
    );
    public static final RegistryObject<ArmorItem> SNAIL_MAIL_BOOTS = ITEMS.register("snail_mail_boots", () ->
            new ArmorItem(ModArmorMaterial.SNAIL_MAIL, EquipmentSlotType.FEET, new Item.Properties().group(YeOldeSnails.TAB))
    );

    //Blocks
    public static final RegistryObject<Block> FOSSILIZED_SHELL_BLOCK = BLOCKS.register("fossilized_shell_block", FossilizedShellBlock::new);

    //Block Items
    public static final RegistryObject<Item> FOSSILIZED_SHELL_BLOCK_ITEM = ITEMS.register("fossilized_shell_block", () -> new BlockItemBase(FOSSILIZED_SHELL_BLOCK.get()));
}
