package com.natamus.icepreventscropgrowth.neoforge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.natamus.icepreventscropgrowth.events.CropEvent;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.block.CropGrowEvent;

@EventBusSubscriber
public class NeoForgeCropEvent {
	@SubscribeEvent
	public static void onCropGrow(CropGrowEvent.Pre e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}
		
		if (!CropEvent.onCropGrowth(level, e.getPos(), e.getState())) {
			e.setResult(CropGrowEvent.Pre.Result.DO_NOT_GROW);
		}
	}
}
