package com.aspctt.creategunpowder.item;

import com.aspctt.creategunpowder.CreateGunpowder;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // Create a Deferred Register to hold Items which will all be registered under the "creategunpowder" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateGunpowder.MOD_ID);

    // Create our items
    public static final DeferredItem<Item> FLINT_SHARD = ITEMS.registerSimpleItem("flint_shard");
    public static final DeferredItem<Item> CARBON_DUST = ITEMS.registerSimpleItem("carbon_dust");
    public static final DeferredItem<Item> VOLATILE_POWDER = ITEMS.registerSimpleItem("volatile_powder");
    public static final DeferredItem<Item> MINERAL_DUST = ITEMS.registerSimpleItem("mineral_dust");

    // Register the Deferred Register to the mod event bus so items get registered
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
