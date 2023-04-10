package com.emily.emilysmagic;

import com.emily.emilysmagic.block.ModBlocks;
import com.emily.emilysmagic.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
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
            event.accept(ModItems.MANA_CRISTAL);
        }

        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.MANA_ORE);
            event.accept(ModBlocks.DEEPSLATE_MANA_ORE);
        }

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.MANA_BLOCK);
        }
    }

}
