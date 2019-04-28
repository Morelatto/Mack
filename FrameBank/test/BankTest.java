
import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void BankTest() {
        Bank x = new Bank("entrada.txt");
        assertEquals(5000, x.a.get(1).getBalance(),0);

    }
}