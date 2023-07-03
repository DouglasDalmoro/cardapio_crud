package com.restaurante.cardapio.mapper;

import com.restaurante.cardapio.controller.response.ProductResponse;
import com.restaurante.cardapio.domain.Product;

public class ProductMapper {
    public static ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .description(product.getDescription())
                .createdOn(product.getCreatedOn())
                .updatedOn(product.getUpdatedOn())
                .image(product.getImage())
                .active(product.isActive())
                .build();
    }
}
