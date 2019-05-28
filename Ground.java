package minePackage;

//main graphics class, implements JFrame
//http://www.mathcs.emory.edu/~cheung/Courses/377/Syllabus/8-JDBC/GUI/activeComponents2.html
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
		//Need to create 256 squares
class Ground extends JFrame
{
	private Graphics billy;
	private static Location[][] arr;
	private int x;
	private int y;
	private int sum = 1;
	private ArrayList<Bundle> bundles = new ArrayList<Bundle>();
	
	public Ground()
	{
		//to  Set JFrame title
		super("Ground Class: MineSweeper");
		//Set default close operation for JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set JFrame size
		setSize(750,800);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		//Make JFrame visible
		setVisible(true);
	}
	
	public void setArr(Location[][] arr)
	{
		this.arr = arr;
	}
	
	public void openFree(int row, int col)
	{
		int totalLocation = 1;
		if(!arr[row][col].getState())
		{
			//billy.setColor(Color.GRAY);
			//billy.fillRect(row, col, 39, 39);
		}
		bundles.add(new Bundle(row-1, col));
		bundles.add(new Bundle(row, col-1));
		bundles.add(new Bundle(row, col+1));
		bundles.add(new Bundle(row+1, col));
		totalLocation = 4;
		
		
	}
	public void mouseAt(int xCoor, int yCoor)
	{
		xCoor = ((xCoor - 50)/40) * 40 + 50;
		yCoor = ((yCoor - 80)/40) * 40 + 80;
		x = (xCoor- 50)/40;
		y = (yCoor- 80)/40;
		System.out.println("X is:" + xCoor + " Y is:" + yCoor);
		//System.out.println("MouseAt");
		System.out.println(x + " " + y);
		arr[x][y].setRevealed(true);
		if(sum == 1)
		{
			sum++;
			System.out.println("First open");
			billy.setColor(Color.GRAY);
			billy.fillRect(xCoor, yCoor, 39, 39);
			(MineSweeper.g).placeMines();
			openFree(x, y);
			
			
			
	//!!!!!!!!!!!!!!!!
	//remove this to play game
			//showAll();
	//remove this to play game
	//!!!!!!!!!!!!!!!
		}
		else
		{
			if(arr[x][y].getState())
			{
				billy.setColor(Color.RED);
				billy.fillRect(xCoor, yCoor, 39, 39);
				System.out.println("There is a mine here");
			}
			else
			{
				billy.setColor(Color.GRAY);
				billy.fillRect(xCoor, yCoor, 39, 39);
			}
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		//g.drawString("Hello World", 10, 10);
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
		billy.setFont(billy.getFont().deriveFont(18.0f));
		billy.drawString("MineSweeper", 340, 50);
	}
		
	public static void main(String[]args)
	{
		Ground rect=new Ground();
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
	public void showAll()
	{
		for (int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 16; j++)
			{
				if(arr[i][j].getState())
				{
					billy.setColor(Color.RED);
					billy.fillRect((i * 40) + 50, (j * 40) + 80, 39, 39);
				}
				else
				{
					if((MineSweeper.g).getLocalValue(i, j) > 0)
					{
						billy.setColor(Color.WHITE);
						billy.fillRect((i * 40) + 50, (j * 40) + 80, 39, 39);
					}
					else
					{
						billy.setColor(Color.GRAY);
						billy.fillRect((i * 40) + 50, (j * 40) + 80, 39, 39);
					}
				}
			}
		}
	}
}
