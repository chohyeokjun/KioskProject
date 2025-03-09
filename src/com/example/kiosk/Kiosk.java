package com.example.kiosk;

import java.util.*;

public class Kiosk {
    //Menu 객체 불러오기
    private List<Menu> menus;

    //생성자
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    //스캐너 선언
    Scanner sc = new Scanner(System.in);
    //반복문 탈출 논리형
    boolean progress = true;

    //시작 메서드
    public void start() {
        System.out.println("===================================================================");
        System.out.println("                             JO GYM");
        System.out.println("===================================================================");
        System.out.println();
        System.out.println("목록을 보시려면 '0' 을 입력하세요.");
        System.out.println();
        System.out.print("입력: ");
        // 숫자 입력 받기
        int input1 = inputMis();
        //List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
        if (input1 == 0) {
            showCategories(); //카테고리 출력
        }

        //반복문 시작
        while (progress) {
            //입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            // 숫자 입력 받기
            System.out.println();
            System.out.println("구매를 원하시는 항목을 선택하세요.");
            System.out.println();
            System.out.print("입력: ");
            int input2 = inputMis();
            // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
            if (input2 >= 1 && input2 <= 3) {
                menuSelection(input2); // 새로운 메서드 호출
            } else if (input2 == 0) {
                System.out.println("종료합니다.");
                progress = false;
                return; // 종료 호출
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
    }

    //카테고리 출력 메서드
    public void showCategories() {
        System.out.println("===========[menu]===========");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getName());
        }
        System.out.println("=========================");
    }

    //메뉴 출력 메서드
    public void showMenu(Menu menu) {
        System.out.println("================= " + menu.getName() + " =================");
        for (int i = 0; i < menu.getMenuItem().size(); i++) {
            MenuItem list = menu.getMenuItem().get(i);
            System.out.println((i + 1) + ". " + list.getInfo());
        }
        System.out.println("============================================");
    }

    //InputMismatchException 예외 처리 메서드
    public int inputMis() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                sc.nextLine(); //버퍼 비우기
            }
        }
    }

    //스캐너 닫기 메서드
    public void closeScanner() {
        sc.close();
    }

    // 메뉴 선택과 처리 로직을 담당하는 메서드
    public void menuSelection(int j) {
        // 메뉴 인덱스는 1부터 시작하므로, 리스트 접근 시 -1 필요
        Menu selectedMenu = menus.get(j - 1);

        while(progress) {
            showMenu(selectedMenu); // 메뉴 출력
            System.out.println("구매를 원하시는 항목을 선택하세요.");
            System.out.println("[뒤로가기: '9' ]     [종료: '0' ]");
            System.out.print("입력: ");
            int input4 = inputMis(); //숫자 입력 받기
            //입력받은 숫자 기반으로 해당 인덱스 출력
            if (input4 == 9) {
                showCategories();
                return;
            } else if (input4 == 0) {
                System.out.println("종료합니다.");
                progress = false;
                return; // 종료 호출
            } else {
                menuItemSelection(j, input4);
            }
        }
    }

    // 선택 항목 보여주는 메서드
    public void menuItemSelection(int a, int input4) {
        Menu selectedMenu = menus.get(a - 1);
        List<MenuItem> menuItemList = selectedMenu.getMenuItem();
        if (input4 >= 1 && input4 <= menuItemList.size()) {
            MenuItem selecteItem = menuItemList.get(input4 - 1);
            System.out.println("=============== 구매 항목 ================");
            System.out.println(selecteItem.getInfo()); //선택한 항목 출력
            System.out.println("========================================");
            while(progress) {
                System.out.println("[뒤로가기: '9' ]     [종료: '0' ]");
                System.out.print("입력: ");
                int input5 = inputMis(); // 숫자 입력 받기
                if (input5 == 9) {
                    return; // 뒤로가기 처리 (메뉴 리스트로 돌아감)
                } else if (input5 == 0) {
                    System.out.println("종료합니다.");
                    progress = false;
                    return; // 종료 호출
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}