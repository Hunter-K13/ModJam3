package ninjasecrets.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import ninjasecrets.NinjaSecrets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNinjaSkillBase extends Item{

	public ItemNinjaSkillBase(int par1) {
		super(par1);
		setCreativeTab(NinjaSecrets.ninTab);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.BaseUnlocal);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TextureLocation + ":" + ItemInfo.SkillIcon);
	}

}
