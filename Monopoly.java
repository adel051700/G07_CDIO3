import java.util.Scanner;

class Monopoly {

    

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int whoseTurn = 0;
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);
        Tile[] tiles = Tile.getTilesFromFile(Tiles.java);

        System.out.println("Welcome to Monopoly Jr.! How many players are you? Press 2, 3 or 4");

        int n = s.nextInt();
        if (n<2 || n>4)
        {
            
        }
        Player[] players = new Player[n];

        for (int i = 0; i < players.length; i++)
        {
            players[i] = new Player(i+1,24-(n*2));
        }
        
    }
}