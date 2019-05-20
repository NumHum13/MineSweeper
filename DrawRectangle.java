package minePackage;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

class DrawRectangle extends JFrame
{
	public DrawRectangle()
	{
		//to  Set JFrame title
		super("Minesweeper base");
	
		//Set default close operation for JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set JFrame size
		setSize(500,500);
		
		//Make JFrame visible
		setVisible(true);
	}
		
	public void paint(Graphics g)
	{
		super.paint(g);
		
		//draw rectangle outline
		g.drawRect(50,50,300,300);
		
		//set color to Green
		g.setColor(Color.LIGHT_GRAY);
		
		//fill rectangle with GREEN color
		g.fillRect(50,50,300,300);
	}
		
	public static void main(String[]args)
	{
		DrawRectangle rect=new DrawRectangle();
	}
}
