package com.example.kiosk;

public class Main {
    public static void main(String[] args) {
        // Menu 객체 생성하면서 카테고리 이름 설정
        Menu gymPass = new Menu("헬스장 이용권");
        Menu personalTraining = new Menu("PT");
        Menu pilates = new Menu("필라테스");
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        gymPass.addList(new MenuItem("헬스장", "10,000원", "일일권"));
        gymPass.addList(new MenuItem("헬스장", "85,000원", "1개월"));
        gymPass.addList(new MenuItem("헬스장", "210,000원", "3개월"));
        gymPass.addList(new MenuItem("헬스장", "330,000원", "6개월"));
        personalTraining.addList(new MenuItem("조혁준(원장)", "500,000원", "PT 10회"));
        personalTraining.addList(new MenuItem("조혁준(원장)", "900,000원", "PT 20회"));
        personalTraining.addList(new MenuItem("조혁준(원장)", "1,200,000원", "PT 30회"));
        personalTraining.addList(new MenuItem("임욱호", "400,000원", "PT 10회"));
        personalTraining.addList(new MenuItem("임욱호", "800,000원", "PT 20회"));
        personalTraining.addList(new MenuItem("임욱호", "1,000,000원", "PT 30회"));
        pilates.addList(new MenuItem("신은주", "880,000원", "개인 레슨 10회"));
        pilates.addList(new MenuItem("신은주", "1,540,000원", "개인 레슨 20회"));
        pilates.addList(new MenuItem("신은주", "1,980,000원", "개인 레슨 30회"));
        pilates.addList(new MenuItem("진혜정", "850,000원", "개인 레슨 10회"));
        pilates.addList(new MenuItem("진혜정", "1,500,000원", "개인 레슨 20회"));
        pilates.addList(new MenuItem("진혜정", "1,770,000원", "개인 레슨 30회"));
        //Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(gymPass, personalTraining, pilates);
        //Kiosk 함수 호출
        kiosk.start();
        //스캐너 닫는 메서드 호출
        kiosk.closeScanner();
    }
}