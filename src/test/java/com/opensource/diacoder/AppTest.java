package com.opensource.diacoder;

import org.junit.Test;


public class AppTest {
	
	@Test
	public void testDiaCoderMain() {

		Launcher launcher = new Launcher();
		App.setLaunch(launcher);
		App.main(new String[] {});		
	}
}
