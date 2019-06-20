package com.qfedu.pojo;

import java.util.Date;

/**
 * Created by Coco on 2019/6/17.
 */
public class LoginInfo {

    private Integer id;
    private String ip;
    private String no;
    private Date createtime;
    private String location;

    public LoginInfo() {
    }

    public LoginInfo(Integer id, String ip, String no, Date createtime, String location) {
        this.id = id;
        this.ip = ip;
        this.no = no;
        this.createtime = createtime;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", no='" + no + '\'' +
                ", createtime=" + createtime +
                ", location='" + location + '\'' +
                '}';
    }
}
