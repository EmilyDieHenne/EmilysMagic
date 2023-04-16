package com.emily.emilysmagic.item.custom;

import com.emily.emilysmagic.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class ItemEarthArmor extends ArmorItem {


    public ItemEarthArmor(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("item.emilysmagic.earth_armor.desc").withStyle(ChatFormatting.DARK_PURPLE));
        super.appendHoverText(stack, world, components, tooltipFlag);
    }
    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if( player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.ITEMS_EARTH_HELMET.get() &&
            player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.ITEMS_EARTH_CHESTPLATE.get() &&
            player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.ITEMS_EARTH_LEGGINGS.get() &&
            player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.ITEMS_EARTH_BOOTS.get()
        ) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100,1));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100));
        }

    }
}
