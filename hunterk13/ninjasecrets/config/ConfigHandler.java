package ninjasecrets.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import ninjasecrets.items.ItemInfo;

public class ConfigHandler {

	public static void init(File file) {

		Configuration config = new Configuration(file);
		config.load();
		
		ItemInfo.SuspendID = config.getItem(ItemInfo.SuspendKey, ItemInfo.SuspendDefault).getInt() - 256;
		ItemInfo.VanishID = config.getItem(ItemInfo.VanishKey, ItemInfo.VanishDefault).getInt() - 256;
		
		config.save();
	}
	
}
