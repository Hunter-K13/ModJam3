package ninjasecrets.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ninjasecrets.items.Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabNinja extends CreativeTabs {
    
	
    public CreativeTabNinja(int tabId, String label) {
        super(tabId, label);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return Items.suspend;
    }
}
