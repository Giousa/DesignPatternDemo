package com.giousa.访问者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 实例
 * 王二狗刚参加工作那会由于社会经验不足误入了一个大忽悠公司，公司老板不舍得花钱就给公司招了3个人，一个Hr，一个程序员，一个测试，但关键是老板总想追风口，啥都想做，一会社交，一会短视频。二狗多次提出说人太少，申请加几个人，至少加个保洁阿姨啊，每天都自己打扫卫生，累屁了。每到此时老板就画大饼：你现在刚毕业正是要奋斗的时候，此时不奋斗什么时候奋斗？过两年公司上市了，你作为元老就财富自由拉...balabala
 * <p>
 * 这个场景就很适合使用访问者模式：
 * <p>
 * 大忽悠公司结构很稳定，老板舍不得花钱招人，总共就那么3个人，还是3种角色，即只有3个元素。 大忽悠公司老板想法多，这就要求这3个人承担各种新技能，即不断的给元素增加新的算法。
 */
public class Client2 {

    /**
     * 构建Element
     * 毕竟改变的是元素的算法，所以这里我们先构建元素。
     * <p>
     * 社畜类只有一个accept方法，它需要一个访问者接口类型的参数
     */
    public interface CorporateSlave {
        void accept(CorporateSlaveVisitor visitor);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 构建3个社畜的实现类
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 程序员
     */
    public static class Programmer implements CorporateSlave {
        private String name;

        public Programmer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void accept(CorporateSlaveVisitor visitor) {
            visitor.visit(this);
        }
    }

    /**
     * 测试
     */
    public static class Tester implements CorporateSlave {

        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void accept(CorporateSlaveVisitor visitor) {
            visitor.visit(this);
        }
    }

    /**
     * 人事
     */
    public static class HumanSource implements CorporateSlave {

        private String name;

        public HumanSource(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void accept(CorporateSlaveVisitor visitor) {
            visitor.visit(this);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 构建ObjectStructure
    ///////////////////////////////////////////////////////////////////////////

    /**
     * BigHuYouCompany 类里面需要包含相对稳定的元素（大忽悠老板就招这3个人，再也不肯招人），而且要求可以对这些元素迭代访问。此处我们以集合存储3位员工。
     */
    public static class BigHuYouCompany {
        private List<CorporateSlave> employee = new ArrayList<>();

        public BigHuYouCompany() {
            employee.add(new Programmer("程序员-曹操"));
            employee.add(new HumanSource("人事-刘备"));
            employee.add(new Tester("测试-孙权"));
        }

        public void startProject(CorporateSlaveVisitor visitor) {
            for (CorporateSlave slave : employee) {
                slave.accept(visitor);
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 构建Visitor
    ///////////////////////////////////////////////////////////////////////////


    /**
     * Visitor 接口里面一般会存在与各元素对应的visit方法，例如此例我们有3个角色，所以这里就有3个方法。
     */
    public interface CorporateSlaveVisitor {
        void visit(Programmer programmer);

        void visit(HumanSource humanSource);

        void visit(Tester tester);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Visitor实现类
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 因为老板觉得社交是人类永恒的需求，所以开始想做社交App，他觉得他能成为微信第二。
     * <p>
     * 这就相当于要为每一个元素定义一套新的算法，让程序员仿照微信开发设计app，让测试完成即时通信的测试，让人力发软文。
     */
    public static class SocialApp implements CorporateSlaveVisitor {
        @Override
        public void visit(Programmer programmer) {
            System.out.println(String.format("%s: 给你一个月，先仿照微信搞个类似的APP出来,要能语音能发红包,将来公司上市了少不了你的，好好干...", programmer.getName()));
        }

        @Override
        public void visit(HumanSource humanSource) {
            System.out.println(String.format("%s: 咱现在缺人，你暂时就充当了陪聊吧，在程序员开发APP期间，你去发发软文，积攒点粉丝...", humanSource.getName()));
        }

        @Override
        public void visit(Tester tester) {
            System.out.println(String.format("%s: 这是咱创业的第一炮，一定要打响，测试不能掉链子啊，不能让APP带伤上战场，以后给你多招点人，你就是领导了...", tester.getName()));
        }
    }


    /**
     * 过了一段时间，老板又觉的短视频很火，又要做短视频，这就要求给每一员工增加一套新的算法。
     */
    public static class LiveApp implements CorporateSlaveVisitor {
        @Override
        public void visit(Programmer programmer) {
            System.out.println(String.format("%s: 最近小视频很火啊，咱能不能抄袭下抖音，搞他一炮,将来公司上市了，你的身价至少也是几千万，甚至上亿...", programmer.getName()));
        }

        @Override
        public void visit(HumanSource humanSource) {
            System.out.println(String.format("%s: 咱公司就数你长得靓，哪天化化妆，把你的事业线适当露一露，要是火了你在北京买房都不是梦...", humanSource.getName()));
        }

        @Override
        public void visit(Tester tester) {
            System.out.println(String.format("%s: 你也开个账户，边测试边直播，两不耽误...", tester.getName()));
        }
    }

    //再过段时间老板可能要开KTV，程序员王二狗可能要下海当鸭子，其他两位也需要解锁新技能...

    ///////////////////////////////////////////////////////////////////////////
    // 测试
    ///////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        BigHuYouCompany bigHuYou = new BigHuYouCompany();
        //可以很轻松的更换Visitor，但是要求BigHuYouCompany的结构稳定
        System.out.println("-----------------启动社交APP项目--------------------");
        bigHuYou.startProject(new SocialApp());
        System.out.println("-----------------启动短视频APP项目--------------------");
        bigHuYou.startProject(new LiveApp());
    }

}
