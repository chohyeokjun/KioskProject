package com.example.kiosk;

import java.util.*;

public class Kiosk {
    //스캐너 선언
    Scanner sc = new Scanner(System.in);
    //반복문 조건 선언
    boolean condition = true;
    //속성
    private List<Menu> menus;
    //생성자
    public Kiosk(Menu gymPass, Menu personalTraining, Menu pilates) {
        //menus 리스트 초기화
        this.menus = new ArrayList<>();
        //menus 리스트에 menu1(gymPass), menu2(PT), menu3(pilates) 객체 add
        menus.add(gymPass);
        menus.add(personalTraining);
        menus.add(pilates);
    }
    //시작
    public void start() {

        while (condition) {
            //표지 출력
            System.out.println("===================================================================");
            System.out.println("                             JO GYM");
            System.out.println("===================================================================");
            System.out.println();
            System.out.println("원하시는 메뉴를 선택하세요.");
            System.out.println();
            //MenuList 호출
            menuListCall();
            //MenuItemList 호출
            menuItemListCall();
            //처음으로 또는 종료 메서드 호출
            backOrEnd();
        }
    }
    //MenuList 호출 메서드
    public void menuListCall() {
        System.out.println("===========[menu]===========");
        // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
        for (int i = 0; i < menus.size(); i++) {
            // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            Menu menu = menus.get(i);
            System.out.println((i + 1) + ". " + menu.getName());
        }
        System.out.println("============================");
    }
    //MenuItemList 호출 메서드
    public void menuItemListCall() {
        while (condition) {
            System.out.print("입력1: ");
            //카테고리 선택 입력
            int input = InputMisMatchException(); //inputmismatch 예외 처리
            // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
            if (input >= 1 && input <= menus.size()) {
                //중복 코드를 없애기 위한 리스트 선언
                List<MenuItem> menuItemLists = menus.get(input - 1).getMenuItemList();
                System.out.println("================= " + menus.get(input - 1).getName() + " =================");
                // Menu가 가진 List<MenuItem>을 반복문을 활용하여 메뉴 출력
                for (int i = 0; i < menuItemLists.size(); i++) {
                    System.out.println((i + 1) + ". " + menuItemLists.get(i).getInfo());
                }
                System.out.println("============================================");
                System.out.print("입력2: ");
                //상세 메뉴 선택 메서드 호출(MenuItemList 호출 메서드에서 입력값인 input을 활용하기 위해 괄호()안에 input 값을 넣어서 호출)
                detailMenuSelect(input);
                return;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
    //상세 메뉴 선택 메서드
    public void detailMenuSelect(int input) {
        while (condition) {
            //상세 메뉴 선택 입력
            int input2 = InputMisMatchException(); //inputmismatch 예외 처리
            if (input2 >= 1 && input2 <= menus.get(input - 1).getMenuItemList().size()) {
                System.out.println("===================================");
                System.out.println(input2 + ". " + menus.get(input - 1).getMenuItemList().get(input2 - 1).getInfo());
                System.out.println("===================================");
                return;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
    //처음 or 종료 메서드
    public void backOrEnd () {
        while (condition) {
            System.out.println("============================================");
            System.out.println("처음으로: 9                             종료: 0");
            System.out.println("============================================");
            System.out.print("입력3: ");
            int input3 = InputMisMatchException(); //inputmismatch 예외 처리
            if (input3 == 9) {
                //처음으로
                return;
            } else if (input3 == 0) {
                //조건문 false로 바꾸고 탈출
                condition = false;
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
    //문자 입력 예외 처리
    public int InputMisMatchException () {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                sc.nextLine(); //무한 루프 방지 버퍼 비우기
            }
        }
    }
    //스캐너 닫기 기능 메서드
    public void closeScanner() {
        System.out.println("종료합니다.");
        sc.close();
    }
}