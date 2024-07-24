package yukinarisoftware.app;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import yukinarisoftware.app.group.CreditCardGroup;
import yukinarisoftware.app.group.VirtualAccountGroup;

public class Payment {
    @Range(min = 1, max = 100, message = "Character min 10, and max 100")
    @NotBlank(groups = {CreditCardGroup.class, VirtualAccountGroup.class},
    message = "Order cannot blank")
    private String order;

    @Range(min = 10_000L, max = 100_000_000L,
    message = "ammount min 10.000 and max 100.000.000",
    groups = {CreditCardGroup.class, VirtualAccountGroup.class})
    @NotNull(groups = {CreditCardGroup.class, VirtualAccountGroup.class},
    message = "ammount cannot null")
    private Long ammount;

    @LuhnCheck(message = "credit card not valid",
    groups = CreditCardGroup.class)
    @NotBlank(message = "credit card cannot blank", groups = CreditCardGroup.class)
    private String creditCard;

    @NotBlank(message = "virtual account cannot blank",
    groups = VirtualAccountGroup.class)
    private String virtualAccount;

    @Override
    public String toString() {
        return "Payment{" +
                "order='" + order + '\'' +
                ", ammount=" + ammount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                '}';
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Long getAmmount() {
        return ammount;
    }

    public void setAmmount(Long ammount) {
        this.ammount = ammount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }
}
