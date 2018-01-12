import java.util.ArrayList;



public class Table {

	private static final int MAXPLAYER = 4;
	private Deck allDeck;	//存放所有的牌
	private Player[] allPlayer;//存放所有玩家
	private Dealer ADealer;	//存放莊家
	private int[] pos_betArray;	//存放每個玩家在一局內下的注
	private ArrayList<Card>  faceupcard;
	
	public Table(int nDeck) {
		// TODO Auto-generated constructor stub
		allDeck = new Deck(nDeck);
		allPlayer = new Player[MAXPLAYER];
		
	}
	public void set_player(int pos, Player p) {
		// TODO Auto-generated method stub		
		allPlayer[pos] = p;
	}
	public Player[] get_player() {
		// TODO Auto-generated method stub
		return allPlayer;
	}
	public void set_dealer(Dealer d) {
		// TODO Auto-generated method stub
		ADealer=d;
		
	}
	public Dealer get_Dealer(){
		return ADealer;
	}
	public Card get_face_up_card_of_dealer(){
		
		return faceupcard.get(1);
	}
	private void ask_each_player_about_bets() {
		// TODO Auto-generated method stub
		pos_betArray = new int[allPlayer.length];
		for (Player p:allPlayer){
			p.sayHello();
		}
		for (int i = 0;i < pos_betArray.length;i++){
			pos_betArray[i] = allPlayer[i].makeBet();
		}
	}
	private void calculate_chips() {
		// TODO Auto-generated method stub
		int DTotal = ADealer.getTotalValue();
		System.out.println("Dealer's card value is "+ DTotal+"Cards:");
		ADealer.printAllCard();
		for(int p = 0;p<allPlayer.length;p++){
			int PTotal = allPlayer[p].getTotalValue();
			Player player = allPlayer[p];
			System.out.println(player.getName()+"card value is"+PTotal);
			if((PTotal>21||PTotal<DTotal)&&DTotal<=21 ){
				player.increaseChips(-pos_betArray[p]);
				System.out.println("Loss"+pos_betArray[p]+"chips,the chip now is "+player.getCurrentChips());
			}else if((DTotal>21||DTotal<PTotal)&&PTotal<=21 ){
				player.increaseChips(pos_betArray[p]);
				System.out.println("Win"+pos_betArray[p]+"chips,the chip now is "+player.getCurrentChips());
			}else if((DTotal>21&&PTotal>21)||(DTotal==PTotal)){
				System.out.println("chip is no change,the chip now is "+player.getCurrentChips());
			}
					
		}
	}
	private void ask_dealer_about_hits() {
		// TODO Auto-generated method stub
		boolean hit = false;
		if (ADealer.getTotalValue()<=21){
			hit = ADealer.hit_me(this);
			if(hit){
				faceupcard.add(allDeck.getOneCard(true));
				ADealer.setOneRoundCard(faceupcard);
			}else {
				hit = false;
			}
			
		}else{
			hit = false;
			System.out.println("Dealer's hit is over");
		}
	}
	private void ask_each_player_about_hits() {
		// TODO Auto-generated method stub
		boolean hit = false;
		for(Player p:allPlayer){
			if (p.getTotalValue()<=21){
				hit = p.hit_me(this);
				if (hit){
					ArrayList<Card> Pcard= new ArrayList<Card>();
					p.setOneRoundCard(Pcard);
					Pcard.add(allDeck.getOneCard(true));
					p.setOneRoundCard(Pcard);
					System.out.println("hit");
					System.out.println(p.getName()+"'s card now");
					p.printAllCard();
				}else{
					System.out.println("Pass hit");
				}
				
			}else {
				hit = false;
			}
		}
	}
	
	private void distribute_cards_to_dealer_and_players() {
		// TODO Auto-generated method stub
		faceupcard = new ArrayList<Card>();
		for(int c = 0;c<allPlayer.length;c++){
			ArrayList<Card> Pcard= new ArrayList<Card>();
			Pcard.add(allDeck.getOneCard(true));
			Pcard.add(allDeck.getOneCard(true));
			allPlayer[c].setOneRoundCard(Pcard);
		}
		faceupcard.add(allDeck.getOneCard(true));
		faceupcard.add(allDeck.getOneCard(false));
		ADealer.setOneRoundCard(faceupcard);
		System.out.println("Dealer's face up card is " + faceupcard );
	}


	public void play(){
		ask_each_player_about_bets();
		distribute_cards_to_dealer_and_players();
		ask_each_player_about_hits();
		ask_dealer_about_hits();
		calculate_chips();
	}

	public int[] get_palyers_bet() {
		// TODO Auto-generated method stub
		
		return pos_betArray;
	}


	



}

