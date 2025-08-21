package media.arc;

import media.arc.index.AfflictBlocks;
import media.arc.index.AfflictItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Afflict implements ModInitializer {
	public static final String MOD_ID = "afflict";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		AfflictItems.initialize();
		AfflictBlocks.initialize();


		LOGGER.info("A F F L I C T .");
	}
}