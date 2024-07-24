package yukinarisoftware.app;

import org.junit.jupiter.api.Test;
import yukinarisoftware.app.group.CreditCardGroup;
import yukinarisoftware.app.group.VirtualAccountGroup;


public class PaymentTest extends SetUpValidation{

    @Test
    void testPayment(){

        Payment payment = new Payment();
        payment.setOrder("XE001");
        payment.setAmmount(25_000L);
        payment.setCreditCard("433334333343333");
        payment.setVirtualAccount("2132434242323");

        validateGroups(payment, CreditCardGroup.class, VirtualAccountGroup.class);

    }
}
