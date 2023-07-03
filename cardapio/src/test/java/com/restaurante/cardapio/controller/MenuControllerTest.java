package com.restaurante.cardapio.controller;

import com.restaurante.cardapio.controller.response.ProductResponse;
import com.restaurante.cardapio.domain.Product;
import com.restaurante.cardapio.factory.ProductFactory;
import com.restaurante.cardapio.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.restaurante.cardapio.factory.ProductFactory.createProduct;
import static com.restaurante.cardapio.factory.ProductFactory.createProductResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MenuController.class)
public class MenuControllerTest {

    public static final String URL_CONTROLLER = "/v1/menu/";
    @MockBean
    private MockMvc mockMvc;

    @MockBean
    private IncludeProductService includeProductService;

    @MockBean
    private ChangeProductService changeProductService;

    @MockBean
    private ListProductsService listProductsService;

    @MockBean
    private ListProductsInactiveService listProductsInactiveService;

    @MockBean
    private DetailProductService detailProductService;

    @MockBean
    private FindProductService findProductService;

    @Mock
    private DeleteProductService service;

    @Test
    public void controllerMustReturnTheServiceObject() throws Exception {
        ProductResponse productResponse = createProductResponse();

        Mockito.when(detailProductService.detail(1L)).thenReturn(productResponse);

        this.mockMvc.perform(delete(URL_CONTROLLER + "product/{id}")).andDo(print()).andExpect(status().isOk());
    }
}
