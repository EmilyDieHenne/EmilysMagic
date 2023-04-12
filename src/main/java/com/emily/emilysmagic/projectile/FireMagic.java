package com.emily.emilysmagic.projectile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class FireMagic extends AbstractArrow {
    protected FireMagic(EntityType<? extends AbstractArrow> p_36721_, Level p_36722_) {
        super(p_36721_, p_36722_);

    }
    public FireMagic(Level world, LivingEntity entity) {
        super(EntityType.ARROW, entity, world);
    }
    @Override
    protected void onHitBlock(BlockHitResult hitResult){
        BlockPos result = hitResult.getBlockPos().above();
        if(checkIfBlock(result)){
            this.level.setBlockAndUpdate(result, Blocks.FIRE.defaultBlockState());
        }


        this.discard();
    }
    private boolean checkIfBlock(BlockPos blockPos){

        BlockState block = this.level.getBlockState(blockPos);
        return (block == Blocks.AIR.defaultBlockState() ||
                block == Blocks.GRASS.defaultBlockState() ||
                block == Blocks.TALL_GRASS.defaultBlockState() );
    }
    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
}
