package com.example.productservice_proxy.repositories;

import com.example.productservice_proxy.models.Category;
import com.example.productservice_proxy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepo extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Product save(Product product);
    List<Product> findByCategory(Category category);
}
