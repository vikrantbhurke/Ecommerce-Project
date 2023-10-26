package com.example.productservice_proxy.services;

import com.example.productservice_proxy.models.Category;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.repositories.ICategoryRepo;
import com.example.productservice_proxy.repositories.IProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private final ICategoryRepo categoryRepo;
    private final IProductRepo productRepo;

    CategoryService(ICategoryRepo categoryRepo, IProductRepo productRepo) {
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
    }

    @Override
    public List<Category> getCategories() {
        return this.categoryRepo.findAll();
    }

    public List<Product> getProductsInCategory(String categoryName) {
        Category cat = this.categoryRepo.findByName(categoryName);
        return this.productRepo.findByCategory(cat);
    }
}
