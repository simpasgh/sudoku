package it.pasculli.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinearAreaTest {

	@Test
	public void testIsValid() {
		LinearArea area = new LinearArea();

		assertTrue(area.isValid());

		area.setCell(0, 1);

		assertTrue(area.isValid());

		area.setCell(1, 1);

		assertFalse(area.isValid());

		area.setCell(1, 2);

		assertTrue(area.isValid());
	}

}
