package _03_ManyToMany;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "trucks")
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "truck_id")
    private Long id;
    private String type;
    private String model;
    private BigDecimal price;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column(name = "load_capacity")
    private Double loadCapacity;

    @ManyToMany
    @JoinTable(name = "drivers_trucks",
            joinColumns = @JoinColumn(name = "truck_id", referencedColumnName = "truck_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "driver_id"))
    private Set<Driver> drivers;

    public Truck() {
    }

    public Truck(String type, String model, BigDecimal price, String fuelType, Double loadCapacity) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
        this.loadCapacity = loadCapacity;
    }

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }
}
