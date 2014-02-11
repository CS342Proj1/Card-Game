package pokertest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Players {
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

	static void HandEval(Players p)
	{
		System.out.println("Evaluating Hand: ");

		highCard(p);
		onePair(p);
		twoPair(p);
		threeKind(p);
		straight(p);
		flush(p);
		fullHouse(p);
		fourKind(p);
		straightFlush(p);

		System.out.println("This hand's high card: " + p.getHighCard());

		if(p.getPair() > 0)
		{
			System.out.println("This hand has a pair." + p.getPair());
    	}

		if(p.getTwoPair() > 0)
		{
			System.out.println("This hand has two pairs." + p.getTwoPair());
		}
		if(p.getThreeKind() > 0)
		{
			System.out.println("This hand has three of a kind." + p.getThreeKind());
		}
		if(p.getStraight() > 0)
		{
			System.out.println("This hand has a straight." + p.getStraight());
		}
		if(p.getFlush() > 0)
		{
			System.out.println("This hand has a flush." + p.getFlush());
     	}
		if(p.getFullHouse() > 0)
		{
			System.out.println("This hand has a full house." + p.getFullHouse());
		}
		if(p.getFourKind() > 0)
		{
			System.out.println("This hand has four of a kind." + p.getFourKind());
		}
		if(p.getStraightFlush() > 0)
		{
			System.out.println("This hand has a straight flush." + p.getStraightFlush());
		}
	}

	static void highCard(Players p)
	{
		ArrayList<Card> evalHand = p.getHandCards();
		Collections.sort(evalHand, new Comparator<Card>(){
			public int compare(Card C1, Card C2) {
					return C1.getRank() - C2.getRank();
			}});

		p.setHighCard(evalHand.get(4).getRank()+1);
	}

	static void onePair(Players p)
	{
		ArrayList<Card> evalHand =  p.getHandCards();
		ArrayList<Integer> ranks = new ArrayList<Integer>();

		for(Card C: evalHand)
		{
			ranks.add(C.getRank());
		}

		for(int i : ranks)
		{
			if(Collections.frequency(ranks , i) == 2)
			{
				p.setPair(i+1);
				return;
			}
		}


	}

	static void twoPair(Players p)
	{
		boolean p1 = false, p2 = false;
		ArrayList<Card> evalHand = p.getHandCards();

		ArrayList<Integer> ranks = new ArrayList<Integer>();

		for(Card C: evalHand)
		{
			ranks.add(C.getRank());
		}


		int rank1 = 0;
		int rank2 = 0;

		for(int i: ranks)
		{
			if(Collections.frequency(ranks,i) == 2 && p1 == false)
			{
				//p.setPair(C.getRank());
				rank1 = i;
				p1 = true;
			}

			else if(Collections.frequency(ranks,i) == 2 && i != rank1)
			{
				rank2 = i;
				p2 = true;
			}	
		}

		if(p1 == true && p2 == true)
		{
			if(rank1 > rank2)
			{
				p.setTwoPair(rank1+1);
				return;
			}

			else
			{
				p.setTwoPair(rank2+1);
				return;
			}
		}
	}

	static void threeKind(Players p)
	{
		ArrayList<Card> evalHand = ((Players) p).getHandCards();
		ArrayList<Integer> ranks = new ArrayList<Integer>();

		for(Card C: evalHand)
		{
			ranks.add(C.getRank());
		}

		for(int i : ranks)
		{
			if(Collections.frequency(ranks , i) == 3)
			{
				p.setThreeKind(i+1);
				return;
			}
		}

	}

	static void straight(Players p)
	{
		ArrayList<Card> evalHand = ((Players) p).getHandCards();
		Collections.sort(evalHand, new Comparator<Card>(){
			public int compare(Card C1, Card C2) {
					return C1.getRank() - C2.getRank();
			}});

			int straightVal = evalHand.get(0).getRank();
			int i = 0;
			for(i = 0; i < evalHand.size(); i++)
			{
				if(evalHand.get(i).getRank() != straightVal)
				{
					return;
				}
				straightVal++;
			}


			p.setStraight(straightVal-1);

	}

	static void flush(Players p)
	{
	ArrayList<Card> evalHand = ((Players) p).getHandCards();
	Collections.sort(evalHand, new Comparator<Card>(){
		public int compare(Card C1, Card C2) {
				return C1.getRank() - C2.getRank();
		}});

	ArrayList<Integer> suits = new ArrayList<Integer>();

	for(Card C: evalHand)
	{
		suits.add(C.getSuit());
	}

	int suit = evalHand.get(0).getSuit();

		if(Collections.frequency(suits , suit) == 5)
		{
			p.setFlush(evalHand.get(4).getRank()+1);
			return;
		}



	}

	static void fullHouse(Players p)
	{
		if(p.getThreeKind() > 0 && p.getPair() > 0)
		{
			p.setFullHouse(p.getThreeKind());
			return;
		}
	}

	static void fourKind(Players p)
	{
		ArrayList<Card> evalHand = ((Players) p).getHandCards();
		ArrayList<Integer> ranks = new ArrayList<Integer>();

		for(Card C: evalHand)
		{
			ranks.add(C.getRank());
		}

		for(int i : ranks)
		{
			if(Collections.frequency(ranks , i) == 4)
			{
				p.setFourKind(i+1);
				return;
			}
		}
	}


	static void straightFlush(Players p)
	{
		if(p.getFlush() > 0 && p.getStraight() > 0)
		{
			p.setStraightFlush(p.getStraight());
			return;
		}
	}
}

