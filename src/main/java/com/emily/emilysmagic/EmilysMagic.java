package com.emily.emilysmagic;

import com.emily.emilysmagic.block.ModBlocks;
import com.emily.emilysmagic.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(EmilysMagic.MOD_ID)
public class EmilysMagic
{
    public static final String MOD_ID = "emilysmagic";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EmilysMagic()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ITEMS_MANA_CRISTAL);
        }

        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.MANA_ORE);
            event.accept(ModBlocks.DEEPSLATE_MANA_ORE);
        }

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.MANA_BLOCK);
        }

    }

    @Mod.EventBusSubscriber(modid = EmilysMagic.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static final class ModEvents {
        @SubscribeEvent
        public static void onCreativeTabRegistry(CreativeModeTabEvent.Register event) {
            event.registerCreativeModeTab(new ResourceLocation(EmilysMagic.MOD_ID, "mytab"), builder -> {
                builder.title(Component.translatable("item_group." + EmilysMagic.MOD_ID + ".emilysmagic"))
                        .icon(() -> new ItemStack(ModItems.ITEMS_SAPPHIRE_WAND.get()))
                        .displayItems((enabledFlags, tab) -> {
                            tab.accept(ModItems.ITEM_ENDER_WAND.get());
                            tab.accept(ModItems.ITEMS_SAPPHIRE_WAND.get());
                            tab.accept(ModItems.ITEMS_EARTH_WAND.get());
                            tab.accept(ModItems.ITEMS_ICE_WAND.get());
                            tab.accept(ModItems.ITEMS_FIRE_WAND.get());
                            tab.accept(ModItems.ITEMS_POISON_WAND.get());
                            tab.accept(ModItems.ITEMS_LIGHTNING_WAND.get());

                            tab.accept(ModItems.ITEMS_EARTH_HELMET.get());
                            tab.accept(ModItems.ITEMS_EARTH_CHESTPLATE.get());
                            tab.accept(ModItems.ITEMS_EARTH_LEGGINGS.get());
                            tab.accept(ModItems.ITEMS_EARTH_BOOTS.get());

                            tab.accept(ModItems.ITEMS_MANA_CRISTAL.get());
                            tab.accept(ModBlocks.MANA_ORE.get());
                            tab.accept(ModBlocks.DEEPSLATE_MANA_ORE.get());
                            tab.accept(ModBlocks.MANA_BLOCK.get());
                        });
            });
        }
    }
}
