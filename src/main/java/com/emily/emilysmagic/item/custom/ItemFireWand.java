package com.emily.emilysmagic.item.custom;


import com.emily.emilysmagic.projectile.FireMagic;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.checkerframework.checker.units.qual.A;


public class ItemFireWand extends Item {

    public ItemFireWand(Properties properties){
        super(properties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {


        if (!player.level.isClientSide() ){

            shootArrow(world, player, player.getLookAngle().yRot(0.2f));
            shootArrow(world, player, player.getLookAngle().yRot(0.1f));
            shootArrow(world, player, player.getLookAngle());
            shootArrow(world, player, player.getLookAngle().yRot(-0.1f));
            shootArrow(world, player, player.getLookAngle().yRot(-0.2f));
            player.getCooldowns().addCooldown(this, 60);

        }
        player.playSound(SoundEvents.FIRECHARGE_USE);
        return super.use( world, player, hand);

    }

private void shootArrow(Level world, Player player, Vec3 direction){

    FireMagic arrow = new FireMagic(world,player);
    arrow.setSecondsOnFire(100);
    arrow.setDeltaMovement(direction);
    arrow.setInvisible(true);
    arrow.setSilent(true);
    arrow.onAddedToWorld();
    player.level.addFreshEntity(arrow);
}



}
