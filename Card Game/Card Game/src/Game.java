
public class Game {
	
	private int rank, suit;
	
	private static String[] suits = {"H","S","D","C"};
	private static String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	Card(int suit, int rank)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getRank()
	{
		return rank;
	}
	
	public int getSuit()
	{
		return suit;
	}

}
