package com.example.tddminiproj.controller;

import com.example.tddminiproj.exception.OrderNotFoundException;
import com.example.tddminiproj.model.Order;
import com.example.tddminiproj.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    private Order order;

    @BeforeEach
    public void setup() {
        order = new Order(1L, "John Doe", LocalDate.now(), "123 Street, City", 100.0);
    }

    @Test
    public void shouldFailWhenUpdatingNonExistentOrder() throws Exception {
        when(orderService.updateOrder(Mockito.any(Order.class))).thenThrow(new OrderNotFoundException("Order not found"));

        mockMvc.perform(put("/api/orders/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"customerName\": \"Jane Doe\", \"orderDate\": \"2024-09-12\", \"shippingAddress\": \"456 Avenue, City\", \"total\": 200.0}"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldFailWhenDeletingNonExistentOrder() throws Exception {
        Mockito.doThrow(new OrderNotFoundException("Order not found")).when(orderService).deleteOrder(1L);

        mockMvc.perform(delete("/api/orders/1"))
                .andExpect(status().isNotFound());
    }
}