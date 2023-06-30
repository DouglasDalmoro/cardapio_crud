package com.restaurante.cardapio.service;

import com.restaurante.cardapio.domain.Product;
import com.restaurante.cardapio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService {

    @Autowired
    private FindProductService findProductService;

    @Autowired
    private ProductRepository productRepository;

    public void delete(Long id) {
        Product product = findProductService.findById(id);

        product.setActive(false);

        productRepository.save(product);
    }
}
