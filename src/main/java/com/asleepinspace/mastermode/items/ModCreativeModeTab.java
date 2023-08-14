package com.asleepinspace.mastermode.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MASTERMODE_TAB = new CreativeModeTab("Mastermodetab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.LACED_GUNPOWDER.get());
        }
    };
}
