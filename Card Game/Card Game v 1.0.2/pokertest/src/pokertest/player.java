package pokertest;
import java.util.ArrayList;
import java.util.Collections;


public class player {
	private ArrayList<Card> handCards = new ArrayList<Card>();
	
	private int highCard;
	private int pair;
	private int twoPair;
	private int threeKind;
	private int straight;
	private int flush;
	private int fullHouse;
	private int fourKind;
	private int straightFlush;
	
	
	

	public ArrayList<Card> getHandCards() {
		return handCards;
	}

	public void setHandCards(ArrayList<Card> handCards) {
		this.handCards = handCards;
	}

	public int getStraightFlush() {
		return straightFlush;
	}

	public void setStraightFlush(int straightFlush) {
		this.straightFlush = straightFlush;
	}

	public int getFourKind() {
		return fourKind;
	}

	public void setFourKind(int fourKind) {
		this.fourKind = fourKind;
	}

	public int getFullHouse() {
		return fullHouse;
	}

	public void setFullHouse(int fullHouse) {
		this.fullHouse = fullHouse;
	}

	public int getFlush() {
		return flush;
	}

	public void setFlush(int flush) {
		this.flush = flush;
	}

	public int getStraight() {
		return straight;
	}

	public void setStraight(int straight) {
		this.straight = straight;
	}

	public int getThreeKind() {
		return threeKind;
	}

	public void setThreeKind(int threeKind) {
		this.threeKind = threeKind;
	}

	public int getPair() {
		return pair;
	}

	public void setPair(int pair) {
		this.pair = pair;
	}

	public int getHighCard() {
		return highCard;
	}

	public void setHighCard(int highCard) {
		this.highCard = highCard;
	}

	public int getTwoPair() {
		return twoPair;
	}

	public void setTwoPair(int twoPair) {
		this.twoPair = twoPair;
	}

	
	

}
