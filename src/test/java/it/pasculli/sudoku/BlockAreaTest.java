package it.pasculli.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class BlockAreaTest {

	@Test
	public void testIsValid() {
		BlockArea area = new BlockArea();
		
		assertTrue(area.isValid());
		
		area.setCell(0, 0, 1);
		
		assertTrue(area.isValid());
		
		area.setCell(1, 1, 1);

		assertFalse(area.isValid());
		
		area.setCell(1, 1, 2);

		assertTrue(area.isValid());
	}

}
