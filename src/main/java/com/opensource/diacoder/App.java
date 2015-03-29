package com.opensource.diacoder;

public class App 
{

	private static Launcher launcher = new Launcher();
	
	public static void main( String[] args )
    {
		launcher.run();
    }
	
	static void setLaunch(Launcher launcher) {
		App.launcher = launcher; 
	}
}
