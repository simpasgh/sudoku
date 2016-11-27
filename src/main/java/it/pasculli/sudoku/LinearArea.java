package it.pasculli.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a linear area of the game (row or column)
 * 
 * @author simone
 *
 */
public class LinearArea implements Area {

	private static final int AREA_SIZE = 9;
	
	Integer[] cells = new Integer[AREA_SIZE];

	/**
	 * Set the cell passed in the area
	 * 
	 * @param x
	 * @param value
	 */
	public void setCell(int x, Integer value) {
		cells[x] = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.pasculli.sudoku.model.Area#isValid()
	 */
	public boolean isValid() {

		Set<Integer> set = new HashSet<Integer>(Arrays.asList(cells));
		set.remove(null);

		return set.size() == this.size();
	}


	/*
	 * Return the actual size of this area
	 */
	public int size() {
		int result = 0;
		for (Integer value : cells) {
			if (value != null)
				result++;
		}
		return result;
	}

	@Override
	public String toString() {
		return "Area [cells=" + Arrays.toString(cells) + "]";
	}

}
