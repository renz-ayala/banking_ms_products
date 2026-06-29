package com.banking.ms.bankingmsproducts.controller;

import com.banking.ms.bankingmsproducts.controller.response.ProductResponse;
import com.banking.ms.bankingmsproducts.repository.entity.Product;
import com.banking.ms.bankingmsproducts.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get-products/{uniqueClientId}")
    public Flux<ProductResponse> findByUniqueClientId(@PathVariable  String uniqueClientId) {
        return productService.findByUniqueClientId(uniqueClientId);
    }
}
