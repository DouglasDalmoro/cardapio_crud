package com.restaurante.cardapio.mapper;

import com.restaurante.cardapio.controller.response.ProductResponse;
import com.restaurante.cardapio.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.restaurante.cardapio.factory.ProductFactory.createProduct;
import static com.restaurante.cardapio.mapper.ProductMapper.toResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProductMapperTest {

    @Test
    @DisplayName("Must return complete response when receiving a complete product")
    void mustReturnCompleteResponse(){
        Product product = createProduct();
        ProductResponse response = toResponse(product);

        assertEquals(product.getId(), response.getId());
        assertEquals(product.getProductName(), response.getProductName());
        assertEquals(product.getDescription(), response.getDescription());
        assertEquals(product.getUpdatedOn().getDayOfMonth(), response.getCreatedOn().getDayOfMonth());
        assertEquals(product.getUpdatedOn().getDayOfMonth(), response.getUpdatedOn().getDayOfMonth());
        assertEquals(product.getImage(), response.getImage());
        assertEquals(product.isActive(), response.isActive());
    }
}
