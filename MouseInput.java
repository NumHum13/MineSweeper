package minePackage;

//another experimental class, trying to figure out how to implement input from the mouse into the code
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Mouse Clicked");
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		Ground game = MineSweeper.game;
		System.out.println("Mouse pressed. x = " + event.getX() + " y = " + event.getY());
		game.mouseAt(event.getX(), event.getY());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}