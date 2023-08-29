package com.giousa.责任链模式;

import java.util.Objects;

/**
 * 背景：
 * 用户提出买一台Mac笔记本电脑。这花钱的事需要领导审批，而每个领导权限不一样，能够审批的最大金额有限制。
 * 用户首先肯定是向自己的小组leader提出，但是由于金额太大，超出了他的审批权限。于是小组领导就去找自己的领导，部门经理，但是部门经理也权限不够，最后到了CFO那里...
 * 用户遇到的情况就非常适合使用责任链模式。用户这个预算申请的请求，事先不知道会由哪层领导处理，而各层领导的审批职责就好像铁链一样连接在一起，一个预算请求沿着这条链一直往上传...
 */
public class Client2 {

    /**
     * 设计一个所有处理器都要实现的接口
     * <p>
     * 其中setNextHandler(BudgetHandler)方法负责设置下一个处理器，以便在自己不能处理此请求的情况下，将请求交给下一个处理器。
     * handle(int) 方法负责处理请求。
     */
    public interface BudgetHandler {
        void setNextHandler(BudgetHandler nextHandler);

        boolean handle(int amount);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 实现各种处理器
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 小组领导类
     */
    public static class GroupLeader implements BudgetHandler {
        private BudgetHandler nextHandler;

        @Override
        public void setNextHandler(BudgetHandler nextHandler) {
            this.nextHandler = nextHandler;
        }

        @Override
        public boolean handle(int amount) {
            Objects.requireNonNull(nextHandler);
            if (amount < 1000) {
                System.out.println("小钱，批了！");
                return true;
            }
            System.out.println(String.format("%d超出GroupLeader权限,请更高级管理层批复", amount));
            return nextHandler.handle(amount);
        }
    }

    /**
     * 经理类
     */
    public static class Manager implements BudgetHandler {
        private BudgetHandler nextHandler;

        @Override
        public void setNextHandler(BudgetHandler nextHandler) {
            this.nextHandler = nextHandler;
        }

        @Override
        public boolean handle(int amount) {
            Objects.requireNonNull(nextHandler);
            if (amount < 5000) {
                System.out.println("小于5000块，我这个经理可以决定：同意！");
                return true;
            }
            System.out.println(String.format("%d超出Manager权限,请更高级管理层批复", amount));
            return nextHandler.handle(amount);
        }
    }

    /**
     * 首席财务官类
     */
    public static class CFO implements BudgetHandler {
        private BudgetHandler nextHandler;

        @Override
        public void setNextHandler(BudgetHandler nextHandler) {
            this.nextHandler = nextHandler;
        }

        @Override
        public boolean handle(int amount) {
            if (amount < 50000) {
                System.out.println("CFO同意,希望你再接再厉，为公司做出更大的贡献。");
                return true;
            }
            if (nextHandler != null) {
                return nextHandler.handle(amount);
            }
            //已经没有更高级的管理层来处理了
            System.out.println(String.format("%d太多了，回去好好看看能不能缩减一下", amount));
            return false;
        }
    }

    public static void main(String[] args) {
        GroupLeader leader = new GroupLeader();
        Manager manager = new Manager();
        CFO cfo = new CFO();

        leader.setNextHandler(manager);
        manager.setNextHandler(cfo);

        System.out.println(String.format("领导您好：由于开发需求，需要购买一台Mac笔记本电脑，预算为%d 望领导批准", 95000));
        if (leader.handle(95000)) {
            System.out.println("谢谢领导");
        } else {
            System.out.println("巧妇难为无米之炊，只能划船了...");
        }
    }
}
