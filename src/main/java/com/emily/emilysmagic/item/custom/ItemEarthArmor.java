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


public class ItemEarthArmor extends ArmorItem {


    public ItemEarthArmor(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if( player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.ITEMS_EARTH_HELMET.get() &&
            player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.ITEMS_EARTH_CHESTPLATE.get() &&
            player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.ITEMS_EARTH_LEGGINGS.get() &&
            player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.ITEMS_EARTH_BOOTS.get()
        ) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1));
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 1));
        }

    }
}
