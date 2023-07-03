package com.restaurante.cardapio.factory;

import com.restaurante.cardapio.controller.request.ProductRequest;
import com.restaurante.cardapio.controller.response.ProductResponse;
import com.restaurante.cardapio.domain.Product;

import static java.time.LocalDateTime.now;

public class ProductFactory {

    public static Product createProduct(){
        Product product = new Product();
        product.setId(1L);
        product.setProductName("X-salada");
        product.setDescription("Pão de hamburguer, hamburguer, queijo, milho, alface, tomate, maionese");
        product.setCreatedOn(now());
        product.setUpdatedOn(now());
        product.setImage("image");
        product.setActive(true);
        return product;
    }

    public static Product createProductInative(){
        Product product = new Product();
        product.setId(1L);
        product.setProductName("X-salada");
        product.setDescription("Pão de hamburguer, hamburguer, queijo, milho, alface, tomate, maionese");
        product.setCreatedOn(now());
        product.setUpdatedOn(now());
        product.setImage("image");
        product.setActive(false);
        return product;
    }

    public static ProductResponse createProductResponse(){
        return ProductResponse.builder()
            .id(1L)
            .productName("X-salada")
            .description("Pão de hamburguer, hamburguer, queijo, milho, alface, tomate, maionese")
            .createdOn(now())
            .updatedOn(now())
            .image("image")
            .active(false)
            .build();
    }

    public static ProductRequest createProductRequest(){
        return ProductRequest.builder()
                .productName("X-salada")
                .description("Pão de hamburguer, hamburguer, queijo, milho, alface, tomate, maionese")
                .image("image")
                .build();
    }
}
