package com.asleepinspace.mastermode.event;

import com.asleepinspace.mastermode.gamerules.ModGamerules;
import com.asleepinspace.mastermode.mixin.CreeperMixin;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


import static com.asleepinspace.mastermode.util.values.AttributeValues.*;


@Mod.EventBusSubscriber
public class ModEvents  {

    public static void setHardmodeAttributes(LivingEvent event, int HardmodeLevel) {
        AttributeInstance Max_health = event.getEntity().getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance Max_speed = event.getEntity().getAttribute(Attributes.MOVEMENT_SPEED);
        AttributeInstance Knockback_resistance = event.getEntity().getAttribute(Attributes.KNOCKBACK_RESISTANCE);
        AttributeInstance Max_damage = event.getEntity().getAttribute(Attributes.ATTACK_DAMAGE);
        if (HardmodeLevel == 0){
            event.getEntity().setHealth(event.getEntity().getMaxHealth());
        }
        else if (HardmodeLevel == 1) {
            Max_health.addPermanentModifier(HEALTH_BONUS);
            Max_speed.addPermanentModifier(SPEED_BONUS);
            Knockback_resistance.addPermanentModifier(KNOCKBACK_BONUS);
            Max_damage.addPermanentModifier(DAMAGE_BONUS);
            event.getEntity().setHealth(event.getEntity().getMaxHealth());
        }
        else if (HardmodeLevel == 2) {
            Max_damage.addPermanentModifier(DAMAGE_BONUS_2);
            Knockback_resistance.addPermanentModifier(KNOCKBACK_BONUS_2);
            Max_health.addPermanentModifier(HEALTH_BONUS_2);
            Max_speed.addPermanentModifier(SPEED_BONUS_2);
            event.getEntity().setHealth(event.getEntity().getMaxHealth());
        }
    }

    public static void removeHardmodeAttributes (LivingEvent event, int oldHardmodeLevel) {
        if (oldHardmodeLevel==1) {
            event.getEntity().getAttribute(Attributes.MAX_HEALTH).removeModifier(HEALTH_BONUS);
            event.getEntity().getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(SPEED_BONUS);
            event.getEntity().getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(KNOCKBACK_BONUS);
            event.getEntity().getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(DAMAGE_BONUS);
        }
        else if (oldHardmodeLevel==2) {
            event.getEntity().getAttribute(Attributes.MAX_HEALTH).removeModifier(HEALTH_BONUS_2);
            event.getEntity().getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(SPEED_BONUS_2);
            event.getEntity().getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(KNOCKBACK_BONUS_2);
            event.getEntity().getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(DAMAGE_BONUS_2);
        }
    }

    @SubscribeEvent
    public static void EntityTick (LivingEvent.LivingTickEvent event) {
        CompoundTag entityHardmodeValue = event.getEntity().getPersistentData();
        int serverHardmodeLvl = event.getEntity().level.getGameRules().getInt(ModGamerules.ATTRIBUTE_LEVELS);
        if(event.getEntity() instanceof Monster && !entityHardmodeValue.contains("Hardmode_Level") && !event.getEntity().level.isClientSide)
        {
            entityHardmodeValue.putInt("Hardmode_Level", serverHardmodeLvl);
            setHardmodeAttributes(event,serverHardmodeLvl);
            if (event.getEntity() instanceof Creeper && serverHardmodeLvl == 0) {
                    ((CreeperMixin) event.getEntity()).setExplosionRadius(3);
            }
            else if (event.getEntity() instanceof Creeper) {
                ((CreeperMixin) event.getEntity()).setExplosionRadius(2*serverHardmodeLvl+2);
            }
        }
        else if ((event.getEntity() instanceof Monster && entityHardmodeValue.getInt("Hardmode_Level") != serverHardmodeLvl && !event.getEntity().level.isClientSide)) {

            removeHardmodeAttributes(event,entityHardmodeValue.getInt("Hardmode_Level"));
            setHardmodeAttributes(event,serverHardmodeLvl);
            event.getEntity().getPersistentData().putInt("Hardmode_Level", serverHardmodeLvl);
            if (event.getEntity() instanceof Creeper && serverHardmodeLvl == 0 ) {
                ((CreeperMixin) event.getEntity()).setExplosionRadius(3);
            }
            else if (event.getEntity() instanceof Creeper) {
                ((CreeperMixin) event.getEntity()).setExplosionRadius(2*serverHardmodeLvl+2);
            }
        }
    }
}
