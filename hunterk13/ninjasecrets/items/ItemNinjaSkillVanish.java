package ninjasecrets.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import ninjasecrets.NinjaSecrets;

public class ItemNinjaSkillVanish extends ItemNinjaSkillBase {
	
	public ItemNinjaSkillVanish(int id) {
		super(id);
		setCreativeTab(NinjaSecrets.ninTab);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.VanishUnlocal);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player) {
		world.createExplosion(player, player.posX, player.posY, player.posZ, 0, false);
		player.addPotionEffect(new PotionEffect(14, 70, 255, true));
		player.addPotionEffect(new PotionEffect(18, 70, 127, true));
		player.hurtResistantTime = 70;
		if (player.getCurrentEquippedItem().itemID == 261 && player.isUsingItem()) {
			player.dropOneItem(true);
		}
		par1ItemStack.stackSize--;
		return par1ItemStack;
	}
}