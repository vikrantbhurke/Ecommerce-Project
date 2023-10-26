package com.example.productservice_proxy.services;

import com.example.productservice_proxy.clients.FakeStoreClient;
import com.example.productservice_proxy.dtos.FakeStoreClientProductDto;
import com.example.productservice_proxy.models.Category;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.utils.DataConvertor;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreCategoryService implements ICategoryService {
       private final FakeStoreClient fakeStoreClient;

    FakeStoreCategoryService(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }

    public List<Category> getCategories() throws JsonProcessingException {
        String[] categoryArray = fakeStoreClient.getCategories();
        List<Category> categoryList = new ArrayList<>();
        for (String category : categoryArray) {
            categoryList.add(DataConvertor.convertStringToCategory(category, getProductsInCategory(category)));
        }
        return categoryList;
    }

    public List<Product> getProductsInCategory(String categoryId) {
        List<FakeStoreClientProductDto> fakeStoreProducts = fakeStoreClient.getProductsInCategory(categoryId);
        List<Product> products = new ArrayList<>();
        for (FakeStoreClientProductDto fakeStoreProduct : Objects.requireNonNull(fakeStoreProducts)) {
            products.add(DataConvertor.convertFakeStoreClientProductDtoToProduct(fakeStoreProduct));
        }
        return products;
    }
}
