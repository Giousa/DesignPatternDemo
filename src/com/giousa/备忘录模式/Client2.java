package com.giousa.备忘录模式;

import java.util.ArrayList;

/**
 * 棋牌游戏：可以下棋，悔棋，撤销悔棋等
 */
public class Client2 {

    /**
     * 备忘录角色
     */
    public static class ChessmanMemento {
        private String label;
        private int x;
        private int y;

        public ChessmanMemento(String label, int x, int y) {
            this.label = label;
            this.x = x;
            this.y = y;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    /**
     * 原发器角色
     */
    public static class Chessman {
        private String label;
        private int x;
        private int y;

        public Chessman(String label, int x, int y) {
            this.label = label;
            this.x = x;
            this.y = y;
        }

        //保存状态 生成备忘录对象
        public ChessmanMemento save() {
            return new ChessmanMemento(this.label, this.x, this.y);
        }

        //恢复状态
        public void restore(ChessmanMemento memento) {
            this.label = memento.getLabel();
            this.x = memento.getX();
            this.y = memento.getY();
        }

        public void show() {
            System.out.println(String.format("棋子<%s>：当前位置为：<%d, %d>", this.getLabel(), this.getX(), this.getY()));
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    /**
     * 负责人角色
     */
    public static class MementoCaretaker {
        //定义一个集合来存储备忘录
        private ArrayList mementolist = new ArrayList();

        public ChessmanMemento getMemento(int i) {
            return (ChessmanMemento) mementolist.get(i);
        }

        public void addMemento(ChessmanMemento memento) {
            mementolist.add(memento);
        }
    }


    //下棋，同时保存备忘录
    public static void play(Chessman chess) {
        mc.addMemento(chess.save());
        index++;
        chess.show();
    }

    //悔棋，撤销到上一个备忘录
    public static void undo(Chessman chess, int i) {
        System.out.println("******悔棋******");
        index--;
        chess.restore(mc.getMemento(i - 1));
        chess.show();
    }

    //撤销悔棋，恢复到下一个备忘录
    public static void redo(Chessman chess, int i) {
        System.out.println("******撤销悔棋******");
        index++;
        chess.restore(mc.getMemento(i + 1));
        chess.show();
    }


    private static int index = -1;

    //初始化负责人角色
    private static MementoCaretaker mc = new MementoCaretaker();

    public static void main(String args[]) {
        //创建原发器
        Chessman chess = new Chessman("车", 1, 1);
        play(chess);
        chess.setY(4);
        play(chess);
        chess.setX(5);
        play(chess);
        undo(chess, index);
        undo(chess, index);
        redo(chess, index);
        redo(chess, index);
    }

}
