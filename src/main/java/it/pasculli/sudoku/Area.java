package it.pasculli.sudoku;

/**
 * A validation area of the sudoku game
 * @author simone
 *
 */
public interface Area {

	/**
	 * Returns true if the area is valid (no duplicates)
	 * 
	 * @return
	 */
	public boolean isValid();
}
