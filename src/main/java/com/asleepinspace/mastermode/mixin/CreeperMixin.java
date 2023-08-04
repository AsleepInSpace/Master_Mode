package com.asleepinspace.mastermode.mixin;



import net.minecraft.world.entity.monster.Creeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;



@Mixin(Creeper.class)
public class CreeperMixin {


    @ModifyArg( method = "explodeCreeper()V", at = @At(value = "INVOKE",
    target = "Lnet/minecraft/world/level/Level;explode(Lnet/minecraft/world/entity/Entity;DDDFLnet/minecraft/world/level/Explosion$BlockInteraction;)Lnet/minecraft/world/level/Explosion;" ),
    index = 4)
    public float ExplosionRadius( float F) {
        return F*2;

    }

}
