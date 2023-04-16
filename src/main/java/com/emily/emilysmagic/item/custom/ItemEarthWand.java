package com.emily.emilysmagic.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;


public class ItemEarthWand extends Item {

    public ItemEarthWand(Properties properties){
        super(properties);
    }
    @Override
    @NotNull
    @ParametersAreNonnullByDefault
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {


        if (world.isClientSide() ){

            player.setDeltaMovement(0,-3,0);
            player.resetFallDistance();
            player.playSound(SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR);
            player.getCooldowns().addCooldown(this, 40);
        }

        return super.use( world, player, hand);

    }

}
