package com.opensource.diacoder;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiameterHeaderTest {

	@Test
	public void testDecodeHeader() {
	
		byte[] input = {0x01, 0x00, 0x00, 0x10, (byte) 0xC0, 0x00, 0x00, 0x00,
				0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x02};
		DiameterHeader header = new DiameterHeader(input);
		assertEquals(0x01, header.getVersion());
		assertEquals(16, header.getMessageLength());
		assertTrue(header.isRequest());
		assertTrue(header.isProxiable());
		assertFalse(header.isError());
		assertFalse(header.isRetransmitted());
		assertEquals(0, header.getCommandCode());
		assertEquals(0, header.getHopByHopId());
		assertEquals(0, header.getEndToEndId());
		
	}

}
