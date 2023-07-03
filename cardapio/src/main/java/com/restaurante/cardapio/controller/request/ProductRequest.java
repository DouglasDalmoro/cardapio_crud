package com.restaurante.cardapio.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    public static final String ERROR_MESSAGE_PRODUCT_NAME_EMPTY = "O campo nome do produto é obrigatório";
    public static final String ERROR_MESSAGE_DESCRIPTION_EMPTY = "O campo descrição é obrigatório";
    @NotBlank(message = ERROR_MESSAGE_PRODUCT_NAME_EMPTY)
    private String productName;

    @NotBlank(message = ERROR_MESSAGE_DESCRIPTION_EMPTY)
    private String description;

    private String image;
}
