package com.restaurante.cardapio.service;

import com.restaurante.cardapio.controller.request.ProductRequest;
import com.restaurante.cardapio.domain.Product;
import com.restaurante.cardapio.repository.ProductRepository;
import com.restaurante.cardapio.validator.ProductAtivoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.restaurante.cardapio.factory.ProductFactory.createProduct;
import static com.restaurante.cardapio.factory.ProductFactory.createProductRequest;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChangeProductServiceTest {

    @InjectMocks
    private ChangeProductService test;

    @Mock
    private FindProductService findProductService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductAtivoValidator productAtivoValidator;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Test
    @DisplayName("Must return void when successfully created product")
    void mustFinishWhenProductSuccessfullyCreated(){

        Product product = createProduct();
        ProductRequest request = createProductRequest();

        when(findProductService.findById(product.getId())).thenReturn(product);

        test.change(product.getId(), request);

        verify(findProductService).findById(product.getId());
        verify(productAtivoValidator).validateProduct(product);
        verify(productRepository).save(productCaptor.capture());
    }
}
