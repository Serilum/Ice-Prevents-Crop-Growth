package com.natamus.icepreventscropgrowth.neoforge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.natamus.icepreventscropgrowth.events.CropEvent;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.level.BlockEvent.CropGrowEvent;
import net.neoforged.bus.api.Event.Result;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeCropEvent {
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
