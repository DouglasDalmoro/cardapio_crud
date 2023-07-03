package com.restaurante.cardapio.service;

import com.restaurante.cardapio.controller.response.ProductResponse;
import com.restaurante.cardapio.domain.Product;
import com.restaurante.cardapio.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static com.restaurante.cardapio.factory.ProductFactory.createProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListProductsServiceTest {

    @InjectMocks
    private ListProductsService test;

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("It should return an empty product list if it does not have courses")
    void  shouldReturnEmptyProductList(){
        List<Product> products = List.of();
        Page<Product> productsResearched = new PageImpl<>(products);
        PageRequest pageable = PageRequest.of(0, 10);

        when(productRepository.findAllByActive(true, pageable))
                .thenReturn(productsResearched);

        Page<ProductResponse> response = test.list(pageable);

        verify(productRepository).findAllByActive(true, pageable);
        assertEquals(products.size(), response.getSize());
    }

    @Test
    @DisplayName("Should return a list of products if it has courses")
    void  shouldReturnProductList(){
        List<Product> products = List.of(
                createProduct(),
                createProduct()
        );
        Page<Product> productsResearched = new PageImpl<>(products);
        PageRequest pageable = PageRequest.of(0, 10);

        when(productRepository.findAllByActive(true, pageable))
                .thenReturn(productsResearched);

        Page<ProductResponse> response = test.list(pageable);

        verify(productRepository).findAllByActive(true, pageable);
        assertEquals(products.size(), response.getSize());
        assertEquals(products.get(0).getId(), response.getContent().get(0).getId());
        assertEquals(products.get(1).getId(), response.getContent().get(1).getId());


    }
}
