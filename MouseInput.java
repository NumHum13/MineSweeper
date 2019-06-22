package minePackage;

//another experimental class, trying to figure out how to implement input from the mouse into the code
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Mouse Clicked");
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		Ground game = MineSweeper.game;
		//System.out.println("Mouse pressed. x = " + event.getX() + " y = " + event.getY());
		if(SwingUtilities.isLeftMouseButton(event))
		{
			//System.out.println("Left Clicked");
			game.mouseAt(event.getX(), event.getY(), true);
		}
		else if(SwingUtilities.isRightMouseButton(event))
		{
			//System.out.println("Right Clicked");
			game.mouseAt(event.getX(), event.getY(), false);
		}
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