package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //카테고리 list
    private static List <Menu> categories = new ArrayList<>();
    //속성
    private String name;
    private List<MenuItem> menuItem;

    //생성자
    public Menu(String name) {
        this.name = name;
        this.menuItem = new ArrayList<>();
        categories.add(this); //생성된 메뉴를 categories에 자동 추가
    }

    //메뉴 추가 메서드
    public void addMenuItem(MenuItem menuitem) {
        menuItem.add(menuitem);
    }
    //카테고리 이름 반환
    public String getName () {
        return name;
    }
    //메뉴 list 반환
    public List<MenuItem> getMenuItem () {
        return menuItem;
    }
    //카테고리 list 반환
    public static List<Menu> getCategories () {
        return categories;
    }
}