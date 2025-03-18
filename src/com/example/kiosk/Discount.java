package com.example.kiosk;

import java.util.Arrays;

//할인 enum
enum Discount{
    PARTICIPATION ( 1, (totalFee) -> (totalFee - totalFee * 10 /100)),
    NON_PARTICIPATION ( 2, (totalFee) -> (totalFee));

    private final int num;
    private final DiscountService discountFee;

    Discount(int num, DiscountService discountFee) {
        this.num = num;
        this.discountFee = discountFee;
    }
    // 매개변수를 입력받아 할인 받은 금액 반환
    public int discount (int totalFee) {
        return discountFee.discountFee(totalFee);
    }
    // 입력 받은 input5가 참여와 불참의 num과 일치하는지 확인
    public static Discount of(int input5) { //메서드 명을 of로 바꾸는 편이 코드를 봤을 때 직관적!

//        if (input5 > 0 && input5 < Discount.values().length) {
//            return Discount.values()[input5];
//        }
        // 위의 식의랑 동일
        return Arrays.stream(Discount.values())
                .filter(check -> input5 == check.num)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 숫자가 아닙니다."));
        }
    }

