package ninjasecrets.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class Items {
	
	public static final String TextureLocation = "ninjasecrets";
	
	//public static Item[] items; 
	public static Item suspension/* = items[0]*/;
	
	//for(int i = 0; i < items.length; i++) {
		
	//}
	
	public static int SuspensionID;
	public static final String SuspensionKey = "Suspension";
	public static final int SuspensionDefault = 20131;
	public static final String SuspensionUnlocalized = "suspension";
	public static final String SuspensionName = "Ninja Suspension";
	public static final String SuspensionIcon = "suspension";
	
	public static void init() {
		suspension = new ItemNinjaSkillSuspension(SuspensionID);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(suspension, SuspensionName);
	}
}
