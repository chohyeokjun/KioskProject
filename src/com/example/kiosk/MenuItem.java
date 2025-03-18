package com.example.kiosk;

public class MenuItem {
    //속성
    private String name;
    private String gymFee;
    private String introduction;

    //생성자
    public MenuItem (String name, String gymFee,String introduction) {
        this.name = name;
        this.gymFee = gymFee;
        this.introduction = introduction;
    }
    //메서드

    //getter
    public String getGymInfo () {
        return  name + " :  " + gymFee + "  |  " + introduction;
    }
    //setter
}