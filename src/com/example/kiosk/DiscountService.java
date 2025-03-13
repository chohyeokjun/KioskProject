package com.example.kiosk;

//할인률 적용 인터페이스
@FunctionalInterface
interface DiscountService {
    int discountFee(int price);
}