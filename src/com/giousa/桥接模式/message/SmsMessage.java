package com.giousa.桥接模式.message;

public class SmsMessage implements IMessage{
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用短信发送：" + message + "，给：" + toUser);

    }
}
