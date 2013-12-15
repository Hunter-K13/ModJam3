package ninjasecrets.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static Item suspend;
	public static Item vanish;
	
	public static void init() {
		suspend = new ItemNinjaSkillSuspension(ItemInfo.SuspendID);
		vanish = new ItemNinjaSkillVanish(ItemInfo.VanishID);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(suspend, ItemInfo.SuspendName);
		LanguageRegistry.addName(vanish, ItemInfo.VanishName);
	}
}
