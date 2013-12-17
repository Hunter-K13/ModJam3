package ninjasecrets.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import ninjasecrets.NinjaSecrets;

public class ItemNinjaSkillGhost extends ItemNinjaSkillBase {

	public ItemNinjaSkillGhost(int par1) {
		super(par1);
		setCreativeTab(NinjaSecrets.ninTab);
		setMaxStackSize(1);
		setMaxDamage(150);
		setUnlocalizedName(ItemInfo.GhostUnlocal);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		NBTTagCompound tag = getTagCompound(itemStack);
		if (!tag.getBoolean("activated")) {
			tag.setBoolean("activated", true);
			myJump(player);
			itemStack.setTagCompound(tag);
		}
		return itemStack;
	}
	
	@Override
	public void onUpdate(ItemStack itemStack, World par2World, Entity entity, int par4, boolean par5) {
		EntityPlayer player = ((EntityPlayer)entity);
		NBTTagCompound tag = getTagCompound(itemStack);
		if (entity instanceof EntityPlayer && tag.getBoolean("activated")) {
			if (tag.getByte("time") < 2) {
				tag.setByte("time", (byte)(tag.getByte("time") + 1));
				itemStack.setTagCompound(tag);
			}else if (tag.getByte("time") >= 2) {
				if (itemStack.getItemDamage() == 0) {
					player.noClip = true;
					player.capabilities.isFlying = true;
					player.capabilities.disableDamage = true;
					itemStack.setTagCompound(tag);
				}else if ((itemStack.getMaxDamage() - itemStack.getItemDamage()) <= 0) {
					player.noClip = false;
					player.capabilities.isFlying = false;
					player.capabilities.disableDamage = false;
					player.fallDistance = 0;
					player.inventory.mainInventory[player.inventory.currentItem] = null;
					MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(player, itemStack));
				}		
				itemStack.setItemDamage(itemStack.getItemDamage() + 1);
			}
		}
	}
	
	public void myJump(EntityPlayer player) {
		player.motionY = 0.41999998688697815D;
        player.isAirBorne = true;
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