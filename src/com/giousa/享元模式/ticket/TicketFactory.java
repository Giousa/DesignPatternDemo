package com.giousa.享元模式.ticket;

public class TicketFactory {

    public static ITicket queryTicket(String from, String to) {
        return new TrainTicket(from, to);
    }
}
