package com.emily.emilysmagic.projectile;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class PoisonMagic extends AbstractArrow {
    protected PoisonMagic(EntityType<? extends AbstractArrow> p_36721_, Level p_36722_) {
        super(p_36721_, p_36722_);

    }
    public PoisonMagic(Level world, LivingEntity entity) {
        super(EntityType.ARROW, entity, world);
    }
    @Override
    protected void onHitBlock(BlockHitResult hitResult ){

        AreaEffectCloud cloud = new AreaEffectCloud(EntityType.AREA_EFFECT_CLOUD, this.level);
        cloud.setPos(hitResult.getBlockPos().above(1).getCenter());
        cloud.setPotion(Potion.byName("poison"));

        cloud.setDuration(50);
        this.level.addFreshEntity(cloud);

        this.discard();
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult){
        AreaEffectCloud cloud = new AreaEffectCloud(EntityType.AREA_EFFECT_CLOUD, this.level);
        cloud.setPos(hitResult.getLocation());
        cloud.setPotion(Potion.byName("poison"));

        cloud.setDuration(50);
        this.level.addFreshEntity(cloud);

    }
    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
}
