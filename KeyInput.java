package minePackage;
//import java.awt.*;  
import java.awt.event.*; 
import java.awt.event.KeyListener;

import javax.swing.SwingUtilities;

public class KeyInput  implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		Ground game = MineSweeper.game;
		//System.out.println(e.getKeyCode());
		if(e.getKeyCode() == 16)
		{
			System.out.println("Shift Clicked");
			//game.shiftHeld(true);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
