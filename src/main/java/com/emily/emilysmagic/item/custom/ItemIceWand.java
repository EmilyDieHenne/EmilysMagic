package com.emily.emilysmagic.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;


public class ItemIceWand extends Item {

    public ItemIceWand(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {


        if (!world.isClientSide() ){

            replaceWaterWithIce(player.blockPosition().below(), world);
            player.getCooldowns().addCooldown(this, 7);
            player.playSound(SoundEvents.PLAYER_HURT_FREEZE);
        }

        return super.use( world, player, hand);

    }

    private void replaceWaterWithIce(BlockPos pos, Level world) {
        int size = 3;

        for(int x = 0; x <= size; x++){
            for(int z = 0; z <= size; z++){
                if(!(x == size && z == size)){
                    if(checkIfEmpty(world.getBlockState(pos.north(x).east(z))) ){
                        world.setBlockAndUpdate(pos.north(x).east(z), Blocks.BLUE_ICE.defaultBlockState());
                    }
                    if(checkIfEmpty(world.getBlockState(pos.south(x).east(z)))) {
                        world.setBlockAndUpdate(pos.south(x).east(z), Blocks.BLUE_ICE.defaultBlockState());
                    }
                    if(checkIfEmpty(world.getBlockState(pos.north(x).west(z)))){
                        world.setBlockAndUpdate(pos.north(x).west(z), Blocks.BLUE_ICE.defaultBlockState());
                    }
                    if(checkIfEmpty(world.getBlockState(pos.south(x).west(z)))) {
                        world.setBlockAndUpdate(pos.south(x).west(z), Blocks.BLUE_ICE.defaultBlockState());
                    }
                }

            }
        }


    }
    private boolean checkIfEmpty(BlockState blockState){
        return  blockState == Blocks.WATER.defaultBlockState() ||
                blockState == Blocks.SEAGRASS.defaultBlockState() ||
                blockState == Blocks.TALL_SEAGRASS.defaultBlockState() ||
                blockState == Blocks.KELP_PLANT.defaultBlockState() ||
                blockState == Blocks.KELP.defaultBlockState();
    }
}
