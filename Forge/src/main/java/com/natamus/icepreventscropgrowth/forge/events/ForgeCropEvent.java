package com.natamus.icepreventscropgrowth.forge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.natamus.icepreventscropgrowth.events.CropEvent;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.Result;
import net.minecraftforge.event.level.BlockEvent.CropGrowEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

public class ForgeCropEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeCropEvent.class);

		CropGrowEvent.Pre.BUS.addListener(ForgeCropEvent::mobItemDrop);
	}

	@SubscribeEvent
	public static void mobItemDrop(CropGrowEvent.Pre e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}
		
		if (!CropEvent.onCropGrowth(level, e.getPos(), e.getState())) {
			e.setResult(Result.DENY);
		}
	}
}
