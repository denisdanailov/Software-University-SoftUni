package entities;

import javax.persistence.*;

@Entity
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "street_name", length = 100, nullable = false)
    private String street;
    @Column(name = "address_number",nullable = false)
    private int number;
    @Column(name = "postal_code", nullable = true)
    private int pCode;

    public Address() {
    }

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }
}
