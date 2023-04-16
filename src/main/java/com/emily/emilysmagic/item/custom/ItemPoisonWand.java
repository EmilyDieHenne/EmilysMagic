package com.emily.emilysmagic.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.function.Predicate;


public class ItemPoisonWand extends BowItem {

    public ItemPoisonWand(Properties properties){
        super(properties);
    }

    @Override
    @NotNull
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return  (p_43017_) -> {
            return true;
        };
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable( "item.emilysmagic.poison_wand.desc").withStyle(ChatFormatting.DARK_PURPLE));
        super.appendHoverText(stack, world, components, tooltipFlag);
    }
    @Override
    @ParametersAreNonnullByDefault
    public void releaseUsing(ItemStack item, Level world, LivingEntity entity, int time) {
        if (entity instanceof Player player) {


            if (!world.isClientSide) {
                int i = this.getUseDuration(item) - time;
                AreaEffectCloud cloud = new AreaEffectCloud(EntityType.AREA_EFFECT_CLOUD, world);
                cloud.setPos(getPlayerPOVHitResult(world,player).getLocation());
                cloud.setPotion(Potions.STRONG_POISON);
                cloud.setDuration(i);
                cloud.setRadius((float)i / 5);
                world.addFreshEntity(cloud);


                player.getCooldowns().addCooldown(this, 60);
            }


            player.awardStat(Stats.ITEM_USED.get(this));


        }
    }
    protected static BlockHitResult getPlayerPOVHitResult(Level world, Player player) {
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
        return world.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
    }

}
