package com.example.tddminiproj.repository;

import com.example.tddminiproj.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void shouldSaveOrder() {
        // Arrange
        Order order = new Order(null, "John Doe", LocalDate.now(), "123 Street, City", 100.0);

        // Act
        Order savedOrder = orderRepository.save(order);

        // Assert
        assertThat(savedOrder.getId()).isNotNull();
        assertThat(savedOrder.getCustomerName()).isEqualTo("John Doe");
        assertThat(savedOrder.getTotal()).isEqualTo(100.0);
    }

    @Test
    public void shouldFindOrderById() {
        // Arrange
        Order order = new Order(null, "John Doe", LocalDate.now(), "123 Street, City", 100.0);
        Order savedOrder = orderRepository.save(order);

        // Act
        Order foundOrder = orderRepository.findById(savedOrder.getId()).orElse(null);

        // Assert
        assertThat(foundOrder).isNotNull();
        assertThat(foundOrder.getId()).isEqualTo(savedOrder.getId());
    }

    @Test
    public void shouldUpdateOrder() {
        // Arrange
        Order order = new Order(null, "John Doe", LocalDate.now(), "123 Street, City", 100.0);
        Order savedOrder = orderRepository.save(order);

        // Act
        savedOrder.setTotal(200.0);
        Order updatedOrder = orderRepository.save(savedOrder);

        // Assert
        assertThat(updatedOrder.getTotal()).isEqualTo(200.0);
    }

    @Test
    public void shouldDeleteOrder() {
        // Arrange
        Order order = new Order(null, "John Doe", LocalDate.now(), "123 Street, City", 100.0);
        Order savedOrder = orderRepository.save(order);

        // Act
        orderRepository.deleteById(savedOrder.getId());
        boolean exists = orderRepository.existsById(savedOrder.getId());

        // Assert
        assertThat(exists).isFalse();
    }



}
