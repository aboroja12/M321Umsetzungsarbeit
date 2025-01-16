package ch.bbw.umsetzungsarbeit.controller;

import ch.bbw.umsetzungsarbeit.model.CartItem;
import ch.bbw.umsetzungsarbeit.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

  private final CartService cartService;

  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @PostMapping
  public ResponseEntity<String> addItemToCart(@RequestBody CartItem item) {
    cartService.addItem(item);
    return ResponseEntity.ok("Item added to cart");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> removeItemFromCart(@PathVariable String id) {
    cartService.removeItem(id);
    return ResponseEntity.ok("Item removed from cart");
  }

  @GetMapping
  public ResponseEntity<List<CartItem>> getCartItems() {
    return ResponseEntity.ok(cartService.getCartItems());
  }
}
