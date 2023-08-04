package com.asleepinspace.mastermode.event;

import com.asleepinspace.mastermode.gamerules.ModGamerules;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

import static com.asleepinspace.mastermode.util.values.AttributeValues.*;


@Mod.EventBusSubscriber
public class ModEvents {


    @SubscribeEvent
    public static void LivingJoins (LivingSpawnEvent.SpecialSpawn event) {
        if (event.getEntity() instanceof Monster && event.getEntity().level.getGameRules().getInt(ModGamerules.ATTRIBUTE_LEVELS) == 2) {
            AttributeInstance Max_health = event.getEntity().getAttribute(Attributes.MAX_HEALTH);
            AttributeInstance Max_speed = event.getEntity().getAttribute(Attributes.MOVEMENT_SPEED);
            AttributeInstance Knockback_resistance = event.getEntity().getAttribute(Attributes.KNOCKBACK_RESISTANCE);
            AttributeInstance Max_damage = event.getEntity().getAttribute(Attributes.ATTACK_DAMAGE);
            Max_damage.addPermanentModifier(DAMAGE_BONUS);
            Knockback_resistance.addPermanentModifier(KNOCKBACK_BONUS);
            Max_health.addPermanentModifier(HEALTH_BONUS);
            Max_speed.addPermanentModifier(SPEED_BONUS);

            event.getEntity().setHealth(event.getEntity().getMaxHealth());
        }


    }


}
