package com.emily.emilysmagic.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class ItemEarthWand extends Item {

    public ItemEarthWand(Properties properties){
        super(properties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {


        if (world.isClientSide() ){

            player.setDeltaMovement(0,-3,0);
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100));
            player.playSound(SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR);
            player.getCooldowns().addCooldown(this, 70);
        }

        return super.use( world, player, hand);

    }

}
