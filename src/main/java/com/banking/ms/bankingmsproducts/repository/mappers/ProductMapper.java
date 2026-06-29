package com.banking.ms.bankingmsproducts.repository.mappers;

import com.banking.ms.bankingmsproducts.controller.response.ProductResponse;
import com.banking.ms.bankingmsproducts.repository.entity.Product;

public class ProductMapper {

    public static ProductResponse mapProduct(Product product){
        return new ProductResponse(
                product.getProductType(),
                product.getProductName(),
                product.getBalance()
        );
    }
}
