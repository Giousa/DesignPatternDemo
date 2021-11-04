package com.giousa.桥接模式.message;

public class UrgencyMessage extends AbstractMessage {

    public UrgencyMessage(IMessage iMessage) {
        super(iMessage);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "加急：" + message;
        super.sendMessage(message, toUser);
    }

    public Object watch(String messageId) {
        System.out.println("处理紧急任务,msgId = " + messageId);
        return "加急的消息id" + messageId;
    }
}
