package pokertest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OpponentPlayer extends player {
	
	private boolean oneCard = false;
	private boolean twoCards = false;
	private boolean threeCards = false;
	private boolean fourCards = false;
	
	
	
	void aiRunner()
	{
		hasPair();
		
		if(hasPair() == false)
		{
			highCard();
			
			if(highCard() == false)
			{
				sequence();
				
				if(sequence() == false)
				{
					discardFour();
					if(discardFour() == false)
					{
					keepTwo();
					}
				}
			}
		}
	}
	
	
	
	

	
	boolean hasPair()
	{

		if(this.getPair() > 0 ) //If has a pair.
		{
			
			for(int x = 0; x < this.getHandCards().size(); x++)
			{
				
				if(this.getFourKind() > 0 && this.getHandCards().get(x).getRank() != (this.getFourKind() - 1))
				{
					this.getHandCards().remove(x);  //remove card if not part of pair.
				    x = 0;
					setOneCard(true);
				}
				
				if(this.getThreeKind() > 0 && this.getHandCards().get(x).getRank() != (this.getThreeKind() - 1))
				{
					this.getHandCards().remove(x);  //remove card if not part of pair.
					x = 0;
					setTwoCards(true);
				}
				
				if(this.getHandCards().get(x).getRank() != (this.getPair() - 1)) 
				{
					this.getHandCards().remove(x);  //remove card if not part of pair.
					x = 0;
					setThreeCards(true);
				}
				
				
			
			
			
		}
		return true;
	}
		return false;
}

	
	boolean highCard()
	{
		boolean highCardOnly = false;
		boolean fourSuit = false;
		int suitVal = 0;
		int index = 0;


		ArrayList<Integer> suits =  new ArrayList<Integer>();
		
		
		for(Card C : this.getHandCards())
		{
			suits.add(C.getSuit());
		}
		
		
		if(this.getPair() < 1 && this.getTwoPair() < 1 && this.getThreeKind() < 1 && this.getStraight() < 1 && this.getFlush() < 1 && this.getFourKind() < 1 ) //Check if Hand evaluates to High Card only
		{
			highCardOnly = true;
		}
		
		for(int i : suits)
		{
			if(Collections.frequency(suits,i) == 4) //Check if hand has 4 cards of the same suit
			{
				fourSuit = true; 
				suitVal = i;
			}
		}
		
		if(highCardOnly && fourSuit) //If previous two are true then remove the card of different suit
		{
			for(int x = 0; x < this.getHandCards().size(); x++)
			{
				if(this.getHandCards().get(x).getSuit() != suitVal)
				{
					this.getHandCards().remove(index);
					x--;
					setOneCard(true);
				}
				
				index++;
			}
			
			return true;
		}
		
		return false;
		
		
	}
	
	boolean sequence()
	{
	
		ArrayList<Integer> seq = new ArrayList<Integer>();
		
		Collections.sort(this.getHandCards(), new Comparator<Card>(){
			public int compare(Card C1, Card C2) {
					return C1.getRank() - C2.getRank();
			}});
		
		for(Card C : this.getHandCards())
		{
			seq.add(C.getRank());
		}
		

		if(seq.get(4) == seq.get(3) + 1)
		{
			if(seq.get(3) == seq.get(2) + 1)
			{
				if(seq.get(2) == seq.get(1) + 1)
				{
					this.getHandCards().remove(0);
					setOneCard(true);
					return true;
				}
			}
		}
		
		else if(seq.get(3) == seq.get(2) + 1)
		{
			if(seq.get(2) == seq.get(1) + 1)
			{
				if(seq.get(1) == seq.get(0) + 1)
				{
					this.getHandCards().remove(4);
					setOneCard(true);
					return true;
				}
			}
		}
		
		return false;
		
	}

	boolean checkAce(player p) //Helper function to check if hand contains an Ace
	{
		ArrayList<Card> evalHand =  p.getHandCards();
		
		for(Card C : evalHand)
		{
			if(C.getRank() == 12)
			{
				return true;
			}
		}
		return false;
		
	}
	
	
	boolean discardFour() // Discard other four cards if hand contains an Ace
	{

		
		if(checkAce(this) == true)
		{
			
			
			for(int x = 0; x < this.getHandCards().size() ; x++)
			{
				if(this.getHandCards().get(x).getRank() != 12)
				{
					this.getHandCards().remove(x);
					x--;
				}

			}
			setFourCards(true);
			return true;
		}
		return false;
	}
	
	boolean keepTwo()
	{
		if(hasPair() == false && highCard() == false && checkAce(this) == false) //If none of the above
		{
			Collections.sort(this.getHandCards(), new Comparator<Card>(){
				public int compare(Card C1, Card C2) {
						return C1.getRank() - C2.getRank();
				}});
			
			this.getHandCards().remove(0);  //keep the top two ranked cards
			this.getHandCards().remove(0);
			this.getHandCards().remove(0);
			
			setThreeCards(true);
			return true;
		}
		
		return false;
		
	}



	public boolean isThreeCards() {
		return threeCards;
	}


	public void setThreeCards(boolean threeCards) {
		this.threeCards = threeCards;
	}



	public boolean isFourCards() {
		return fourCards;
	}



	public void setFourCards(boolean fourCards) {
		this.fourCards = fourCards;
	}

	public boolean isTwoCards() {
		return twoCards;
	}


	public void setTwoCards(boolean twoCards) {
		this.twoCards = twoCards;
	}


	public boolean isOneCard() {
		return oneCard;
	}


	public void setOneCard(boolean oneCard) {
		this.oneCard = oneCard;
	}
	
	
}
