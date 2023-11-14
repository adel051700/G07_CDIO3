import java.util.Scanner;

class Monopoly {

    static Player[] players = new Player[n];

    public static int getAmountofplayers() {
        return players.length;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int whoseTurn = 1;
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);
        Tile[] tiles = Tile.getTilesFromFile(Gameboard.java);

        System.out.println("Welcome to Monopoly Jr.! How many players are you? Press 2, 3 or 4");

        int numberOfPlayers = s.nextLine();
        // We need to integrade this above method so it uses the getAmountOfPlayers
        // method. Also we need to set boundaries and exceptions.
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        if (numberOfPlayers == 3) {
            Player player3 = new Player(3);
        } else if (numberOfPlayers == 4) {
            Player player4 = new Player(4);
        }

        
    }

}