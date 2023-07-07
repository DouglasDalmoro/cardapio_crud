package com.restaurante.cardapio.service;

import com.restaurante.cardapio.controller.request.ProductRequest;
import com.restaurante.cardapio.domain.Product;
import com.restaurante.cardapio.repository.ProductRepository;
import com.restaurante.cardapio.validator.ProductAtivoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Service
public class ChangeProductService {

    @Autowired
    private FindProductService findProductService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductAtivoValidator productAtivoValidator;

    public void change(Long id, ProductRequest request) {

        Product product = findProductService.findById(id);
        productAtivoValidator.validateProduct(product);
        
        LocalDateTime currentDate = now();
        product.setUpdatedOn(currentDate);
        product.setProductName(request.getProductName());
        product.setImage(request.getImage());

        productRepository.save(product);
    }
}
