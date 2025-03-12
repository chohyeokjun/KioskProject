package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //속성
    private List<MenuItem> menuItemList;
    private String name;

    //생성자
    public Menu(String name) {
        this.menuItemList = new ArrayList<>();
        this.name = name;
    }

    //하위 리스트 추가
    public void addList(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }

    //상위 카테고리 이름 반환
    public String getName() {
        return name;
    }

    //깊은 복사? vs 얕은 복사?
    //하위 리스트 반환
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }
}