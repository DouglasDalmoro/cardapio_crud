package com.restaurante.cardapio.mapper;

import com.restaurante.cardapio.controller.response.IdResponse;
import com.restaurante.cardapio.domain.Product;

public class IdMapper {


    public static IdResponse toResponse(Product product) {
        return IdResponse.builder()
                .id(product.getId())
                .build();
    }
}
