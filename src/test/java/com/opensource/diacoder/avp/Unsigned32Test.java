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

		byte[] expected = { 0x11, 0x22, 0x33, 0x44, 0x40, 0x00, 0x00,
				(byte) 0x0C, (byte) 0x88, 0x77, 0x66, 0x55 };
		byte[] actual = avp.encode();

		assertArrayEquals(expected, actual);

	}

	@Test
	public void testUnsigned32EncodeWithVendorId() {

		Unsigned32 avp = new Unsigned32();
		avp.setAvpCode(0x11223344);
		avp.setVendorId(0xFFEEDDCC);
		avp.setData(0x88776655);
		avp.setMandatory(false);

		byte[] expected = { 0x11, 0x22, 0x33, 0x44, (byte) 0x80, 0x00, 0x00,
				(byte) 0x10, (byte) 0xFF, (byte) 0xEE, (byte) 0xDD,
				(byte) 0xCC, (byte) 0x88, 0x77, 0x66, 0x55 };
		byte[] actual = avp.encode();

		assertArrayEquals(expected, actual);

	}

}
