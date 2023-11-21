import java.util.Scanner;

class Monopoly {

    

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int whoseTurn = 0;
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);
        //giTile[] tiles = Tile.getTilesFromFile(Tiles.java);

        System.out.println("Welcome to Monopoly Jr.! How many players are you? Press 2, 3 or 4");
        try{
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
            System.out.println(players[i].getBankBalance());
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