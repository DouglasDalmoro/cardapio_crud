package com.restaurante.cardapio.service;

import com.restaurante.cardapio.controller.response.ProductResponse;
import com.restaurante.cardapio.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.restaurante.cardapio.mapper.ProductMapper.toResponse;

@Service
public class DetailProductService {

    @Autowired
    private FindProductService findProductService;

    public ProductResponse detail(Long id) {

        Product product = findProductService.findById(id);

        return toResponse(product);
    }
}
