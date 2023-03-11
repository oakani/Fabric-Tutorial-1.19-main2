package net.bluefish.tutorialmod.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.bluefish.tutorialmod.block.ModBlocks;

public class ModStrippableBlocks {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.DOGWOOD_LOG, ModBlocks.STRIPPED_DOGWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.DOGWOOD_WOOD, ModBlocks.STRIPPED_DOGWOOD_WOOD);
    }
}
