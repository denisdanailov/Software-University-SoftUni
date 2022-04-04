package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    @Column(name = "town_name", unique = true, nullable = false)
    private String townName;

    @Column(nullable = false)
    private int population;

    @OneToMany(mappedBy = "town", targetEntity = Agent.class)
    private Set<Agent> agents;

    @OneToMany(mappedBy = "town", targetEntity = Apartment.class)
    private Set<Apartment> apartments;

    public String getTownName() {
        return townName;
    }

    public int getPopulation() {
        return population;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return townName.equals(town.townName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(townName);
    }
}
