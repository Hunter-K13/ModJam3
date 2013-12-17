package ninjasecrets.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static Item base;
	public static Item suspend;
	public static Item vanish;
	public static Item ghost;
	public static Item paralyze;
	public static Item dagger;
	
	public static void init() {
		base = new ItemNinjaSkillBase(ItemInfo.BaseID);
		suspend = new ItemNinjaSkillSuspension(ItemInfo.SuspendID);
		vanish = new ItemNinjaSkillVanish(ItemInfo.VanishID);
		ghost = new ItemNinjaSkillGhost(ItemInfo.GhostID);
		//paralyze = new ItemNinjaSkillParalysis(ItemInfo.PararlyzeID);
		dagger = new ItemNinjaDagger(ItemInfo.DaggerID);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(base, ItemInfo.BaseName);
		LanguageRegistry.addName(suspend, ItemInfo.SuspendName);
		LanguageRegistry.addName(vanish, ItemInfo.VanishName);
		LanguageRegistry.addName(ghost, ItemInfo.GhostName);
		//LanguageRegistry.addName(paralyze, ItemInfo.ParalyzeName);
		LanguageRegistry.addName(dagger, ItemInfo.DaggerName);
	}
	
	public static void registerRecipes() {
		GameRegistry.addRecipe(new ItemStack(base),
			new Object[] {	"XXX",
							"XOX",
							"XXX",
							
							'X', Item.dyePowder,
							'O', Item.enderPearl
						});
		GameRegistry.addRecipe(new ItemStack(suspend),
				new Object[] {	"XYX",
								"XOX",
								"XXX",
								
								'Y', Item.appleGold,
								'X', Item.fermentedSpiderEye,
								'O', base
							});
		GameRegistry.addRecipe(new ItemStack(vanish),
				new Object[] {	"XXX",
								"XOX",
								"XXX",
								
								'X', Item.gunpowder,
								'O', base
							});
		GameRegistry.addRecipe(new ItemStack(ghost),
				new Object[] {	" Y ",
								" O ",
								"   ",
								
								'Y', Item.diamond,
								'O', vanish
							});
		/*GameRegistry.addRecipe(new ItemStack(paralyze, 4),
				new Object[] {	"YYY",
								"YOY",
								"YYY",
								
								'Y', Item.rottenFlesh,
								'O', base
							});*/
		GameRegistry.addRecipe(new ItemStack(dagger),
				new Object[] {	"XXX",
								"XOX",
								"XXX",
								
								'X', base,
								'O', Item.swordDiamond
							});
	}
}
