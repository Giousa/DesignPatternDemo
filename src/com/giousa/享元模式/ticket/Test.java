package com.giousa.享元模式.ticket;

public class Test {

    public static void main(String[] args) {
//        ITicket ticket = TicketFactory.queryTicket("阜阳", "上海");
//        ticket.showInfo("硬卧");

        ITicket ticket1 = TicketFlyweightFactory.queryTicket("阜阳", "上海");
        ticket1.showInfo("硬卧");

        ITicket ticket2 = TicketFlyweightFactory.queryTicket("阜阳", "上海");
        ticket2.showInfo("硬卧");
        ITicket ticket3 = TicketFlyweightFactory.queryTicket("阜阳", "上海");
        ticket3.showInfo("硬卧");
        ITicket ticket4 = TicketFlyweightFactory.queryTicket("阜阳", "上海");
        ticket4.showInfo("硬卧");
    }
}
