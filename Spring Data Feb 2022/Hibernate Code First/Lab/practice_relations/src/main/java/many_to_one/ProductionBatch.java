package many_to_one;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "PB_many_to_one")
@Table(name = "production_batches")
public class ProductionBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    public ProductionBatch() {
    }

    public ProductionBatch(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
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
