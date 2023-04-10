package com.emily.emilysmagic.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;


public class ItemEnderWand extends Item {

    public ItemEnderWand(Properties properties){
        super(properties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {


        if (world.isClientSide() ){
            BlockHitResult block = getPlayerPOVHitResult(world, player, ClipContext.Fluid.NONE);
            var lookPos = block.getBlockPos().relative(block.getDirection());
            player.moveTo(lookPos.getX(), lookPos.getY(), lookPos.getZ());
            player.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT);
            player.getCooldowns().addCooldown(this, 30);
        }



        return super.use( world, player, hand);

    }

}
