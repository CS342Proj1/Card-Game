package pokertest;
import java.util.ArrayList;
import java.util.Collections;


public class player {
	private ArrayList<Card> handCards = new ArrayList<Card>();
	private ArrayList<Integer> score = new ArrayList<Integer>();
	private int topScore;
	
	private int highCard;
	private int pair;
	private int twoPair;
	private int threeKind;
	private int straight;
	private int flush;
	private int fullHouse;
	private int fourKind;
	private int straightFlush;
	
	
	void setAllZero() //Reset hand after discarding cards, for safety
	{
		setHighCard(0);
		setPair(0);
		setTwoPair(0);
		setThreeKind(0);
		setStraight(0);
		setFlush(0);
		setFullHouse(0);
		setFourKind(0);
		setStraightFlush(0);
	}
	
	
	

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




	public ArrayList<Integer> getScore() {
		return score;
	}




	public void setScore(ArrayList<Integer> score) {
		this.score = score;
	}




	public int getTopScore() {
		return topScore;
	}




	public void setTopScore(int topScore) {
		this.topScore = topScore;
	}

	
	

}
