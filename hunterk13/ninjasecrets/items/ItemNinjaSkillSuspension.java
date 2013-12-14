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
	private boolean isNew = false;
	
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
		System.out.println(this.activated);
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
