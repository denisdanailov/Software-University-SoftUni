package softuni.exam.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity{

    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    private BigDecimal price;

    @Column(name = "take_off")
    private LocalDateTime takeOff;

    @ManyToOne
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "plane_id", referencedColumnName = "id")
    private Plane plane;

    @ManyToOne
    @JoinColumn(name = "to_town_id", referencedColumnName = "id")
    private Town toTown;

    @ManyToOne
    @JoinColumn(name = "from_town_id", referencedColumnName = "id")
    private Town fromTown;

    public String getSerialNumber() {
        return serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getTakeOff() {
        return takeOff;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Plane getPlane() {
        return plane;
    }

    public Town getToTown() {
        return toTown;
    }

    public Town getFromTown() {
        return fromTown;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTakeOff(LocalDateTime takeOff) {
        this.takeOff = takeOff;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setToTown(Town toTown) {
        this.toTown = toTown;
    }

    public void setFromTown(Town fromTown) {
        this.fromTown = fromTown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return serialNumber.equals(ticket.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }
}
