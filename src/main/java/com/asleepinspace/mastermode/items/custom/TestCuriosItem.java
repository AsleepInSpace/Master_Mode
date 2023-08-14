package com.asleepinspace.mastermode.items.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.Objects;

public class TestCuriosItem extends Item implements ICurioItem {

    public TestCuriosItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
        Player player = (Player) livingEntity;
        if (!player.level.isClientSide) {
            boolean hasFireResistance =
                    !Objects.equals(player.getEffect(MobEffects.FIRE_RESISTANCE), null);

            if (!hasFireResistance){
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,200));
            }
        }

        ICurioItem.super.curioTick(identifier, index, livingEntity, stack);
    }
}
