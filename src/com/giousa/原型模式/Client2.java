package com.giousa.原型模式;

import java.text.MessageFormat;

public class Client2 {

    /**
     * 实现了Cloneable接口的类相当于具体原型类
     */
    public static class Mail implements Cloneable {
        private String name;
        private String emailAddress;
        private String content;

        public Mail() {
            System.out.println("Mail Class Constructor");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        /**
         * Object类相当于抽象原型类，所有实现了Cloneable接口的类相当于具体原型类。
         */
        @Override
        protected Object clone() throws CloneNotSupportedException {
            System.out.println("clone mail object");
            return super.clone();
        }
    }

    public static void sendMail(Mail mail) {
        System.out.println(MessageFormat.format("【发送到】:{0}同学, 【邮件地址】:{1}, 【邮件内容】:{2} 发送邮件成功", mail.getName(), mail.getEmailAddress(), mail.getContent()));
    }

    public static void saveOriginMailRecord(Mail mail) {
        System.out.println("存储originMail记录,originMail:" + mail.getContent());
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("恭喜您，此次抽奖活动中奖了");
        System.out.println("初始化mail:" + mail);
        for (int i = 0; i < 3; i++) {
            System.out.println();
            Mail mailTemp = (Mail) mail.clone();
            mailTemp.setName("姓名" + i);
            mailTemp.setEmailAddress("姓名" + i + "@test.com");
//            mailTemp.setContent("恭喜您，此次抽奖活动中奖了");
            sendMail(mailTemp);
            System.out.println("克隆的mailTemp:" + mailTemp);
        }
        saveOriginMailRecord(mail);
    }
}
