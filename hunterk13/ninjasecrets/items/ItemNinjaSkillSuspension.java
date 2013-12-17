package ninjasecrets.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import ninjasecrets.NinjaSecrets;

public class ItemNinjaSkillSuspension extends ItemNinjaSkillBase {

	public ItemNinjaSkillSuspension(int id) {
		super(id);
		setCreativeTab(NinjaSecrets.ninTab);
		setMaxStackSize(1);
		setMaxDamage(6000);
		setUnlocalizedName(ItemInfo.SuspendUnlocal);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if (!par3EntityPlayer.capabilities.isCreativeMode) {
			NBTTagCompound tag = getTagCompound(par1ItemStack);
			if (par2World.getTotalWorldTime() - tag.getLong("time") > 10) {
				tag.setInteger("oldFood", -987);
				par1ItemStack.setTagCompound(tag);
			}
			if (par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage()) {
				par3EntityPlayer.addPotionEffect(new PotionEffect(13, 10, 0, true));
				par3EntityPlayer.addPotionEffect(new PotionEffect(2, 10, 2, true));
				if(tag.getInteger("oldFood") != -987) {
					par3EntityPlayer.getFoodStats().setFoodLevel(tag.getInteger("oldFood"));
					System.out.println("2");
				}
				
				par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() + 1);
				tag.setInteger("oldFood", par3EntityPlayer.getFoodStats().getFoodLevel());
				par1ItemStack.setTagCompound(tag);
			}else if ((par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()) <= 0) {
				par1ItemStack.stackSize--;
			}
			tag.setLong("time", par2World.getTotalWorldTime());
			par1ItemStack.setTagCompound(tag);
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
        stack.setTagCompound(nbt);
        return nbt;
    }
	
}
