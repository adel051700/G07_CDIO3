import java.io.File;
class Tile 
{
  private String name;
  private String story;
  private int value;
  
  public Tile(String name, String story, int value)
    {
        this.name = name;
        this.story = story;
        this.value = value;
    }

  public int getValue()
  {
    return this.value;
  }
  public String getName()
  {
    return this.name;
  }
  public String getStory()
  {
    return this.story;
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