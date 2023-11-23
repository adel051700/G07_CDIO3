import java.util.Random;
import java.util.Scanner;

public class field {
    public String name;

    public field(String name) {
        this.name = name;
    }

    public String getDescription() {
        String returnStatement = "You have landed on " + this.name + "Nothing further happens...";
        return returnStatement;
    }
}

class specialField extends field {

    public specialField(String name) {
        super(name);

    }

    @Override
    public String getDescription() {
        String returnStatement = "You have landed on " + this.name + "!";
        return returnStatement;
    }

}

class chanceField extends field {

    public chanceField(String name) {
        super(name);
    }

    public static int drawChanceCard() {
        Random random = new Random();
        int cardNumber = random.nextInt((19 - 0) + 1) + 0;
        return cardNumber;
    }
    @Override
    public String getDescription(){
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
    public String getDescription(){
        String returnStatement = "You have landed on Go to Prison! " + "You have now been transfered to the prison and the turn is passed on...";
        return returnStatement;
    }
}

class buyableField extends field {
    private int value;
    private String color;
    private int rent;
    private String[] owner;

    public buyableField(String name, int value, String color, int rent, String[] owner) {
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
    @Override
    public String getDescription() {
        String returnStatement = "You landed on " + this.name + " which is a " + this.color
                + " tile, \n The tile is owned by: " + this.owner;
        if (owner == null) {
            returnStatement += "\n You buy this tile for " + this.value + " and your turn has now ended...";
        } else {
            returnStatement += "You pay " + this.value + " in rent to  " + this.owner + ". Your turn has now ended...";
        }
        return returnStatement;
    }
}