package minePackage;

public class Location {
	private boolean state;
	private boolean revealed;
	private boolean marked;
	private int locationValue;
	
	public Location()
	{
		state = false;
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
		if(revealed && state)
		{
			System.out.println("There is a mine here");
		}
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
