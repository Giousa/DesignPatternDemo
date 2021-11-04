package com.giousa.桥接模式.message;

public class NormalMessage extends AbstractMessage{
    public NormalMessage(IMessage iMessage) {
        super(iMessage);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        super.sendMessage(message, toUser);
    }
}
