package com.zhh.personal.entity;
/**
 * 统计类
 * @author zhaohaihao
 * @date 2017-3-10 下午11:46:22
 */
public class Count {
	
	private Integer id;			// 统计编号
	private Integer typeId;		// 类型编号
	private Integer views;		// 浏览数
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	@Override
	public String toString() {
		return "Count [id=" + id + ", typeId=" + typeId + ", views=" + views
				+ "]";
	}
	
}
