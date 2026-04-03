package com.banking.ms.bankingmsproducts.service;

import com.banking.ms.bankingmsproducts.model.Product;
import reactor.core.publisher.Flux;

public interface ProductService {
    Flux<Product> findByUniqueClientId(String uniqueClientId);
}
