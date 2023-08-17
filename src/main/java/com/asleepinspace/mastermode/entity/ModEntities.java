package com.asleepinspace.mastermode.entity;

import com.asleepinspace.mastermode.Mastermode;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Mastermode.MOD_ID);

    public static final RegistryObject<EntityType<>>





    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
