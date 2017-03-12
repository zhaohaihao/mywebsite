package com.zhh.personal.entity;

import java.util.Date;

/**
 * 图片类
 * @author zhaohaihao
 * @date 2017-3-10 下午11:47:58
 */
public class Image {
	
	private Integer id;			// 图片编号
	private String name;		// 图片名称
	private String depict;		// 图片描述
	private String url;			// 图片地址
	private Integer type;		// 图片类型:0未分类,1人物,2地方,3事物
	private Integer state;		// 状态:0未审核,1审核通过,2审核未通过,3已删除
	private Date createTime;	// 上传时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepict() {
		return depict;
	}
	public void setDepict(String depict) {
		this.depict = depict;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", depict=" + depict
				+ ", url=" + url + ", type=" + type + ", state=" + state
				+ ", createTime=" + createTime + "]";
	}
	
}
