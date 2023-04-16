package com.emily.emilysmagic.item.custom;

import com.emily.emilysmagic.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class ItemMagmaArmor extends ArmorItem {


    public ItemMagmaArmor(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        var position = player.blockPosition().below();

        if( level.getBlockState(position) ==  Blocks.WARPED_NYLIUM.defaultBlockState() ||
            level.getBlockState(position) ==  Blocks.CRIMSON_NYLIUM.defaultBlockState()) {
            level.setBlockAndUpdate(position, Blocks.NETHERRACK.defaultBlockState());
        }
        else if(level.getBlockState(position) ==  Blocks.GRASS_BLOCK.defaultBlockState()){
            level.setBlockAndUpdate(position, Blocks.DIRT.defaultBlockState());
        }

        if( player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.ITEMS_MAGMA_HELMET.get() &&
                player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.ITEMS_MAGMA_CHESTPLATE.get() &&
                player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.ITEMS_MAGMA_LEGGINGS.get() &&
                player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.ITEMS_MAGMA_BOOTS.get()
        ) {
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 1));
        }


    }

}
