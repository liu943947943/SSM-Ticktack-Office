package com.vo;

import java.util.List;

public class MenuVo {
	private Integer id;
	private String aicon;
	private String aurl;
	private Integer parentId;
	private String title;
	private Integer type;
	private List<MenuVo> childs;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<MenuVo> getChilds() {
		return childs;
	}
	public void setChilds(List<MenuVo> childs) {
		this.childs = childs;
	}
	
	
}
