package com.xd.ums.domain;

public class Depart {

    private int id;
    private int pId;
    private String name;
//    private Boolean isParent;

    public Depart(){

    }

    public Depart(int id, int pId, String name) {
        this.id = id;
        this.pId = pId;
        this.name = name;
//        this.isParent = isParent;
    }

//    public Boolean getParent() {
//        return isParent;
//    }
//
//    public void setParent(Boolean parent) {
//        isParent = parent;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPId() {
        return pId;
    }

    public void setPId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
