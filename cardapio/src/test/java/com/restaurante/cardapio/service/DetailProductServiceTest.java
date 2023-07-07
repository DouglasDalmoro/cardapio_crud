package com.restaurante.cardapio.service;

import com.restaurante.cardapio.controller.response.ProductResponse;
import com.restaurante.cardapio.domain.Product;
import com.restaurante.cardapio.validator.ProductAtivoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.restaurante.cardapio.factory.ProductFactory.createProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DetailProductServiceTest {

    @InjectMocks
    private DetailProductService test;

    @Mock
    private FindProductService findProductService;

    @Mock
    private ProductAtivoValidator productAtivoValidator;

    @Test
    @DisplayName("Should return product response when product is successfully found")
    void shouldReturnProductResponse(){

        Product product = createProduct();
        Long id = 1L;

        when(findProductService.findById(id)).thenReturn(product);

        ProductResponse response = test.detail(id);

        verify(findProductService).findById(id);
        verify(productAtivoValidator).validateProduct(product);
        assertEquals(product.getId(), response.getId());
        assertEquals(product.getProductName(), response.getProductName());
        assertEquals(product.getDescription(), response.getDescription());
        assertEquals(product.getUpdatedOn().getDayOfMonth(), response.getCreatedOn().getDayOfMonth());
        assertEquals(product.getUpdatedOn().getDayOfMonth(), response.getUpdatedOn().getDayOfMonth());
        assertEquals(product.getImage(), response.getImage());
        assertEquals(product.isActive(), response.isActive());
    }
}
