
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    public BankAccountTest() {
    }

    @Test
    public void testBankAccount() {
        BankAccount b = new BankAccount(1, "123", "fabio", 100.0);

        assertEquals(1, b.getAccountNumber());
        assertEquals("123", b.getPassword());

    }
}