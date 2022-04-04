package softuni.exam.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    private BigDecimal price;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "has_gold_status")
    private Boolean hasGoldStatus;

    @Column(name = "added_on")
    private LocalDateTime addedOn;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private Seller seller;

    @ManyToMany
    @JoinTable(name = "offers_pictures",
            joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pictures_id", referencedColumnName = "id"))
    private Set<Picture> pictures;

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public Car getCar() {
        return car;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return description.equals(offer.description) && addedOn.equals(offer.addedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, addedOn);
    }
}
