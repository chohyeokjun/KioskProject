package com.example.kiosk;

import java.util.*;

public class Kiosk {
    //속성
    private List<Menu> menus;
    private boolean condition;
    private Cart cart;

    //생성자
    public Kiosk(Menu gymPass, Menu personalTraining, Menu pilates) {
        //menus 리스트 초기화
        this.menus = new ArrayList<>();
        //menus 리스트에 menu1(gymPass), menu2(PT), menu3(pilates) 객체 add
        menus.add(gymPass);
        menus.add(personalTraining);
        menus.add(pilates);
        this.cart = new Cart();
        //반복문 조건
        this.condition = true;
    }

    //시작
    public void start() {
        //스캐너 선언
        Scanner sc = new Scanner(System.in);
        //반복문 시작
        while (condition) {
            //InputMismatchException 예외 처리
            try {
                //표지 출력
                System.out.println("===================================================================");
                System.out.println("                             JO GYM");
                System.out.println("===================================================================");
                System.out.println();
                System.out.println("[원하시는 메뉴를 선택하세요.]");
                System.out.println();

                // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
                //1. MenuList 출력
                menuListCall();

                // 숫자 입력 받기 1
                System.out.print("입력1: "); //카테고리 선택 입력
                int input = sc.nextInt();

                // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                if (input == 0) {
                    return;
                } else if (input >= 1 && input <= menus.size()) {
                    //2. MenuItemList 출력
                    menuItemListCall(input);
                } else {
                    System.out.println("잘못된 입력입니다.");
                }

                // 상세 메뉴 선택 입력 2
                System.out.print("입력2: ");
                int input2 = sc.nextInt();

                // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                if (input2 == 0) {
                    //처음으로
                    continue;
                } else if (input2 >= 1 && input2 <= menus.get(input - 1).getMenuItemList().size()) {
                    //3. 상세 메뉴 선택 메서드 호출(MenuItemList 호출 메서드에서 입력값인 input을 활용하기 위해 괄호()안에 input 값을 넣어서 호출)
                    detailMenuSelect(input, input2);
                } else {
                    System.out.println("잘못된 입력입니다.");
                }

                // 숫자 입력 3
                System.out.print("입력3: ");
                int input3 = sc.nextInt();

                //4. 장바구니 담기 메서드 호출
                addCart(input, input2, input3);

                //5. orderMenu 메서드 호출
                orderMenu();

                // 숫자 입력 4
                System.out.print("입력4: ");
                int input4 = sc.nextInt();

                // 만약에 장바구니에 물건이 들어 있지 않다면 [ ORDER MENU ] 가 출력되지 않습니다.
                if (cart.getCart().isEmpty()) {
                    if (input4 == 4) {
                        System.out.println("장바구니가 비어있습니다.");
                        System.out.println("처음 주문 단계로 돌아갑니다.");
                        continue;
                    } else if (input4 == 5) {
                        System.out.println("주문을 취소하고 처음으로 돌아갑니다.");
                        continue;
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } else if (input4 == 4) {
                    // 장바구니에 물건이 들어 있으면 아래와 같이 [ ORDER MENU ] 가 추가로 출력됩니다.
                    //5. 장바구니 보여주기
                    showCart();
                } else {
                    System.out.println("잘못된 입력입니다.");
                }

                System.out.print("입력5: ");
                int input5 = sc.nextInt();


                if (input5 == 1) {
                    //6 구매하기
                    purchase();
                } else if (input5 == 2) {
                    break;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    //MenuList 출력 메서드
    public void menuListCall() {
        System.out.println("===========[menu]===========");
        for (int i = 0; i < menus.size(); i++) {
            // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            Menu menu = menus.get(i);
            System.out.println((i + 1) + ". " + menu.getName());
        }
        System.out.println("0. 종료");
        System.out.println("============================");

    }

    //MenuItemList 출력 메서드
    public void menuItemListCall(int input) {
        //중복 코드를 없애기 위한 리스트 선언
        List<MenuItem> menuItemLists = menus.get(input - 1).getMenuItemList();
        System.out.println("================= " + menus.get(input - 1).getName() + " =================");
        // Menu가 가진 List<MenuItem>을 반복문을 활용하여 메뉴 출력
        for (int i = 0; i < menuItemLists.size(); i++) {
            System.out.println((i + 1) + ". " + menuItemLists.get(i).getInfo());
        }
        System.out.println("============================================");
        System.out.println("[원하시는 메뉴를 선택하세요.]");
        System.out.println("[처음으로 돌아가길 원하시면 숫자 '0' 을 입력하세요.]");
        ;
    }

    //상세 메뉴 선택 메서드
    public void detailMenuSelect(int input, int input2) {
        if (input2 >= 1 && input2 <= menus.get(input - 1).getMenuItemList().size()) {
            System.out.println("============= 선택한 메뉴 =============");
            System.out.println(input2 + ". " + menus.get(input - 1).getMenuItemList().get(input2 - 1).getInfo());
            System.out.println("===================================");
            System.out.println("[위 메뉴를 장바구니에 추가하시겠습니까?]");
            System.out.println("[1. 확인                       2. 취소]");
        }
    }

    // 메뉴 장바구니 담기 메서드
    public void addCart(int input, int input2, int input3) {
        if (input3 == 1) {
            //장바구니 담기
            cart.addCart(menus.get(input - 1).getMenuItemList().get(input2 - 1));
        }
    }

    //orderMenu 메서드
    public void orderMenu() {
        System.out.println("[ ORDER MENU]");
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
    }

    //장바구니 보여주기 메서드
    public void showCart() {
        int TotalFee = 0;
        System.out.println("============= 장바구니 ==============");
        for (int i = 0; i < cart.getCart().size(); i++) {
            System.out.println((i + 1) + ". " + cart.getCart().get(i).getInfo());
            //각각의 가격 을 getter로 가져와 합하기
            TotalFee += cart.getCart().get(i).getFee();
        }
        //리스트 사이즈를 활용한 주문 수량 확인
        System.out.println("[총 주문 수량: " + cart.getCart().size() + "]");
        System.out.println("[총 주문 금액: " + TotalFee + "원]");
        System.out.println("===================================");
        System.out.println("[구매하기: 1                 메뉴판: 2]");
    }

    //구매하기 메서드
    public void purchase() {
        System.out.println("===================================");
        System.out.println("          구매가 완료되었습니다.");
        System.out.println("===================================");
        // 장바구니 초기화
        removeAllCartList();
    }

    // 장바구니 초기화 메서드
    public void removeAllCartList() {
        cart.removeAllCart();
    }
}