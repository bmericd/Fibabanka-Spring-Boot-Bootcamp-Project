package com.fiba.shopping.data.repository;

import com.fiba.shopping.business.dto.CartProductDto;
import com.fiba.shopping.data.entity.Cart;
import com.fiba.shopping.data.entity.CartProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart,Long> {
    @Query("select p from CartProduct as p where p.cart.cartId =:cartId")
    List<CartProduct> findAllByCartId(@Param("cartId") long cartId);
}
