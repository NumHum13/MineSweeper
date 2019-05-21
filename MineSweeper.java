package minePackage;

/**
 * The main class of the program. Everything happens from here and can test everything out.
 * Be sure to call your package "minePackage" because that is what I named mine and you wouldn't have to change anything to make it work.
 * @author ByLink
 *
 */
public class MineSweeper{
	public static void main(String[] args) {
		
		//creates a new 2D array that stores all the grid locations
		Grid matrix = new Grid(16, 16, 40);
		
		//Ground is my graphics class, it is the one that creates the JFrame
		Ground g = new Ground();
		
	}
}
