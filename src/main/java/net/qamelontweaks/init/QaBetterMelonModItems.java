/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.qamelontweaks.init;

import net.qamelontweaks.QaBetterMelonMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import java.util.function.Function;

public class QaBetterMelonModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(QaBetterMelonMod.MODID);
	public static final DeferredItem<Item> GLISTERING_MELON_BLOCK = block(QaBetterMelonModBlocks.GLISTERING_MELON_BLOCK);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}
}