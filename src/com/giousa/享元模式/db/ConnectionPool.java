package com.giousa.享元模式.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPool {

    private Vector<Connection> pool;

    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "root";
    private String driverClassName = "com.mysql.jdbc.Driver";
    private int poolSize = 100;

    public ConnectionPool() {
        pool = new Vector<>(poolSize);

        try {
            Class<?> clazz = Class.forName(driverClassName);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                pool.add(connection);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        if (pool.size() > 0) {
            Connection connection = pool.get(0);
            pool.remove(connection);
            return connection;
        }
        return null;
    }

    public synchronized void release(Connection connection) {
        pool.add(connection);
    }
}
