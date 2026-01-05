package com.aspctt.creategunpowder.recipe;

import com.aspctt.creategunpowder.CreateGunpowder;
import com.aspctt.creategunpowder.item.ModItems;
import com.aspctt.creategunpowder.utility.ModTags;
import com.simibubi.create.AllFluids;
import com.simibubi.create.api.data.recipe.MillingRecipeGen;
import com.simibubi.create.api.data.recipe.MixingRecipeGen;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class ModMixingRecipeGen extends MixingRecipeGen {
    public ModMixingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateGunpowder.MOD_ID);
    }

    GeneratedRecipe
            VOLATILE_POWDER = create("volatile_powder_from_mixing", b -> b.require(ModItems.FLINT_SHARD.get())
                    .require(ModItems.CARBON_DUST.get())
                    .output(ModItems.VOLATILE_POWDER.get(), 1)
                    .requiresHeat(HeatCondition.NONE)),

    GUNPOWDER_BASIC = create("gunpowder_from_mixing", b -> b.require(ModItems.VOLATILE_POWDER.get())
            .require(ModItems.MINERAL_DUST.get())
            .output(Items.GUNPOWDER, 1)
            .requiresHeat(HeatCondition.NONE)),

    GUNPOWDER_HEATED = create("gunpowder_from_mixing_heated", b -> b.require(ModItems.VOLATILE_POWDER.get())
            .require(ModItems.MINERAL_DUST.get())
            .require(Fluids.WATER, 250)
            .output(Items.GUNPOWDER, 2)
            .requiresHeat(HeatCondition.HEATED)),

    GUNPOWDER_SUPERHEATED = create("gunpowder_from_mixing_superheated", b -> b.require(ModItems.VOLATILE_POWDER.get())
            .require(ModItems.MINERAL_DUST.get())
            .require(ModItems.MINERAL_DUST.get())
            .require(Fluids.WATER, 500)
            .output(Items.GUNPOWDER, 3)
            .requiresHeat(HeatCondition.SUPERHEATED));
}
