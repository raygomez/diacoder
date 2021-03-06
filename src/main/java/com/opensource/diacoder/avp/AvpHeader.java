package com.opensource.diacoder.avp;

public class AvpHeader {

	private int avpCode;
	private boolean hasVendorId;
	private boolean isMandatory;
	private boolean isEncrypted;
	private int avpLength;
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
		this.hasVendorId = true;
	}

	public int getAvpLength() {
		return avpLength;
	}

	public void setAvpLength(int length) {
		this.avpLength = length;
	}

	public boolean hasVendorId() {
		return hasVendorId;
	}

	public int getLength(){
		return hasVendorId ? 12 : 8;
	}
	public void decode(byte[] input) {
		
		avpCode = input[0] << 24 | input[1] << 16 | input[2] << 8 | input[3];
		hasVendorId = (input[4] & 0x80) > 0;
		isMandatory = (input[4] & 0x40) > 0;
		isEncrypted = (input[4] & 0x20) > 0;
		
		avpLength = input[5] << 16 | input[6] << 8 | input[7];  
		
		if(hasVendorId()){
			vendorId = input[8] << 24;
			vendorId |= (input[9] & 0xFF) << 16;
			vendorId |= (input[10] & 0xFF) << 8;
			vendorId |= input[11] & 0xFF;

		} else {
			vendorId = 0;
		}
	}
	
	public byte[] encode() {
	
		byte[] output = new byte[getLength()];
		output[0] = (byte) ((avpCode >> 24) & 0xFF);
		output[1] = (byte) ((avpCode >> 16) & 0xFF);
		output[2] = (byte) ((avpCode >> 8) & 0xFF);
		output[3] = (byte) (avpCode & 0xFF);
		
		output[4] = (byte)(hasVendorId ? 0x80 : 0);
		output[4] |= (byte)(isMandatory ? 0x40 : 0);
		output[4] |= (byte)(isEncrypted ? 0x20 : 0);
		
		output[5] = (byte) ((avpLength >> 16) & 0xFF);
		output[6] = (byte) ((avpLength >> 8) & 0xFF);
		output[7] = (byte) (avpLength & 0xFF);
		
		if(hasVendorId){
			output[8] = (byte) ((vendorId >> 24) & 0xFF);
			output[9] = (byte) ((vendorId >> 16) & 0xFF);
			output[10] = (byte) ((vendorId >> 8) & 0xFF);
			output[11] = (byte) (vendorId & 0xFF);
		}
		
		return output;
		
	}

}
