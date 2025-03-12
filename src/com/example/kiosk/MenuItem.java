package com.example.kiosk;

public class MenuItem {
    //속성
    private String name;
    private int fee;
    private String introduction;

    //생성자
    public MenuItem (String name, int fee, String introduction) {
        this.name = name;
        this.fee = fee;
        this.introduction = introduction;
    }

    //메서드

    //getter
    public String getInfo () {
        return  name + " :  " + fee + "원" + "  |  " + introduction;
    }
    // 총 주문 금액으로 합산을 위한 getter
    public int getFee () {
        return fee;
    }
}