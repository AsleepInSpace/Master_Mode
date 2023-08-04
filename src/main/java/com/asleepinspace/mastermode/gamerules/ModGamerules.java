package com.asleepinspace.mastermode.gamerules;

import net.minecraft.world.level.GameRules;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModGamerules {

    public static final GameRules.Key<GameRules.IntegerValue> ATTRIBUTE_LEVELS =
            GameRules.register("HardmodeLevel", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(2));



}
