package com.aspctt.creategunpowder.recipe;

import com.aspctt.creategunpowder.CreateGunpowder;
import com.aspctt.creategunpowder.item.ModItems;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.MillingRecipeGen;
import com.simibubi.create.api.data.recipe.PressingRecipeGen;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModPressingRecipeGen extends PressingRecipeGen {
    public ModPressingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateGunpowder.MOD_ID);
    }

    GeneratedRecipe
            FLINT_SHARD = create("flint_shard_from_pressing", b -> b.require(Items.FLINT)
            .output(ModItems.FLINT_SHARD.get()));
}
