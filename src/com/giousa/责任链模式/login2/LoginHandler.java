package com.giousa.责任链模式.login2;

import com.giousa.责任链模式.login.Member;

public class LoginHandler extends Handler{

    @Override
    public void doHandler(Member member) {
        System.out.println("登录成功!");
        member.setRoleName("管理员");
        chain.doHandler(member);
    }
}
