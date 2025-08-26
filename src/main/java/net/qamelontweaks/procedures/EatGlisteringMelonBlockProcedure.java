package net.qamelontweaks.procedures;

import net.qamelontweaks.init.QaBetterMelonModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class EatGlisteringMelonBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double hunger = 0;
		double saturation = 0;
		double theory_sat = 0;
		hunger = entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0;
		saturation = entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.INSTANT_HEALTH, 0, 0));
		if (blockstate.getBlock() == QaBetterMelonModBlocks.GLISTERING_MELON_BLOCK.get()) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = QaBetterMelonModBlocks.GLISTERING_MELON_BLOCK_1.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (blockstate.getBlock() == QaBetterMelonModBlocks.GLISTERING_MELON_BLOCK_1.get()) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = QaBetterMelonModBlocks.GLISTERING_MELON_BLOCK_HALF.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (blockstate.getBlock() == QaBetterMelonModBlocks.GLISTERING_MELON_BLOCK_HALF.get()) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = QaBetterMelonModBlocks.GLISTERING_MELON_BLOCK_QUARTER.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (blockstate.getBlock() == QaBetterMelonModBlocks.GLISTERING_MELON_BLOCK_QUARTER.get()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
		theory_sat = saturation + 4.5;
		if (theory_sat > 20) {
			theory_sat = 20;
		}
		if (hunger > 13.2) {
			if (entity instanceof Player _player)
				_player.getFoodData().setFoodLevel(20);
		} else {
			if (entity instanceof Player _player)
				_player.getFoodData().setFoodLevel((int) (hunger + 6.8));
		}
		hunger = entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0;
		if (hunger >= theory_sat) {
			if (entity instanceof Player _player)
				_player.getFoodData().setSaturation((float) theory_sat);
		} else {
			if (entity instanceof Player _player)
				_player.getFoodData().setSaturation((float) hunger);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.player.burp")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.player.burp")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
	}
}