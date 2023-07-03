package com.restaurante.cardapio.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductResponse {

    private Long id;
    private String productName;
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private String image;
    private boolean active;
}
