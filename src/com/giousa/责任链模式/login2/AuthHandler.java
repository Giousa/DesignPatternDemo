package com.giousa.责任链模式.login2;

import com.giousa.责任链模式.login.Member;

import java.util.Objects;

public class AuthHandler extends Handler{
    @Override
    public void doHandler(Member member) {
        if(!Objects.equals("管理员",member.getRoleName())){
            System.out.println("您不是管理员，没有权限");
            return;
        }

        System.out.println("您是管理员，拥有权限!");
    }
}
