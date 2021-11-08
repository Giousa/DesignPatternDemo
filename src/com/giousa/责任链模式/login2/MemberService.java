package com.giousa.责任链模式.login2;

import com.giousa.责任链模式.login.Member;

public class MemberService {

    public void login(String loginName, String loginPass) {
        ValidateHandler validateHandler = new ValidateHandler();
        LoginHandler loginHandler = new LoginHandler();
        AuthHandler authHandler = new AuthHandler();

        validateHandler.next(loginHandler);
        loginHandler.next(authHandler);

        validateHandler.doHandler(new Member(loginName, loginPass));
    }
}
