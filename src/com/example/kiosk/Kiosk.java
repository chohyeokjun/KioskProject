package com.example.kiosk;

import javax.swing.*;
import java.util.*;

public class Kiosk {
    //Menu 객체 불러오기
    private List<Menu> menus;

    public Kiosk (List<Menu> menus) {
        this.menus = menus;
    }
    //스캐너 선언
    Scanner sc = new Scanner(System.in);
    //시작 메서드
    public void start () {
        System.out.println("===================================================================");
        System.out.println("                             JO GYM");
        System.out.println("===================================================================");
        System.out.println();
        System.out.println("목록을 보시려면 '0'을 입력하세요.");
        System.out.println();
        System.out.print("입력: ");
        // 숫자 입력 받기
        int input = sc.nextInt();
        //List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
        if (input == 0) {
            showCategories();
        }
        // 숫자 입력 받기
        System.out.println();
        System.out.println("구매를 원하시는 항목을 선택하세요.");
        System.out.println();
        System.out.print("입력: ");
        int input2 = sc.nextInt();
        // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기

        if (input2 == 1) {
            showMenu(menus.get(0)); //Menu가 가진 List<MenuItem>을 반복문을 활용하여 gympass 메뉴 출력
        } else if (input2 == 2) {
            showMenu(menus.get((1))); //Menu가 가진 List<MenuItem>을 반복문을 활용하여 personalTraining 메뉴 출력
        } else if (input2 == 3) {
            showMenu(menus.get(2)); //Menu가 가진 List<MenuItem>을 반복문을 활용하여 pilates 메뉴 출력
        } else if (input2 == 4) {
            end(); //종료 메서드로 이동
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }

    //종료 메서드
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
    //메뉴 출력 메서드
    public void showMenu (Menu menu) {
        System.out.println("================= " + menu.getName() + " =================");
        for (int i = 0; i < menu.getMenuItem().size(); i++) {
            MenuItem list = menu.getMenuItem().get(i);
            System.out.println((i+1) + ". " + list.getInfo());
        }
        System.out.println("============================================");
    }
    //카테고리 출력 메서드
    public void showCategories () {
        System.out.println("===========menu===========");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getName());
        }
        System.out.println("=========================");
    }


    //입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기



}