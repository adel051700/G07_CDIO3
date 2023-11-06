import java.io.File;

public class ChanceCard 
{    
    private int tilesToMove;
    private int deltaBalance;
    ChanceCard()
    {
    }

    public void changeDeltaBalance(int changeBalance)
    {
        this.deltaBalance += changeBalance;
    }

    public static ChanceCard[] getChanceCardsFromFile(String language)
    {
    }
}
