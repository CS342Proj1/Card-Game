package pokertest;
import java.util.ArrayList;
import java.util.Collections;

public class Players {
	
		private ArrayList<Card> handCards = new ArrayList<Card>();

		public ArrayList<Card> getHandCards() {
			return handCards;
		}

		public void setHandCards(ArrayList<Card> handCards) {
			this.handCards = handCards;
		}
		
		
		/*Collections.sort(handCards, new Comparator<Card>(){
			@Override
			public int compare(Card handCards1, Card handCards2){
				return handCards1.getRank().compareTo(handCards2.getRank());
			}
		});*/

}

