package com.iamslash.wfmongo;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author iamslash
 */
@Service
class CartService {

  private final ItemRepository itemRepository;
  private final CartRepository cartRepository;

  CartService(ItemRepository itemRepository,
      CartRepository cartRepository) {
    this.itemRepository = itemRepository;
    this.cartRepository = cartRepository;
  }

  Mono<Cart> addToCart(String cartId, String id) {
    return this.cartRepository
        .findById(cartId) //
        .defaultIfEmpty(new Cart(cartId)) //
        .flatMap(cart -> cart.getCartItems().stream() //
            .filter(cartItem -> cartItem.getItem().getId().equals(id)) //
            .findAny() //
            .map(cartItem -> {
              cartItem.increment();
              return Mono.just(cart);
            })
            .orElseGet(() -> {
              return this.itemRepository.findById(id) //
                  .map(CartItem::new) // <4>
                  .doOnNext(cartItem -> cart.getCartItems().add(cartItem)) //
                  .map(cartItem -> cart);
            }))
        .flatMap(this.cartRepository::save); // <5>
  }
}
