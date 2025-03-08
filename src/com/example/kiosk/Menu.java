package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List <Menu> categories = new ArrayList<>();
    //속성
    private String name;
    private List<MenuItem> menuItem;

    //생성자
    public Menu(String name) {
        this.name = name;
        this.menuItem = new ArrayList<>();
    }

    //카테고리 추가 메서드
    public void addCategory(Menu category) {
        categories.add(category);
    }
    //하위 메뉴 추가 메서드
    public void addMenuItem(MenuItem menuitem) {
        menuItem.add(menuitem);
    }
    public List<MenuItem> getMenuItem () {
        return menuItem;
    }

        // List 선언 및 초기화

}