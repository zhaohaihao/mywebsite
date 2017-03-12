package com.zhh.personal.entity;

import java.util.Date;

/**
 * 评论类
 * @author zhaohaihao
 * @date 2017-3-10 下午11:43:28
 */
public class Comment {
	
	private Integer id;			// 评论编号
	private Integer typeId;		// 类型编号
	private String content;		// 评论内容
	private Integer parentId;	// 评论父编号
	private Integer childId;	// 评论子编号
	private Date createTime;	// 评论时间
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getChildId() {
		return childId;
	}
	public void setChildId(Integer childId) {
		this.childId = childId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", typeId=" + typeId + ", content="
				+ content + ", parentId=" + parentId + ", childId=" + childId
				+ ", createTime=" + createTime + "]";
	}
	
}
