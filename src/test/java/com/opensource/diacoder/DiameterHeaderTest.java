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
		
		
	}

}
