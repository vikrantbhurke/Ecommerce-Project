package com.example.productservice_proxy.utils;

import com.example.productservice_proxy.dtos.CategoryDto;
import com.example.productservice_proxy.dtos.FakeStoreClientProductDto;
import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Category;
import com.example.productservice_proxy.models.Product;

import java.util.List;

public class DataConvertor {
    public static Product convertProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return product;
    }

    public static ProductDto convertProductToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setCategory(product.getCategory().getName());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        return productDto;
    }

    public static Product convertFakeStoreClientProductDtoToProduct(FakeStoreClientProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());
        return product;
    }

    public static FakeStoreClientProductDto convertProductToFakeStoreClientProductDto(Product product) {
        FakeStoreClientProductDto productDto = new FakeStoreClientProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
         productDto.setCategory(product.getCategory().getName());
        productDto.setImage(product.getImageUrl());
        return productDto;
    }

    public static Category convertStringToCategory(String stringCategory, List<Product> productList) {
        Category category = new Category();
        category.setName(stringCategory);
        category.setProductList(productList);
        return category;
    }

    public static CategoryDto convertCategoryToCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        categoryDto.setProductList(category.getProductList());
        return categoryDto;
    }
}