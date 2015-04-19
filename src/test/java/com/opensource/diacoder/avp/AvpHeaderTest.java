package com.opensource.diacoder.avp;

import static org.junit.Assert.*;

import org.junit.Test;

import com.opensource.diacoder.avp.AvpHeader;

public class AvpHeaderTest {

	@Test
	public void testDecodeHeaderNoVendorId() {
		byte[] input = { 0x00, 0x01, 0x23, 0x45, (byte) 0x40, 0x00, 0x00, 0x08 };

		AvpHeader header = new AvpHeader();
		header.decode(input);

		assertEquals(0x12345, header.getAvpCode());
		assertFalse(header.hasVendorId());
		assertTrue(header.isMandatory());
		assertFalse(header.isEncrypted());
		assertEquals(0x08, header.getAvpLength());
	}

	@Test
	public void testEncodeHeaderNoVendorId(){
		byte[] expected = { 0x00, 0x01, 0x23, 0x45, (byte) 0x40, 0x00, 0x00, 0x08 };
		
		AvpHeader header = new AvpHeader();
		header.setAvpCode(0x12345);
		header.setMandatory(true);
		header.setEncrypted(false);
		header.hasVendorId(false);
		header.setAvpLength(8);
		byte[] result = header.encode();

		assertArrayEquals(expected, result);
		
	}
	@Test
	public void testDecodeHeaderVendorId() {
		byte[] input = { 0x00, 0x01, 0x23, 0x45, (byte) 0xC0, 0x00, 0x00, 0x0C,
				0x00, 0x00, 0x28, (byte) 0xAF };

		AvpHeader header = new AvpHeader();
		header.decode(input);

		assertEquals(0x12345, header.getAvpCode());
		assertTrue(header.hasVendorId());
		assertEquals(10415, header.getVendorId());
		assertTrue(header.isMandatory());
		assertFalse(header.isEncrypted());
		assertEquals(12, header.getAvpLength());
		
	}
}
