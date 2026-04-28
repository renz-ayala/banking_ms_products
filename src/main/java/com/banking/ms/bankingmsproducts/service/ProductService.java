package com.banking.ms.bankingmsproducts.service;

import com.banking.ms.bankingmsproducts.repository.entity.Product;
import reactor.core.publisher.Flux;

public interface ProductService {
    Flux<Product> findByUniqueClientId(String uniqueClientId);
}
