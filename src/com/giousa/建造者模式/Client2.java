package com.giousa.建造者模式;

public class Client2 {

    public static class Person {
        private String name;

        private String ppt;

        private String video;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPpt() {
            return ppt;
        }

        public void setPpt(String ppt) {
            this.ppt = ppt;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", ppt='" + ppt + '\'' +
                    ", video='" + video + '\'' +
                    '}';
        }
    }

    public static class PersonBuilder {
        Person person = new Person();

        public static PersonBuilder build() {
            return new PersonBuilder();
        }

        public PersonBuilder addName(String name) {
            person.setName(name);
            return this;
        }

        public PersonBuilder addPPT(String ppt) {
            person.setPpt(ppt);
            return this;
        }

        public PersonBuilder addVideo(String video) {
            person.setVideo(video);
            return this;
        }

        public Person builder() {
            return person;
        }
    }

    public static void main(String[] args) {
        Person person = PersonBuilder.build()
                .addName("曹操")
                .addPPT("展示PPT")
                .addVideo("放视频")
                .builder();

        System.out.println(person);
    }
}
