package net.hycrafthd.tutorialmod.proxy;

import net.hycrafthd.tutorialmod.init.TutorialGuis;
import net.hycrafthd.tutorialmod.init.TutorialModels;

public class ClientProxy extends CommonProxy {
	
	public void construct() {
		super.construct();
		TutorialGuis.construct();
		TutorialModels.contruct();
	}
	
	public void setup() {
		super.setup();
	}
	
	public void complete() {
		super.complete();
	}
	
}
