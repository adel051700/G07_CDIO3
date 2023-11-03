import java.util.Random;

class Dice {
    
    private int dieSides;

    public Dice(int dieSides) {
        this.dieSides = dieSides;

    }

    public int roll() {
        Random random = new Random();
        int randomInt = random.nextInt(this.dieSides);

        return randomInt + 1;
    }
}
