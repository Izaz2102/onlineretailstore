package com.ors.inventoryservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inventory {
    @Id
    @GeneratedValue(generator = "uuid")
    private UUID inventoryId;

    private UUID productId;

    private int quantity;
}
