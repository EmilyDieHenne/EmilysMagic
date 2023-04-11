package com.emily.emilysmagic.item.custom;

import com.emily.emilysmagic.projectile.FireMagic;
import com.emily.emilysmagic.projectile.PoisonMagic;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class ItemPoisonWand extends Item {

    public ItemPoisonWand(Properties properties){
        super(properties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {


        if (!world.isClientSide() ){

            shootArrow(world, player, player.getLookAngle());
            player.getCooldowns().addCooldown(this, 60);
        }
        player.playSound(SoundEvents.WITCH_CELEBRATE);
        return super.use( world, player, hand);

    }
    private void shootArrow(Level world, Player player, Vec3 direction){

        PoisonMagic arrow = new PoisonMagic(world,player);
        arrow.setDeltaMovement(direction);
        arrow.setSilent(true);
        arrow.onAddedToWorld();
        player.level.addFreshEntity(arrow);
    }
}
