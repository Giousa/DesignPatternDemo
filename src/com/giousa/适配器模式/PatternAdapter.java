package com.giousa.适配器模式;

/**
 * 适配器模式（Adapter Pattern）是一种常见的设计模式。
 *
 * 适配器模式是一种结构型设计模式，它主要通过将一个类的接口转换成客户端所期望的另一个接口，来解决接口不兼容的问题。
 * 适配器模式一般包括三个角色：目标（Target）、适配器（Adapter）和被适配者（Adaptee）。
 * 其中，目标角色是客户端所期望的接口，适配器角色是将被适配者的接口转换成目标接口的类，被适配者角色是需要被适配的类。
 *
 * 适配器模式与其他设计模式的区别在于，它主要是用于接口转换。
 * 而其他模式则主要用于解决其他问题，如工厂模式用于对象创建、单例模式用于对象的唯一性等等。
 *
 * 使用场景：
 * 1、系统需要使用一些现有的类，但这些类的接口不符合系统的要求。
 * 2、两个或多个独立的系统需要进行协作，但它们的接口不兼容。
 * 3、需要在不修改现有代码的情况下，增加或修改一些功能。
 *
 * 在Java编程语言中，适配器模式广泛应用于各种接口的适配，例如数据源适配、日志适配、UI组件适配等等。
 *
 *
 * 假设我们有一个音乐播放器程序，其中包括一个播放MP3音乐的接口MusicPlayer和一个播放CD音乐的接口CdPlayer，
 * 而我们想要将CdPlayer适配成MusicPlayer接口，这时就可以使用适配器模式。
 */
public class PatternAdapter {

    /**
     * 目标接口
     */
    public interface MusicPlayer {
        void playMusic(String fileName);
    }

    /**
     * 被适配者接口
     */
    public interface CdPlayer {
        void playCd(String cdName);
    }

    /**
     * 被适配者接口-实现
     */
    public static class CdPlayerImpl implements CdPlayer {

        @Override
        public void playCd(String cdName) {
            System.out.println("CdPlayer playCd. cdName: "+cdName);
        }
    }

    /**
     * 目标接口适配器
     * 简而言之，目标实现类，需要通过构造方法等传入适配类，调用目标方法时，本质上是调用适配类的方法。
     */
    public static class CdPlayerAdapter implements MusicPlayer {
        private CdPlayer cdPlayer;

        public CdPlayerAdapter(CdPlayer cdPlayer) {
            this.cdPlayer = cdPlayer;
        }

        @Override
        public void playMusic(String fileName) {
            cdPlayer.playCd(fileName);
        }
    }

    /**
     * 测试功能
     */
    public static void main(String[] args) {
        CdPlayer cdPlayer = new CdPlayerImpl();
        MusicPlayer musicPlayer = new CdPlayerAdapter(cdPlayer);
        musicPlayer.playMusic("CD_NAME");
    }
}
