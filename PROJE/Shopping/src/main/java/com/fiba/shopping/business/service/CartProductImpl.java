package com.fiba.shopping.business.service;

import com.fiba.shopping.business.dto.CartProductDto;
import com.fiba.shopping.data.entity.Cart;
import com.fiba.shopping.data.entity.CartProduct;
import com.fiba.shopping.data.repository.CartProductRepository;
import com.fiba.shopping.data.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartProductImpl implements CartProductService{

    private CartProductRepository cartProductRepository;
    private CartRepository cartRepository;

    public CartProductImpl(CartProductRepository cartProductRepository,CartRepository cartRepository){
        this.cartProductRepository = cartProductRepository;
        this.cartRepository = cartRepository;
    }


    @Override
    public String addProduct(CartProductDto cartProductDto) {
        Optional<Cart> optinalCart = cartRepository.findById(cartProductDto.getCartId());
        if(optinalCart.isPresent()){
            CartProduct cartProduct = new CartProduct();
            cartProduct.setSalesPrice(cartProductDto.getSalesPrice());
            cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());
            cartProduct.setProductId(cartProductDto.getProductId());
            cartProduct.setCart(optinalCart.get());

            //update cart amount
            Cart cart = optinalCart.get();
            cart.setTotalAmount(cart.getTotalAmount()+(cartProductDto.getSalesPrice()*cartProductDto.getSalesQuantity()));

            //update line amount
            cartProduct.setLineAmount(cartProductDto.getSalesPrice()*cartProductDto.getSalesQuantity());
            cartProductRepository.save(cartProduct);
            cartRepository.save(cart);
            return "Product added to the cart.";
        }
        return "Cart not found.";
    }

    @Override
    public String removeProductFromCart(long cartId, long productId) {
        try {
            cartProductRepository.deleteCartProductByCartId(cartId,productId);
        }catch (Exception e){
            return "Product and/or cart not found.";
        }
        return "Deleted the product from the cart.";
    }
}
