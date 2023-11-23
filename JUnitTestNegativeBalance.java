import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class JUnitTestNegativeBalance {
    private Player player;

      @Before
    public void testPlayer() {
        player = new Player(1,20);
    }

    @Test
    public void testStartBalance() {
        assertEquals(20, player.getBankBalance());
    }

    @Test 
    public void testBalanceNotNegative() {
        player.setBankBalance(2);
        assertEquals(22, player.getBankBalance());
        player.setBankBalance(-25);
        assertEquals(0, player.getBankBalance());
    }

    @Test 
    public void testToString() {
        String expected = "Player 1 " + System.lineSeparator()+ "Bank balance: 20";
        assertEquals(expected, player.toString());
    }
}
