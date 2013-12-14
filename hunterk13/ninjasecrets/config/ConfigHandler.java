package ninjasecrets.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import ninjasecrets.items.Items;

public class ConfigHandler {
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		config.load();
		
		Items.SuspensionID = config.getItem(Items.SuspensionKey, Items.SuspensionDefault).getInt() - 256;
		
		config.save();
	}
}
