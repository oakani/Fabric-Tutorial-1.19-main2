package net.bluefish.tutorialmod;

import net.bluefish.tutorialmod.block.ModBlocks;
import net.bluefish.tutorialmod.entity.ModEntities;
import net.bluefish.tutorialmod.entity.custom.ChomperEntity;
import net.bluefish.tutorialmod.event.AttackEntityHandler;
import net.bluefish.tutorialmod.event.PlayerTickHandler;
import net.bluefish.tutorialmod.item.ModItemGroup;
import net.bluefish.tutorialmod.item.ModItems;
import net.bluefish.tutorialmod.painting.ModPaintings;
import net.bluefish.tutorialmod.recipe.ModRecipes;
import net.bluefish.tutorialmod.screen.ModScreenHandlers;
import net.bluefish.tutorialmod.util.ModFlammableBlocks;
import net.bluefish.tutorialmod.util.ModLootTableModifiers;
import net.bluefish.tutorialmod.util.ModStrippableBlocks;
import net.bluefish.tutorialmod.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.bluefish.tutorialmod.block.entity.ModBlockEntities;
import net.bluefish.tutorialmod.fluid.ModFluids;
import net.bluefish.tutorialmod.networking.ModMessages;
import net.bluefish.tutorialmod.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

// Very important comment

//very important comment #2
public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {







		ModItemGroup.registerItemGroup();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModPaintings.registerPaintings();
		ModWorldGen.generateWorldGen();

		ModLootTableModifiers.modifyLootTables();
		ModMessages.registerC2SPackets();

		ModFluids.register();
		ModBlockEntities.registerBlockEntities();

		ModScreenHandlers.registerAllScreenHandlers();
		ModRecipes.registerRecipes();

		ModFlammableBlocks.registerFlammableBlocks();
		ModStrippableBlocks.registerStrippables();

		GeckoLib.initialize();

		FabricDefaultAttributeRegistry.register(ModEntities.CHOMPER, ChomperEntity.setAttributes());
		// VillageAdditions.registerNewVillageStructures();

		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
		AttackEntityCallback.EVENT.register(new AttackEntityHandler());
	}
}
