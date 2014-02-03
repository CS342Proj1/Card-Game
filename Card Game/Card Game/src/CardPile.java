
import java.util.Random;


public class CardPile {
	private Card[] cards;
	int i;
	
	CardPile()
	{
		i = 51; 
		cards = new Card[52];
		int x = 0;
		
		for(int a = 0; a <= 3; a++)
		{
			for(int b = 0;b<=12;b++)
			{
				cards[x] = new Card(a,b);
				x++;
			}
		}
		
	}
}

