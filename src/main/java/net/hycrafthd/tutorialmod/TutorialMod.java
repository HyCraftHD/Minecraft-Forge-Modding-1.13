package net.hycrafthd.tutorialmod;

import net.hycrafthd.tutorialmod.proxy.ClientProxy;
import net.hycrafthd.tutorialmod.proxy.CommonProxy;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TutorialMod.modid)
public class TutorialMod {

	public static final String modid = "tutorialmod";

	private final CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	public TutorialMod() {
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
		proxy.construct();
	}

	@SubscribeEvent
	public void setup(FMLCommonSetupEvent event) {
		proxy.setup();
	}

	@SubscribeEvent
	public void ready(FMLLoadCompleteEvent event) {
		proxy.complete();
	}

}
