import java.util.Scanner;

class Monopoly {

    

    public static void main(String[] args) {
        System.out.println("Welcome to Monopoly Jr.! How many players are you? Press 2, 3 or 4");
        Scanner s = new Scanner(System.in);
        Field[] gameBoard = Gameboard.getTilesFromFile("tiles.csv");
        Dice dice = new Dice(6);
        int die1;
        int die2;
        while (true)
        {
            try
            {
                
                int n;

                String input = s.nextLine(); // Read the entire line and remove leading/trailing whitespaces

                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Didnt recieve an integer, Please enter a number between 2 and 4");
                }
                try
                {
                    n = Integer.parseInt(input);
                }
                catch (Exception e)
                {
                    throw new IllegalArgumentException("Didnt recieve an integer, Please enter a number between 2 and 4");
                }
            

            if (n<2 || n>4)
            {
                throw new IllegalArgumentException("Recieved an invalid amount: Please pick a number between 2 and 4!");
            } 
            

            // Creates array of players with given length;
            Player[] players = new Player[n];

            

            for (int i = 0; i < players.length; i++)
            {
                players[i] = new Player(i+1,(24-(n*2)));
            }
            int playerTurn = 0;
            Player activePlayer;
            boolean loseCondition = false;
            //
            //
            // Main game loop:
            //
            //
            while (!loseCondition)
            {
                //System.out.println(gameBoard.getString(players));
                System.out.println("\n");
                
                playerTurn %= n;
                System.out.println("It is player number " +(playerTurn+1)+" turn, press enter to roll the dice:");
                //s.nextLine();
                activePlayer = players[playerTurn];
                
                if (activePlayer.getSkipPlayerTurn())
                {
                    System.out.println("Your turn is skipped.");
                    playerTurn++;
                    continue;
                }

                if (activePlayer.getIsInPrison())
                {
                    System.out.println("You are in prison, and must therefore pay 1$ to continue playing");
                    activePlayer.setBankBalance(-1);
                    System.out.println("Your balance is now, " + activePlayer.getBankBalance()+ "$");
                    if (activePlayer.getBankBalance()==0)
                    {
                        break;
                    }
                    else
                    {
                        activePlayer.changeIsInPrison();
                        playerTurn++;
                        continue;
                    }
                }

                die1 = dice.roll();
                die2 = dice.roll();
                //System.out.println(activePlayer.getPosition());
                //System.out.println(die1 + " " + die2);
                activePlayer.setPosition(activePlayer.getPosition() + die1 + die2);
                System.out.println(gameBoard[activePlayer.getPosition()].getDescription(activePlayer,players,gameBoard,false));
                
                
                if (die1 != die2)
                {
                    playerTurn++;
                }
                else
                {
                    System.out.println("You rolled two " + die1 + "\n It is therefore your turn again");
                }
                
                for (int k = 0; k < players.length; k++)
                {
                    if (players[k].getBankBalance() == 0)
                    {
                        // Breaks to calculate the winner(s);
                        loseCondition = true;
                    }
                }
                for (int j = 0; j < gameBoard.length-1; j++)
                {
                    if (gameBoard[j].getOwner()!=null && gameBoard[j+1].getOwner() != null)
                    {
                        if (gameBoard[j].getOwner().equals(gameBoard[j+1].getOwner()))
                        {
                            gameBoard[j].setMultiplier(2);
                        }
                    }
                }
                
            }
            System.out.println(LeaderBoard.printWinner(players,n,gameBoard));
            
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
                //s.next();
                continue;
            }
            s.close();
            break;
        }
        
    }
}