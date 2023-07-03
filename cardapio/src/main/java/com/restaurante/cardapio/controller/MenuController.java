package com.restaurante.cardapio.controller;

import com.restaurante.cardapio.controller.request.ProductRequest;
import com.restaurante.cardapio.controller.response.IdResponse;
import com.restaurante.cardapio.controller.response.ProductResponse;
import com.restaurante.cardapio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("v1/menu")
public class MenuController {

    @Autowired
    private IncludeProductService includeProductService;

    @Autowired
    private ChangeProductService changeProductService;

    @Autowired
    private ListProductsService listProductsService;

    @Autowired
    private ListProductsInactiveService listProductsInactiveService;

    @Autowired
    private DetailProductService detailProductService;

    @Autowired
    private DeleteProductService deleteProductService;

    @PostMapping()
    @ResponseStatus(CREATED)
    public IdResponse createProduct(@Valid @RequestBody ProductRequest request) {
        return includeProductService.include(request);
    }

    @PutMapping("/product/{id}")
    public void changeProduct(@PathVariable Long id, @Valid @RequestBody ProductRequest request){
        changeProductService.change(id, request);
    }

    @GetMapping
    @ResponseStatus(OK)
    public Page<ProductResponse> listProducts(Pageable pageable){
        return listProductsService.list(pageable);
    }

    @GetMapping("/products-inactives")
    @ResponseStatus(OK)
    public Page<ProductResponse> listProductsInactive(Pageable pageable){
        return listProductsInactiveService.list(pageable);
    }

    @GetMapping("/product/{id}")
    @ResponseStatus(OK)
    public ProductResponse detailProduct(@PathVariable Long id){
        return detailProductService.detail(id);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id){
        deleteProductService.delete(id);
    }

}
