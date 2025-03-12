package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //속성
    private List<MenuItem> cart;

    //생성자
    public Cart() {
        this.cart = new ArrayList<>();
    }

    //메서드
    //장바구니 리스트 추가
    public void addCart(MenuItem menuItem) {
        cart.add(menuItem);
    }

    //장바구니 리스트 반환
    public List<MenuItem> getCart() {
        return cart;
    }

    //장바구니 리스트 초기화
    public void removeAllCart() {
        cart.clear();
    }

    //장바구니 리스트 삭제
//    public void removeCart(int index) {
//        cart.remove(index);
//    }
}