package com.qfedu.pojo;

/**
 * Created by Coco on 2019/6/18.
 */
public class Role {

    private Integer id;
    private String info;
    private String name;
    private int parentid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentid;
    }

    public void setParentId(int parentId) {
        this.parentid = parentid;
    }
}
