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
	private int xCoor;
	private int yCoor;
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
	public void openFree()
	{
		Location thisLocation = new Location();
		bundles.add(new Bundle(x-1, y));
		bundles.add(new Bundle(x, y-1));
		bundles.add(new Bundle(x, y+1));
		bundles.add(new Bundle(x+1, y));
		while(bundles.size() > 1)
		{
			System.out.println("While loop");
			for(int i = 1; i < bundles.size(); i++)
			{
				System.out.println("For loop");
				try
				{
					thisLocation = arr[(bundles.get(i)).getRow()][(bundles.get(i)).getCol()];
					if(!thisLocation.getRevealed())
					{
						if(thisLocation.getLocationValue() == 0)
						{
							thisLocation.setRevealed(true);
							bundles.add(new Bundle((bundles.get(i)).getRow()-1, (bundles.get(i)).getCol()));
							bundles.add(new Bundle((bundles.get(i)).getRow(), (bundles.get(i)).getCol()-1));
							bundles.add(new Bundle((bundles.get(i)).getRow(), (bundles.get(i)).getCol()+1));
							bundles.add(new Bundle((bundles.get(i)).getRow()-1, (bundles.get(i)).getCol()));
							billy.setColor(Color.GRAY);
							billy.fillRect(xSet((bundles.get(i)).getRow()), ySet((bundles.get(i)).getCol()), 39, 39);
							bundles.remove(i);
							
							System.out.println("OpenFree IF");
						}
						else if(thisLocation.getLocationValue() >= 0)
						{
							if(!arr[(bundles.get(i)).getRow()-1][(bundles.get(i)).getCol()].getState())
							{
								arr[(bundles.get(i)).getRow()-1][(bundles.get(i)).getCol()].setRevealed(true);
								billy.setColor(Color.GRAY);
								billy.fillRect(xSet((bundles.get(i)).getRow()-1), ySet((bundles.get(i)).getCol()), 39, 39);
							}
							if(!arr[(bundles.get(i)).getRow()][(bundles.get(i)).getCol()-1].getState())
							{
								arr[(bundles.get(i)).getRow()][(bundles.get(i)).getCol()-1].setRevealed(true);
								billy.setColor(Color.GRAY);
								billy.fillRect(xSet((bundles.get(i)).getRow()), ySet((bundles.get(i)).getCol()-1), 39, 39);
							}
							if(!arr[(bundles.get(i)).getRow()][(bundles.get(i)).getCol()+1].getState())
							{
								arr[(bundles.get(i)).getRow()][(bundles.get(i)).getCol()+1].setRevealed(true);
								billy.setColor(Color.GRAY);
								billy.fillRect(xSet((bundles.get(i)).getRow()), ySet((bundles.get(i)).getCol()+1), 39, 39);
							}
							if(!arr[(bundles.get(i)).getRow()+1][(bundles.get(i)).getCol()].getState())
							{
								arr[(bundles.get(i)).getRow()+1][(bundles.get(i)).getCol()].setRevealed(true);
								billy.setColor(Color.GRAY);
								billy.fillRect(xSet((bundles.get(i)).getRow()+1), ySet((bundles.get(i)).getCol()), 39, 39);
							}
							billy.setColor(Color.GRAY);
							billy.fillRect(xSet((bundles.get(i)).getRow()), ySet((bundles.get(i)).getCol()), 39, 39);
							bundles.remove(i);
							System.out.println("OpenFree Else If");
						}
						else
						{
							thisLocation.setRevealed(false);
							bundles.remove(i);
							System.out.println("OpenFree Else");
						}
					}
					else
					{
						bundles.remove(i);
						System.out.println("OpenFree ELSE ELSE");
					}
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					break;
					//System.out.println("Error Caught" +i);
				}
			}
		}

		
	}
	public int xSet(int rowed)
	{
		return (rowed * 40) + 50;
	}
	public int ySet(int coled)
	{
		return (coled * 40) + 80;
	}
	public void mouseAt(int xCoored, int yCoored)
	{
		xCoor = ((xCoored - 50)/40) * 40 + 50;
		yCoor = ((yCoored - 80)/40) * 40 + 80;
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
			openFree();
			
			
			
	//!!!!!!!!!!!!!!!!
	//remove this to play game
			//showAll();
	//remove this to play game
	//!!!!!!!!!!!!!!!
		}
		else if(sum == 0)
		{
			System.exit(0);
		}
		else
		{
			if(arr[x][y].getState())
			{
				billy.setColor(Color.RED);
				billy.fillRect(xCoor, yCoor, 39, 39);
				//billy.fillArc(xCoor, yCoor, 30, 30, 18, 50);
				billy.setFont(billy.getFont().deriveFont(100.0f));
				billy.drawString("Gameover", 180, 400);
				billy.setFont(billy.getFont().deriveFont(40.0f));
				billy.drawString("3", 50 + 9, 80 + 35);
				sum = 0;
			}
			else
			{
				billy.setColor(Color.GRAY);
				billy.fillRect(xCoor, yCoor, 39, 39);
				//openFree();
			}
		}
	}
	public void showValue(int numX, int numY)
	{
		billy.setFont(billy.getFont().deriveFont(40.0f));
		//int valued = arr.
		billy.drawString("3", numX + 9, numY + 35);
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

		//int totalLocation = 1;
		//bundles.add(new Bundle(x-1, y));
		//bundles.add(new Bundle(x, y-1));
		//bundles.add(new Bundle(x, y+1));
		//bundles.add(new Bundle(x+1, y));
		//totalLocation = 4;
		//for(int i = 0; i < totalLocation)