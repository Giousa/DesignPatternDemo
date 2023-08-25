package com.giousa.模板方法;

public class Client2 {
    public static abstract class AbstractCourse {

        public final void createCourse() {

            //1、发布预习资料
            postPreResource();

            //2、制作课程PPT
            createPPT();

            //3、在线直播
            liveVideo();

            //4、上传课后资料
            postResource();

            //5、布置作业
            postHomework();

            if (neeedCheckHomework()) {
                checkHomework();
            }
        }

        protected abstract void checkHomework();

        protected boolean neeedCheckHomework() {
            return false;
        }

        private void postPreResource() {
            System.out.println("发布预习资料");
        }

        private void createPPT() {
            System.out.println("制作课程PPT");
        }

        private void liveVideo() {
            System.out.println("在线直播");
        }

        private void postResource() {
            System.out.println("上传课后资料");
        }

        private void postHomework() {
            System.out.println("布置作业");
        }
    }

    public static class PythonCourse extends AbstractCourse {
        @Override
        protected void checkHomework() {
            System.out.println("检查Python作业");
        }
    }

    public static class JavaCourse extends AbstractCourse {

        private boolean needCheckHome = false;

        public void setNeedCheckHome(boolean needCheckHome) {
            this.needCheckHome = needCheckHome;
        }

        @Override
        protected boolean neeedCheckHomework() {
            return this.needCheckHome;
        }

        @Override
        protected void checkHomework() {
            System.out.println("检查java课后作业");
        }
    }

    public static void main(String[] args) {
        System.out.println("===java===");
        JavaCourse javaCourse = new JavaCourse();
        javaCourse.setNeedCheckHome(true);
        javaCourse.createCourse();


        System.out.println("===python===");
        PythonCourse pythonCourse = new PythonCourse();
        pythonCourse.createCourse();
    }
}
