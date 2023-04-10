package com.emily.emilysmagic.item;

import com.emily.emilysmagic.EmilysMagic;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
        public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, EmilysMagic.MOD_ID);

        public static final RegistryObject<Item> MANA_CRISTAL = ITEMS.register("mana_cristal",
                () -> new Item(new Item.Properties().stacksTo(64)));


        public static void register(IEventBus eventBus){
            ITEMS.register(eventBus);
        }
}
