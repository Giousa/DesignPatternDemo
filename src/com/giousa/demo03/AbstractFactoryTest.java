package com.giousa.demo03;

/**
 * Description: 抽象工厂模式  一些工厂模式，组合而成
 *
 * 应用场合：
 * 程序需要处理不同系列的相关产品，但是您不希望它依赖于这些产品的具体类时，可以使用抽象工厂
 * 简单来说，如下面我们定义的IConnection和IComand接口，我们不希望直接创建一个类实现这几个接口，而是用一个
 * 叫做：IDatabaseUtils的接口管理起来，我们自定义的类，只需要实现这个工具接口即可
 *
 *
 * Author:zhangmengmeng
 * Date:2021/1/23
 * Email:65489469@qq.com
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        IDatabaseUtils iDatabaseUtils = new MysqlDatabaseUtils();

        IConnection connection = iDatabaseUtils.getConnection();
        connection.connect();


        IComand comand = iDatabaseUtils.getComand();
        comand.comand();

        System.out.println("-------------------");

        IDatabaseUtils oracle = new OracleDatabaseUtils();

        oracle.getConnection().connect();

        oracle.getComand().comand();


    }
}


/**
 * 接口
 */

interface IConnection{

    void connect();

}


interface IComand{

    void comand();
}




/**
 * 实现类
 */

//mysql
class MysqlConnect implements IConnection{

    @Override
    public void connect() {
        System.out.println("mysql connect 连接成功！");
    }
}

class MysqlComand implements IComand{

    @Override
    public void comand() {
        System.out.println("mysql comand 执行！");
    }
}


//oracle

class OracleConnect implements IConnection{

    @Override
    public void connect() {
        System.out.println("Oracle connect 连接成功！");
    }
}



class OracleComand implements IComand{


    @Override
    public void comand() {
        System.out.println("Oracle comand 执行！");
    }
}



/**
 * 我们使用的
 */
interface IDatabaseUtils{

    IConnection getConnection();

    IComand getComand();

}


class MysqlDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new MysqlConnect();
    }

    @Override
    public IComand getComand() {
        return new MysqlComand();
    }
}


class OracleDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new OracleConnect();
    }

    @Override
    public IComand getComand() {
        return new OracleComand();
    }
}