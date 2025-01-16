package ch.bbw.umsetzungsarbeit.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@RedisHash("CartItem")
public class CartItem {

  @Id
  private String id;
  private String productId;
  private int quantity;
}
