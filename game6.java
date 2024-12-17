import java.util.Scanner;

class GameOperation

{
	int player=0;
  int turn=0;
  int counter=0;
  String game[] = {"1","2","3","4","5","6","7","8","9"};
	
  
  boolean winstatus()
  {
	  int localcounterO=0, localcounterX=0;
	  int win1[][] = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
	  
	  for(int i[]: win1)
	  {
		  for (int j: i)
		  {
			  if ( game[j-1] == "O" )
			  {
				  localcounterO++;
				  }
			  else if (game[j-1] =="X" )
			  {
				  localcounterX++;
				  }
		  }
		  if (localcounterO ==3 ||localcounterX ==3 )
		  {return true;}
		  else
	  {localcounterO = 0;
	  localcounterX = 0;}
	 
	  }
	  
 return false; 
 }
  
  void update(String newUpdate)
	{
	  int integerUpdate = Integer.valueOf(newUpdate);
	  
	  //System.out.println("integerUpdate: \n"+ integerUpdate);
	  
		  if (!(game[integerUpdate-1].equals("X")) && !(game[integerUpdate-1].equals("O")))
		  {
	  	
		  for (int i=0; i<game.length; i++)
		{
			 
			if (newUpdate.equals(game[i]) && (turn%2==0) )
			{
				 
				game[i] = "O";
				 turn++;
			}
			else if ( newUpdate.equals(game[i])  && (turn%2!=0))
			{
				 
				game[i] = "X";
				 turn++;
			}
			
			
		}
		  }
		  
		  else 
		  {
			  System.out.println("Enter at a valid space, try again!!!\n");
		  }
		
		
			print();
	}
  
  void print()
	{
		for (int i=0; i<game.length; i++)
		{
			System.out.print("\t"+game[i]+"\t|");
			counter++;
			if (counter==3)
			{System.out.println("");
			counter=0;}
		}
	}
}

public class game6
 {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean checkStatus= false;
		GameOperation object = new GameOperation();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Let's play Tic-Tac-Toe\n"
				+ "Player1: O and Player2: X\n");
		object.print();
				 
				try {
				
				while(object.turn<9 && checkStatus== false)
				{
					if (object.turn%2==0)
					{System.out.println("Player1 turn: ");
					object.player = 0;}
					else if(object.turn%2!=0)
					{System.out.println("Player2 turn: ");
					object.player = 1;}
					object.update(String.valueOf(input.nextInt()));
					
				checkStatus= object.winstatus();
				
				if ((checkStatus == true) && (object.player == 1))
				{System.out.println("Player2 WINS");
				break;}
				
				else if ((checkStatus == true) && (object.player == 0))
				{System.out.println("Player1 WINS");
				break;}
				
				else if(object.turn==9)
				{System.out.println("It's a DRAW");
					break;}
				
				}
				}
				
				catch (Exception mismatch)
				{System.out.println("Enter only integers from 1 to 9...");}
				
	}

}