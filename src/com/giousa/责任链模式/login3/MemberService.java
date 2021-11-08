package com.giousa.责任链模式.login3;


import com.giousa.责任链模式.login.Member;

public class MemberService {

    public void login(String loginName, String loginPass) {
        Handler.Builder builder = new Handler.Builder();

        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler());

        builder.build().doHandler(new Member(loginName, loginPass));
    }
}
