import java.util.ArrayList;
import java.util.Random;


public class Deck {
	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard;
	private ArrayList<Card> openCard;
	public int nUsed;
	
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		usedCard = new ArrayList<Card>();
		openCard = new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int i =0;i < nDeck; i++)
			{
			for (Card.Suit s : Card.Suit.values())	
				{
				for(int y = 1;y<14;y++)
					{
						Card card = new Card (s,y);
						cards.add(card);
						
					}
				}
				
			}
			shuffle();

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		
		for (Card Pcard:cards)
		{
			Pcard.printCard();
		}

			
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
	public Card getOneCard(boolean isOpened) {
		// TODO Auto-generated method stub
		Card getCard;
		getCard = cards.get(0);
				
		usedCard.add(getCard);
		cards.remove(getCard);
		nUsed++;
		if (cards.size()==0)
		{
			shuffle();
		}
		return getCard;
	}
	public ArrayList getOpenedCard(){
		boolean isOpened = false;
		Card getOpenCard;
		getOpenCard = getOneCard(isOpened);
		if (isOpened=true){
			openCard.add(getOpenCard);
		}
		return openCard;
	}

	public void shuffle() {
		// TODO Auto-generated method stub
		Random ran = new Random(); 
		if(nUsed>0)
		{
			for(Card C:usedCard)
				{
					cards.add(C);
				}
		}
		
		
		for(int a =0;a<cards.size();a++)
			{
				int b = ran.nextInt(cards.size());
				Card c = cards.get(b);
				cards.set(b,cards.get(a));
				cards.set(a, c);
			}
		
		usedCard.clear();
		openCard.clear();
		nUsed = 0;
	}
}

