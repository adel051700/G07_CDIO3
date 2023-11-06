import java.io.File;

public class ChanceCard 
{    
    private String name;
    private String text;
    private int tilesToMove;
    private int MoneyToChange;

    private int deltaBalance;
    ChanceCard(String name, String text, int tilesToMove, int MoneyToChange)
    {
        this.name=name;
        this.text=text;
        this.tilesToMove=tilesToMove;
        this.MoneyToChange=MoneyToChange;

    }

    public void changeDeltaBalance(int changeBalance)
    {
        this.deltaBalance += changeBalance;
    }

    public static ChanceCard[] getChanceCardsFromFile(String language)
    {
        int numberOfChancecard=20;
        ChanceCard[] Chancearr= new ChanceCard[numberOfChancecard];
        try{
            var fileToRead= new File(language +".csv");
            var Scanner = new java.util.Scanner(fileToRead);
            int i=0;
            while (Scanner.hasNextLine()){
                String chanceCard=Scanner.nextLine();
                String[] ChanceCards=chanceCard.split(";");
                String name=ChanceCards[0];
                String text=ChanceCards[1];
                int tilesToMove=Integer.parseInt(ChanceCards[2]);
                int MoneyToChange=Integer.parseInt(ChanceCards[3]);
                     
                Chancearr[i]=new ChanceCard(name,text, tilesToMove, MoneyToChange);
                i++;
            }
            Scanner.close();
        }
        catch (Exception e){
            System.out.println(e + " Error");
        }
        return Chancearr;
    }
}
