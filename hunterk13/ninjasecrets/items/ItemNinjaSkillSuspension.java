package ninjasecrets.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNinjaSkillSuspension extends ItemNinjaSkillBase{

	//private boolean activated = false;
	//private boolean inUse = false;
	int oldFood = -987;
	long h = -987; 
	
	public ItemNinjaSkillSuspension(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabCombat);
		setMaxStackSize(1);
		setMaxDamage(500);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		/*this.inUse = true;
		if (par1ItemStack.getItemDamage() < 500) {
			System.out.println("2.1");
			this.activated = true;
		}*/
		if (par2World.getTotalWorldTime() +- this.h > 10) {
			this.oldFood = -987;
		}
		if (par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage()/* && this.activated == true*/) {
			par3EntityPlayer.addPotionEffect(new PotionEffect(13, 10, 0, true));
			//par3EntityPlayer.addPotionEffect(new PotionEffect(8, 10, 127, true));
			par3EntityPlayer.addPotionEffect(new PotionEffect(2, 10, 2, true));
			if(oldFood != -987) {
				par3EntityPlayer.getFoodStats().setFoodLevel(oldFood);
			}
			System.out.println("2");
			par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() + 1);
			oldFood = par3EntityPlayer.getFoodStats().getFoodLevel();
		}else if ((par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()) <= 0) {
			//this.activated = false;
			System.out.println("3");
			par1ItemStack.stackSize = 0;
		}
		h = par2World.getTotalWorldTime();
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
	
	
}
