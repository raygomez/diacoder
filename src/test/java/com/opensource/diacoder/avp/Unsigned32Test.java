package com.opensource.diacoder.avp;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


public class Unsigned32Test {

	@Test
	public void testUnsigned32EncodeWithoutVendorId() {
		
		Unsigned32 avp = new Unsigned32();
		avp.setAvpCode(0x11223344);
		avp.setData(0x88776655);
		avp.setMandatory(true);
	
		byte[] expected = { 0x11, 0x22, 0x33, 0x44, 0x40, 0x00, 0x00, (byte) 0x0C,
				(byte) 0x88, 0x77, 0x66, 0x55};		
		byte[] actual = avp.encode();
		
		assertArrayEquals(expected, actual);

	}
	
}
