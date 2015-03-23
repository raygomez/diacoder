package com.opensource.diacoder;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiameterHeaderTest {

	@Test
	public void testDecodeHeader() {

		byte[] input = { 0x01, 0x00, 0x00, 0x10, (byte) 0xC0, 0x00, 0x00, 0x00,
				0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00,
				0x00, 0x02 };
		DiameterHeader header = new DiameterHeader(input);
		assertEquals(0x01, header.getVersion());
		assertEquals(16, header.getMessageLength());
		assertTrue(header.isRequest());
		assertTrue(header.isProxiable());
		assertFalse(header.isError());
		assertFalse(header.isRetransmitted());
		assertEquals(0, header.getCommandCode());
		assertEquals(0, header.getApplicationId());
		assertEquals(1, header.getHopByHopId());
		assertEquals(2, header.getEndToEndId());

	}

	@Test
	public void testDecodeHeaderWithOtherValues() {

		byte[] input = { (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x10,
				(byte) 0x30, (byte) 0x11, (byte) 0x22, (byte) 0x33,
				(byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44,
				(byte) 0x99, (byte) 0x88, (byte) 0x77, (byte) 0x66,
				(byte) 0x55, (byte) 0x44, (byte) 0x33, (byte) 0x22 };
		DiameterHeader header = new DiameterHeader(input);
		assertEquals(0x01, header.getVersion());
		assertEquals(16, header.getMessageLength());
		assertFalse(header.isRequest());
		assertFalse(header.isProxiable());
		assertTrue(header.isError());
		assertTrue(header.isRetransmitted());
		assertEquals(0x112233, header.getCommandCode());
		assertEquals(0x11223344, header.getApplicationId());
		assertEquals(0x99887766, header.getHopByHopId());
		assertEquals(0x55443322, header.getEndToEndId());

	}
}
