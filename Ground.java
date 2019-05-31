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
	private int flags = 40;
	private int minesLeft = 40;
	
	public Graphics getGraph()
	{
		return billy;
	}
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
		ArrayList<Bundle> bundles = new ArrayList<Bundle>();
		int s = 0;
		Location thisLocation = new Location();
		if(checked(x-1,y)){
			bundles.add(new Bundle(x-1, y));
			s++;
		}
		if(checked(x,y-1)){
			bundles.add(new Bundle(x, y-1));
			s++;
		}
		if(checked(x,y+1)) {
			bundles.add(new Bundle(x, y+1));
			s++;
		}
		if(checked(x+1,y)){
			bundles.add(new Bundle(x+1, y));
			s++;
		}
		for(int i=0;i<s;i++) 
		{
			Bundle high = new Bundle((bundles.get(i)).getRow(), (bundles.get(i)).getCol());
			thisLocation = arr[high.getRow()][high.getCol()];
			if(!thisLocation.getRevealed() && !thisLocation.getState() && !thisLocation.getMarked())
			{
				if(thisLocation.getLocationValue() == 0)
				{
					thisLocation.setRevealed(true);
					//System.out.println("Alpha");
					if(checked(high.getRow()-1,high.getCol())){
						bundles.add(new Bundle(high.getRow()-1, high.getCol()));
						s++;
					}
					//System.out.println("Beta");
					if(checked(high.getRow(),high.getCol()-1)){
						bundles.add(new Bundle(high.getRow(), high.getCol()-1));
						s++;
					}
					if(checked(high.getRow(),high.getCol()+1)){
						bundles.add(new Bundle(high.getRow(), high.getCol()+1));
						s++;
					}
					if(checked(high.getRow()+1,high.getCol())){
						bundles.add(new Bundle(high.getRow()+1, high.getCol()));
						s++;
					}
					
					if(checked(high.getRow()-1,high.getCol()-1)){
						bundles.add(new Bundle(high.getRow()-1, high.getCol()-1));
						s++;
					}
					if(checked(high.getRow()-1,high.getCol()+1)){
						bundles.add(new Bundle(high.getRow()-1, high.getCol()+1));
						s++;
					}
					if(checked(high.getRow()+1,high.getCol()-1)){
						bundles.add(new Bundle(high.getRow()+1, high.getCol()-1));
						s++;
					}
					if(checked(high.getRow()+1,high.getCol()-1)){
						bundles.add(new Bundle(high.getRow()+1, high.getCol()-1));
						s++;
					}
					if(checked(high.getRow()+1,high.getCol()+1)){
						bundles.add(new Bundle(high.getRow()+1, high.getCol()+1));
						s++;
					}
					billy.setColor(Color.GRAY);
					billy.fillRect(xSet(high.getRow()), ySet(high.getCol()), 39, 39);
					showValue(high.getRow(), high.getCol());
					System.out.println("OpenFree IF");
				}
				else if(thisLocation.getLocationValue() >= 0)
				{
					billy.setColor(Color.GRAY);
					/**
					if(checked(high.getRow()-1,high.getCol()) && !arr[high.getRow()-1][high.getCol()].getState()){
						arr[high.getRow()-1][high.getCol()].setRevealed(true);
						billy.fillRect(xSet(high.getRow()-1), ySet(high.getCol()), 39, 39);
						showValue(high.getRow()-1, high.getCol());
					}
					if(checked(high.getRow(),high.getCol()-1) && !arr[high.getRow()][high.getCol()-1].getState()){
						arr[high.getRow()][high.getCol()-1].setRevealed(true);
						billy.fillRect(xSet(high.getRow()), ySet(high.getCol()-1), 39, 39);
						showValue(high.getRow(), high.getCol()-1);
					}
					if(checked(high.getRow(),high.getCol()+1) && !arr[high.getRow()][high.getCol()+1].getState()){
						arr[high.getRow()][high.getCol()+1].setRevealed(true);
						billy.fillRect(xSet(high.getRow()), ySet(high.getCol()+1), 39, 39);
						showValue(high.getRow(), high.getCol()+1);
					}
					if(checked(high.getRow()+1,high.getCol()) && !arr[high.getRow()+1][high.getCol()].getState()){
						arr[high.getRow()+1][high.getCol()].setRevealed(true);
						billy.fillRect(xSet(high.getRow()+1), ySet(high.getCol()), 39, 39);
						showValue(high.getRow()+1, high.getCol());
					}
					*/
					thisLocation.setRevealed(true);
					billy.fillRect(xSet(high.getRow()), ySet(high.getCol()), 39, 39);
					showValue(high.getRow(), high.getCol());
					System.out.println("OpenFree Else");
				}
			}
		}
	}
	public void showValue(int numX, int numY)
	{
		//System.out.println("showValue");
		int numXCoor = (numX * 40) + 50;
		int numYCoor = (numY * 40) + 80;
		int value = (MineSweeper.g).getLocalValue(numX, numY);
		if(!(value == 0)) //if(value > 0)
		{
			String locationVal = String.valueOf(value);
			billy.setColor(Color.RED);
			billy.setFont(billy.getFont().deriveFont(40.0f));
			billy.drawString(locationVal, numXCoor + 9, numYCoor + 35);
			billy.setColor(Color.GRAY);
		}
		
	}
	public boolean checked(int x, int y)
	{
		return (x>=0&&x<16&&y>=0&&y<16);
	}
	public int xSet(int rowed)
	{
		return (rowed * 40) + 50;
	}
	public int ySet(int coled)
	{
		return (coled * 40) + 80;
	}
	public void mouseAt(int xCoored, int yCoored, boolean click)
	{
		xCoor = ((xCoored - 50)/40) * 40 + 50;
		yCoor = ((yCoored - 80)/40) * 40 + 80;
		x = (xCoor- 50)/40;
		y = (yCoor- 80)/40;
		if(!click && !arr[x][y].getRevealed())
		{
			if(!arr[x][y].getMarked() && (flags >= 1))
			{
				arr[x][y].setMarked(true);
				billy.setColor(Color.RED);
				billy.fillArc(xCoor+6, yCoor-39, 60, 100, 170, 20);
				billy.fillRect(xCoor+6, yCoor+5, 5, 30);
				billy.fillRect(xCoor+4, yCoor+30, 10, 5);
				flags--;
				billy.fillArc(280, 690, 60, 100, 170, 20);
				billy.fillRect(280, 734, 5, 30);
				billy.fillRect(278, 759, 10, 5);
				billy.setColor(Color.lightGray);
				billy.clearRect(225, 723, 40, 40);
				billy.setColor(Color.BLACK);
				billy.setFont(billy.getFont().deriveFont(30.0f));
				billy.drawString(String.valueOf(flags), 230, 760);
				billy.setColor(Color.GREEN);
				if(arr[x][y].getMarked() && arr[x][y].getState())
				{
					minesLeft--;
				}
				System.out.println(minesLeft);
				if(minesLeft == 0)
				{
					billy.setColor(Color.BLACK);
					billy.fillRect(125, 320, 505, 85);
					billy.setColor(Color.MAGENTA);
					billy.setFont(billy.getFont().deriveFont(100.0f));
					billy.drawString("You Won!!!", 130, 400);
				}
			}
			else if((flags > 0) || arr[x][y].getMarked())
			{
				if(arr[x][y].getMarked() && arr[x][y].getState())
				{
					minesLeft++;
				}
				System.out.println(minesLeft);
				arr[x][y].setMarked(false);
				billy.setColor(Color.GREEN);
				billy.fillRect(xCoor, yCoor, 39, 39);
				flags++;
				billy.setColor(Color.RED);
				billy.fillArc(280, 690, 60, 100, 170, 20);
				billy.fillRect(280, 734, 5, 30);
				billy.fillRect(278, 759, 10, 5);
				billy.setColor(Color.lightGray);
				billy.clearRect(225, 723, 40, 40);
				billy.setColor(Color.BLACK);
				billy.setFont(billy.getFont().deriveFont(30.0f));
				billy.drawString(String.valueOf(flags), 230, 760);
				billy.setColor(Color.GREEN);
			}
		}
		if(click && !arr[x][y].getMarked())
		{
			//System.out.println(checked(10,16));
			//System.out.println(checked(16,10));
			//System.out.println(checked(-1,10));
			//System.out.println(checked(10,-1));
			//System.out.println("X is:" + xCoor + " Y is:" + yCoor);
			//System.out.println("MouseAt");
			//System.out.println(x + " " + y);
			if(sum == 1)
			{
				arr[x][y].setRevealed(true);
				sum++;
				System.out.println("First open");
				billy.setColor(Color.GRAY);
				billy.fillRect(xCoor, yCoor, 39, 39);
				(MineSweeper.g).placeMines();
				openFree();
				showValue(x, y);
				
				
				
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
					arr[x][y].setRevealed(true);
					billy.setColor(Color.RED);
					billy.fillRect(xCoor, yCoor, 39, 39);
					//billy.fillArc(xCoor, yCoor, 30, 30, 18, 50);
					billy.setColor(Color.BLACK);
					billy.fillRect(125, 322, 485, 85);
					billy.setColor(Color.RED);
					billy.setFont(billy.getFont().deriveFont(100.0f));
					billy.drawString("Gameover", 135, 400);
					billy.setColor(Color.RED);
					//billy.setFont(billy.getFont().deriveFont(40.0f));
					//billy.drawString("3", 50 + 9, 80 + 35);
					sum = 0;
				}
				else if(!arr[x][y].getRevealed())
				{
					arr[x][y].setRevealed(true);
					billy.setColor(Color.GRAY);
					billy.fillRect(xCoor, yCoor, 39, 39);
					showValue((xCoor-50)/40,(yCoor-80)/40);
					openFree();
				}
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
		billy.setFont(billy.getFont().deriveFont(30.0f));
		billy.drawString("MineSweeper", 280, 70);
		g.setColor(Color.RED);
		g.fillArc(280, 690, 60, 100, 170, 20);
		g.fillRect(280, 734, 5, 30);
		g.fillRect(278, 759, 10, 5);
		billy.drawString("Flags Left", 315, 760);
		billy.drawString(String.valueOf(flags), 230, 760);
		//billy.setColor(Color.BLACK);
		//billy.fillRect(125, 320, 505, 85);
		//billy.setColor(Color.MAGENTA);
		//billy.setFont(billy.getFont().deriveFont(100.0f));
		//billy.drawString("You Won!!!", 130, 400);
		//g.setColor(Color.lightGray);
		//g.clearRect(225, 723, 40, 40);
		//billy.setColor(Color.BLACK);
		//billy.fillRect(125, 322, 485, 85);
		//billy.setColor(Color.RED);
		//billy.setFont(billy.getFont().deriveFont(100.0f));
		//billy.drawString("Gameover", 135, 400);
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


