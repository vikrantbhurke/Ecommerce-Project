package com.example.productservice_proxy.services;

import com.example.productservice_proxy.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getProducts();
    Product getProduct(Long productId);
    Product addProduct(Product product);
    Product putProduct(Long productId, Product product);
    Product patchProduct(Long productId, Product product);
    Product deleteProduct(Long productId);
}
