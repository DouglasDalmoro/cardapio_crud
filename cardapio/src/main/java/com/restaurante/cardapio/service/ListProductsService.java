package com.restaurante.cardapio.service;

import com.restaurante.cardapio.controller.response.ProductResponse;
import com.restaurante.cardapio.mapper.ProductMapper;
import com.restaurante.cardapio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListProductsService {

    @Autowired
    private ProductRepository productRepository;

    public Page<ProductResponse> list(Pageable pageable) {
        return productRepository.findAllByActive(true, pageable)
                .map(ProductMapper::toResponse);
    }
}
