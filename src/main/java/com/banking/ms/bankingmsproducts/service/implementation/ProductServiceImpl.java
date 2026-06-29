package com.banking.ms.bankingmsproducts.service.implementation;

import com.banking.ms.bankingmsproducts.controller.response.ProductResponse;
import com.banking.ms.bankingmsproducts.repository.ProductRepository;
import com.banking.ms.bankingmsproducts.repository.mappers.ProductMapper;
import com.banking.ms.bankingmsproducts.service.ProductService;
import com.nimbusds.jose.shaded.gson.Gson;
import gg.renz.CryptUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final CryptUtil cryptUtil;
    private final ProductRepository productRepository;

    Gson gson = new Gson();

    @Override
    public Flux<ProductResponse> findByUniqueClientId(String uniqueClientId) {
        String decryptedUniqueId = cryptUtil.decrypt(uniqueClientId);
        return productRepository
                .findByUniqueClientId(decryptedUniqueId)
                .map(
                        entity -> {
                            ProductResponse response = ProductMapper.mapProduct(entity);
                            log.info("Products results: {}", gson.toJson(response));
                            return response;
                        }
                );
    }


}
