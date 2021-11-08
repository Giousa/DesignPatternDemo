package com.giousa.责任链模式.login;


import java.util.Objects;

public class MemberService {

    public void login(String loginName, String loginPass) {
        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(loginPass)) {
            System.out.println("用户名或密码为空，无法登录");
            return;
        }

        System.out.println("用户名和密码校验成功！");

        Member member = checkExists(loginName, loginPass);
        if (Objects.isNull(member)) {
            System.out.println("用户不存在");
            return;
        }

        System.out.println("登录成功!");

        if (!Objects.equals("管理员", member.getRoleName())) {
            System.out.println("您不是管理员，没有操作权限");
            return;
        }

        System.out.println("具有操作权限！");
    }

    private Member checkExists(String loginName, String loginPass) {
        Member member = new Member(loginName, loginPass);
        member.setRoleName("管理员");
        return member;
    }
}
