package com.aspctt.creategunpowder.recipe;

import com.aspctt.creategunpowder.CreateGunpowder;
import com.simibubi.create.api.data.recipe.CrushingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

// Create's own millstone recipes for coal, charcoal and sandstone are switched off in
// data/create/recipe/milling, because they took the same items as the Carbon Dust and
// Mineral Dust milling recipes and the millstone picked between them at random. Their
// outputs and timings are carried over here unchanged, so crushing wheels, which check
// crushing recipes before milling ones, keep giving dye and sand.
public class ModCrushingRecipeGen extends CrushingRecipeGen {
    public ModCrushingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateGunpowder.MOD_ID);
    }

    GeneratedRecipe
            BLACK_DYE_FROM_COAL = create("black_dye_from_coal", b -> b.duration(100)
            .require(Items.COAL)
            .output(Items.BLACK_DYE, 2)
            .output(0.1f, Items.GRAY_DYE, 1)),

    BLACK_DYE_FROM_CHARCOAL = create("black_dye_from_charcoal", b -> b.duration(100)
            .require(Items.CHARCOAL)
            .output(Items.BLACK_DYE, 1)
            .output(0.1f, Items.GRAY_DYE, 2)),

    SAND_FROM_SANDSTONE = create("sand_from_sandstone", b -> b.duration(150)
            .require(Items.SANDSTONE)
            .output(Items.SAND, 1));
}
