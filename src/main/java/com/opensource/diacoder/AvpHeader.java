package com.opensource.diacoder;

public class AvpHeader {

	private int avpCode;
	private boolean hasVendorId;
	private boolean isMandatory;
	private boolean isEncrypted;
	private int avplength;
	private int vendorId;

	
	public AvpHeader() {
	}

	public int getAvpCode() {
		return avpCode;
	}

	public void setAvpCode(int avpCode) {
		this.avpCode = avpCode;
	}

	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean isMBit) {
		this.isMandatory = isMBit;
	}

	public boolean isEncrypted() {
		return isEncrypted;
	}

	public void setEncrypted(boolean isPBit) {
		this.isEncrypted = isPBit;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getAvpLength() {
		return avplength;
	}

	public void setAvpLength(int length) {
		this.avplength = length;
	}

	public boolean hasVendorId() {
		return hasVendorId;
	}

	public void hasVendorId(boolean hasVendorId) {
		this.hasVendorId = hasVendorId;
	}

	public void decode(byte[] input) {
		
		avpCode = input[0] << 24 | input[1] << 16 | input[2] << 8 | input[3];
		hasVendorId = (input[4] & 0x80) > 0;
		isMandatory = (input[4] & 0x40) > 0;
		isEncrypted = (input[4] & 0x20) > 0;
		
		avplength = input[5] << 16 | input[6] << 8 | input[7];  
		
		if(hasVendorId()){
			vendorId = input[8] << 24 | input[9] << 16 | input[10] << 8 | (input[11] & 0xFF);
		} else {
			vendorId = 0;
		}
	}
	
	public void encode(byte[] input) {
		
	}

}
