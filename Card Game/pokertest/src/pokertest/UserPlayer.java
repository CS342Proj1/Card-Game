package pokertest;

public class UserPlayer {
	private String name;
	private Card[] handCards;
	
	public UserPlayer(Card[] cards, String name){
		this.handCards = cards;
		this.name = name;
		handCards = new Card[5];
	}
	
	public String getUserName(){
		return name;
	}
	
	public Card[] getHandCards(){
		return handCards;
	}
	
	public void setHandCards(Card[] handCards){
		this.handCards = handCards;
	}
}
