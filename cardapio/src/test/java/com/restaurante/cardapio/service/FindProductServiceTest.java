package com.restaurante.cardapio.service;

import com.restaurante.cardapio.domain.Product;
import com.restaurante.cardapio.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static com.restaurante.cardapio.factory.ProductFactory.createProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindProductServiceTest {

    @InjectMocks
    private FindProductService test;

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("Must return product when product is successfully found")
    void mustReturnProduct() {
        Product product = createProduct();
        Long id = 1L;

        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        Product response = test.findById(id);

        verify(productRepository).findById(id);
        assertEquals(product.getId(), response.getId());
        assertEquals(product.getProductName(), response.getProductName());
        assertEquals(product.getDescription(), response.getDescription());
        assertEquals(product.getUpdatedOn().getDayOfMonth(), response.getCreatedOn().getDayOfMonth());
        assertEquals(product.getUpdatedOn().getDayOfMonth(), response.getUpdatedOn().getDayOfMonth());
        assertEquals(product.getImage(), response.getImage());
        assertEquals(product.isActive(), response.isActive());
    }

    @Test
    @DisplayName("Should return error message when product is not successfully found")
    void shouldReturnErrorMessage() {
        String errorMessage = "Produto não encontrado";
        Long id = 1L;

        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () -> test.findById(id));

        assertEquals(errorMessage, exception.getReason());
    }
}
