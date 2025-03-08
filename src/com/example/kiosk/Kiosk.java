package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //스캐너 선언
    Scanner sc = new Scanner(System.in);
    //시작 메서드
    public void start () {
        System.out.println("===================================================================");
        System.out.println("             JO GYM");
        System.out.println("===================================================================");
        System.out.println();
        System.out.println("원하시는 메뉴를 선택하세요.");
        System.out.println();
        System.out.println("1. 헬스장 이용권");
    }

    //끝내기 메서드
    public void end () {
        //반복문
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
    //MenuItem 관리하는  리스트
    public List gymList () {
        while (true) {
            try {
                int input = sc.nextInt();
                if (input == 1) {
                    //생성자 호출
                    MenuItem oneday = new MenuItem("헬스장(일권)", "10,000원", "설명1");
                    MenuItem month1 = new MenuItem("헬스장(1개월)", "85,000원", "설명2");
                    MenuItem month3 = new MenuItem("헬스장(3개월)", "210,000원", "설명3");
                    MenuItem month6 = new MenuItem("헬스장(6개월)", "330,000원", "설명4");
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
                } else {
                    System.out.println("잘못된 선택입니다.");
                }
            } catch (InputMismatchException e) {
                sc.nextLine();  // 무한 루프 방지 버퍼 비우기
                System.out.println("올바른 숫자를 선택하세요.");
            }
        }
    }
    //List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
    //입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
    //Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
    // 숫자 입력 받기
    // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
}
