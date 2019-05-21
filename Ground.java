package minePackage;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JTextField;
		//Need to create 256 squares
class Ground extends JFrame
{
	public Ground()
	{
		//to  Set JFrame title
		super("Ground Class: Minesweeper");
		//Set default close operation for JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set JFrame size
		setSize(750,800);
		
		//Make JFrame visible
		setVisible(true);
	}
		
	public void paint(Graphics g)
	{
		//super.paint(g);
		boolean color = true;
		for (int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 16; j++)
			{
				g.drawRect(50 + (i * 40),80 + (j * 40), 40,40);
				g.setColor(Color.GREEN);
				g.fillRect(50 + (i * 40),80 + (j * 40), 39,39);
			}
		}
			
		
		//draw rectangle outline
		//g.drawRect(50,50,40,40);
		
		//set color to Green
		//g.setColor(Color.LIGHT_GRAY);
		
		//fill rectangle with GREEN color
		//g.fillRect(50,50,300,300);
	}
		
	public static void main(String[]args)
	{
		Ground rect=new Ground();
	}
}

/**
 * 				g.drawRect(50 + (i * 40),50 + (j * 40), 40,40);
				if(color)
				{
					g.setColor(Color.LIGHT_GRAY);
					color = false;
				}
				else
				{
					g.setColor(Color.GRAY);
					color = true;
				}
				g.fillRect(50 + (i * 40),50 + (j * 40), 39,39);
 */

