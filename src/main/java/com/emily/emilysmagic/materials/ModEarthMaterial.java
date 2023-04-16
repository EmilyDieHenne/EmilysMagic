package com.emily.emilysmagic.materials;

import com.emily.emilysmagic.EmilysMagic;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModEarthMaterial implements ArmorMaterial {
    EARTH_MATERIAL(
            EmilysMagic.MOD_ID + ":earth",
            50,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            0,
            () -> {
                return Ingredient.of(Items.IRON_INGOT);
            }
    );



    private final String name;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModEarthMaterial(String name, int enchantability, SoundEvent sound, float toughness, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.enchantmentValue = enchantability;
        this.sound = sound;
        this.toughness = toughness;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }


    @Override
    public int getDurabilityForType(Type type) {
        return 0;
    }

    @Override
    public int getDefenseForType(Type type) {

        switch (type.getSlot()){
            case HEAD:
                return 4;
            case FEET:
                return 2;
            default:
                return 5;
        }

    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

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
