package minePackage;

/**
 * The main class of the program. Everything happens from here and can test everything out.
 * Be sure to call your package "minePackage" because that is what I named mine and you wouldn't have to change anything to make it work.
 * @author ByLink
 *
 */
public class MineSweeper{
	public static Grid g = new Grid(16, 16, 40);;
	public static Ground game = new Ground();
	
	public static void main(String[] args) {
		game.addMouseListener(new MouseInput());
		(game.g).drawRect(55, 730, 40, 40);
	}
}