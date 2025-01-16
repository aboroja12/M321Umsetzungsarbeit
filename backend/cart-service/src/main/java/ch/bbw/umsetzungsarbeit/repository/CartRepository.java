package ch.bbw.umsetzungsarbeit.repository;

import ch.bbw.umsetzungsarbeit.model.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<CartItem, String> {
}
