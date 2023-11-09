package br.com.fiap.challenge.model.response;

import br.com.fiap.challenge.model.entities.ShoppingItem;

public record ShoppingItemResponse(String title,
                                   String link,
                                   String source,
                                   String price,
                                   Double rating,
                                   String thumbnail,
                                   String delivery
) {
    public ShoppingItemResponse(ShoppingItem shoppingItem) {
        this(
                shoppingItem.getTitle(),
                shoppingItem.getLink(),
                shoppingItem.getSource(),
                shoppingItem.getPrice(),
                shoppingItem.getRating(),
                shoppingItem.getThumbnail(),
                shoppingItem.getDelivery()
        );
    }
}
