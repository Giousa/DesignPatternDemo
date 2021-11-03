package com.giousa.享元模式.ticket;

import java.util.Random;

public class TrainTicket implements ITicket {

    private String from;

    private String to;

    private int price;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String bunk) {
        this.price = new Random().nextInt(1000);
        System.out.println(String.format("%s->%s: %s 价格: %s 元", this.from, this.to, bunk, this.price));
    }
}
