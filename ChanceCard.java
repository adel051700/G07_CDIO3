import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class ChanceCard 
{    
    private String name;
    private String text;
    private int tilesToMove;
    private int MoneyToChange;

    private int deltaBalance;
    ChanceCard(String name)
    {
        this.name=name;
    }

    public void changeDeltaBalance(int changeBalance)
    {
        this.deltaBalance += changeBalance;
    }
    public static void main(String[] args)
    {
        getChanceCardsFromFile("chancecards.csv");
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
                            System.out.println(individualValues[k+1]);
                        }
                        else if (individualValues[k].equals("text"))
                        {
                            System.out.println(individualValues[k+1]);
                        } 
                        {

                        }
                        
                    }
                }

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
