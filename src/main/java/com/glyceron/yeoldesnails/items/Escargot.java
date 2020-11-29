package com.glyceron.yeoldesnails.items;

import com.glyceron.yeoldesnails.YeOldeSnails;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Escargot extends Item {

    public Escargot(){
        super(new Item.Properties()
              .group(YeOldeSnails.TAB)
              .food(new Food.Builder()
                    .hunger(4)
                    .saturation(8.0f)
                    .effect(() -> new EffectInstance(Effects.RESISTANCE, 1200, 0), 1.0f)
                    .build())
        );
    }
}
