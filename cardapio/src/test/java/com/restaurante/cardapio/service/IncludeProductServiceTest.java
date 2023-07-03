package com.restaurante.cardapio.service;

import com.restaurante.cardapio.controller.request.ProductRequest;
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

import static com.restaurante.cardapio.factory.ProductFactory.createProductRequest;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class IncludeProductServiceTest {

    @InjectMocks
    private IncludeProductService test;

    @Mock
    private ProductRepository productRepository;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Test
    @DisplayName("Must return id response when request is correct")
    void mustReturnIdResponse() {
        ProductRequest request = createProductRequest();

        test.include(request);

        verify(productRepository).save(productCaptor.capture());
    }
}
