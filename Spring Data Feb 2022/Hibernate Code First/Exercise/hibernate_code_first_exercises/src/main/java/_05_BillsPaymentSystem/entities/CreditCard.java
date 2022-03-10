package _05_BillsPaymentSystem.entities;

import _05_BillsPaymentSystem.enums.CardType;

import javax.persistence.*;
import java.time.Month;

@Entity
@DiscriminatorValue(value = "credit_card")
public class CreditCard extends BillingDetail{

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Column(name = "expiration_month")
    private Month expirationMonth;

    @Column(name = "expiration_year")
    private int expirationYear;

    public CreditCard() {
    }

    public CreditCard(int number, String owner, CardType cardType, Month expirationMonth, int expirationYear) {
        super(number, owner);
        this.cardType = cardType;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Month getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Month expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }
}
