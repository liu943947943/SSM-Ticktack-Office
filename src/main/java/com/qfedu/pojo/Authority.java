package com.qfedu.pojo;

/**
 * Created by Coco on 2019/6/18.
 */
public class Authority {

    private Integer id;
    private String aicon;
    private String aurl;
    private Integer parentId;
    private String title;
    private int type;

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", aicon='" + aicon + '\'' +
                ", aurl='" + aurl + '\'' +
                ", parentId=" + parentId +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAicon() {
        return aicon;
    }

    public void setAicon(String aicon) {
        this.aicon = aicon;
    }

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
