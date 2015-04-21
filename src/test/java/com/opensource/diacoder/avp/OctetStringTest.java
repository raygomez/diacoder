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
	
	@Test
	public void testOctetStringEncodeWithVendorId() {

		OctetString avp = new OctetString();
		avp.setAvpCode(0x11223344);
		avp.setVendorId(0xFFEEDDCC);
		byte[] data = { (byte) 0x88, 0x77};
		avp.setData(data);
		avp.setMandatory(false);

		byte[] expected = { 0x11, 0x22, 0x33, 0x44, (byte) 0x80, 0x00, 0x00,
				(byte) 0x0E, (byte) 0xFF, (byte) 0xEE, (byte) 0xDD,
				(byte) 0xCC, (byte) 0x88, 0x77, 0x00, 0x00 };
		byte[] actual = avp.encode();

		assertArrayEquals(expected, actual);

	}

}