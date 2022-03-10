package one_to_many;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "PB_one_to_many")
@Table(name = "production_batches")
public class ProductionBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "batch", targetEntity = BasicShampoo.class,
        fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BasicShampoo> shampoo;

    public ProductionBatch() {
    }

    public ProductionBatch(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Set<BasicShampoo> getShampoo() {
        return shampoo;
    }

    public void setShampoo(Set<BasicShampoo> shampoo) {
        this.shampoo = shampoo;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
