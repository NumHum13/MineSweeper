package minePackage;

public class Location {
	//is there a mine here
	private boolean state;
	//has it been revealed by the player
	private boolean revealed;
	//did the player flag it
	private boolean marked;
	//what is the location's value
	private int locationValue;
	
	//construtor, automatically does put any mines anywhere
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
