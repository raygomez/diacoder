package com.opensource.diacoder;

public class AvpHeader {

	private int avpCode;
	private boolean hasVendorId;
	private boolean isMandatory;
	private boolean isEncrypted;
	private int vendorId;
	
	public AvpHeader() {
	}

	public int getAvpCode() {
		return avpCode;
	}

	public void setAvpCode(int avpCode) {
		this.avpCode = avpCode;
	}

	public boolean isVendorBit() {
		return hasVendorId;
	}

	public void setVendorBit(boolean isVBit) {
		this.hasVendorId = isVBit;
	}

	public boolean isMandatoryBit() {
		return isMandatory;
	}

	public void setMandatoryBit(boolean isMBit) {
		this.isMandatory = isMBit;
	}

	public boolean isEncryptedBit() {
		return isEncrypted;
	}

	public void setEncryptedBit(boolean isPBit) {
		this.isEncrypted = isPBit;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

}
