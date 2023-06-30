package com.restaurante.cardapio.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProductRequest {

    public static final String MESSAGE_ERROR_PRODUCT_NAME_EMPTY = "O campo nome do produto é obrigatório";
    @NotBlank(message = MESSAGE_ERROR_PRODUCT_NAME_EMPTY)
    private String productName;

    private String image;
}
