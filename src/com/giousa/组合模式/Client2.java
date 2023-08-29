package com.giousa.组合模式;

import java.util.ArrayList;
import java.util.List;

public class Client2 {

    /**
     * 定义对外展示的统一处理接口
     */
    public static abstract class OrganizationComponent {
        private String name;

        public OrganizationComponent(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract void add(OrganizationComponent organization);

        public abstract OrganizationComponent getChild(String orgName);

        public abstract int getStaffCount();

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * 组合类
     * 此类持有一个List<OrganizationComponent>，并继承OrganizationComponent。
     */
    public static class OrganizationComposite extends OrganizationComponent {

        //很关键，这体现了组合的思想
        private List<OrganizationComponent> organizations = new ArrayList<>();

        public OrganizationComposite(String name) {
            super(name);
        }

        @Override
        public void add(OrganizationComponent organization) {
            organizations.add(organization);
        }

        @Override
        public OrganizationComponent getChild(String orgName) {
            for (OrganizationComponent org : organizations) {
                OrganizationComponent targetOrg = org.getChild(orgName);
                if (targetOrg != null) {
                    return targetOrg;
                }
            }
            return null;
        }

        @Override
        public int getStaffCount() {
            int count = 0;
            for (OrganizationComponent organization : organizations) {
                count += organization.getStaffCount();
            }
            return count;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 子节点
    ///////////////////////////////////////////////////////////////////////////
    /**
     * 叶子节点就是单个对象了，我们要使用合适的方式处理那些叶子节点不支持的对外接口方法。因为用户使的时候只会看到对外暴露的统一接口，他不知道此对象是叶子节点还是组合对象。
     */
    public static class ItDepartment extends OrganizationComponent {

        public ItDepartment(String name) {
            super(name);
        }

        @Override
        public int getStaffCount() {
            return 20;
        }

        @Override
        public void add(OrganizationComponent organization) {
            throw new UnsupportedOperationException(this.getName()+"已经是最基本部门，无法增加下属部门");
        }

        @Override
        public OrganizationComponent getChild(String orgName) {
            if(getName().equals(orgName)){
                return this;
            }
            return null;
        }
    }

    public static class AdminDepartment extends OrganizationComponent {

        public AdminDepartment(String name) {
            super(name);
        }

        @Override
        public int getStaffCount() {
            return 30;
        }

        @Override
        public void add(OrganizationComponent organization) {
            throw new UnsupportedOperationException(this.getName()+"已经是最基本部门，无法增加下属部门");
        }

        @Override
        public OrganizationComponent getChild(String orgName) {
            if(getName().equals(orgName)){
                return this;
            }
            return null;
        }
    }


    ///////////////////////////////////////////////////////////////////////////
    // 测试
    ///////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        //构建总部
        OrganizationComposite org = new OrganizationComposite("总公司");
        AdminDepartment headAdmin = new AdminDepartment("总公司行政部");
        ItDepartment headIt = new ItDepartment("总公司It部");
        org.add(headAdmin);
        org.add(headIt);

        //构建分公司
        OrganizationComposite branch1 = new OrganizationComposite("天津分公司");
        AdminDepartment branch1Admin = new AdminDepartment("天津分公司行政部");
        ItDepartment branch1It = new ItDepartment("天津分公司It部");
        branch1.add(branch1Admin);
        branch1.add(branch1It);

        //将分公司加入到org中
        org.add(branch1);

        System.out.println(String.format("%s共有%d名员工", org.getName(), org.getStaffCount()));

        OrganizationComponent subOrg = org.getChild("天津分公司行政部");
        System.out.println(String.format("%s共有%d名员工", subOrg.getName(), subOrg.getStaffCount()));
    }


}
