package ninjasecrets.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemNinjaSkillSuspension extends ItemNinjaSkillBase {

	//private boolean activated = false;
	//private boolean inUse = false;
	
	public ItemNinjaSkillSuspension(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabCombat);
		setMaxStackSize(1);
		setMaxDamage(1800);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if (!par3EntityPlayer.capabilities.isCreativeMode) {
			NBTTagCompound tag = getTagCompound(par1ItemStack);
			/*this.inUse = true;
			if (par1ItemStack.getItemDamage() < 500) {
				System.out.println("2.1");
				this.activated = true;
			}*/
			if (par2World.getTotalWorldTime() - tag.getLong("time") > 10) {
				tag.setInteger("oldFood", -987);
			}
			if (par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage()/* && this.activated == true*/) {
				par3EntityPlayer.addPotionEffect(new PotionEffect(13, 10, 0, true));
				//par3EntityPlayer.addPotionEffect(new PotionEffect(8, 10, 127, true));
				par3EntityPlayer.addPotionEffect(new PotionEffect(2, 10, 2, true));
				if(tag.getInteger("oldFood") != -987) {
					par3EntityPlayer.getFoodStats().setFoodLevel(tag.getInteger("oldFood"));
				}
				System.out.println("2");
				par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() + 1);
				tag.setInteger("oldFood", par3EntityPlayer.getFoodStats().getFoodLevel());
			}else if ((par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()) <= 0) {
				//this.activated = false;
				System.out.println("3");
				par1ItemStack.stackSize--;
			}
			tag.setLong("time", par2World.getTotalWorldTime());
		}
        return par1ItemStack;
    }
	
	private NBTTagCompound getTagCompound(ItemStack stack) {
        NBTTagCompound nbt;
        if (stack.getTagCompound() != null) {
            nbt = stack.getTagCompound();
        } else {
            nbt = new NBTTagCompound();
        }
        return nbt;
    }
	
}
