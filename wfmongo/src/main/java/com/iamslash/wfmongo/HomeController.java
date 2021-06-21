package com.iamslash.wfmongo;


import org.springframework.web.bind.annotation.DeleteMapping;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.result.view.Rendering;

@Controller
public class HomeController {
  private ItemRepository itemRepository;
  private CartRepository cartRepository;
  private InventoryService inventoryService;
  private CartService cartService;

  public HomeController(ItemRepository itemRepository,
      CartRepository cartRepository,
      InventoryService inventoryService,
      CartService cartService) {
    this.itemRepository = itemRepository;
    this.cartRepository = cartRepository;
    this.inventoryService = inventoryService;
    this.cartService = cartService;
  }

  @GetMapping
  Mono<Rendering> home() { // <1>
    return Mono.just(Rendering.view("home.html") // <2>
        .modelAttribute("items", //
            this.itemRepository.findAll()) // <3>
        .modelAttribute("cart", //
            this.cartRepository.findById("My Cart") // <4>
                .defaultIfEmpty(new Cart("My Cart")))
        .build());
  }

  @PostMapping
  Mono<String> createItem(@ModelAttribute Item newItem) {
    return this.itemRepository
        .save(newItem)
        .thenReturn("redirect:/");
  }

  @PostMapping("/add/{id}")
  Mono<String> addToCart(@PathVariable String id) {
    return cartService
        .addToCart("My Cart", id)
        .thenReturn("redirect:/");
  }

  @PostMapping("/delete/{id}")
  Mono<String> deleteItem(@PathVariable String id) {
    return this.itemRepository
        .deleteById(id)
        .thenReturn("redirect:/");
  }
}
