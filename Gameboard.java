import java.io.File;

class Gameboard
{
    private Object[] gameBoard;
    public Gameboard()
    { 
        this.gameBoard = getTilesFromFile("tiles");
    }

    public static Object[] getTilesFromFile(String fileName)
  {
    //Create Tiles from csv file of the chosen language, and create array of type Tile
    // with all tiles

    int numberOfTiles = 24;
    Object[]fieldArr = new Object[numberOfTiles];
    try
    {
    var fileToRead = new File(fileName + ".csv");
    var Scanner = new java.util.Scanner(fileToRead);
    int i = 0;
      while (Scanner.hasNextLine())
    {
      String field = Scanner.nextLine();
      String[] fieldValues = field.split(";");
      String name = fieldValues[0];
      String color = fieldValues[1];
      int value = Integer.parseInt(fieldValues[2]);
      if (color == "black") {
        fieldArr[i] = new specialField(name, value);
      } else if (color == "pink") {
        fieldArr[i] = new chanceField(name);
      } else if (color == "stripes") {
        fieldArr[i] = new prisonField(name);
      } else if (color == "purple") {
        fieldArr[i] = new field(name);
      } else {
        int rent = value;
        fieldArr[i] = new buyableField(name, value, color, rent, null);
      }
      i++;
    }
    Scanner.close();
    } 
    catch(Exception e)
    {
      System.out.println(e + " Error");
    }
    return fieldArr;
  }
}

