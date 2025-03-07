package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //생성자 호출
        MenuItem oneday = new MenuItem("헬스장(일권)", "10,000원", "설명1");
        MenuItem month1 = new MenuItem("헬스장(1개월)", "85,000원", "설명2");
        MenuItem month3 = new MenuItem("헬스장(3개월)", "210,000원", "설명3");
        MenuItem month6 = new MenuItem("헬스장(6개월)", "330,000원", "설명4");

        // Scanner 선언
        Scanner sc = new Scanner(System.in);
        // List 선언 및 초기화
        List<MenuItem> gymprice = new ArrayList<>();
        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        gymprice.add(oneday);
        gymprice.add(month1);
        gymprice.add(month3);
        gymprice.add(month6);

        // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        System.out.println("MENU");
        System.out.println("===================================================================");
        for (int i = 0; i < gymprice.size(); i++) {
            MenuItem gp = gymprice.get(i);
            System.out.println(i + 1 + ". " + gp.getGymInfo());
        }
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