package com.asleepinspace.mastermode.items;

import com.asleepinspace.mastermode.Mastermode;
import com.asleepinspace.mastermode.items.custom.TestCuriosItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SimpleFoiledItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Mastermode.MOD_ID);

    public static final RegistryObject<Item> FIRECROWN = ITEMS.register("firecrown",
            () -> new TestCuriosItem(new Item.Properties().fireResistant().tab(ModCreativeModeTab.MASTERMODE_TAB).stacksTo(1)));

    public static final RegistryObject<Item> LACED_GUNPOWDER = ITEMS.register("laced_gunpowder",
            ()-> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON).tab(ModCreativeModeTab.MASTERMODE_TAB)));











    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
