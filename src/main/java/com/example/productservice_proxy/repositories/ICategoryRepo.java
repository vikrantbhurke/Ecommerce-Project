package com.example.productservice_proxy.repositories;

import com.example.productservice_proxy.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepo extends JpaRepository<Category, Long> {
    List<Category> findAll();
    Category findByName(String name);
}
