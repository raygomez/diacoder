package com.opensource.diacoder;

public class AvpHeader {

	private int avpCode;
	private boolean isVBit;
	private boolean isMBit;
	private boolean isPBit;
	private int VendorId;
	
	public AvpHeader() {
	}

	public int getAvpCode() {
		return avpCode;
	}

	public void setAvpCode(int avpCode) {
		this.avpCode = avpCode;
	}

}
