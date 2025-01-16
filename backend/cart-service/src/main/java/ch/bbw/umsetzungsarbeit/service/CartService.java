package ch.bbw.umsetzungsarbeit.service;

import ch.bbw.umsetzungsarbeit.model.CartItem;
import ch.bbw.umsetzungsarbeit.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

  private final CartRepository cartRepository;

  public CartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  public void addItem(CartItem item) {
    cartRepository.save(item);
  }

  public void removeItem(String id) {
    cartRepository.deleteById(id);
  }

  public List<CartItem> getCartItems() {
    return (List<CartItem>) cartRepository.findAll();
  }
}
