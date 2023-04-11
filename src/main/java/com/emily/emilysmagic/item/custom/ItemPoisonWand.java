package com.emily.emilysmagic.item.custom;

import com.emily.emilysmagic.projectile.FireMagic;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;


public class ItemPoisonWand extends Item {

    public ItemPoisonWand(Properties properties){
        super(properties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {


        if (!world.isClientSide() ){
            BlockHitResult block = getPlayerPOVHitResult(world, player, ClipContext.Fluid.NONE);

            AreaEffectCloud cloud = new AreaEffectCloud(EntityType.AREA_EFFECT_CLOUD, world);
            cloud.setPos(block.getBlockPos().getCenter());
            cloud.setPotion(Potion.byName("poison"));

            cloud.setDuration(50);
            world.addFreshEntity(cloud);

            player.getCooldowns().addCooldown(this, 60);
        }
        player.playSound(SoundEvents.WITCH_CELEBRATE);
        return super.use( world, player, hand);

    }

}
