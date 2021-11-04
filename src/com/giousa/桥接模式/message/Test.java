package com.giousa.桥接模式.message;

public class Test {

    public static void main(String[] args) {
        IMessage smsMessage = new SmsMessage();
        AbstractMessage normalMessage = new NormalMessage(smsMessage);
        normalMessage.sendMessage("加班申请速批", "CEO");

        IMessage emailMessage = new EmailMessage();
        UrgencyMessage urgencyMessage = new UrgencyMessage(emailMessage);
        urgencyMessage.sendMessage("加班申请速批", "CEO");
        urgencyMessage.watch("111111111111");
    }
}
