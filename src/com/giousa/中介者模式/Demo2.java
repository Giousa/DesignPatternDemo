package com.giousa.中介者模式;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 需求：
 * 有三种数据库 Mysql、Redis、Elasticsearch。
 * Mysql 作为主数据库，当增加一条数据时需要同步到另外两个数据库中；
 * Redis 作为缓存数据库，当增加一条数据时不需要同步到另外另个数据库；
 * Elasticsearch 作为大数据查询数据库，有一个统计功能，当增加一条数据时只需要同步到Mysql。
 */
public class Demo2 {

    /**
     * 抽象数据库操作
     */
    public static abstract class AbstractDatabase {
        public static final String MYSQL = "mysql";
        public static final String REDIS = "redis";
        public static final String ELASTICSEARCH = "elasticsearch";

        // 中介者
        protected AbstractMediator mediator;

        public AbstractDatabase(AbstractMediator mediator) {
            this.mediator = mediator;
        }

        public abstract void addData(String data);

        public abstract void add(String data);
    }

    /**
     * Mysql数据库操作（同事类1）
     */
    public static class MysqlDatabase extends AbstractDatabase {
        private List<String> dataset = new ArrayList<String>();

        public MysqlDatabase(AbstractMediator mediator) {
            super(mediator);
        }

        @Override
        public void addData(String data) {
            System.out.println("Mysql 添加数据：" + data);
            this.dataset.add(data);
        }

        @Override
        public void add(String data) {
            addData(data);
            this.mediator.sync(AbstractDatabase.MYSQL, data); // 数据同步作业交给中介者管理
        }

        public void select() {
            System.out.println("Mysql 查询，数据：" + this.dataset.toString());
        }
    }


    /**
     * Redis操作（同事类2）
     */
    public static class RedisDatabase extends AbstractDatabase {
        private List<String> dataset = new LinkedList<String>();

        public RedisDatabase(AbstractMediator mediator) {
            super(mediator);
        }

        @Override
        public void addData(String data) {
            System.out.println("Redis 添加数据：" + data);
            this.dataset.add(data);
        }

        @Override
        public void add(String data) {
            addData(data);
            this.mediator.sync(AbstractDatabase.REDIS, data);    // 数据同步作业交给中介者管理
        }

        public void cache() {
            System.out.println("Redis 缓存的数据：" + this.dataset.toString());
        }
    }



    /**
     * ES操作（同事类2）
     */
    public static class EsDatabase extends AbstractDatabase {
        private List<String> dataset = new CopyOnWriteArrayList<String>();

        public EsDatabase(AbstractMediator mediator) {
            super(mediator);
        }

        @Override
        public void addData(String data) {
            System.out.println("ES 添加数据：" + data);
            this.dataset.add(data);
        }

        @Override
        public void add(String data) {
            addData(data);
            this.mediator.sync(AbstractDatabase.ELASTICSEARCH, data);    // 数据同步作业交给中介者管理
        }

        public void count() {
            int count = this.dataset.size();
            System.out.println("Elasticsearch 统计，目前有 " + count + " 条数据，数据：" + this.dataset.toString());
        }
    }

    /**
     * 抽象中介者
     */
    public static abstract class AbstractMediator {
        protected MysqlDatabase mysqlDatabase;
        protected RedisDatabase redisDatabase;
        protected EsDatabase esDatabase;

        public abstract void sync(String databaseName, String data);

        public void setMysqlDatabase(MysqlDatabase mysqlDatabase) {
            this.mysqlDatabase = mysqlDatabase;
        }

        public void setRedisDatabase(RedisDatabase redisDatabase) {
            this.redisDatabase = redisDatabase;
        }

        public void setEsDatabase(EsDatabase esDatabase) {
            this.esDatabase = esDatabase;
        }
    }

    /**
     * 具体中介者
     */
    public static class SyncMediator extends AbstractMediator {
        @Override
        public void sync(String databaseName, String data) {
            if (AbstractDatabase.MYSQL.equals(databaseName)) {
                // mysql 同步到 redis 和 Elasticsearch
                this.redisDatabase.addData(data);
                this.esDatabase.addData(data);
            } else if (AbstractDatabase.REDIS.equals(databaseName)) {
                // redis 缓存同步，不需要同步到其他数据库
            } else if (AbstractDatabase.ELASTICSEARCH.equals(databaseName)) {
                // Elasticsearch 同步到 Mysql
                this.mysqlDatabase.addData(data);
            }
        }
    }

    public static void main(String[] args) {
        AbstractMediator syncMediator = new SyncMediator();
        MysqlDatabase mysqlDatabase = new MysqlDatabase(syncMediator);
        RedisDatabase redisDatabase = new RedisDatabase(syncMediator);
        EsDatabase esDatabase = new EsDatabase(syncMediator);

        syncMediator.setMysqlDatabase(mysqlDatabase);
        syncMediator.setRedisDatabase(redisDatabase);
        syncMediator.setEsDatabase(esDatabase);

        System.out.println("\n---------mysql 添加数据 1，将同步到Redis和ES中-----------");
        mysqlDatabase.add("1");
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

        System.out.println("\n---------Redis添加数据 2，将不同步到其它数据库-----------");
        redisDatabase.add("2");
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

        System.out.println("\n---------ES 添加数据 3，只同步到 Mysql-----------");
        esDatabase.add("3");
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();
    }

}
