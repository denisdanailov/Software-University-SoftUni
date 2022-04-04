package hiberspring.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "branches")
public class Branch extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id", nullable = false)
    private Town town;

    @OneToMany(mappedBy = "branch", targetEntity = Product.class)
    private Set<Product> products;

    @OneToMany(mappedBy = "branch", targetEntity = Employee.class)
    private Set<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
