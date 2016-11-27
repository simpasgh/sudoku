package it.pasculli.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class representing the sudoku game
 * 
 * @author simone
 *
 */
public class Sudoku {

	private static final int MAX_CELL_VALUE = 9;
	private static final int MIN_CELL_VALUE = 1;
	private static final int BOARD_SIZE = 9;
	private static final int BLOCK_SIZE = 3;
	
	private Integer[][] board;

	public Sudoku(Integer[][] board) {
		this.board = board;

		if (!legalBoard(board)) {
			throw new IllegalArgumentException("Board not valid");
		}
	}

	/**
	 * Returns true if the board is valid
	 * 
	 * @return
	 */
	public boolean isValid() {

		List<Area> areas = getBoardAreas();

		boolean result = false;
		// verify that all the areas of the board are valid
		for (Area area : areas) {
			if (!(result = area.isValid()))
				break;
		}
		return result;
	}

	/**
	 * Set the cell in the board
	 * 
	 * @param x
	 * @param y
	 * @param value
	 */
	public void setCell(int x, int y, Integer value) {

		if (!legalCell(value)) {
			throw new IllegalArgumentException("Value not valid");
		}
		
		if (x<0 || x>8 || y<0 || y>8) {
			throw new IllegalArgumentException("Position not valid");
		}

		board[y][x] = value;
	}

	/*
	 * Returns true if the parameter is legal for the board
	 */
	private boolean legalCell(Integer value) {
		return value != null && value >= MIN_CELL_VALUE  && value <= MAX_CELL_VALUE;
	}

	/*
	 * Returns true if the cells passed are a legal board
	 */
	private boolean legalBoard(Integer[][] cells) {

		boolean result = false;

		if (cells != null && cells.length == BOARD_SIZE) {
			for (Integer[] column : cells) {
				if (column != null && column.length == BOARD_SIZE) {
					result = true;
				} else {
					result = false;
					break;
				}
			}
		}

		return result;
	}

	/*
	 * Returns the board validity areas
	 */
	private List<Area> getBoardAreas() {
		List<Area> areas = new ArrayList<Area>();

		LinearArea rowArea, columnArea;
		BlockArea blockArea;

		for (int i = 0; i < board.length; i++) {
			rowArea = new LinearArea();
			columnArea = new LinearArea();
			blockArea = new BlockArea();
			areas.add(rowArea);
			areas.add(columnArea);
			areas.add(blockArea);
			for (int j = 0; j < board[i].length; j++) {
				rowArea.setCell(j, board[i][j]);
				columnArea.setCell(j, board[j][i]);
				int rowOffset = (i / 3) * 3;
				int colOffset = (j / 3) * 3;
				for (int k = 0; k < BLOCK_SIZE; k++) {
					for (int m = 0; m < BLOCK_SIZE; m++) {
						blockArea.setCell(k, m, board[rowOffset + k][colOffset + m]);
					}
				}
			}
		}

		return areas;
	}

	@Override
	public String toString() {
		return "Sudoku [board=" + Arrays.deepToString(board) + "]";
	}

	
}
