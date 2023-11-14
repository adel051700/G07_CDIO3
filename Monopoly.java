import java.util.Scanner;

class Monopoly {

    public static int getAmountofplayers() {
        return players.length;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int whoseTurn = 1;
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);
        Tile[] tiles = Tile.getTilesFromFile(Tiles.java);

        System.out.println("Welcome to Monopoly Jr.! How many players are you? Press 2, 3 or 4");

        int n = s.nextInt();
        Player[] players = new Player[n];
        Player player1 = new Player(1, "cat", 20);
        Player player2 = new Player(2, "dog", 20);
        if (getAmountofplayers() == 3) {
            Player player3 = new Player(3, "car", 18);
            player1.setBankBalance(18);
            player2.setBankBalance(18);

        } else if (getAmountofplayers() == 4) {
            Player player3 = new Player(3, "car",16);
            Player player4 = new Player(4, "boat", 16);
            player1.setBankBalance(16);
            player2.setBankBalance(16);
        }

        
    }

}