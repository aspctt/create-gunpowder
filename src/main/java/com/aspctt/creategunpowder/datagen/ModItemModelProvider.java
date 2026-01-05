package com.aspctt.creategunpowder.datagen;

import com.aspctt.creategunpowder.CreateGunpowder;
import com.aspctt.creategunpowder.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateGunpowder.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.FLINT_SHARD.get());
        basicItem(ModItems.CARBON_DUST.get());
        basicItem(ModItems.VOLATILE_POWDER.get());
        basicItem(ModItems.MINERAL_DUST.get());
    }
}
