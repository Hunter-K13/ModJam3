package ninjasecrets.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNinjaSkillSuspension extends ItemNinjaSkillBase{

	//private boolean activated = false;
	//private boolean inUse = false;
	
	public ItemNinjaSkillSuspension(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabCombat);
		setMaxStackSize(1);
		setMaxDamage(1800);
	}
	
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		NBTTagCompound tag = getTagCompound(par1ItemStack);
		tag.setInteger("oldFood", -987);
		tag.setLong("time", -987);
        par1ItemStack.setTagCompound(tag);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
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
        return par1ItemStack;
    }
	
		/*if (this.isNew == false) {
			par1ItemStack.setItemDamage(100);
			this.isNew = true;
		}
		if (par1ItemStack.getItemDamage() > 0 && this.activated == true) {
			((EntityLiving)par3Entity).addPotionEffect(new PotionEffect(13, 10, 0, true));
			par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);
		}else if (par1ItemStack.getItemDamage() <= 0 && this.activated == true) {
			this.activated = false;
			par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() + 1);
		}else{
			par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() + 1);
		}*/
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(Items.TextureLocation + ":" + Items.SuspensionIcon);
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
