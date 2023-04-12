package com.emily.emilysmagic.item;

import com.emily.emilysmagic.EmilysMagic;
import com.emily.emilysmagic.item.custom.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EmilysMagic.MOD_ID);

    public static final RegistryObject<Item> ITEMS_MANA_CRISTAL = ITEMS.register("mana_cristal",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ITEM_ENDER_WAND = ITEMS.register("ender_wand",
            () -> new ItemEnderWand(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ITEMS_ICE_WAND = ITEMS.register("ice_wand",
            () -> new ItemIceWand(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ITEMS_SAPPHIRE_WAND = ITEMS.register("sapphire_wand",
            () -> new ItemSapphireWand(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ITEMS_POISON_WAND = ITEMS.register("poison_wand",
            () -> new ItemPoisonWand(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ITEMS_FIRE_WAND = ITEMS.register("fire_wand",
            () -> new ItemFireWand(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ITEMS_LIGHTNING_WAND = ITEMS.register("lightning_wand",
            () -> new ItemLightningWand(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ITEMS_WIND_BOOTS = ITEMS.register("wind_boots",
            () -> new ItemWindBoots(ArmorMaterials.LEATHER, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).defaultDurability(46)));
    public static final RegistryObject<Item> ITEMS_EARTH_LEGGINGS = ITEMS.register("earth_leggings",
            () -> new ItemEarthLeggings(ArmorMaterials.CHAIN, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).defaultDurability(99)));
    public static void register(IEventBus eventBus){
            ITEMS.register(eventBus);
        }
}
