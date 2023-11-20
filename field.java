public class field {
    public String name;

    public field(String name) {
        this.name = name;
    }
}

class specialField extends field {
    private int changeBalance;
    
    public specialField(String name, int changeBalance) {
        super(name);
        this.changeBalance = changeBalance;

    }

}

class chanceField extends field{

}

class prisonField extends field{
    private boolean isInPrison;

    public prisonField (String name){
        super(name);
    }
}

class buyableField extends field{
    private int value;
    private String color;
    private int rent;
    private String[] owner;

    public buyableField (String name, int value, String color, int rent, String[] owner){
        super(name);
        this.value = value;
        this.color = color;
        this.rent = rent;
        this.owner = owner;
    }
    public int getRent(){
        return this.rent;
    }

    public void setRent(int multiplier){
        this.rent=this.rent*multiplier;
    }
}