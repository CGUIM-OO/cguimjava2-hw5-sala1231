
public class Card {
	
	enum Suit {Clubs, Diamonds, Hearts, Spades}	
	private int rank; //1~13
	private Suit Suit;
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(Suit s,int r){
		Suit=s;
		rank=r;	
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		String PokerSuit = null ;
		String PokerRank = null;
		Integer R = rank;
		
		switch(Suit){
			case Clubs:
				PokerSuit = "Clubs";
				break;
				
			case Diamonds:
				PokerSuit = "Diamonds";
				break;
				
			case Hearts:
				PokerSuit = "Hearts";
				break;
			
			case Spades:
				PokerSuit = "Spades";
				break;
			
		}
	
		if (rank == 1)
			{
				PokerRank = "Ace";
			}
		else if(rank == 11)
			{
				PokerRank ="Jack";
			}
		else if(rank == 12)
			{
				PokerRank ="Queen";
			}
		else if(rank == 13)
			{
				PokerRank ="King";
			}
		else
			{
				PokerRank = R.toString();
			}
	
		System.out.println(PokerSuit + PokerRank);
	}
	public Suit getSuit(){
		return Suit;
	}
	public Integer getRank(){
		return rank;
	}

}
