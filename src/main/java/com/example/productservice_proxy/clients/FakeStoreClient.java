package com.example.productservice_proxy.clients;

import com.example.productservice_proxy.dtos.FakeStoreClientProductDto;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.utils.DataConvertor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class FakeStoreClient {
    private final WebClient webClient = WebClient.builder().baseUrl("https://fakestoreapi.com").build();

    public List<FakeStoreClientProductDto> getProducts() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(FakeStoreClientProductDto.class).collectList().block();
    }

    public FakeStoreClientProductDto getProduct(Long productId) {
       return webClient.get()
                .uri("/products/{productId}", productId)
                .retrieve()
                .bodyToMono(FakeStoreClientProductDto.class)
                .block();
    }

    public FakeStoreClientProductDto addProduct(Product product) {
        return webClient.post()
                .uri("/products")
                .body(BodyInserters.fromValue(DataConvertor.convertProductToFakeStoreClientProductDto(product)))
                .retrieve()
                .bodyToMono(FakeStoreClientProductDto.class)
                .block();
    }

    public FakeStoreClientProductDto putProduct(Long productId, Product product) {
        return webClient.put()
                .uri("/products/{id}", productId)
                .body(BodyInserters.fromValue(DataConvertor.convertProductToFakeStoreClientProductDto(product)))
                .retrieve()
                .bodyToMono(FakeStoreClientProductDto.class)
                .block();
    }

    public FakeStoreClientProductDto patchProduct(Long productId, Product product) {
        return webClient.patch()
                .uri("/products/{id}", productId)
                .body(BodyInserters.fromValue(DataConvertor.convertProductToFakeStoreClientProductDto(product)))
                .retrieve()
                .bodyToMono(FakeStoreClientProductDto.class)
                .block();
    }

    public FakeStoreClientProductDto deleteProduct(Long productId) {
        return webClient.delete()
                .uri("/products/{productId}", productId)
                .retrieve()
                .bodyToMono(FakeStoreClientProductDto.class)
                .block();
    }

    public String[] getCategories() throws JsonProcessingException {
        String categoriesResponse = webClient.get()
                .uri("/products/categories")
                .retrieve()
                .bodyToMono(String.class).block();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(categoriesResponse, String[].class);
    }

    public List<FakeStoreClientProductDto> getProductsInCategory(String categoryId) {
        return webClient.get()
                .uri("/products/category/{categoryId}", categoryId)
                .retrieve()
                .bodyToFlux(FakeStoreClientProductDto.class).collectList()
                .block();
    }
}
