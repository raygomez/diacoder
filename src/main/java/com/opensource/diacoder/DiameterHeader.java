package com.opensource.diacoder;

public class DiameterHeader {

	int version;
	int messageLength;
	boolean isRequest;
	boolean isProxiable;
	boolean isError;
	boolean isRetransmitted;
	int commandCode;
	int applicationId;
	int hopByHopId;
	int endToEndId;
	
	public DiameterHeader() {
		
	}
	
	public DiameterHeader(byte[] array){
		
	}

	public int getVersion() {
		return version;
	}
}
