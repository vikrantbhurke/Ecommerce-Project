package com.example.productservice_proxy.controllers;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.services.IProductService;
import com.example.productservice_proxy.utils.UtilClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.example.productservice_proxy.utils.DataConvertor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getProducts() {
        try {
            MultiValueMap<String, String> headers = UtilClass.getHeaders();
            List<Product> products = this.productService.getProducts();
            List<ProductDto> productDtos = new ArrayList<>();
            for (Product product : products) {
                productDtos.add(DataConvertor.convertProductToProductDto(product));
            }
            return new ResponseEntity<>(productDtos, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") Long productId) {
        try {
            MultiValueMap<String, String> headers = UtilClass.getHeaders();
            Product product = this.productService.getProduct(productId);
            ProductDto productDto = DataConvertor.convertProductToProductDto(product);
            return new ResponseEntity<>(productDto, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        try {
            MultiValueMap<String, String> headers = UtilClass.getHeaders();
            Product product = this.productService.addProduct(DataConvertor.convertProductDtoToProduct(productDto));
            ProductDto productDto1 = DataConvertor.convertProductToProductDto(product);
            return new ResponseEntity<>(productDto1, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> putProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {
        try {
            MultiValueMap<String, String> headers = UtilClass.getHeaders();
            Product product = this.productService.putProduct(productId, DataConvertor.convertProductDtoToProduct(productDto));
            ProductDto productDto1 = DataConvertor.convertProductToProductDto(product);
            return new ResponseEntity<>(productDto1, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductDto> patchProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {
        try {
            MultiValueMap<String, String> headers = UtilClass.getHeaders();
            Product product = this.productService.patchProduct(productId, DataConvertor.convertProductDtoToProduct(productDto));
            ProductDto productDto1 = DataConvertor.convertProductToProductDto(product);
            return new ResponseEntity<>(productDto1, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable("productId") Long productId) {
        try {
            MultiValueMap<String, String> headers = UtilClass.getHeaders();
            Product product = this.productService.deleteProduct(productId);
            ProductDto productDto1 = DataConvertor.convertProductToProductDto(product);
            return new ResponseEntity<>(productDto1, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
