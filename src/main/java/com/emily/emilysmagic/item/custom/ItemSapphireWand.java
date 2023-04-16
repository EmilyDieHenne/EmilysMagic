package com.emily.emilysmagic.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;


public class ItemSapphireWand extends Item {

    public ItemSapphireWand(Properties properties){
        super(properties);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("item.emilysmagic.sapphire_wand.desc").withStyle(ChatFormatting.DARK_PURPLE));
        super.appendHoverText(stack, world, components, tooltipFlag);
    }
    @Override
    @NotNull
    @ParametersAreNonnullByDefault
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {


        if (world.isClientSide() ){
            player.jumpFromGround();
            player.setDeltaMovement(player.getLookAngle().add(0,0.3,0));
            player.playSound(SoundEvents.RESPAWN_ANCHOR_DEPLETE.value());
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use( world, player, hand);

    }

}
