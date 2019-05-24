package minePackage;

public class Grid {
	//the static 2D array of Location objects
	private static Location[][] arr;
	//row size of minesweeper
	private int numRows;
	//col size of minesweeper, don't actually change the graphics size.
	private int numCols; //should both equal 16
	int numMines;
	private int mouseX;
	private int mouseY;
	
	public Grid(int numRows, int numCols,int numMines)
	{
		this.numRows = numRows; //numRows = 16
		this.numCols = numCols;  //numCols = 16
		this.numMines = numMines;   //numMines = 40
		arr = new Location[numRows][numCols];
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				arr[i][j] = new Location();
			}
		}
	}
	
	public void placeMines()
	{
		int randRow;
		int randCol;
		//randomly places the mines around the map
		for(int r = 0; r < numMines; r++)
		{
			randRow = (int)(Math.random() * numRows);
			randCol = (int)(Math.random() * numCols);
			if(!arr[randRow][randCol].getRevealed() && !arr[randRow][randCol].getState())
			{
				arr[randRow][randCol].setState(true);
			}
			else
			{
				r--;
			}
		}
	}
	public Location[][] getArr()
	{
		return arr;
	}
	//computes and sets the value of each location by computing how many mines are near it
	public void setLocalValue(int row, int col)
	{
		int sum = 0;
		if(!arr[row][col].getState())
		{
			for(int rowValue = row - 1; rowValue <= row + 1; rowValue++)
			{
				for(int colValue = col - 1; colValue <= col + 1; colValue++)
				{
					if(rowValue > 0 && rowValue < numRows && colValue > 0 && colValue < numCols)
					{
						if(arr[rowValue][colValue].getState())
						{
							sum++;
						}
					}
				}
					
			}
		}
		else 
		{
			//just a placeholder
			System.out.println("There is a mine here!");
		}
		arr[row][col].setLocationValue(sum);
	}
}
