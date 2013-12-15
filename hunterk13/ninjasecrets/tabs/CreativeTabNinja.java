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
    
    /**
     * TODO This one returns a stack instead of an ID maybe we should use this instead?
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return Items.base;
    }
}
