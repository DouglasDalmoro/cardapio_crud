package com.restaurante.cardapio.mapper;

import com.restaurante.cardapio.controller.response.ProductsResponse;
import com.restaurante.cardapio.domain.Product;

public class ProductsMapper {
    public static ProductsResponse toResponse(Product product) {
        return ProductsResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .createdOn(product.getCreatedOn())
                .updatedOn(product.getUpdatedOn())
                .image(product.getImage())
                .active(product.isActive())
                .build();
    }
}
