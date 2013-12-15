package ninjasecrets.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class Items {
	
	public static final String TextureLocation = "ninjasecrets";

	public static Item base;
	public static Item suspension;
	public static Item vanish;

	public static final String SkillIcon = "skill";
	
	public static int SuspensionID;
	public static final String SuspensionKey = "Suspension";
	public static final int SuspensionDefault = 20131;
	
	public static int VanishID;
	public static final String VanishKey = "Vanish";
	public static final int VanishDefault = 20132;
	
	public static void init() {
		suspension = new ItemNinjaSkillSuspension(SuspensionID);
		vanish = new ItemNinjaSkillVanish(VanishID);
		base = new ItemNinjaSkillBase(-1);
	}
}
