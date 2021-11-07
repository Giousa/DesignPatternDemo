package com.giousa.委派模式.work;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {

    private Map<String, IEmployee> employee = new HashMap<>();

    public Leader() {
        employee.put("爬虫", new EmployeeA());
        employee.put("海报图", new EmployeeB());
    }

    @Override
    public void doing(String task) {
        if (!employee.containsKey(task)) {
            System.out.println("这个任务：" + task + "，超出能力范围");
            return;
        }
        employee.get(task).doing(task);
    }
}
