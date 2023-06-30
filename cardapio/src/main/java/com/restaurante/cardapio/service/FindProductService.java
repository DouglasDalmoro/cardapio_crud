package com.restaurante.cardapio.service;

import com.restaurante.cardapio.domain.Product;
import com.restaurante.cardapio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class FindProductService {

    public static final String ERROR_MESSAGE_PRODUCT_NOT_FOUND = "Produto não encontrado";

    @Autowired
    private ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, ERROR_MESSAGE_PRODUCT_NOT_FOUND));
    }
}