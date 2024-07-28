package com.natamus.icepreventscropgrowth;

import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import com.natamus.collective.fabric.callbacks.CollectiveCropEvents;
import com.natamus.icepreventscropgrowth.events.CropEvent;
import com.natamus.icepreventscropgrowth.util.Reference;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		CollectiveCropEvents.PRE_CROP_GROW.register((Level world, BlockPos pos, BlockState state) -> {
			return CropEvent.onCropGrowth(world, pos, state);
		});
	}

	private static void setGlobalConstants() {

	}
}
