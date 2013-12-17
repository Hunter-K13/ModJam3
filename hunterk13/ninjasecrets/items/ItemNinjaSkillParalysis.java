package ninjasecrets.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import ninjasecrets.NinjaSecrets;

public class ItemNinjaSkillParalysis extends ItemNinjaSkillBase {

	public ItemNinjaSkillParalysis(int par1) {
		super(par1);
		setCreativeTab(NinjaSecrets.ninTab);
		setMaxStackSize(16);
		//setUnlocalizedName(ItemInfo.ParalyzeUnlocal);
	}
	
	public boolean itemInteractionForEntity(ItemStack item, EntityPlayer player, EntityLivingBase target) {
		if(!target.worldObj.isRemote) {
			target.addPotionEffect(new PotionEffect(2, 50, 20, true));
			item.stackSize--;
		}
		return false;
	}
	
}
