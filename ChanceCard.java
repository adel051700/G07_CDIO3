import java.io.File;
import java.util.Scanner;

public class ChanceCard
{   
    private String text;
    private String name;
    private String[] color;
    private String tileName;
    private int tilesToMove = 0;
    private int moneyToChange = 0;
    private int jailFreeCards = 0;
    private boolean drawChance = false;

    public static void main(String[] args) {
        ChanceCard[] chanceCards = getChanceCardsFromFile("chancecard.csv");

        for (ChanceCard card : chanceCards) {
            System.out.println("Name: " + card.getName());
            System.out.println("Text: " + card.getText());
            System.out.println("Tiles to move: " + card.getTilesToMove());
            System.out.println("Money to change: " + card.getMoneyToChange());
            System.out.println("Amount of jail free cards: " + card.getJailFreeCards());
            System.out.println("\n");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("\n");
        }

    }
    
    
    ChanceCard(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    private void setMoneyToChange(int changeBalance)
    {
        this.moneyToChange = changeBalance;
    }

    public int getMoneyToChange()
    {
        return this.moneyToChange;
    }

    private void setText(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return this.text;
    }
    
    private void setTilesToMove(int tilesToMove)
    {
        this.tilesToMove = tilesToMove;
    }
    
    public int getTilesToMove()
    {
        return this.tilesToMove;
    }

    public int getJailFreeCards()
    {
        return this.jailFreeCards;
    }

    public static ChanceCard[] getChanceCardsFromFile(String filename)
    {
        ChanceCard[] chanceCards = new ChanceCard[16];
        
        try
        {
            File fileToRead = new File(filename);
            Scanner Scanner = new Scanner(fileToRead);
            int j = 0;
            while (Scanner.hasNextLine() && j < chanceCards.length)
            {
                String parsedLine = Scanner.nextLine();
                String[] chanceCard = parsedLine.split(";");
                ChanceCard workingCard = new ChanceCard(chanceCard[0]);

                workingCard.setText(chanceCard[1]);

                for (int i = 2; i < chanceCard.length;i++)
                {
                    String[] individualValues = chanceCard[i].split(":");
                    for (int k = 0; k < individualValues.length; k++)
                    {
                        // Get Next Action
                        if(individualValues[0] == "NextAction")
                        {
                            if(individualValues[1] == "moveToTile")
                            {
                                workingCard.tileName = individualValues[2];
                            }
                            if(individualValues[1] == "moveToColor")
                            {
                                workingCard.color = individualValues[2].split(",");
                            }
                            if(individualValues[1] == "moveForward")
                            {
                                workingCard.tilesToMove = Integer.parseInt(individualValues[2]);
                            }
                            if(individualValues[1] == "moveToInput")
                            {
                                workingCard.tilesToMove = Integer.parseInt(individualValues[2]);
                            }
                            if(individualValues[1] == "Jailfreevar")
                            {
                                workingCard.jailFreeCards += 1;
                            }
                            
                        }
                        if(individualValues[0] == "MoneyChange")
                        {
                            if(individualValues[1] == "getFromPlayers")
                            {
                                workingCard.moneyToChange = Integer.parseInt(individualValues[3]);
                            }
                        }
                    }
                }
                chanceCards[j] = workingCard;
                j++;
            }
            Scanner.close();
        }
        catch (Exception error)
        {
            System.out.println(error + " Error");
        }
        return chanceCards;
    }
}
