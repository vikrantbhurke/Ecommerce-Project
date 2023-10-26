package com.example.productservice_proxy.services;

import com.example.productservice_proxy.clients.FakeStoreClient;
import com.example.productservice_proxy.dtos.FakeStoreClientProductDto;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.utils.DataConvertor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FakeStoreProductService implements IProductService {
    private final FakeStoreClient fakeStoreClient;

    FakeStoreProductService(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public List<Product> getProducts() {
        List<FakeStoreClientProductDto> fakeStoreProducts = fakeStoreClient.getProducts();
        List<Product> products = new ArrayList<>();
        for (FakeStoreClientProductDto fakeStoreProduct : Objects.requireNonNull(fakeStoreProducts)) {
            products.add(DataConvertor.convertFakeStoreClientProductDtoToProduct(fakeStoreProduct));
        }
        return products;
    }

    @Override
    public Product getProduct(Long productId) {
        FakeStoreClientProductDto fakeStoreProduct = fakeStoreClient.getProduct(productId);
        assert fakeStoreProduct != null;
        return DataConvertor.convertFakeStoreClientProductDtoToProduct(fakeStoreProduct);
    }

    @Override
    public Product addProduct(Product product) {
        FakeStoreClientProductDto fakeStoreProduct = fakeStoreClient.addProduct(product);
        assert fakeStoreProduct != null;
        return DataConvertor.convertFakeStoreClientProductDtoToProduct(fakeStoreProduct);
    }

    @Override
    public Product putProduct(Long productId, Product product) {
        FakeStoreClientProductDto fakeStoreProduct = fakeStoreClient.putProduct(productId, product);
        assert fakeStoreProduct != null;
        return DataConvertor.convertFakeStoreClientProductDtoToProduct(fakeStoreProduct);
    }

    @Override
    public Product patchProduct(Long productId, Product product) {
        FakeStoreClientProductDto fakeStoreProduct = fakeStoreClient.patchProduct(productId, product);
        assert fakeStoreProduct != null;
        return DataConvertor.convertFakeStoreClientProductDtoToProduct(fakeStoreProduct);
    }

    @Override
    public Product deleteProduct(Long productId) {
        FakeStoreClientProductDto fakeStoreProduct = fakeStoreClient.deleteProduct(productId);
        assert fakeStoreProduct != null;
        return DataConvertor.convertFakeStoreClientProductDtoToProduct(fakeStoreProduct);
    }
}
