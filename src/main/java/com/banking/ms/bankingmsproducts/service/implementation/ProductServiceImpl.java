package com.banking.ms.bankingmsproducts.service.implementation;

import com.banking.ms.bankingmsproducts.repository.entity.Product;
import com.banking.ms.bankingmsproducts.repository.ProductRepository;
import com.banking.ms.bankingmsproducts.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Flux<Product> findByUniqueClientId(String uniqueClientId) {
        return productRepository.findByUniqueClientId(uniqueClientId);
    }


}
