package minePackage;

//main graphics class, implements JFrame
//http://www.mathcs.emory.edu/~cheung/Courses/377/Syllabus/8-JDBC/GUI/activeComponents2.html
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
		//Need to create 256 squares
class Ground extends JFrame
{
	private Graphics billy;
	private static Location[][] arr;
	private int x;
	private int y;
	
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
	
	public void setArr(Location[][] arr)
	{
		this.arr = arr;
	}
	public void mouseAt(int xCoor, int yCoor)
	{
		xCoor = ((xCoor - 50)/40) * 40 + 50;
		yCoor = ((yCoor - 80)/40) * 40 + 80;
		x = (xCoor- 50)/40;
		y = (yCoor- 80)/40;
		//System.out.println("MouseAt");
		billy.setColor(Color.GRAY);
		System.out.println("X is:" + xCoor + " Y is:" + yCoor);
		billy.fillRect(xCoor, yCoor, 39, 39);
		System.out.println(x + " " + y);
		arr[x][y].setRevealed(true);
		if(arr[x][y].getState())
		{
			System.out.println("There is a mine here");
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawString("Hello World", 10, 10);
		//g.drawString("This is my custom Panel!",1000,20);
		billy = g.create();
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
		//billy.setColor(Color.GRAY);
		//billy.fillRect(50, 80, 39, 39);
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

