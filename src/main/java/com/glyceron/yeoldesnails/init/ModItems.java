package com.glyceron.yeoldesnails.init;

import com.glyceron.yeoldesnails.YeOldeSnails;
import com.glyceron.yeoldesnails.blocks.BlockItemBase;
import com.glyceron.yeoldesnails.items.EscargotBucket;
import com.glyceron.yeoldesnails.items.ItemBase;
import com.glyceron.yeoldesnails.items.SnailBucket;
import com.glyceron.yeoldesnails.util.enums.ModArmorMaterial;
import com.glyceron.yeoldesnails.util.enums.ModItemTier;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, YeOldeSnails.MOD_ID);

    //Items
    public static final RegistryObject<Item>           SNAIL_SHELL     = ITEMS.register("snail_shell",     ItemBase::new);
    public static final RegistryObject<EscargotBucket> ESCARGOT_BUCKET = ITEMS.register("escargot_bucket", EscargotBucket::new);
    //public static final RegistryObject<SnailBucket>    SNAIL_BUCKET    = ITEMS.register("snail_bucket",    SnailBucket::new);
    public static final RegistryObject<SnailBucket> SNAIL_BUCKET =  ITEMS.register("snail_bucket",
            () -> new SnailBucket(Fluids.EMPTY, new Item.Properties().group(YeOldeSnails.TAB))
    );

    //Tools
    public static final RegistryObject<SwordItem> KNIGHTS_LANCE = ITEMS.register("knights_lance",
            () -> new SwordItem(ModItemTier.KNIGHT, 2, -2.4F, new Item.Properties().group(YeOldeSnails.TAB))
    );
    public static final RegistryObject<SwordItem> KNIGHTS_MACE = ITEMS.register("knights_mace",
            () -> new SwordItem(ModItemTier.KNIGHT, 4, -3.2F, new Item.Properties().group(YeOldeSnails.TAB))
    );
    public static final RegistryObject<AxeItem> KNIGHTS_BATTLEAXE = ITEMS.register("knights_battleaxe",
            () -> new AxeItem(ModItemTier.KNIGHT, 3, -2.8F, new Item.Properties().group(YeOldeSnails.TAB))
    );

    //Armor
    public static final RegistryObject<ArmorItem> SNAIL_MAIL_HELMET = ITEMS.register("snail_mail_helmet",
            () -> new ArmorItem(ModArmorMaterial.SNAIL_MAIL, EquipmentSlotType.HEAD, new Item.Properties().group(YeOldeSnails.TAB))
    );
    public static final RegistryObject<ArmorItem> SNAIL_MAIL_CHESTPLATE = ITEMS.register("snail_mail_chestplate",
            () -> new ArmorItem(ModArmorMaterial.SNAIL_MAIL, EquipmentSlotType.CHEST, new Item.Properties().group(YeOldeSnails.TAB))
    );
    public static final RegistryObject<ArmorItem> SNAIL_MAIL_LEGGINGS = ITEMS.register("snail_mail_leggings",
            () -> new ArmorItem(ModArmorMaterial.SNAIL_MAIL, EquipmentSlotType.LEGS, new Item.Properties().group(YeOldeSnails.TAB))
    );
    public static final RegistryObject<ArmorItem> SNAIL_MAIL_BOOTS = ITEMS.register("snail_mail_boots",
            () -> new ArmorItem(ModArmorMaterial.SNAIL_MAIL, EquipmentSlotType.FEET, new Item.Properties().group(YeOldeSnails.TAB))
    );

    //Block Items
    public static final RegistryObject<Item> FOSSILIZED_SHELL_BLOCK_ITEM = ITEMS.register("fossilized_shell_block",
            () -> new BlockItemBase(ModBlocks.FOSSILIZED_SHELL_BLOCK.get()));
}
