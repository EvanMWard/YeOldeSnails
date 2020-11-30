package com.glyceron.yeoldesnails.items;

import com.glyceron.yeoldesnails.YeOldeSnails;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class SnailBucket extends Item {
    public SnailBucket() {
        super(new Item.Properties()
        .group(YeOldeSnails.TAB)
        .containerItem(Items.BUCKET)
        .maxStackSize(1));
    }

}
