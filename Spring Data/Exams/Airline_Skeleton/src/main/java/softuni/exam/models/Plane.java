package softuni.exam.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "planes")
public class Plane extends BaseEntity{

    @Column(name = "register_number", nullable = false, unique = true)
    private  String registerNumber;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private String airline;

    @OneToMany(mappedBy = "plane", targetEntity = Ticket.class)
    private Set<Ticket> tickets;

    public String getRegisterNumber() {
        return registerNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return registerNumber.equals(plane.registerNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registerNumber);
    }
}
