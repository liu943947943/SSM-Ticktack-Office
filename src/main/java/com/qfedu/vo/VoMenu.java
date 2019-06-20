package com.qfedu.vo;

import java.util.List;

/**
 * Created by Coco on 2019/6/13.
 */
public class VoMenu {

    private Integer id;
    private String aTitle;
    private String aUrl;

    private List<VoMenu> voMenuList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public String getaUrl() {
        return aUrl;
    }

    public void setaUrl(String aUrl) {
        this.aUrl = aUrl;
    }

    public List<VoMenu> getVoMenuList() {
        return voMenuList;
    }

    public void setVoMenuList(List<VoMenu> voMenuList) {
        this.voMenuList = voMenuList;
    }
}
