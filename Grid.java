package minePackage;

public class Grid {
	private Location[][] matrix;
	private int numRows;
	private int numCols;
	int numMines;
	
	public Grid(int numRows, int numCols,int numMines)
	{
		this.numRows = numRows;
		this.numCols = numCols;
		this.numMines = numMines;
		matrix = new Location[numRows][numCols];
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				matrix[i][j] = new Location();
			}
		}
		int randRow;
		int randCol;
		for(int r = 0; r < numMines; r++)
		{
			randRow = (int)(Math.random() * numRows);
			randCol = (int)(Math.random() * numCols);
			matrix[randRow][randCol].setState(true);
		}
	}
	public void setLocalValue(int row, int col)
	{
		int sum = 0;
		if(!matrix[row][col].getState())
		{
			for(int rowValue = row - 1; rowValue <= row + 1; rowValue++)
			{
				for(int colValue = col - 1; colValue <= col + 1; colValue++)
				{
					
				}
					
			}
		}
		else
		{
			System.out.println("There is a mine here!");
		}
	}
}
