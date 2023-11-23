import java.util.Scanner;

class Monopoly {

    

    public static void main(String[] args) {
        System.out.println("Welcome to Monopoly Jr.! How many players are you? Press 2, 3 or 4");
        Scanner s = new Scanner(System.in);
        var gameBoard = Gameboard.getTilesFromFile("tiles");
        Dice dice = new Dice(6);
        int die1;
        int die2;
        while (true)
        {
            try
            {
                int n;
                if (s.hasNextInt())
                {
                    n = s.nextInt();
                }
                else
                {
                    throw new IllegalArgumentException("Didnt recieve an integer, Please enter an integer between 2 and 4");
                }

            if (n<2 || n>4)
            {
                throw new IllegalArgumentException("Recieved an invalid amount: Please pick an integer between 2 and 4!");
            }

            // Creates array of players with given length;
            Player[] players = new Player[n];

            for (int i = 0; i < players.length; i++)
            {
                players[i] = new Player(i+1,(24-(n*2)));
            }
            // Main game loop:
            int playerTurn = 0;
            Player activePlayer;
            boolean loseCondition = false;
            while (!loseCondition)
            {
                playerTurn %= n;
                activePlayer = players[playerTurn];
                
                die1 = dice.roll();
                die2 = dice.roll();
                System.out.println(activePlayer.getPosition());
                System.out.println(die1 + " " + die2);
                activePlayer.setPosition(activePlayer.getPosition() + die1 + die2);
                System.out.println(gameBoard[activePlayer.getPosition()].getDescription());
                
                if (die1 != die2)
                {
                    playerTurn++;
                }
                
                for (int k = 0; k < players.length; k++)
                {
                    if (players[k].getBankBalance() <= 0)
                    {
                        // Breaks to calculate the winner(s);
                        loseCondition = true;
                    }
                }
            }

            // Game has ended and we will now calculate the winner(s);

            Player[] leaderboard = new Player[n];
            int[] sharedPlaces = new int[n];
            for (int i = 0; i < players.length; i++)
            {
                s.next();
                int higherAmount = 0;
                for (int k = 0; k < players.length; k++)
                {
                    if (players[i].getBankBalance() < players[k].getBankBalance() && i!=k)
                    {
                        higherAmount++;
                        
                    }


                    if (k == players.length-1 && leaderboard[higherAmount] == null)
                    {
                        leaderboard[higherAmount] = players[i];
                    }
                    else if (leaderboard[higherAmount] != null)
                    {
                        for (int j = higherAmount; j < leaderboard.length; j++)
                        {
                            if (leaderboard[j] == null)
                            {
                                leaderboard[j] = players[i];
                                sharedPlaces[j] = players[i].getBankBalance();
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < leaderboard.length; i++)
            {
                boolean share = false;
                for (int k = 0; k < sharedPlaces.length; k++)
                {
                    if (leaderboard[i].getBankBalance() == sharedPlaces[k])
                    {
                        share = true;
                    }
                }
                if (!share)
                {
                    System.out.println("Place "+ (i+1) + " goes to player: " + leaderboard[i].getNumber() + " with a score of: "  + leaderboard[i].getBankBalance());
                }
                else
                {
                    String sharedStatement = "Place number " + (i+1) + " is shared by players: " + (i+1); 
                    for (int x = (i+1); x < leaderboard.length; x++)
                    {
                        sharedStatement += ", " + (x+1);
                        i++;
                    }
                    System.out.println(sharedStatement);
                }
                    
                
            }
            
            
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
                s.next();
                continue;
            }
            s.close();
            break;
        }
        
    }
}