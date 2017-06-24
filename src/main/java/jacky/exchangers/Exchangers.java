package jacky.exchangers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jacky.exchangers.proxy.CommonProxy;
import jacky.exchangers.util.Data;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Data.MODID, version = Data.VERSION, name = Data.MODNAME, dependencies = Exchangers.DEPENDS, useMetadata = true)
public class Exchangers {

	public static final String DEPENDS = "after:enderio;after:thermalfoundation;after:thermalexpansion;after:mekanism;";

	public static Logger logger = LogManager.getLogger("Exchangers");

	@SidedProxy(serverSide = "jacky.exchangers.proxy.CommonProxy", clientSide = "jacky.exchangers.proxy.ClientProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}

}
