package com.restaurante.cardapio.service;

import com.restaurante.cardapio.controller.request.ProductRequest;
import com.restaurante.cardapio.controller.response.IdResponse;
import com.restaurante.cardapio.domain.Product;
import com.restaurante.cardapio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.restaurante.cardapio.mapper.IdMapper.toResponse;
import static com.restaurante.cardapio.mapper.IncludeProductMapper.toEntity;
import static java.time.LocalDateTime.now;

@Service
public class IncludeProductService {

    @Autowired
    private ProductRepository productRepository;

    public IdResponse include(ProductRequest request) {

        LocalDateTime currentDate = now();

        Product product = toEntity(request);
        product.setActive(true);
        product.setCreatedOn(currentDate);
        product.setUpdatedOn(currentDate);

        productRepository.save(product);
        
        return toResponse(product);
    }
}
