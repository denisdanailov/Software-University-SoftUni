package bg.softuni.examprep_springfund.model.view;

import bg.softuni.examprep_springfund.model.entity.Category;
import bg.softuni.examprep_springfund.model.entity.User;

import java.math.BigDecimal;


public class OrderViewModel {
    private Long id;
    private String name;

    private BigDecimal price;

    private Category category;

    public OrderViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
