import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class ChanceCard 
{    
    private String name;
    private String text;
    private int tilesToMove;
    private int MoneyToChange;
    ChanceCard(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }

    private void setMoneyToChange(int changeBalance)
    {
        this.MoneyToChange = changeBalance;
    }
    public int getMoneyToChange()
    {
        return this.MoneyToChange;
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
 

    public static void main(String[] args)
    {
        var arr = getChanceCardsFromFile("chancecards.csv");
        System.out.println(arr.get(0).getText());
    }

    public static ArrayList<ChanceCard> getChanceCardsFromFile(String filename)
    {
        ArrayList<ChanceCard> chanceCards = new ArrayList<ChanceCard>();
        
        try
        {
            File fileToRead= new File(filename);
            Scanner Scanner = new Scanner(fileToRead);

            while (Scanner.hasNextLine())
            {
                String parsedLine = Scanner.nextLine();
                String[] chanceCard = parsedLine.split(";");
                ChanceCard workingCard = new ChanceCard(chanceCard[0]);
                for (int i = 1; i < chanceCard.length;i++)
                {
                    String[] individualValues = chanceCard[i].split(":");
                    for (int k = 0; k < individualValues.length; k++)
                    {
                        if (individualValues[k].equals("moneyChange"))
                        {
                            workingCard.setMoneyToChange(Integer.parseInt(individualValues[k+1]));
                        }
                        else if (individualValues[k].equals("text"))
                        {
                            workingCard.setText(individualValues[k+1]);
                        }
                        else if (individualValues[k].equals("move"))
                        {
                            workingCard.setTilesToMove(Integer.parseInt(individualValues[k+1]));
                            
                        }
                        
                    }
                }
                chanceCards.add(workingCard);

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
