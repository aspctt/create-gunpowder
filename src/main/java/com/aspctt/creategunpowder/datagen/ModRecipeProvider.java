package com.aspctt.creategunpowder.datagen;

import com.aspctt.creategunpowder.CreateGunpowder;
import com.aspctt.creategunpowder.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        List<ItemLike> SAND_SMELTABLES = List.of(Items.SANDSTONE);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FLINT_SHARD.get(), 9)
                .requires(Items.FLINT)
                .unlockedBy("has_coal", has(Items.FLINT))
                .save(recipeOutput, "creategunpowder:flint_shard_from_flint");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CARBON_DUST.get(), 9)
                .requires(Items.COAL)
                .unlockedBy("has_coal", has(Items.COAL))
                .save(recipeOutput, "creategunpowder:carbon_dust_from_coal");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MINERAL_DUST.get(), 9)
                .requires(Items.SAND)
                .unlockedBy("has_coal", has(Items.SAND))
                .save(recipeOutput, "creategunpowder:mineral_dust_from_sand");


        oreSmelting(recipeOutput, SAND_SMELTABLES, RecipeCategory.MISC, ModItems.MINERAL_DUST.get(), 0.25f, 200, "mineral_dust");
        oreBlasting(recipeOutput, SAND_SMELTABLES, RecipeCategory.MISC, ModItems.MINERAL_DUST.get(), 0.25f, 100, "mineral_dust");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, CreateGunpowder.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
