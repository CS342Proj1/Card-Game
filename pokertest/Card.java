/**
 * 
 */
/**
 * @author tong
 *
 */
package pokertest;



//import java.util.*;
public class Card
{

    private int rank, suit, color;

 

    private static String[] suits = { "C","D","H","S"};
	private static String[] ranks= { "2","3","4","5","6","7","8","9","T","J","Q","K","A"};
	private static String[] colors = {"Red","Black"};

    Card(int suit, int rank)
    {

        this.rank=rank;

        this.suit=suit;
    
    }

    public @Override String toString()
    {

          return ranks[rank] + suits[suit];
    }

    public int getRank() {

         return rank;

    }

    public int getSuit() {

        return suit;

    }

    public int getColor ()
    {
      if ( suit == 1 || suit == 2)
         return 0;  // red
      else
         return 1;  // black
    }

	public void setColor(int color) {
		this.color = color;
	}
    
}//end of class

	

