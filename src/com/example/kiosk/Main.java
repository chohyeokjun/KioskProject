package com.example.kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 변수 생성 및 선언
        String oneday = new String("1. 헬스장(일권) : 10,000원  |   설명1 ");
        String month1 = new String("2. 헬스장(일권) : 85,000원  |   설명2 ");
        String month3 = new String("3. 헬스장(일권) : 210,000원  |   설명3 ");
        String month6 = new String("4. 헬스장(일권) : 330,000원  |   설명4 ");

        // Scanner 선언
        Scanner sc = new Scanner(System.in);

        System.out.println("MENU");
        System.out.println("===================================================================");
        System.out.println(oneday);
        System.out.println(month1);
        System.out.println(month3);
        System.out.println(month6);
        System.out.println("===================================================================");

        //입력
        while (true) {
            System.out.println("종료하시려면 0 을 입력하세요.");
            int termination = sc.nextInt();
            if (termination == 0) {
                System.out.println("종료합니다.");
                sc.close();
                return;
            }
        }
    }
}