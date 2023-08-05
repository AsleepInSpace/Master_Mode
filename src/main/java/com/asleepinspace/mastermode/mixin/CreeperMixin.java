package com.asleepinspace.mastermode.mixin;



import net.minecraft.world.entity.monster.Creeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;



@Mixin(Creeper.class)
public interface CreeperMixin {
    @Accessor("explosionRadius")
    public void setExplosionRadius(int explosionRadius);






}
