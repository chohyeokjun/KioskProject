package com.example.kiosk;

public class Main {
    public static void main(String[] args) {
        //Kiosk 객체 생성
        Kiosk kiosk = new Kiosk();
        //Kiosk 함수 호출
        kiosk.start();
        kiosk.gymList();
        kiosk.end();
    }
}