package com.opensource.diacoder.avp;

public class OctetString extends Avp {

	private byte[] data = new byte[0];
	
	public OctetString() {
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public byte[] encode() {
		
		byte[] output = new byte[getLength()];
		header.setAvpLength(output.length);
		byte[] encodedHeader = header.encode();
		int headerLength = encodedHeader.length;
		System.arraycopy(encodedHeader, 0, output, 0, headerLength);
		System.arraycopy(data, 0, output, headerLength, data.length);
		
		return output;
	}

	public int getLength() {
		return header.getLength() + (data.length + 3) & ~3;
	}

	@Override
	public void decode(byte[] input) {

	}

}
