package com.giousa.责任链模式.login2;

import com.giousa.责任链模式.login.Member;
import com.giousa.责任链模式.login.StringUtils;

import java.util.Objects;

public class ValidateHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        if (Objects.isNull(member) || StringUtils.isEmpty(member.getLoginName()) || StringUtils.isEmpty(member.getLoginPass())) {
            System.out.println("用户名或密码为空");
            return;
        }
        chain.doHandler(member);
    }
}
