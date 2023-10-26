package com.example.productservice_proxy.dtos;

import com.example.productservice_proxy.models.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CategoryDto {
    private String name;
    private List<Product> productList;
}
