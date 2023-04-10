package com.emily.emilysmagic.item.custom;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class ItemFireWand extends Item {

    public ItemFireWand(Properties properties){
        super(properties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {


        if (!player.level.isClientSide() ){


            Arrow arrow = new Arrow(world, player);
            arrow.setSecondsOnFire(100);
            arrow.setDeltaMovement(player.getLookAngle().yRot(0.2f));
            player.level.addFreshEntity(arrow);

            Arrow arrow1 = new Arrow(world, player);
            arrow1.setSecondsOnFire(100);
            arrow1.setDeltaMovement(player.getLookAngle());
            player.level.addFreshEntity(arrow1);

            Arrow arrow2 = new Arrow(world, player);
            arrow2.setSecondsOnFire(100);
            arrow2.setDeltaMovement(player.getLookAngle().yRot(-0.2f));
            player.level.addFreshEntity(arrow2);



            player.getCooldowns().addCooldown(this, 60);
        }

        return super.use( world, player, hand);

    }

private void shootArrow(Level world, Player player, Vec3 direction){

}



}
