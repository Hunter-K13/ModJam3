package ninjasecrets;

import net.minecraft.creativetab.CreativeTabs;
import ninjasecrets.config.ConfigHandler;
import ninjasecrets.items.Items;
import ninjasecrets.network.PacketHandler;
import ninjasecrets.proxies.CommonProxy;
import ninjasecrets.tabs.CreativeTabNinja;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInfo.ID, name = ModInfo.Name, version = ModInfo.Version)
@NetworkMod(channels = {ModInfo.Channel}, clientSideRequired = true, serverSideRequired = true, packetHandler = PacketHandler.class)

public class NinjaSecrets {
	
	public static CreativeTabNinja  ninTab = new CreativeTabNinja(CreativeTabs.getNextID(), "nintab");
	
	@Instance(ModInfo.ID)
	public static NinjaSecrets ns;
	
	@SidedProxy(clientSide = "ninjasecrets.proxies.ClientProxy", serverSide = "ninjasecrets.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preInit) {
		ConfigHandler.init(preInit.getSuggestedConfigurationFile());
		Items.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent init) {
		Items.addNames();
		//Items.registerRecipes();
	}
}
