import java.io.File;
class Tile implements field
{
  private String name;
  private String color;
  private String ownedBy;
  private int tileCost;


  public String getDescription()
  {
    String returnStatement =  "You landed on " + this.name +" which is a " + this.color + "Tile, \n The tile is owned by: " + this.ownedBy;
    if (ownedBy == "None")
    {
      returnStatement += "\n You can buy this tile for " + this.tileCost;
    }
    else
    {
      returnStatement += "You have to pay " + this.tileCost +  " in rent to  " + this.ownedBy; 
    }

    return returnStatement;
  }
  
  public Tile(String name, String color ,int tileCost)
    {
        this.name = name;
        this.color = color;
        this.ownedBy = "None";
        this.tileCost= tileCost;
    }

  public void setTileCost(int newValue)
  {
    this.tileCost = newValue;
  }

  public static Tile[] getTilesFromFile(String language)
  {
    //Create Tiles from csv file of the chosen language, and create array of type Tile
    // with all tiles

    int numberOfTiles = 11;
    Tile[]tileArr = new Tile[numberOfTiles];
    try
    {
    var fileToRead = new File(language + ".csv");
    var Scanner = new java.util.Scanner(fileToRead);
    int i = 0;
      while (Scanner.hasNextLine())
    {
      String tile = Scanner.nextLine();
      String[] tileValues = tile.split(";");
      String name = tileValues[0];
      String story = tileValues[1];
      int value = Integer.parseInt(tileValues[2]);
      tileArr[i] = new Tile(name,story,value);
      i++;
    }
    Scanner.close();
    } 
    catch(Exception e)
    {
      System.out.println(e + " Error");
    }

    return tileArr;

  }
}