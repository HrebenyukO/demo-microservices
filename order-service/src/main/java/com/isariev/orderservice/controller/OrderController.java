package com.isariev.orderservice.controller;

import com.isariev.orderservice.dto.OrderRequest;
import com.isariev.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public void placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
    }

  /*  public CompletableFuture<String> placeOrderFallback(OrderRequest orderRequest, RuntimeException e) {
        return CompletableFuture.supplyAsync(() -> "Oops! Sth went wrong, please try to order later!");
    }*/
}
