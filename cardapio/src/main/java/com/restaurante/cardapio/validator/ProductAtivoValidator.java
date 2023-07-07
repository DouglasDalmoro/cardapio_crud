package com.restaurante.cardapio.validator;

import com.restaurante.cardapio.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ProductAtivoValidator {

    public static final String ERROR_MESSAGE_PRODUCT_NOT_FOUND = "Produto não encontrado ou foi removido";

    public void validateProduct(Product product) throws ResponseStatusException {
        if(!product.isActive()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ERROR_MESSAGE_PRODUCT_NOT_FOUND);
        }
    }
}
