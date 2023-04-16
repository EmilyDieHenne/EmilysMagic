package com.emily.emilysmagic.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;


public class ItemLightningWand extends Item {

    public ItemLightningWand(Properties properties){
        super(properties);
    }
    @Override
    @NotNull
    @ParametersAreNonnullByDefault
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {


        if (!world.isClientSide() ){


            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT,world);

            lightningBolt.setPos(getGoalBlock(world,player).getCenter());

            world.addFreshEntity(lightningBolt);

            player.getCooldowns().addCooldown(this, 70);
        }



        return super.use( world, player, hand);

    }
    protected static BlockPos getGoalBlock(Level world, Player player) {
        float f = player.getXRot();
        float f1 = player.getYRot();
        Vec3 vec3 = player.getEyePosition();
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = 25;
        Vec3 vec31 = vec3.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        BlockHitResult block =  world.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, player));
        BlockPos pos = block.getBlockPos().relative(block.getDirection());
        while(true){
            if(!world.getBlockState(pos).is(Blocks.AIR)){
                return pos.above();
            }
            pos = pos.below();
        }



    }
}
