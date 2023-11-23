import java.util.Random;
import java.util.Scanner;

public class field {
    public String name;

    public field(String name) {
        this.name = name;
    }

    public String getDescription(Player player) {
        String returnStatement = "You have landed on " + this.name + ", nothing further happens...";
        return returnStatement;
    }
}

class specialField extends field {
    public specialField(String name) {
        super(name);
    }

    @Override
    public String getDescription(Player player) {
        String returnStatement = "You have landed on " + this.name + "!";
        System.out.println("You now have " + player.getBankBalance() + " left");
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
    public String getDescription(Player player){
        ChanceCard[] chanceCards = ChanceCard.getChanceCardsFromFile("chancecard.csv");
        var s = new Scanner(System.in);
        int chanceCardNum = drawChanceCard();
        System.out.println("You have landed on a chancefield. Press a button to draw a chancecard!");
        s.nextLine();
        String returnStatement = "The chancecard reads: " + chanceCards[chanceCardNum].getText();
        return returnStatement;
    }
}

class prisonField extends field {
    private boolean isInPrison;

    public prisonField(String name) {
        super(name);
    }

    @Override
    public String getDescription(Player player){
        String returnStatement = "You have landed on Go to Prison! " + "You have now been transfered to the prison and the turn is passed on...";
        return returnStatement;
    }
}

class buyableField extends field {
    private int value;
    private String color;
    private int rent;
    private Player owner;

    public buyableField(String name, int value, String color, int rent, Player owner) {
        super(name);
        this.value = value;
        this.color = color;
        this.rent = rent;
        this.owner = owner;
    }

    public int getRent() {
        return this.rent;
    }

    public void setRent(int multiplier) {
        this.rent = this.rent * multiplier;
    }
    //@Override
    public String getDescription(Player player) {
        String returnStatement = "You landed on " + this.name + " which is a " + this.color + " tile";
        if (owner != null)
        {
            returnStatement+= "\n The tile is owned by: player number " + this.owner.getNumber();
            returnStatement += "\n You pay " + this.value + " in rent to: player number" + this.owner.getNumber() + ".";
            this.owner.setBankBalance(rent);
            player.setBankBalance(-rent);
        }
        else
        {
            
            returnStatement += "\n You buy this tile for " + this.value;
            player.setBankBalance(-value);
            this.owner = player;
        }
            
        returnStatement += "\n You now have " + player.getBankBalance() + " left";

        
        return returnStatement;
    }
}