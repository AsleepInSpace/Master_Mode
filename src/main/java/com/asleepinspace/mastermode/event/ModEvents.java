package com.asleepinspace.mastermode.event;

import com.asleepinspace.mastermode.gamerules.ModGamerules;
import com.asleepinspace.mastermode.mixin.CreeperMixin;
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

    public static void setHardmodeAttributes(//AttributeInstance Max_health, AttributeInstance Max_speed,
                                             //AttributeInstance Knockback_resistance, AttributeInstance Max_damage,
                                             LivingEvent event, int HardmodeLevel) {
        AttributeInstance Max_health = event.getEntity().getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance Max_speed = event.getEntity().getAttribute(Attributes.MOVEMENT_SPEED);
        AttributeInstance Knockback_resistance = event.getEntity().getAttribute(Attributes.KNOCKBACK_RESISTANCE);
        AttributeInstance Max_damage = event.getEntity().getAttribute(Attributes.ATTACK_DAMAGE);

        if (HardmodeLevel == 1) {
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

    public static void removeHardmodeAttributes (LivingEvent event, int HardmodeLevel) {


        if (HardmodeLevel==1) {
            event.getEntity().getAttribute(Attributes.MAX_HEALTH).removeModifier(HEALTH_BONUS_2);
            event.getEntity().getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(SPEED_BONUS_2);
            event.getEntity().getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(KNOCKBACK_BONUS_2);
            event.getEntity().getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(DAMAGE_BONUS_2);
        }
        if (HardmodeLevel==2) {
            event.getEntity().getAttribute(Attributes.MAX_HEALTH).removeModifier(HEALTH_BONUS);
            event.getEntity().getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(SPEED_BONUS);
            event.getEntity().getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(KNOCKBACK_BONUS);
            event.getEntity().getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(DAMAGE_BONUS);
        }

    }

   // @SubscribeEvent
   // public static void LivingJoins (LivingSpawnEvent.SpecialSpawn event) {
       // if (event.getEntity() instanceof Monster) {
         //   int hardmode_lvl = event.getEntity().level.getGameRules().getInt(ModGamerules.ATTRIBUTE_LEVELS);
          //  event.getEntity().getPersistentData().putInt("Hardmode_Level", hardmode_lvl);

          //  if (hardmode_lvl == 1) {
           //     if (event.getEntity() instanceof Creeper) {
            //        ((CreeperMixin) event.getEntity()).setExplosionRadius(4);
            //    }
            //    setHardmodeAttributes(//Max_health, Max_speed, Knockback_resistance, Max_damage,
                  //       event,1);
         //   }
          //  else if (hardmode_lvl == 2) {
             //   if (event.getEntity() instanceof Creeper) {
               //     ((CreeperMixin) event.getEntity()).setExplosionRadius(6);
               //     setHardmodeAttributes(//Max_health, Max_speed, Knockback_resistance, Max_damage,
                 //            event, 2);
              //  }
         //   }
     //   }
 //   }


    //When the tick event runs and there is no persistent data for hardmode level, you can add the attributes and modify the persistent data in exactly the same way as you are doing now and it will work just fine
    @SubscribeEvent
    public static void EntityTick (LivingEvent.LivingTickEvent event) {
        int hardmode_lvl = event.getEntity().level.getGameRules().getInt(ModGamerules.ATTRIBUTE_LEVELS);
        if(event.getEntity() instanceof Monster && !event.getEntity().getPersistentData().contains("Hardmode_Level") && !event.getEntity().level.isClientSide)
        {
            event.getEntity().getPersistentData().putInt("Hardmode_Level", hardmode_lvl);

            if (hardmode_lvl == 1) {
                if (event.getEntity() instanceof Creeper) {
                    ((CreeperMixin) event.getEntity()).setExplosionRadius(4);
                }
                setHardmodeAttributes(//Max_health, Max_speed, Knockback_resistance, Max_damage,
                        event,1);
            }
            else if (hardmode_lvl == 2) {
                if (event.getEntity() instanceof Creeper) {
                    ((CreeperMixin) event.getEntity()).setExplosionRadius(6);
                    setHardmodeAttributes(//Max_health, Max_speed, Knockback_resistance, Max_damage,
                            event, 2);
                }
            }

        } else if ((event.getEntity() instanceof Monster &&
                event.getEntity().getPersistentData().getInt("Hardmode_Level")
                        != event.getEntity().level.getGameRules().getInt(ModGamerules.ATTRIBUTE_LEVELS) && !event.getEntity().level.isClientSide)) {
            removeHardmodeAttributes(event,hardmode_lvl);
            setHardmodeAttributes(event,hardmode_lvl);
            event.getEntity().getPersistentData().putInt("Hardmode_Level",
                    event.getEntity().level.getGameRules().getInt(ModGamerules.ATTRIBUTE_LEVELS));

        }
    }
}
