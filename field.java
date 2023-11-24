import java.util.Random;
import java.util.Scanner;

public class field {
    public String name;
    private Player owner = null;

    public field(String name) {
        this.name = name;
    }
    public Player getOwner()
    {
        return this.owner;
    }
    public int getValue()
    {
        return 0;
    }
    public void setMultiplier(int fillerFunctionForFunctionalityInBuyableFields)
    {}


    public String getDescription(Player player, Player[] playerArr) {
        String returnStatement = "You have landed on " + this.name + ", nothing further happens...";
        return returnStatement;
    }
}

class specialField extends field {
    public specialField(String name) {
        super(name);
    }

    @Override
    public String getDescription(Player player, Player[] playerArr) {
        String returnStatement = "You have landed on " + this.name + "!";
        System.out.println("You now have " + player.getBankBalance() + "$ left");
        return returnStatement;
    }

}

class chanceField extends field {

    public chanceField(String name) {
        super(name);
    }

    public static int drawChanceCard() {
        Random random = new Random();
        int cardNumber = random.nextInt((15) + 1);
        return cardNumber;
    }
    @Override
    public String getDescription(Player player, Player[] playerArr){
        ChanceCard[] chanceCards = ChanceCard.getChanceCardsFromFile("chancecard.csv");
        var s = new Scanner(System.in);
        int chanceCardNum = drawChanceCard();
        System.out.println("You have landed on a chancefield. Press a button to draw a chancecard!");
        s.nextLine();
        String returnStatement = "The chancecard reads: " + chanceCards[chanceCardNum].getText();



        returnStatement += "\n You now have " + player.getBankBalance() + "$ left";
        return returnStatement;
    }
}

class prisonField extends field {
    private boolean isInPrison;

    public prisonField(String name) {
        super(name);
    }

    @Override
    public String getDescription(Player player, Player[] playerArr){
        String returnStatement = "You have landed on Go to Prison!";
        if (player.getOutOfJailFreeCard())
        {
            returnStatement += "\n But you have a get out of jail free card, and you get out, ready for next turn";
        }
        else
        {
            returnStatement += "\nYou have now been transfered to the prison and the turn is passed on...";
            player.changeIsInPrison();
        }
        player.setPosition(6);
        
        return returnStatement;
    }
}

class buyableField extends field {
    private int value;
    private String color;
    private int multiplier;
    private Player owner;

    public buyableField(String name, int value, String color, int multiplier, Player owner) {
        super(name);
        this.value = value;
        this.color = color;
        this.multiplier = multiplier;
        this.owner = owner;
    }
    @Override
    public Player getOwner()
    {
        return this.owner;
    }
    @Override
    public int getValue()
    {
        return this.value;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
    @Override
    public String getDescription(Player player, Player[] playerArr) {
        String returnStatement = "You landed on " + this.name + " which is a " + this.color + " tile";
        if (owner != null && !owner.equals(player))
        {
            returnStatement+= "\n The tile is owned by: player number " + this.owner.getNumber();
            returnStatement += "\n You pay " + this.value + "$ in rent to: player number " + this.owner.getNumber() + ".";
            this.owner.setBankBalance(value*multiplier);
            player.setBankBalance(-value*multiplier);
        }
        else if (owner == player)
        {
            returnStatement += "\n You already own this tile, and nothing further happens...";
        }
        else
        {
            
            returnStatement += "\n You buy this tile for " + this.value + "$";
            player.setBankBalance(-value);
            this.owner = player;
        }
            
        returnStatement += "\n You now have " + player.getBankBalance() + "$ left";

        
        return returnStatement;
    }
}