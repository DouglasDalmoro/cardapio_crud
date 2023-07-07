package com.restaurante.cardapio.service;

import com.restaurante.cardapio.controller.response.ProductResponse;
import com.restaurante.cardapio.domain.Product;
import com.restaurante.cardapio.validator.ProductAtivoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.restaurante.cardapio.mapper.ProductMapper.toResponse;

@Service
public class DetailProductService {

    @Autowired
    private FindProductService findProductService;

    @Autowired
    private ProductAtivoValidator productAtivoValidator;

    public ProductResponse detail(Long id) {

        Product product = findProductService.findById(id);
        productAtivoValidator.validateProduct(product);

        return toResponse(product);
    }
}
