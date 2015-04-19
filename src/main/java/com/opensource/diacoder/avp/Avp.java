package com.opensource.diacoder.avp;

public abstract class Avp {

	private AvpHeader header;
	
	public Avp() {
	}

	public abstract void encode();
	
	public abstract void decode();
}
