package com.emily.emilysmagic.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;


public class ItemEarthWand extends Item {

    public ItemEarthWand(Properties properties){
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("item.emilysmagic.earth_wand.desc").withStyle(ChatFormatting.DARK_PURPLE));
        super.appendHoverText(stack, world, components, tooltipFlag);
    }
    @Override
    @ParametersAreNonnullByDefault
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity entity, LivingEntity player) {
        entity.setDeltaMovement(0,1,0);
        return super.hurtEnemy(itemStack, entity, player);
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
