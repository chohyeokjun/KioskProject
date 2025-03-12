package com.example.kiosk;

public class Main {
    public static void main(String[] args) {
        // Menu 객체 생성하면서 카테고리 이름 설정
        Menu gymPass = new Menu("헬스장 이용권");
        Menu personalTraining = new Menu("PT");
        Menu pilates = new Menu("필라테스");
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        gymPass.addList(new MenuItem("헬스장", 10000, "일일권"));
        gymPass.addList(new MenuItem("헬스장", 85000, "1개월"));
        gymPass.addList(new MenuItem("헬스장", 210000, "3개월"));
        gymPass.addList(new MenuItem("헬스장", 330000, "6개월"));
        personalTraining.addList(new MenuItem("조혁준(원장)", 500000, "PT 10회"));
        personalTraining.addList(new MenuItem("조혁준(원장)", 900000, "PT 20회"));
        personalTraining.addList(new MenuItem("조혁준(원장)",  200000, "PT 30회"));
        personalTraining.addList(new MenuItem("임욱호", 400000, "PT 10회"));
        personalTraining.addList(new MenuItem("임욱호", 800000, "PT 20회"));
        personalTraining.addList(new MenuItem("임욱호", 1000000, "PT 30회"));
        pilates.addList(new MenuItem("신은주", 880000, "개인 레슨 10회"));
        pilates.addList(new MenuItem("신은주", 1540000, "개인 레슨 20회"));
        pilates.addList(new MenuItem("신은주", 1980000, "개인 레슨 30회"));
        pilates.addList(new MenuItem("진혜정", 850000, "개인 레슨 10회"));
        pilates.addList(new MenuItem("진혜정", 1500000, "개인 레슨 20회"));
        pilates.addList(new MenuItem("진혜정", 1770000, "개인 레슨 30회"));
        //Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(gymPass, personalTraining, pilates);
        //Kiosk 함수 호출
        kiosk.start();
    }
}