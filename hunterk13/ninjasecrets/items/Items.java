package ninjasecrets.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class Items {
	
	public static final String TextureLocation = "ninjasecrets";

	public static Item base;
	public static Item suspension;
	public static Item vanish;
	
	public static int SuspensionID;
	public static final String SuspensionKey = "Suspension";
	public static final int SuspensionDefault = 20131;
	public static final String SuspensionUnlocalized = "suspension";
	public static final String SuspensionName = "Ninja Suspension";
	public static final String SuspensionIcon = "suspension";
	
	public static int VanishID;
	public static final String VanishKey = "Vanish";
	public static final int VanishDefault = 20132;
	public static final String VanishUnlocalized = "vanish";
	public static final String VanishName = "Ninja Vanish";
	
	public static void init() {
		suspension = new ItemNinjaSkillSuspension(SuspensionID);
		vanish = new ItemNinjaSkillVanish(VanishID);
		base = new ItemNinjaSkillBase(-1);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(suspension, SuspensionName);
		LanguageRegistry.addName(vanish, VanishName);
	}
}
