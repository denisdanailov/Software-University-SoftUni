package _02_SalesDatabase.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "_02_sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne(optional = false)
    @JoinColumn(name = "store_location_id", referencedColumnName = "id")
    private StoreLocation storeLocation;
    @Column(name = "date")
    private LocalDateTime date;
}
