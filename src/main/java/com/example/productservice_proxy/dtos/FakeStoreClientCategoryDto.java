package com.example.productservice_proxy.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreClientCategoryDto implements IClientCategoryDto {
    private String name;
  //  private List<Product> productList;
}
