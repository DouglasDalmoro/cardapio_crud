package com.restaurante.cardapio.mapper;

import com.restaurante.cardapio.controller.request.ProductRequest;
import com.restaurante.cardapio.domain.Product;

public class IncludeProductMapper {
    public static Product toEntity(ProductRequest request) {
        return Product.builder()
                .productName(request.getProductName())
                .image(request.getImage())
                .build();
    }
}
