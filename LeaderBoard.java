class LeaderBoard 
{
    public static String printWinner(Player[] players, int n, field[] gameBoard)
    {
        String returnStatement = "";
        java.util.Scanner s = new java.util.Scanner(System.in);
        Player[] leaderboard = new Player[n];
        int[] sharedPlaces = new int[n];
        for (int i = 0; i < players.length; i++)
        {
            int higherAmount = 0;
            for (int k = 0; k < players.length; k++)
            {
                if (players[i].getBankBalance() < players[k].getBankBalance())
                {
                    higherAmount++;
                }
                if (k == players.length-1 && leaderboard[higherAmount] == null)
                {
                    
                    leaderboard[higherAmount] = players[i];
                }
                else if (leaderboard[higherAmount] != null)
                {
                    for (int x = 0; x < gameBoard.length; x++)
                    {
                        if (gameBoard[x].getOwner()!=null)
                        {
                            if (gameBoard[x].getOwner().equals(players[i]))
                        {
                            
                            players[i].setBankBalance(gameBoard[x].getValue());
                        }
                        }
                        
                    }
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
                returnStatement += "\nPlace "+ (i+1) + " goes to player: " + leaderboard[i].getNumber() + " with a score of: "  + leaderboard[i].getBankBalance();
            }
            else
            {
                String sharedStatement = "Place number " + (i+1) + " is shared by players: " + (i+1); 
                for (int x = (i); x < leaderboard.length; x++)
                {
                    if (leaderboard[x].getBankBalance() != leaderboard[i].getBankBalance())
                    {
                        break;
                    }
                    sharedStatement += ", " + (x+1);
                    i++;
                }
                returnStatement += sharedStatement + "\n with a score of: " + leaderboard[i-1].getBankBalance();
            }
                
            
        }
        return returnStatement;
    }
}
