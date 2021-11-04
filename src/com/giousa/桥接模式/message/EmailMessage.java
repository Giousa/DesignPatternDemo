package com.giousa.桥接模式.message;

public class EmailMessage implements IMessage {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用邮件发送：" + message + "，给：" + toUser);
    }
}
