package com.banking.ms.bankingmsproducts.controller.response;

public record ProductResponse(
        String productType,
        String productName,
        Double balance
) {
}
