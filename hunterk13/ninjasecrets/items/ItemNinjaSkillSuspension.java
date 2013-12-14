package ninjasecrets.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNinjaSkillSuspension extends ItemNinjaSkillBase{

	private boolean activated = false;
	
	public ItemNinjaSkillSuspension(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabCombat);
		setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if (par1ItemStack.getItemDamage() > 0 && this.activated == false) {
			this.activated = true;
		}else{
			this.activated = false;
		}
        return par1ItemStack;
    }
	
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if (par1ItemStack.getItemDamage() > 0 && this.activated == true) {
			((EntityLiving)par3Entity).addPotionEffect(new PotionEffect(13, 10, 0, true));
			par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);
		}else if (par1ItemStack.getItemDamage() <= 0 && this.activated == true) {
			this.activated = false;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(Items.TextureLocation + ":" + Items.SuspensionIcon);
	}
	
	
}
