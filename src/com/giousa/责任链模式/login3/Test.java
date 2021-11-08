package com.giousa.责任链模式.login3;

public class Test {

    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("cat","!2");
    }
}
