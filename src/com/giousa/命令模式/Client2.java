package com.giousa.命令模式;

import java.util.ArrayList;

/**
 * 命令模式 的 核心 就是 将 命令 抽象成一个对象
 * <p>
 * 业务场景 :
 * 游戏的 发布 和 关闭 , 使用命令模式实现 , 分别针对 发布 , 关闭 , 各自定义一个命令类
 */
public class Client2 {

    /**
     * 命令接口
     */
    public interface Command {
        /**
         * 执行命令方法
         */
        void execute();
    }


    /**
     * 开放命令
     * 实现 Command 接口
     * 该类代表了一种命令
     */
    public static class OpenCommand implements Command {
        private Game game;

        public OpenCommand(Game game) {
            this.game = game;
        }

        @Override
        public void execute() {
            this.game.open();
        }
    }

    /**
     * 关闭命令
     */
    public static class CloseCommand implements Command {
        private Game game;

        public CloseCommand(Game game) {
            this.game = game;
        }

        @Override
        public void execute() {
            this.game.close();
        }
    }


    /**
     * 游戏类
     * 该类与命令执行的具体逻辑相关
     * 基本上，这个类有几个方法，就有几个命令
     */
    public static class Game {
        private String name;

        public Game(String name) {
            this.name = name;
        }

        public void open() {
            System.out.println(this.name + " 开放");
        }

        public void close() {
            System.out.println(this.name + " 关闭");
        }
    }

    /**
     * 命令接收者
     * 执行命令
     */
    public static class Manager {
        /**
         * 存放命令
         */
        private ArrayList<Command> commands = new ArrayList<>();

        /**
         * 添加命令
         *
         * @param command
         */
        public void addCommand(Command command) {
            commands.add(command);
        }

        /**
         * 执行命令
         */
        public void executeCommand() {
            for (Command command : commands) {
                // 逐个遍历执行命令
                command.execute();
            }
            // 命令执行完毕后 , 清空集合
            commands.clear();
        }
    }

    public static void main(String[] args) {
        // 创建游戏
        Game game = new Game("碧蓝航线");

        // 开放命令
        OpenCommand openCommand = new OpenCommand(game);
        // 关闭命令
        CloseCommand closeCommand = new CloseCommand(game);

        // 发送命令
        Manager manager = new Manager();
        manager.addCommand(openCommand);
        manager.addCommand(closeCommand);

        // 执行命令
        manager.executeCommand();
    }
}
