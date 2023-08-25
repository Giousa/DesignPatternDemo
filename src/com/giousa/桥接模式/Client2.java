package com.giousa.桥接模式;

/**
 * 示例：颜色+形状
 */
public class Client2 {

    /**
     * 颜色接口
     */
    public interface Color {
        void bepaint(String shape);
    }

    public static class White implements Color {
        @Override
        public void bepaint(String shape) {
            System.out.println("白色的" + shape);
        }
    }

    public static class Gray implements Color {
        @Override
        public void bepaint(String shape) {
            System.out.println("灰色的" + shape);
        }
    }

    public static class Black implements Color {
        @Override
        public void bepaint(String shape) {
            System.out.println("黑色的" + shape);
        }
    }


    /**
     * 形状接口
     */
    public static abstract class Shape {
        Color color;

        public void setColor(Color color) {
            this.color = color;
        }

        public abstract void draw();
    }

    public static class Circle extends Shape {
        @Override
        public void draw() {
            color.bepaint("正方形");
        }
    }

    public static class Rectangle extends Shape {
        @Override
        public void draw() {
            color.bepaint("长方形");
        }
    }

    public static class Square extends Shape {
        @Override
        public void draw() {
            color.bepaint("正方形");
        }
    }

    public static void main(String[] args) {
        // 白色
        Color white = new White();

        // 正方形
        Shape square = new Square();
        // 白色的正方形
        square.setColor(white);
        square.draw();

        // 长方形
        Shape rectange = new Rectangle();
        // 白色的长方形
        rectange.setColor(white);
        rectange.draw();
    }
}
