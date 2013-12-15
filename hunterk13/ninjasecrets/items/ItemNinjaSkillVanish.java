package ninjasecrets.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ninjasecrets.NinjaSecrets;

public class ItemNinjaSkillVanish extends ItemNinjaSkillBase {

	public ItemNinjaSkillVanish(int id) {
		super(id);
		setCreativeTab(NinjaSecrets.ninTab);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.VanishUnlocal);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player) {
		player.worldObj.spawnParticle("slime", player.posX, player.posY, player.posZ, 0, 0 , 0);
		return par1ItemStack;
	}
	
}