package com.giousa.组合模式.file;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Direactory {

    private List<Direactory> dirs;

    private Integer level;

    public Folder(String name, Integer level) {
        super(name);
        this.level = level;
        this.dirs = new ArrayList<>();
    }

    @Override
    public void show() {
        System.out.println(this.name);
        for (Direactory direactory : dirs) {

            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    System.out.print("  ");
                }

                for (int i = 0; i < this.level; i++) {
                    if (i == 0) {
                        System.out.print("+");
                    }
                    System.out.print("-");
                }

            }

            direactory.show();
        }
    }

    public boolean add(Direactory direactory) {
        return this.dirs.add(direactory);
    }

    public boolean remove(Direactory direactory) {
        return this.dirs.remove(direactory);
    }

    public Direactory get(int index) {
        return this.dirs.get(index);
    }

    public void list() {
        for (Direactory direactory : dirs) {
            System.out.println(direactory.name);
        }
    }

}
