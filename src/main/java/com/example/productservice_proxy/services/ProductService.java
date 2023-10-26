package com.example.productservice_proxy.services;

import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.repositories.IProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private final IProductRepo productRepo;

    ProductService(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getProducts() {
        return this.productRepo.findAll();
    }

    @Override
    public Product getProduct(Long productId) {
        if (this.productRepo.findById(productId).isPresent()) {
            return this.productRepo.findById(productId).get();
        } else {
            return null;
        }
    }

    @Override
    public Product addProduct(Product product) {
        product.setIsDeleted(false);
        return this.productRepo.save(product);
    }

    public Product putProduct(Long productId, Product product) {
        product.setId(productId);
        product.setIsDeleted(false);
        return this.productRepo.save(product);
    }

    @Override
    public Product patchProduct(Long productId, Product product) {
        if (this.productRepo.findById(productId).isPresent()) {
            Product targetProduct = this.productRepo.findById(productId).get();
            Product updatedProduct = this.patchProductUtil(targetProduct, product);
            return this.productRepo.save(updatedProduct);
        } else {
            return null;
        }
    }

    @Override
    public Product deleteProduct(Long productId) {
       if (this.productRepo.findById(productId).isPresent()) {
           Product product = this.productRepo.findById(productId).get();
           this.productRepo.deleteById(productId);
           return product;
        } else {
           return null;
       }
    }

    private Product patchProductUtil(Product targetProduct, Product product) {
        if (product.getTitle() != null) {
            targetProduct.setTitle(product.getTitle());
        }
        if (product.getDescription() != null) {
            targetProduct.setDescription(product.getDescription());
        }
        if (product.getPrice() != null) {
            targetProduct.setPrice(product.getPrice());
        }
        if (product.getImageUrl() != null) {
            targetProduct.setImageUrl(product.getImageUrl());
        }
        if (product.getCategory() != null) {
            targetProduct.setCategory(product.getCategory());
        }
        return targetProduct;
    }
}
