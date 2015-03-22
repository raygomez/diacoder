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

	public int getMessageLength() {
		return messageLength;
	}

	public boolean isRequest() {
		return isRequest;
	}

	public boolean isProxiable() {
		return isProxiable;
	}

	public boolean isError() {
		return isError;
	}

	public boolean isRetransmitted() {
		return isRetransmitted;
	}

	public int getCommandCode() {
		return commandCode;
	}

	public int getHopByHopId() {
		return hopByHopId;
	}

	public int getEndToEndId() {
		return endToEndId;
	}

}
