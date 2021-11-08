package com.giousa.责任链模式.login2;

public class Test {

    public static void main(String[] args) {

        MemberService memberService = new MemberService();
        memberService.login("tom","999");

    }
}
