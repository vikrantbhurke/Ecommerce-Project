package com.example.productservice_proxy.services;

import com.example.productservice_proxy.models.Category;
import com.example.productservice_proxy.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ICategoryService {
    List<Category> getCategories() throws JsonProcessingException;
    List<Product> getProductsInCategory(String categoryId);
}
