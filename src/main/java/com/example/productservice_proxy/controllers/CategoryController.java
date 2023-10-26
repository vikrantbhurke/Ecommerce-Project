package com.example.productservice_proxy.controllers;

import com.example.productservice_proxy.dtos.CategoryDto;
import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Category;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.services.ICategoryService;
import com.example.productservice_proxy.utils.DataConvertor;
import com.example.productservice_proxy.utils.UtilClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    ICategoryService categoryService;

    @Autowired
    CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        try {
            MultiValueMap<String, String> headers = UtilClass.getHeaders();
            List<Category> categories = this.categoryService.getCategories();
            List<CategoryDto> categoryDtos = new ArrayList<>();
            for (Category category : categories) {
                categoryDtos.add(DataConvertor.convertCategoryToCategoryDto(category));
            }
            return new ResponseEntity<>(categoryDtos, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<ProductDto>> getProductsInCategory(@PathVariable("categoryName") String categoryName) {
        try {
            MultiValueMap<String, String> headers = UtilClass.getHeaders();
            List<Product> productsInCategory = this.categoryService.getProductsInCategory(categoryName);
            List<ProductDto> productsInCategoryDtos = new ArrayList<>();
            for (Product product : productsInCategory) {
                productsInCategoryDtos.add(DataConvertor.convertProductToProductDto(product));
            }
            return new ResponseEntity<>(productsInCategoryDtos, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
