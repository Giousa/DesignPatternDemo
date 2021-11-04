package com.giousa.组合模式.course;

import java.util.ArrayList;
import java.util.List;

public class CoursePackage extends CourseComponent {

    private List<CourseComponent> items = new ArrayList<>();

    private String name;

    private Integer level;

    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(CourseComponent component) {
        items.add(component);
    }

    @Override
    public String getName(CourseComponent component) {
        return this.name;
    }

    @Override
    public void removeChild(CourseComponent component) {
        items.remove(component);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CourseComponent component : items) {
            for (int i = 0; i < this.level; i++) {
                System.out.print("  ");
            }

            for (int i = 0; i < this.level; i++) {
                if (i == 0) {
                    System.out.print("+");
                }
                System.out.print("-");
            }

            component.print();
        }
    }
}
