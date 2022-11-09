package com.fiba.shopping.business.service;

import com.fiba.shopping.business.dto.CartDto;
import com.fiba.shopping.business.dto.CartProductDto;
import com.fiba.shopping.data.entity.Cart;
import com.fiba.shopping.data.entity.CartProduct;
import com.fiba.shopping.data.repository.CartProductRepository;
import com.fiba.shopping.data.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    private CartRepository cartRepository;
    private CartProductRepository cartProductRepository;

    public CartServiceImpl(CartRepository cartRepository, CartProductRepository cartProductRepository){
        this.cartRepository= cartRepository;
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public long create() {
        Cart cart = new Cart();
        cart.setCartStatus(false);
        cart.setTotalAmount(0);
        Cart cart1= cartRepository.save(cart);
        long cartId = cart1.getCartId();
        return cartId;
    }

    @Override
    public String checkout(long cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isPresent()){
            Cart updatedCart = new Cart();
            updatedCart = optionalCart.get();
            updatedCart.setCartStatus(true);
            cartRepository.save(updatedCart);
            return "Checkout has been made.";
        }
        return "Cart not found.";
    }

    @Override
    public CartDto find(long cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isPresent()){
            CartDto cartDto = new CartDto();
            cartDto.setCartId(optionalCart.get().getCartId());
            cartDto.setCartStatus(optionalCart.get().isCartStatus());
            cartDto.setCustomerName(optionalCart.get().getCustomerName());
            cartDto.setTotalAmount(optionalCart.get().getTotalAmount());

            List<CartProduct> cartProductList = cartRepository.findAllByCartId(cartId);
            List<CartProductDto> cartProductDtoList = new ArrayList<>();
            for(CartProduct cartProduct: cartProductList){
                CartProductDto cartProductDto = new CartProductDto();
                cartProductDto.setCartId(cartProduct.getCart().getCartId());
                cartProductDto.setCartProductId(cartProduct.getCartProductId());
                cartProductDto.setProductId(cartProduct.getProductId());
                cartProductDto.setSalesPrice(cartProduct.getSalesPrice());
                cartProduct.setSalesQuantity(cartProduct.getSalesQuantity());
                cartProductDto.setLineAmount(cartProduct.getLineAmount());
                cartProductDtoList.add(cartProductDto);
            }

            cartDto.setCartProductDtoList(cartProductDtoList);
            return  cartDto;
        }
        return null;
    }
}
