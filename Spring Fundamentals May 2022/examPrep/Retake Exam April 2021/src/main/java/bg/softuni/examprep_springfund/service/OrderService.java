package bg.softuni.examprep_springfund.service;

import bg.softuni.examprep_springfund.model.entity.Order;
import bg.softuni.examprep_springfund.model.service.OrderServiceModel;
import bg.softuni.examprep_springfund.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersOrderedByPriceDesc();

    void removeOrder(Long id);
}
