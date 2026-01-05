package com.aspctt.creategunpowder.utility;

import com.aspctt.creategunpowder.CreateGunpowder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> PLACEHOLDER = createTag("placeholder");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CreateGunpowder.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MINERAL_RICH_BLOCKS = createTag("mineral_rich_blocks");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CreateGunpowder.MOD_ID, name));
        }
    }
}
