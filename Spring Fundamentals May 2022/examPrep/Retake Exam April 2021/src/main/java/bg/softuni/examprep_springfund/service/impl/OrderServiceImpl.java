package bg.softuni.examprep_springfund.service.impl;

import bg.softuni.examprep_springfund.model.entity.Category;
import bg.softuni.examprep_springfund.model.entity.Order;
import bg.softuni.examprep_springfund.model.entity.User;
import bg.softuni.examprep_springfund.model.service.OrderServiceModel;
import bg.softuni.examprep_springfund.model.view.OrderViewModel;
import bg.softuni.examprep_springfund.repository.OrderRepository;
import bg.softuni.examprep_springfund.repository.UserRepository;
import bg.softuni.examprep_springfund.security.CurrentUser;
import bg.softuni.examprep_springfund.service.CategoryService;
import bg.softuni.examprep_springfund.service.OrderService;
import bg.softuni.examprep_springfund.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepo;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final UserService userService;
    private final CurrentUser currentUser;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepo, ModelMapper modelMapper, CategoryService categoryService,
                            UserService userService, CurrentUser currentUser) {
        this.orderRepo = orderRepo;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {

        Order orderEntity = this.modelMapper.map(orderServiceModel, Order.class);

        Optional<Category> optCategory = this.categoryService.findByName(orderServiceModel.getCategory());
        orderEntity.setCategory(optCategory.get());

        Optional<User> optUser = this.userService.findUserById(this.currentUser.getId());
        orderEntity.setEmployee(optUser.get());

        this.orderRepo.save(orderEntity);
    }

    @Override
    public List<OrderViewModel> findAllOrdersOrderedByPriceDesc() {
        List<Order> allOrderedByPriceDesc = this.orderRepo.findAllByOrderByPriceDesc();

        return allOrderedByPriceDesc.stream()
                .map(order -> this.modelMapper
                .map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeOrder(Long id) {
        this.orderRepo.deleteById(id);
    }
}
