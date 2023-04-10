package com.emily.emilysmagic.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class ItemSapphireWand extends Item {

    public ItemSapphireWand(Properties properties){
        super(properties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {


        if (world.isClientSide() ){
            player.jumpFromGround();
            player.setDeltaMovement(player.getLookAngle().add(0,0.3,0));
            player.playSound(SoundEvents.RESPAWN_ANCHOR_DEPLETE.value());
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use( world, player, hand);

    }

}
