package com.opensource.diacoder.avp;

public abstract class Avp {

	protected AvpHeader header = new AvpHeader();
	
	public Avp() {
	}
	
	public int getAvpCode(){
		return header.getAvpCode();
	}
	
	public void setAvpCode(int avpCode){
		header.setAvpCode(avpCode);
	}
	
	public void setVendorId(int vendorId){
		header.setVendorId(vendorId);
	}
	
	public boolean hasVendorId(){
		return header.hasVendorId();
	}

	public boolean isMandatory(){
		return header.isMandatory();
	}

	public void setMandatory(boolean isMandatory){
		header.setMandatory(isMandatory);
	}
	
	public void setEncryption(boolean isEncrypted){
		header.setEncrypted(isEncrypted);
	}
	
	public abstract byte[] encode();
	
	public abstract void decode(byte[] input);

	public abstract int getLength();

}
