package net.hycrafthd.tutorialmod.proxy;

import net.hycrafthd.tutorialmod.init.TutorialGuis;

public class ClientProxy extends CommonProxy {
	
	public void construct() {
		super.construct();
		TutorialGuis.construct();
	}
	
	public void setup() {
		super.setup();
	}
	
	public void complete() {
		super.complete();
	}
	
}
