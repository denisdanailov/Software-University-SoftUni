package com.example.product.shop.dtos.query2;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SellerUserDTO {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private List<SuccessfullySoldProductDTO> soldProducts;

    public SellerUserDTO() {
    }

    public SellerUserDTO(String firstName, String lastName, List<SuccessfullySoldProductDTO> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.soldProducts = soldProducts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SuccessfullySoldProductDTO> getSoldProducts() {
        return soldProducts;
    }

    public void setSellingItems(List<SuccessfullySoldProductDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
