package com.aspctt.creategunpowder.item;

import com.aspctt.creategunpowder.CreateGunpowder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "creategunpowder" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateGunpowder.MOD_ID);

    // Create a creative tab with the id "creategunpowder:main_tab"
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATE_GUNPOWDER_ITEMS_TAB = CREATIVE_MODE_TABS.register("main_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.creategunpowder_main"))
            .icon(() -> ModItems.FLINT_SHARD.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                // Add items to the tab. For your own tabs, this method is preferred over the event
                output.accept(Items.GUNPOWDER);
                output.accept(ModItems.FLINT_SHARD.get());
                output.accept(ModItems.CARBON_DUST.get());
                output.accept(ModItems.VOLATILE_POWDER.get());
                output.accept(ModItems.MINERAL_DUST.get());
            })
            .build());

    // Register the Deferred Register to the mod event bus so tabs get registered
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
