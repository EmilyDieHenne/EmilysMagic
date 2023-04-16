package com.emily.emilysmagic.materials;

import com.emily.emilysmagic.EmilysMagic;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;


public enum ModMagmaMaterial implements ArmorMaterial {
    EARTH_MATERIAL(
            EmilysMagic.MOD_ID + ":magma",
            50,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            3.0F


    );


    private final String name;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;


    ModMagmaMaterial(String name, int enchantmentValue, SoundEvent sound, float toughness) {
        this.name = name;


        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;

    }


    @Override
    @ParametersAreNonnullByDefault
    public int getDurabilityForType(Type type) {
        return 0;
    }

    @Override
    public int getDefenseForType(Type type) {

        return switch (type.getSlot()) {
            case CHEST -> 4;
            default -> 3;
        };

    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    @NotNull
    public  SoundEvent getEquipSound() {
        return this.sound;
    }


    @Override
    @NotNull
    @MethodsReturnNonnullByDefault
    public Ingredient getRepairIngredient() {

        return Ingredient.of(ItemStack.EMPTY);
    }
    @NotNull
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return 0;
    }
}
