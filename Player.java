import java.util.ArrayList;


public  class Player extends Person{
	private String name;
	private int chips;
	private int bet;
	
	
	public Player(String name , int chips){
		this.name = name;
		this.chips = chips;
	}
	


	public String getName(){
		
		return name;
	}
	
	
	
	public int makeBet(){
		
		if(chips>0 && chips>bet){
			bet=20;
		}else{
			bet=0;
		}
		return bet;
	}
	

	public boolean hitMe(Table tbl){
		int total_value = getTotalValue();
		
		
		
		if (total_value >= 21) {
			return false;
		}else if(total_value==18 && hasAce()){		
			return true;
		}else if(total_value==19 && hasAce()){			
			return true;
		}
		else if(total_value>=18){
			return false;
		}

			
		else {
//			hitNum++;
			return true;
		}
		
		
	}
	

	
	public int getCurrentChips(){
		chips = (chips - bet);
		return chips;
	}
	
	public void increaseChips (int diff){
		
	}

	
	public boolean hit_me(Table table) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void sayHello(){
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
	}

}
