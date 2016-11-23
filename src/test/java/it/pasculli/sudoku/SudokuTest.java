package it.pasculli.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {

	@Test
	public void testBoardCreation() {
		
		Board board = new Board(new Integer[][]{
					{null,null,3,null,null,null,null,7,null},
					{null,null,null,null,null,null,null,null,null},
					{null,null,null,null,null,null,null,null,null},
					{null,null,null,5,null,null,null,null,null},
					{null,null,null,null,null,null,null,null,null},
					{null,null,null,null,null,null,null,null,null},
					{null,null,null,null,null,9,null,null,null},
					{null,null,null,null,null,null,null,null,null},
					{1,null,null,null,null,null,null,null,null},
		});
		
		fail("Not yet implemented");
	}

}
