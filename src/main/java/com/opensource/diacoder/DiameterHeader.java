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
	
	public DiameterHeader(byte[] input){
		decode(input);
		
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

	public int getApplicationId(){
		return applicationId;
	}
	public int getHopByHopId() {
		return hopByHopId;
	}

	public int getEndToEndId() {
		return endToEndId;
	}

	public void decode(byte[] input) {
		version = input[0];
		messageLength = (input[1] << 16) + (input[2] << 8) + input[3];

		isRequest = (input[4] & 0x80) > 0;
		isProxiable = (input[4] & 0x40) > 0;
		isError = (input[4] & 0x20) > 0;
		isRetransmitted = (input[4] & 0x10) > 0;
		commandCode = input[5] << 16 | input[6] << 8 | input [7];
		applicationId = input[8] << 24 | (input[9] & 0xFF) << 16 | (input[10] & 0xFF) << 8 | input [11];
		hopByHopId =  input[12] << 24 | (input[13] & 0xFF) << 16 | (input[14] & 0xFF) << 8 | input [15];
		endToEndId =  input[16] << 24 | (input[17] & 0xFF) << 16 | (input[18] & 0xFF) << 8 | input [19];
	}

	public void encode(byte[] input){
		
	}
}
