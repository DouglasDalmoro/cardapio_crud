package com.restaurante.cardapio.mapper;

import com.restaurante.cardapio.controller.response.IdResponse;
import com.restaurante.cardapio.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.restaurante.cardapio.factory.ProductFactory.createProduct;
import static com.restaurante.cardapio.mapper.IdMapper.toResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class IdMapperTest {

    @Test
    @DisplayName("Must return complete response when receiving a complete product")
    void mustReturnFullResponse(){
        Product product = createProduct();
        IdResponse response = toResponse(product);

        assertEquals(product.getId(), response.getId());
    }
}
