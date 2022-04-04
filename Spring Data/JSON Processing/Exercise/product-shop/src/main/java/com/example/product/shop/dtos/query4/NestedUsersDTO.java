package com.example.product.shop.dtos.query4;

import java.util.List;

public class NestedUsersDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private List<NestedProductsDTO> productsCollection;
}
