package _05_BillsPaymentSystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "_05_billing_details")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class BillingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private int number;

    @Column(nullable = false)
    private String owner;

    @OneToOne(mappedBy = "billingDetail", targetEntity = User.class)
    private User user;

    public BillingDetail() {
    }

    public BillingDetail(int number, String owner) {
        this.number = number;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
