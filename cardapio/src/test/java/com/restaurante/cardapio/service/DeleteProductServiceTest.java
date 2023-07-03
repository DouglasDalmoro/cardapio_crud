package com.restaurante.cardapio.service;

import com.restaurante.cardapio.domain.Product;
import com.restaurante.cardapio.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.restaurante.cardapio.factory.ProductFactory.createProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeleteProductServiceTest {

    @InjectMocks
    private DeleteProductService test;

    @Mock
    private FindProductService findProductService;

    @Mock
    private ProductRepository productRepository;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Test
    @DisplayName("Must return void when successfully delete product")
    void mustFinishWhenProductSuccessfullyDeleted(){
        Product product = createProduct();

        when(findProductService.findById(product.getId())).thenReturn(product);

        test.delete(product.getId());

        verify(findProductService).findById(product.getId());
        verify(productRepository).save(productCaptor.capture());
        assertEquals(product.isActive(), false);
    }
}
