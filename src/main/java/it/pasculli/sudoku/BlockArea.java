package it.pasculli.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Class representing a block in the sudoku board
 * @author simone
 *
 */
public class BlockArea implements Area {

	private Integer[][] cells = new Integer[3][3];

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.pasculli.sudoku.model.Area#isValid()
	 */
	public boolean isValid() {

		Set<Integer> set = new HashSet<Integer>();
		for (Integer[] column : cells) {
			set.addAll(Arrays.asList(column));
		}
		set.remove(null);

		return set.size() == this.size();
	}
	
	/**
	 * Set the passed value for the passed position
	 * @param x
	 * @param y
	 * @param value
	 */
	public void setCell(int x, int y, Integer value) {
		cells[x][y] = value;
	}
	

	/*
	 * Return the actual size of this area
	 */
	private int size() {
		int result = 0;
		for (Integer[] column : cells) {
			for (Integer value : column) {
				if (value != null)
					result++;
			}
		}
		return result;
	}

}
