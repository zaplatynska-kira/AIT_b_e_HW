package de.aittr.g_31_2_shop.domain.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartDto {

    private int id;
    private List<ProductDto> products = new ArrayList<>();

    public CartDto(int id, List<ProductDto> products) {
        this.id = id;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDto cartDto = (CartDto) o;
        return id == cartDto.id && Objects.equals(products, cartDto.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products);
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }
}