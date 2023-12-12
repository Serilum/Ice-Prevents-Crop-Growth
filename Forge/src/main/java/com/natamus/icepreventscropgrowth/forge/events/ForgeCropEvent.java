package com.natamus.icepreventscropgrowth.forge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.natamus.icepreventscropgrowth.events.CropEvent;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeCropEvent {
	@SubscribeEvent
	public void mobItemDrop(CropGrowEvent.Pre e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getWorld());
		if (level == null) {
			return;
		}
		
		if (!CropEvent.onCropGrowth(level, e.getPos(), e.getState())) {
			e.setResult(Result.DENY);
		}
	}
}
