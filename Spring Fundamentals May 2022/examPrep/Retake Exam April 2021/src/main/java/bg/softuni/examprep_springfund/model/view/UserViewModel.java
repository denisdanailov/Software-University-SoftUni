package bg.softuni.examprep_springfund.model.view;

import bg.softuni.examprep_springfund.model.entity.Order;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class UserViewModel {
    private String username;

    private List<Order> orders;

    public UserViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
