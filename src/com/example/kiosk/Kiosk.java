package com.example.kiosk;

import java.util.*;

public class Kiosk {
    //속성
    private final List<Menu> menus;
    private boolean condition;
    private final Cart cart;

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
        //int형 변수를 사용하기 위한 선언
        int selectedCategory;
        int selectedItem;
        int num;
        //반복문 시작
        while (condition) {
            try {
                //카테고리 출력
                //반환값을 사용하기 위해 int형 변수에 값 저장
                selectedCategory = menuListCall(sc);
                //입력값이 0일 때 호출한 곳으로 반환
                if (selectedCategory == 0) {
                    return;
                }

                //하위 메뉴 출력
                //반환값을 사용하기 위해 int형 변수에 값 저장
                selectedItem = menuItemListCall(sc, selectedCategory);
                //입력값이 0일 때 이후 단계를 건너뛰고 처음으로 돌아감
                if (selectedItem == 0) {
                    continue;
                }

                //상세 메뉴 선택
                detailMenuSelect(selectedCategory, selectedItem);

                //장바구니 담기 or 취소
                addCart(sc, selectedCategory, selectedItem);

                //장바구니
                orderMenu();

                //장바구니에 담긴 메뉴 보여주기
                //반환값을 사용하기 위해 int형 변수에 값 저장
                num = showCart(sc);
                if (cart.getCart().isEmpty()) {
                    if (num == 4 || num == 5) {
                        continue; // 장바구니가 비어 있으므로 처음 메뉴로
                    }
                } if (num == 5) {
                    continue; // 주문 취소후 처음 메뉴로
                }
                //할인
                discount(sc);

                //구매하기
                purchase(sc);

            } catch (InputMismatchException e) {
                sc.nextLine(); // 버퍼 비우기
                System.out.println("잘못된 입력입니다.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("'잘못된 접근입니다.'");
                System.out.println("[처음부터 다시 시작합니다.]");
            }
        }
    }

    //MenuList 출력 메서드
    public int menuListCall(Scanner sc) {
        //표지 출력
        System.out.println("===================================================================");
        System.out.println("                             JO GYM");
        System.out.println("===================================================================");
        System.out.println();
        System.out.println("[원하시는 메뉴를 선택하세요.]");
        System.out.println();
        System.out.println("===========[menu]===========");
        //원시형 for문
        for (int i = 0; i < menus.size(); i++) {
            // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            Menu menu = menus.get(i);
            System.out.println((i + 1) + ". " + menu.getName());
        }
//        //향상된 for문으로
//        int i = 1;
//        for (Menu menu : menus) {
//            System.out.println(i + ". " + menu.getName());
//            i++;
//        }
        //stream으로
//        Stream<Integer> stream = Stream.iterate(1, i -> i <= 3, i -> i + 1);
        // 0번째 부터 menus.size()-1 번째 까지 반복
//        IntStream.rangeClosed(0,menus.size()-1).forEach(i -> System.out.println((i+1) + ". " +menus.get(i).getName()));
//        IntStream.rangeClosed(0,3).forEach(i -> System.out.println(i));

        // stream().foreach
//        menus.stream().forEach(menu -> System.out.println( ". " + menu.getName()));
//        IntStream.range(0,menus.size()).forEach(i -> {
//            System.out.println((i+1) + ". " +menus.get(i).getName());
//        });
        //컬렉션 foreach
//        menus.forEach(menu -> System.out.println(menu.getName()));

        System.out.println("0. 종료");
        System.out.println("============================");
        //카테고리 선택 입력
        System.out.print("입력1: ");
        // 입력값을 리턴값으로 반환
        return sc.nextInt();
    }

