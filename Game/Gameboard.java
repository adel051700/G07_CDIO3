import java.io.File;

class Gameboard
{
  public Field[] GameBoard;
    public Gameboard()
    {
        this.GameBoard = getTilesFromFile("tiles");
    }
    public static String toString(Field[] GameBoard ,Player[] players)
    {
      String statement = "";
      
      for (int i = 0; i < GameBoard.length; i++)
      {
        statement += GameBoard[i].name + " ";
        for (int k = 0; k < players.length; k++)
        {
          if (players[k].getPosition() == i)
          {
            statement += " Player: " + players[k].getNumber();
          }
        }
        statement += "\n";
      }
      return statement;
    }
    public static Field[] getTilesFromFile(String fileName)
  {
    //Create Tiles from csv file of the chosen language, and create array of type Tile
    // with all tiles

    int numberOfTiles = 24;
    Field[] fieldArr = new Field[numberOfTiles];
    try
    {
    var fileToRead = new File(fileName);
    var scanner = new java.util.Scanner(fileToRead);
    int i = 0;
      while (scanner.hasNextLine())
    {
      String field = scanner.nextLine();
      String[] fieldValues = field.split(";");
      String name = fieldValues[0];
      String color = fieldValues[1];
      int value = Integer.parseInt(fieldValues[2]);
      if (color.equals("black")) {
        fieldArr[i] = new specialField(name);
      } else if (name.equals("ChanceCard")) {
        fieldArr[i] = new chanceField(name);
      } else if (color.equals("stripes")) {
        fieldArr[i] = new prisonField(name);
      } else if (color.equals("purple")) {
        fieldArr[i] = new Field(name);
      } else {
        int multiplier = 1;
        fieldArr[i] = new buyableField(name, value, color, multiplier, null);
      }
      i++;
    }
    scanner.close();
    } 
    catch(Exception e)
    {
      System.out.println(e + " Error");
    }
    return fieldArr;
  }
}

