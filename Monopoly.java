import java.util.Scanner;

class Monopoly {

    

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int whoseTurn = 0;
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);

        System.out.println("Welcome to Monopoly Jr.! How many players are you? Press 2, 3 or 4");


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

        
        Player[] players = new Player[n];

        for (int i = 0; i < players.length; i++)
        {
            players[i] = new Player(i+1,(24-(n*2)));
        }

        for (int i = 0; i < players.length+1; i++)
        {
            i %= n;
            for (int k = 0; k < players.length; k++)
            {
                if (players[k].getBankBalance() >= 0)
                {
                    //Sets i value to 6 as of to break the outer for loop, and calculate the winner 
                    i = 6;
                }
            }
        }
        String[] leaderboard = new String[n];
        int[] checkedPlayers = new int[n];
        int maxValue = 0;
        int playerNumber = 0;
        for (int i = 0; i < players.length; i++)
        {
            for (int j = 0; j < players.length; j++)
            {
                if (players[j].getBankBalance() > maxValue)
                {
                    boolean doIt = true;
                    for (int k = 0; k < checkedPlayers.length; k++)
                    {
                        if (checkedPlayers[k] == players[j].getNumber())
                        {
                            doIt = false;
                        }
                    }
                    if (doIt)
                    {
                        maxValue = players[j].getBankBalance();
                        playerNumber = players[j].getNumber();
                        checkedPlayers[i] = playerNumber;
                    }
                    
                }
            }
            leaderboard[i] = "Place Number " + (i+1) + " goes to: " + "Player number " + (i+1) + ", with a balance of " + maxValue;
        }
        for (int x = 0; x < leaderboard.length; x++)
        {
            System.out.println(leaderboard[x]);
        }

        
        
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        {
            
        }
    }
}