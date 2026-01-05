package com.aspctt.creategunpowder.datagen;

import com.aspctt.creategunpowder.recipe.ModMillingRecipeGen;
import com.aspctt.creategunpowder.recipe.ModMixingRecipeGen;
import com.aspctt.creategunpowder.recipe.ModPressingRecipeGen;
import com.simibubi.create.api.data.recipe.ProcessingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModCreateRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModCreateRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {}

    static final List<ProcessingRecipeGen<?, ?, ?>> GENERATORS = new ArrayList<>();
    //static final int BUCKET = FluidType.BUCKET_VOLUME;
    //static final int BOTTLE = 250;

    public static void registerAllProcessing(DataGenerator generator, PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        GENERATORS.add(new ModMillingRecipeGen(packOutput, registries));
        GENERATORS.add(new ModMixingRecipeGen(packOutput, registries));
        GENERATORS.add(new ModPressingRecipeGen(packOutput, registries));

        generator.addProvider(true, new DataProvider() {

            @Override
            public String getName() {
                return "Create: Gunpowder's Processing Recipes";
            }

            @Override
            public CompletableFuture<?> run(CachedOutput dc) {
                return CompletableFuture.allOf(GENERATORS.stream()
                        .map(generator -> generator.run(dc))
                        .toArray(CompletableFuture[]::new));
            }
        });
    }
}
