package many_to_many;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "BS_many_to_many")
@Table(name = "shampoos")
public class BasicShampoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    private ProductionBatch batch;

    @OneToOne(optional = false)
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    private BasicLabel label;

    @ManyToMany
    @JoinTable(name = "shampoos_ingredients",
        joinColumns = @JoinColumn(name = "shampoo_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private Set<BasicIngredient> ingredients;

    public BasicShampoo() {
    }

    public BasicShampoo(String name, BasicLabel label, ProductionBatch batch) {
        this.name = name;
        this.label = label;
        this.batch = batch;

        this.ingredients = new LinkedHashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BasicLabel getLabel() {
        return label;
    }

    public void setLabel(BasicLabel label) {
        this.label = label;
    }

    public Set<BasicIngredient> getIngredients() {
        return Collections.unmodifiableSet(this.ingredients);
    }

    public void addIngredient(BasicIngredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
