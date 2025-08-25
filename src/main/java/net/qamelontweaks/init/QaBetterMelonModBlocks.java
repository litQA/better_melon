/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.qamelontweaks.init;

import net.qamelontweaks.block.MelonBlockQuarterBlock;
import net.qamelontweaks.block.MelonBlockHalfBlock;
import net.qamelontweaks.block.MelonBlock1Block;
import net.qamelontweaks.block.GlisteringMelonBlockQuarterBlock;
import net.qamelontweaks.block.GlisteringMelonBlockHalfBlock;
import net.qamelontweaks.block.GlisteringMelonBlockBlock;
import net.qamelontweaks.block.GlisteringMelonBlock1Block;
import net.qamelontweaks.QaBetterMelonMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class QaBetterMelonModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(QaBetterMelonMod.MODID);
	public static final DeferredBlock<Block> GLISTERING_MELON_BLOCK = register("glistering_melon_block", GlisteringMelonBlockBlock::new);
	public static final DeferredBlock<Block> MELON_BLOCK_1 = register("melon_block_1", MelonBlock1Block::new);
	public static final DeferredBlock<Block> MELON_BLOCK_HALF = register("melon_block_half", MelonBlockHalfBlock::new);
	public static final DeferredBlock<Block> MELON_BLOCK_QUARTER = register("melon_block_quarter", MelonBlockQuarterBlock::new);
	public static final DeferredBlock<Block> GLISTERING_MELON_BLOCK_1 = register("glistering_melon_block_1", GlisteringMelonBlock1Block::new);
	public static final DeferredBlock<Block> GLISTERING_MELON_BLOCK_HALF = register("glistering_melon_block_half", GlisteringMelonBlockHalfBlock::new);
	public static final DeferredBlock<Block> GLISTERING_MELON_BLOCK_QUARTER = register("glistering_melon_block_quarter", GlisteringMelonBlockQuarterBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}