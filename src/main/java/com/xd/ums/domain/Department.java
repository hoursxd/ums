package com.xd.ums.domain;

public class Department {

    private int depart_id;
    private String depart_name;
    private int depart_parent;

    public int getDepart_id() {
        return depart_id;
    }

    public void setDepart_id(int depart_id) {
        this.depart_id = depart_id;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    public int getDepart_parent() {
        return depart_parent;
    }

    public void setDepart_parent(int depart_parent) {
        this.depart_parent = depart_parent;
    }
}
