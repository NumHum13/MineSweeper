package minePackage;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Simply an experimental class that creates a Textbox.
 * Haven't figured out how to implement it into the actual code.
 * @author ByLink
 *
 */
public class CreateTextbox extends JPanel{
	public void paint(Graphics dog){
		dog.drawString("Hello World", 100, 100);
	}
	
	public static void main(String[] args){
		JFrame frame= new JFrame("Textbox Test");	
		frame.getContentPane().add(new CreateTextbox());
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		
	}
}