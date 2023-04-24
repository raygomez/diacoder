package com.opensource.diacoder;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DiameterHeaderTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testDecodeHeader() {

		byte[] input = { 0x01, 0x00, 0x00, 0x14, (byte) 0xC0, 0x00, 0x00, 0x00,
				0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00,
				0x00, 0x02 };
		DiameterHeader header = new DiameterHeader(input);
		assertEquals(0x01, header.getVersion());
		assertEquals(20, header.getMessageLength());
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

		byte[] input = { 0x01, 0x00, 0x00, 0x14, 0x30, 0x11, 0x22, 0x33, 0x11,
				0x22, 0x33, 0x44, (byte) 0x99, (byte) 0x88, 0x77, 0x66, 0x55,
				0x44, 0x33, 0x22 };
		DiameterHeader header = new DiameterHeader(input);
		assertEquals(0x01, header.getVersion());
		assertEquals(20, header.getMessageLength());
		assertFalse(header.isRequest());
		assertFalse(header.isProxiable());
		assertTrue(header.isError());
		assertTrue(header.isRetransmitted());
		assertEquals(0x112233, header.getCommandCode());
		assertEquals(0x11223344, header.getApplicationId());
		assertEquals(0x99887766, header.getHopByHopId());
		assertEquals(0x55443322, header.getEndToEndId());

	}

	@Test
	public void testEncodeHeader() {
		byte[] expected = { 0x01, 0x00, 0x00, 0x14, (byte) 0xC0, 0x00, 0x00,
				0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00,
				0x00, 0x00, 0x02 };
		DiameterHeader header = new DiameterHeader();
		header.setVersion((byte) 1);
		header.setMessageLength(20);
		header.setRequest(true);
		header.setProxiable(true);
		header.setError(false);
		header.setRetransmitted(false);
		header.setCommandCode(0);
		header.setApplicationId(0);
		header.setHopByHopId(1);
		header.setEndToEndId(2);

		byte[] result = new byte[expected.length];
		header.encode(result);

		assertArrayEquals(expected, result);

	}

	@Test
	public void testRaiseExceptionWhenEncodeHeaderTooSmall() {
		byte[] expected = { 0x01 };
		DiameterHeader header = new DiameterHeader();
		header.setVersion((byte) 1);
		byte[] result = new byte[expected.length];
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("DiameterHeader length is less than 20.");
		header.encode(result);
	}

	@Test
	public void testRaiseExceptionWhenEncodeHeaderTooBig() {
		byte[] expected = new byte[21];
		DiameterHeader header = new DiameterHeader();
		header.setVersion((byte) 1);
		byte[] result = new byte[expected.length];
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("DiameterHeader length is greater than 20.");
		header.encode(result);
	}

	@Test
	public void testRaiseExceptionWhenDecodeHeaderTooSmall() {
		byte[] input = { 0x01 };
		DiameterHeader header = new DiameterHeader();
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("DiameterHeader length is less than 20.");
		header.decode(input);
	}

	@Test
	public void testRaiseExceptionWhenDecodeHeaderTooBig() {
		byte[] input = new byte[21];
		DiameterHeader header = new DiameterHeader();
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("DiameterHeader length is greater than 20.");
		header.decode(input);
	}

	private static final byte XFF = -1;
	@Test
	public void testDecodeHeaderMaxValues() {
		byte[] input = { 0x01, XFF, XFF, XFF, (byte) 0xC0, XFF, XFF, XFF,
				XFF, XFF, XFF, XFF, XFF, XFF, XFF, XFF, XFF, XFF,
				XFF, XFF };
		DiameterHeader header = new DiameterHeader(input);
		assertEquals(0x01, header.getVersion());
		assertEquals(0xffffff, header.getMessageLength());
		assertTrue(header.isRequest());
		assertTrue(header.isProxiable());
		assertFalse(header.isError());
		assertFalse(header.isRetransmitted());
		assertEquals(0xffffff, header.getCommandCode());
		assertEquals(0xffffffff, header.getApplicationId());
		assertEquals(0xffffffff, header.getHopByHopId());
		assertEquals(0xffffffff, header.getEndToEndId());
	}
}
