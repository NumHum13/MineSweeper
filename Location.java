package minePackage;

import java.awt.Graphics;

public class Location {
	private int row;
	private int col;
	//is there a mine here
	private boolean state;
	//has it been revealed by the player
	private boolean revealed;
	//did the player flag it
	private boolean marked;
	//what is the location's value
	private int locationValue;
	
	//construtor, automatically doesn't lpace any mines
	public Location()
	{
		//ToDo
	}
	public int getRow()
	{
		return row;
	}
	public int getCol()
	{
		return col;
	}
	public void setState(boolean state)
	{
		this.state = state;
	}
	public boolean getState()
	{
		return state;
	}
	public void setRevealed(boolean revealed)
	{
		this.revealed = revealed;
	}
	public boolean getRevealed()
	{
		return revealed;
	}
	public void setMarked(boolean marked)
	{
		this.marked = marked;
	}
	public boolean getMarked()
	{
		return marked;
	}
	public void setLocationValue(int locationValue)
	{
		this.locationValue = locationValue;
	}
	public int getLocationValue()
	{
		return locationValue;
	}
}
