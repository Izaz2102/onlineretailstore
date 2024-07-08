package com.ors.shoppingservice.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cart {
    private UUID cartId;
    private List<LineItem> lineItemList = new ArrayList<LineItem>();
}
