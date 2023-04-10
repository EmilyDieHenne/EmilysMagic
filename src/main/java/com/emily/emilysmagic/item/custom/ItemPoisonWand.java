package com.emily.emilysmagic.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class ItemPoisonWand extends Item {

    public ItemPoisonWand(Properties properties){
        super(properties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {


        if (world.isClientSide() ){

            ThrownPotion tp = new ThrownPotion(world, player);
            tp.setDeltaMovement(player.getLookAngle());
            player.level.addFreshEntity(tp);
        }

        return super.use( world, player, hand);

    }

}
