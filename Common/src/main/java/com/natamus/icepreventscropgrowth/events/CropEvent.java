package com.natamus.icepreventscropgrowth.events;

import com.natamus.collective.functions.BlockFunctions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CropEvent {
	private final static List<Block> iceblocks = new ArrayList<Block>(Arrays.asList(Blocks.ICE, Blocks.FROSTED_ICE, Blocks.BLUE_ICE, Blocks.PACKED_ICE));
	
	public static boolean onCropGrowth(Level level, BlockPos pos, BlockState state) {
		if (level.isClientSide) {
			return true;
		}
		
		Block belowblock = level.getBlockState(pos.below(2)).getBlock();
		return !BlockFunctions.isOneOfBlocks(iceblocks, belowblock);
	}
}
