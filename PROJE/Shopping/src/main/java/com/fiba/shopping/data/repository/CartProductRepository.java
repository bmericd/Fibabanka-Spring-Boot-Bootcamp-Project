package com.fiba.shopping.data.repository;

import com.fiba.shopping.business.dto.CartProductDto;
import com.fiba.shopping.data.entity.CartProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CartProductRepository extends CrudRepository<CartProduct,Long> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("delete from CartProduct as p where p.cart.cartId =:cartId and p.productId =:productId ")
    void deleteCartProductByCartId(@Param("cartId") long cartId,@Param("productId") long productId);


}
