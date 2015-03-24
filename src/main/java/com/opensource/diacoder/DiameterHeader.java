package com.opensource.diacoder;

public class DiameterHeader {

	private byte version;
	private int messageLength;
	private boolean isRequest;
	private boolean isProxiable;
	private boolean isError;
	private boolean isRetransmitted;
	private int commandCode;
	private int applicationId;
	private int hopByHopId;
	private int endToEndId;

	public DiameterHeader() {

	}

	public DiameterHeader(byte[] input) {
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

	public int getApplicationId() {
		return applicationId;
	}

	public int getHopByHopId() {
		return hopByHopId;
	}

	public int getEndToEndId() {
		return endToEndId;
	}

	public void setVersion(byte version) {
		this.version = version;
	}

	public void setMessageLength(int messageLength) {
		this.messageLength = messageLength;
	}

	public void setRequest(boolean isRequest) {
		this.isRequest = isRequest;
	}

	public void setProxiable(boolean isProxiable) {
		this.isProxiable = isProxiable;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public void setRetransmitted(boolean isRetransmitted) {
		this.isRetransmitted = isRetransmitted;
	}

	public void setCommandCode(int commandCode) {
		this.commandCode = commandCode;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public void setHopByHopId(int hopByHopId) {
		this.hopByHopId = hopByHopId;
	}

	public void setEndToEndId(int endToEndId) {
		this.endToEndId = endToEndId;
	}

	public void decode(byte[] input) {
		
		if(input.length != 20) {
			if(input.length > 20){
				throw new IllegalArgumentException("DiameterHeader length is greater than 20.");
			} else {
				throw new IllegalArgumentException("DiameterHeader length is less than 20.");
			}
		}
		version = input[0];
		messageLength = (input[1] << 16) + (input[2] << 8) + input[3];

		isRequest = (input[4] & 0x80) > 0;
		isProxiable = (input[4] & 0x40) > 0;
		isError = (input[4] & 0x20) > 0;
		isRetransmitted = (input[4] & 0x10) > 0;
		commandCode = input[5] << 16 | input[6] << 8 | input[7];
		applicationId = input[8] << 24 | (input[9] & 0xFF) << 16
				| (input[10] & 0xFF) << 8 | input[11];
		hopByHopId = input[12] << 24 | (input[13] & 0xFF) << 16
				| (input[14] & 0xFF) << 8 | input[15];
		endToEndId = input[16] << 24 | (input[17] & 0xFF) << 16
				| (input[18] & 0xFF) << 8 | input[19];
	}

	public void encode(byte[] input) {

		if(input.length != 20) {
			if(input.length > 20){
				throw new IllegalArgumentException("DiameterHeader length is greater than 20.");
			} else {
				throw new IllegalArgumentException("DiameterHeader length is less than 20.");
			}
		}
		
		input[0] = version;
		input[1] = (byte) ((messageLength >> 16) & 0xFF);
		input[2] = (byte) ((messageLength >> 8) & 0xFF);
		input[3] = (byte) (messageLength & 0xFF);
		input[4] = (byte) (isRequest ? 0x80 : 0);
		input[4] |= (byte) (isProxiable ? 0x40 : 0);
		input[4] |= (byte) (isError ? 0x20 : 0);
		input[4] |= (byte) (isRetransmitted ? 0x10 : 0);
		input[5] = (byte) ((commandCode >> 16) & 0xFF);
		input[6] = (byte) ((commandCode >> 8) & 0xFF);
		input[7] = (byte) (commandCode & 0xFF);
		input[8] = (byte) ((applicationId >> 24) & 0xFF);
		input[9] = (byte) ((applicationId >> 16) & 0xFF);
		input[10] = (byte) ((applicationId >> 8) & 0xFF);
		input[11] = (byte) (applicationId & 0xFF);
		input[12] = (byte) ((hopByHopId >> 24) & 0xFF);
		input[13] = (byte) ((hopByHopId >> 16) & 0xFF);
		input[14] = (byte) ((hopByHopId >> 8) & 0xFF);
		input[15] = (byte) (hopByHopId & 0xFF);
		input[16] = (byte) ((endToEndId >> 24) & 0xFF);
		input[17] = (byte) ((endToEndId >> 16) & 0xFF);
		input[18] = (byte) ((endToEndId >> 8) & 0xFF);
		input[19] = (byte) (endToEndId & 0xFF);

	}
}
