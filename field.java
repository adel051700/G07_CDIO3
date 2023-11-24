//import java.lang.reflect.Field;
import java.util.Random;
import java.util.Scanner;

class Field {
    public String name;
    private Player owner = null;

    public Field(String name) {
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
    public String getColor() {
        return "";
    }
    public String getName()
    {
        return this.name;
    }
    public void setMultiplier(int fillerFunctionForFunctionalityInBuyableFields)
    {}


    public String getDescription(Player player, Player[] playerArr, Field[] gameBoard) {
        String returnStatement = "You have landed on " + this.name + ", nothing further happens...";
        return returnStatement;
    }
}

class specialField extends Field {
    public specialField(String name) {
        super(name);
    }

    @Override
    public String getDescription(Player player, Player[] playerArr, Field[] gameBoard) {
        String returnStatement = "You have landed on " + this.name + "!";
        System.out.println("You now have " + player.getBankBalance() + "$ left");
        return returnStatement;
    }

}

class chanceField extends Field {
    private ChanceCard[] chanceCards = ChanceCard.getChanceCardsFromFile("chancecard.csv");

    public chanceField(String name) {
        super(name);
    }

    public static int drawChanceCard() {
        Random random = new Random();
        int cardNumber = random.nextInt((15) + 1);
        return cardNumber;
    }
    @Override
    public String getDescription(Player player, Player[] playerArr, Field[] gameBoard){
        
        var s = new Scanner(System.in);
        int chanceCardNum = drawChanceCard();
        System.out.println("You have landed on a chancefield. Press a button to draw a chancecard!");
        s.nextLine();
        String returnStatement = "The chancecard reads: " + this.chanceCards[chanceCardNum].getText();
        
        ChanceCard currChance = this.chanceCards[chanceCardNum];

        
        if(currChance.getColor() != null) {
            int shortestRoute = 0;
            int playerStartPos = player.getPosition();
            int currentRoute = 0;

            for(int i = 0; i < currChance.getColor().length; i++) {
                for(int j = playerStartPos; j < gameBoard.length + 1; j++) {
                    currentRoute++;
                    j %= 24;
                    
                    if(currChance.getColor()[i] == gameBoard[j].getColor()) {
                        if(currentRoute <= shortestRoute) {
                            shortestRoute = currentRoute;
                        }    
                        break;
                    }
                }
            }
            player.setPosition(shortestRoute);
        }
        if (currChance.getTilesToMove()!=0)
        {
            player.setPosition(currChance.getTilesToMove());
        }
        if (currChance.getMoneyToChange() != 0)
        {
            player.setBankBalance(currChance.getMoneyToChange());
        }
        if (currChance.getJailFreeCards() != 0 && !player.getOutOfJailFreeCard())
        {
            player.changeOutOfJailFreeCard();
        }

        if(currChance.getTileName() != null) {
            int currentRoute = 0;
            for(int j = player.getPosition(); j < gameBoard.length + 1; j++) {
                currentRoute++;
                j %= 24;
                
                if(currChance.getTileName() == gameBoard[j].getName()) {
                    player.setPosition(currentRoute);
                    break;
                }
            }
            }
        if (currChance.getChangePlayersBalance() != 0)
        {
            for (int i = 0; i < playerArr.length; i++)
            {
                if (!playerArr[i].equals(player))
                {
                    player.setBankBalance(currChance.getChangePlayersBalance());
                }
            }
        }
        


        
        returnStatement += "\n You now have " + player.getBankBalance() + "$ left";
        return returnStatement;
    }
}

class prisonField extends Field {
    private boolean isInPrison;

    public prisonField(String name) {
        super(name);
    }

    @Override
    public String getDescription(Player player, Player[] playerArr, Field[] gameBoard){
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
        returnStatement += "\n-----------------------------------------------------";
        return returnStatement;
    }
}

class buyableField extends Field {
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
    @Override
    public String getColor() {
        return this.color;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
    @Override
    public String getDescription(Player player, Player[] playerArr, Field[] gameBoard) {
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