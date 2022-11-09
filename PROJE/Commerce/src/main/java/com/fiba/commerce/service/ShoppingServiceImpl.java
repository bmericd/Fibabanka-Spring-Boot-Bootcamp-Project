package com.fiba.commerce.service;

import com.fiba.commerce.client.InventoryClient;
import com.fiba.commerce.client.ShoppingClient;
import com.fiba.commerce.data.CartDto;
import com.fiba.commerce.data.CartProductDto;
import com.fiba.commerce.data.ProductDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService{

    private ShoppingClient shoppingClient;
    private InventoryClient inventoryClient;

    public ShoppingServiceImpl(ShoppingClient shoppingClient,InventoryClient inventoryClient){
        this.shoppingClient = shoppingClient;
        this.inventoryClient = inventoryClient;
    }

    @Override
    public long createCart() {
        return shoppingClient.createCart();
    }

    @Override
    public String checkoutCart(long cartId) {
        return shoppingClient.checkoutCart(cartId);
    }

    @Override
    public CartDto findCart(long cartId) {
        CartDto cartDto = shoppingClient.findCart(cartId);
        List<CartProductDto> cartProductDtoList = new ArrayList<>();
        List<ProductDto> productDtoList = new ArrayList<>();

        cartProductDtoList = cartDto.getCartProductDtoList();
        int i = 0;
        for(CartProductDto cartProductDto : cartDto.getCartProductDtoList()){
            String productName = inventoryClient.getProduct(cartProductDto.getProductId()).getProductName();
            cartProductDtoList.get(i).setProductName(productName);
            i++;
        }
        cartDto.setCartProductDtoList(cartProductDtoList);
        return cartDto;
    }

    @Override
    public String addProductToCart(CartProductDto cartProductDto) {
        ProductDto productDto = inventoryClient.getProduct(cartProductDto.getProductId());
        double salesPrice = productDto.getSalesPrice();
        cartProductDto.setSalesPrice(salesPrice);
        cartProductDto.setLineAmount(salesPrice*cartProductDto.getSalesQuantity());
        return shoppingClient.addProductToCart(cartProductDto);
    }

    @Override
    public String removeProductFromCart(long cartId, long productId) {
        return shoppingClient.removeProductFromCart(cartId,productId);
    }
}
