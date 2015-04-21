package com.opensource.diacoder.avp;

public class Unsigned32 extends Avp {

	private static final int INTEGER_DATA_SIZE = 4;
	private int data;
	
	public Unsigned32() {
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isEncrypted() {
		return header.isEncrypted();
	}

	@Override
	public byte[] encode() {
		
		byte[] output = new byte[getLength()];
		header.setAvpLength(getLength());
		byte[] encodedHeader = header.encode();
		int headerLength = encodedHeader.length;
		System.arraycopy(encodedHeader, 0, output, 0, headerLength);
		output[headerLength] = (byte)((data >> 24) & 0xFF);
		output[headerLength + 1] = (byte)((data >> 16) & 0xFF);
		output[headerLength + 2] = (byte)((data >> 8) & 0xFF);
		output[headerLength + 3] = (byte)(data & 0xFF);
		
		return output;
	}

	public int getLength() {
		return header.getLength() + INTEGER_DATA_SIZE;
	}

	@Override
	public void decode(byte[] input) {

	}

}
