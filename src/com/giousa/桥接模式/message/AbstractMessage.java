package com.giousa.桥接模式.message;

public abstract class AbstractMessage {

    IMessage iMessage;

    public AbstractMessage(IMessage iMessage) {
        this.iMessage = iMessage;
    }

    public void sendMessage(String message, String toUser) {
        this.iMessage.send(message, toUser);
    }
}
