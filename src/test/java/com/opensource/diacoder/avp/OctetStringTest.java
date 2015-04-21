package com.opensource.diacoder.avp;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


public class OctetStringTest {

	@Test
	public void testOctetStringEncodeWithoutVendorId() {
		
		OctetString avp = new OctetString();
		avp.setAvpCode(0x11223344);
		byte[] data = {(byte) 0x88, 0x77, 0x66};
		avp.setData(data);
		avp.setMandatory(true);

		byte[] expected = { 0x11, 0x22, 0x33, 0x44, 0x40, 0x00, 0x00,
				(byte) 0x0B, (byte) 0x88, 0x77, 0x66, 0x00 };
		byte[] actual = avp.encode();

		assertArrayEquals(expected, actual);

	}
}
