package com.aspctt.creategunpowder.recipe;

import com.aspctt.creategunpowder.CreateGunpowder;
import com.aspctt.creategunpowder.item.ModItems;
import com.aspctt.creategunpowder.utility.ModTags;
import com.simibubi.create.api.data.recipe.MillingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModMillingRecipeGen extends MillingRecipeGen {
    public ModMillingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateGunpowder.MOD_ID);
    }

    GeneratedRecipe
            CARBON_DUST = create("carbon_dust_from_milling", b -> b.duration(50)
            .require(ItemTags.COALS)
            .output(ModItems.CARBON_DUST.get(),2)),

    MINERAL_DUST = create("mineral_dust_from_milling", b -> b.duration(50)
            .require(ModTags.Items.MINERAL_RICH_BLOCKS)
            .output(ModItems.MINERAL_DUST.get(), 2));
}
