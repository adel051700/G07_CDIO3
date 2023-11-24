import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class JUnitTestChanceCard {
    private Player player;
    private ChanceCard chance;

    @Before
    public void testPlayer() {
        player = new Player(1,20);
        chance = new ChanceCard("Free space");
    }
}
