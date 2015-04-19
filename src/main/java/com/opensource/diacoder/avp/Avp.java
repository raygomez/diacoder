package com.opensource.diacoder.avp;

public abstract class Avp {

	protected AvpHeader header;
	
	public Avp() {
	}
	
	public void setAvpCode(int avpCode){
		header.setAvpCode(avpCode);
	}
	
	public void setVendorId(int vendorId){
		header.setVendorId(vendorId);
		header.hasVendorId(true);
	}
	
	public boolean hasVendorId(){
		return header.hasVendorId();
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
