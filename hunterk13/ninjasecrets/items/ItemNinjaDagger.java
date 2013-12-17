package ninjasecrets.items;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ninjasecrets.NinjaSecrets;

public class ItemNinjaDagger extends Item {

	public ItemNinjaDagger(int par1) {
		super(par1);
		setCreativeTab(NinjaSecrets.ninTab);
		setMaxStackSize(1);
		setMaxDamage(200);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer player, Entity entity) {
		if (entity instanceof EntityLiving) {
			if (entity instanceof EntityPlayer || entity instanceof EntityDragon || entity instanceof EntityWither) {
				return false;
			}
			EntityLiving target = (EntityLiving)entity;
			Random rand = new Random();
			int poop = rand.nextInt(4);
			if (poop == 0) {
				disarm(target);
			}
		}
		itemStack.setItemDamage(itemStack.getItemDamage() + 1);
		if ((itemStack.getMaxDamage() - itemStack.getItemDamage()) <= 0) {
			itemStack.stackSize--;
		}
		return false;
	}

	private void disarm(EntityLiving target) {
		for (int i = 1; i <= 23; i++){
			target.removePotionEffect(i);
		}
		target.hurtResistantTime = 0;
		target.setHealth((float)0.1);
		System.out.println(target.getMaxHealth());
	}
	

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TextureLocation + ":" + ItemInfo.DaggerIcon);
	}
	
}
