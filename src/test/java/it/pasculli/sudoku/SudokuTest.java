package it.pasculli.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

import it.pasculli.sudoku.Sudoku;

public class SudokuTest {

	@Test
	public void testValidBoardCreation() {
		
		Sudoku board = new Sudoku(new Integer[][]{
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
		
		assertTrue(board.isValid());
	}
	
	@Test
	public void testNotValidBoardCreation() {
		
		Sudoku badLineBoard = new Sudoku(new Integer[][]{
			{null,3,1,null,null,null,null,7,null},
			{4,null,null,null,null,null,null,6,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,5,null,null,null,null,null},
			{null,null,null,6,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,9,9,null,null},
			{null,7,null,null,null,null,null,4,null},
			{1,null,null,null,null,null,null,3,8},
		});
		
		Sudoku badColumnBoard = new Sudoku(new Integer[][]{
			{null,3,1,null,null,null,null,7,null},
			{4,null,null,null,null,null,null,6,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,5,null,null,null,null,null},
			{null,null,null,5,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,9,1,null,null},
			{null,7,null,null,null,null,null,4,null},
			{1,null,null,null,null,null,null,3,8},
		});
		
		Sudoku badBlockBoard = new Sudoku(new Integer[][]{
			{null,3,1,null,null,null,null,7,null},
			{4,null,null,null,null,null,null,6,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,5,null,null,null,null,null},
			{null,null,null,5,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,9,1,null,null},
			{null,7,null,null,null,null,null,4,null},
			{1,null,null,null,null,null,null,3,8},
		});
		
		assertFalse(badLineBoard.isValid());
		assertFalse(badColumnBoard.isValid());
		assertFalse(badBlockBoard.isValid());
	}
	
	@Test
	public void testValidSetValue() {
		
		Sudoku board = new Sudoku(new Integer[][]{
			{2,null,3,null,null,8,null,7,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,5,null,null,null,4,null},
			{4,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,9,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{1,null,7,null,null,null,null,null,8},
		});
		
		assertTrue(board.isValid());
		
		board.setCell(1, 0, 1);
		
		assertTrue(board.isValid());
		
		board.setCell(3, 1, 4);
		
		assertTrue(board.isValid());
		
		board.setCell(1, 8, 2);
		
		assertTrue(board.isValid());
	}
	
	@Test
	public void testNotValidSetValue() {
		
		Sudoku board = new Sudoku(new Integer[][]{
			{2,null,3,null,null,8,null,7,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,5,null,null,null,4,null},
			{4,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,9,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{1,null,7,null,null,null,null,null,8},
		});
		
		assertTrue(board.isValid());
		
		board.setCell(1, 0, 8); //row problem
		
		assertFalse(board.isValid());
		
		board.setCell(1, 0, 4); //fix the problem
		
		assertTrue(board.isValid());
		
		board.setCell(2, 4, 3); //column problem
		
		assertFalse(board.isValid());
		
		board.setCell(2, 4, 8); //fix the problem
		
		assertTrue(board.isValid());
		
		board.setCell(7, 7, 8); //block problem
		
		assertFalse(board.isValid());
		
		board.setCell(7, 7, 1); //fix the problem
		
		assertTrue(board.isValid());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalBoardCreation() {
		Sudoku board = new Sudoku(new Integer[][]{
			{2,null,3,null,null,8,null,7,null}
		});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalValueSet() {
		
		Sudoku board = new Sudoku(new Integer[][]{
			{2,null,3,null,null,8,null,7,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,5,null,null,null,4,null},
			{4,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,9,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{1,null,7,null,null,null,null,null,8},
		});
		
		board.setCell(0, 1, 12);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalPositionSet() {
		
		Sudoku board = new Sudoku(new Integer[][]{
			{2,null,3,null,null,8,null,7,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,5,null,null,null,4,null},
			{4,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,9,null,null,null},
			{null,null,null,null,null,null,null,null,null},
			{1,null,7,null,null,null,null,null,8},
		});
		
		board.setCell(0, 10, 2);
	}
	
	

}
