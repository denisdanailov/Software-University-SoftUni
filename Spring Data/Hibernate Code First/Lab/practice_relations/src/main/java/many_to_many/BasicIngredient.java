package many_to_many;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class BasicIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "chemical_name", nullable = false)
    private String chemicalName;

    @Column(name = "quantity")
    private Double  quantity;

    @ManyToMany(mappedBy = "ingredients", targetEntity = BasicShampoo.class)
    private Set<BasicShampoo> shampoos;

    public BasicIngredient() {
    }

    public BasicIngredient(String chemicalName, Double quantity) {
        this.chemicalName = chemicalName;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
