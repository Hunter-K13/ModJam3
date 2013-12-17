package ninjasecrets.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import ninjasecrets.items.ItemInfo;

public class ConfigHandler {

	public static void init(File file) {

		Configuration config = new Configuration(file);
		config.load();
		
		ItemInfo.BaseID = config.getItem(ItemInfo.BaseKey, ItemInfo.BaseDefault).getInt() - 256;
		ItemInfo.SuspendID = config.getItem(ItemInfo.SuspendKey, ItemInfo.SuspendDefault).getInt() - 256;
		ItemInfo.VanishID = config.getItem(ItemInfo.VanishKey, ItemInfo.VanishDefault).getInt() - 256;
		ItemInfo.GhostID = config.getItem(ItemInfo.GhostKey, ItemInfo.GhostDefault).getInt() - 256;
		//ItemInfo.PararlyzeID = config.getItem(ItemInfo.ParalyzeKey, ItemInfo.ParalysisDefault).getInt() - 256;
		ItemInfo.DaggerID = config.getItem(ItemInfo.DaggerKey, ItemInfo.DaggerDefault).getInt() - 256;
		
		config.save();
	}
	
}