    //MenuItemList 출력 메서드
    public int menuItemListCall(Scanner sc, int input) {
        if (input >= 1 && input <= menus.size()) {
            //중복 코드를 없애기 위한 리스트 선언
            List<MenuItem> menuItemLists = menus.get(input - 1).getMenuItemList();
            System.out.println("================= " + menus.get(input - 1).getName() + " =================");
            // Menu가 가진 List<MenuItem>을 반복문을 활용하여 메뉴 출력
            for (int i = 0; i < menuItemLists.size(); i++) {
                System.out.println((i + 1) + ". " + menuItemLists.get(i).getInfo());
            }
            System.out.println("0. 뒤로가기");
            System.out.println("============================================");
            System.out.println("[원하시는 메뉴를 선택하세요.]");
        }
//        //향상된 for문
//        for (MenuItem menuItem : menus.get(input-1).getMenuItemList()) {
//            System.out.println(menuItem.getInfo());
//        }
//        //stream
//        menus.get(input-1).getMenuItemList()
//                .stream()
//                .forEach(menuItem -> System.out.println(menuItem.getInfo()));
        //컬렉션 foreach
//        List<MenuItem> menuItem = menus.get(input - 1).getMenuItemList();
//        menuItem.forEach(menuItem1 -> System.out.println(menuItem.get(input -1).getInfo()));
        // 숫자 입력 받기
        System.out.print("입력2: ");
        return sc.nextInt();
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

    // 메뉴 장바구니 담기 메서드 while
    public void addCart(Scanner sc, int input, int input2) {
        while (condition) {
            System.out.print("입력3: ");
            int input3 = sc.nextInt();
            if (input3 == 1) {
                //장바구니 담기
                cart.addCart(menus.get(input - 1).getMenuItemList().get(input2 - 1));
                break; // 현재 반복문 탈출
            } else if (input3 == 2) {
                System.out.println("장바구니 추가가 취소 되었습니다.");
                break; // 현재 반복문 탈출
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    //orderMenu 메서드
    public void orderMenu() {
        System.out.println("[ ORDER MENU]");
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");

    }

    //장바구니 보여주기 메서드
    public int showCart(Scanner sc) {
        System.out.print("입력4: ");
        int input4 = sc.nextInt();
        if (input4 == 4) {
            int totalFee = 0;
            System.out.println("============= 장바구니 ==============");
            for (int i = 0; i < cart.getCart().size(); i++) {
                System.out.println((i + 1) + ". " + cart.getCart().get(i).getInfo());
                //각각의 가격 을 getter로 가져와 합하기
                totalFee += cart.getCart().get(i).getFee();
            }
            //향상된 for문
//            int i = 1;
//            for (MenuItem cart1 : cart.getCart()) {
//                System.out.println(cart1.getInfo());
//            }
            //stream
//            cart.getCart().stream().forEach(menuItem -> System.out.println(menuItem.getInfo()));
            //컬렉션 foreach
//            cart.getCart().forEach(menuItem -> System.out.println(menuItem.getInfo()));
            //리스트 사이즈를 활용한 주문 수량 확인
            System.out.println("[총 주문 수량: " + cart.getCart().size() + "]");
            // 단위가 큰 숫자에 , 를 넣어주기 위해 String.format("%,d") 사용.
            System.out.println("[총 주문 금액: " + String.format("%,d",totalFee) + "원]");
            System.out.println("===================================");
        } else if (input4 == 5) {
            System.out.println("주문을 취소합니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }
        return input4;
    }

    //구매하기 메서드
    public void purchase(Scanner sc) {
        while (condition) {
            System.out.println("[구매하기: 1                 메뉴판: 2]");
            System.out.print("입력5: ");
            int input6 = sc.nextInt();
            if (input6 == 1) {
                System.out.println("===================================");
                System.out.println("          구매가 완료되었습니다.");
                System.out.println("===================================");
                // 장바구니 초기화
                removeAllCartList();
                return;
            } else if (input6 == 2) {
                System.out.println("[처음 메뉴로 돌아갑니다.]");
                return;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // 장바구니 초기화 메서드
    public void removeAllCartList() {
        cart.removeAllCart();
    }

    //할인 메서드
    public void discount(Scanner sc) {
        System.out.println("[리뷰 이벤트에 참여 하시겠습니까?]");
        System.out.println("1. YES (10% 할인)");
        System.out.println("2. NO");
        System.out.print("입력5: ");
        int input5 = sc.nextInt();
        int total = 0;
        //장바구니에 담긴 금액 구하기
        for (int i = 0; i < cart.getCart().size(); i++) {
            total += cart.getCart().get(i).getFee();
        }
        //향상된 for문
//        for (MenuItem cart : cart.getCart()) {
//            System.out.println(total += cart.getFee());
//        }
        //stream foreach 문
//        cart.getCart().stream().forEach(menuItem -> System.out.println(menuItem.getFee()));
        // 컬렉션 foreach
//        cart.getCart().forEach(menuItem -> System.out.println(menuItem.getFee()));
        // enum에 있는 상수와 일치하는지 확인
        Discount discount1 = Discount.of(input5);
        // enum에서 discount 한 값
        int to1 = discount1.discount(total);;
        if (input5 == 1 || input5 == 2) {
            System.out.println("주문 금액은 " + String.format("%,d",to1) + "원 입니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}