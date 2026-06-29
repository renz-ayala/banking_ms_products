package com.banking.ms.bankingmsproducts.service;

import com.banking.ms.bankingmsproducts.controller.response.ProductResponse;
import reactor.core.publisher.Flux;

public interface ProductService {
    Flux<ProductResponse> findByUniqueClientId(String uniqueClientId);
}
