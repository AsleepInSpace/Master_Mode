package com.asleepinspace.mastermode.util.values;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.UUID;

public class AttributeValues {



    public static final UUID HEALTH_BONUS_UUID = UUID.fromString("5a71e2bb-d285-4d03-81fb-3a87c7acccaa");
    public static final AttributeModifier HEALTH_BONUS = new AttributeModifier(HEALTH_BONUS_UUID,
            "Health_bonus", 1.25, AttributeModifier.Operation.MULTIPLY_TOTAL );

    public static final UUID SPEED_BONUS_UUID = UUID.fromString("b1f54ff9-74cf-4e02-9715-0caad9a5cd8b");
    public static final AttributeModifier SPEED_BONUS = new AttributeModifier(SPEED_BONUS_UUID,
            "Speed_bonus", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL );

    public static final UUID KNOCKBACK_BONUS_UUID = UUID.fromString("20c52c6d-edfa-4c2c-bf20-dc240a07748a");
    public static final AttributeModifier KNOCKBACK_BONUS = new AttributeModifier(KNOCKBACK_BONUS_UUID,
            "Knockback_bonus", 1.5, AttributeModifier.Operation.MULTIPLY_TOTAL );

    public static final UUID DAMAGE_BONUS_UUID = UUID.fromString("2e66b648-7821-4699-a5f5-de5465a483b2");
    public static final AttributeModifier DAMAGE_BONUS = new AttributeModifier(DAMAGE_BONUS_UUID,
            "damage boost", 1.5, AttributeModifier.Operation.MULTIPLY_TOTAL);
    //below is the second set

    public static final UUID HEALTH_BONUS_UUID_2 = UUID.fromString("50d6c1b4-ab95-477b-9cec-b52d361526fd");
    public static final AttributeModifier HEALTH_BONUS_2 = new AttributeModifier(HEALTH_BONUS_UUID_2,
            "Health_bonus", 2, AttributeModifier.Operation.MULTIPLY_TOTAL );

    public static final UUID SPEED_BONUS_UUID_2 = UUID.fromString("e157c874-ef50-4aa4-a9e0-199209d92190");
    public static final AttributeModifier SPEED_BONUS_2 = new AttributeModifier(SPEED_BONUS_UUID_2,
            "Speed_bonus", 0.5, AttributeModifier.Operation.MULTIPLY_TOTAL );

    public static final UUID KNOCKBACK_BONUS_UUID_2 = UUID.fromString("0d7e1c3f-d2ac-4c36-92d4-b7d18aeca442");
    public static final AttributeModifier KNOCKBACK_BONUS_2 = new AttributeModifier(KNOCKBACK_BONUS_UUID_2,
            "Knockback_bonus", 2, AttributeModifier.Operation.MULTIPLY_TOTAL );

    public static final UUID DAMAGE_BONUS_UUID_2 = UUID.fromString("d15b632f-20cb-4aa1-bbd7-5c4174671cea");
    public static final AttributeModifier DAMAGE_BONUS_2 = new AttributeModifier(DAMAGE_BONUS_UUID_2,
            "damage boost", 2, AttributeModifier.Operation.MULTIPLY_TOTAL);







}
