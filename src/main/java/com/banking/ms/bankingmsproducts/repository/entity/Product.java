package com.banking.ms.bankingmsproducts.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("products")
public class Product {
    @Id
    @Column("product_id")
    private Long productId;
    @Column("unique_client_id")
    private String uniqueClientId;
    @Column("product_type")
    private String productType;
    @Column("product_name")
    private String productName;
    @Column("balance")
    private Double balance;
}
