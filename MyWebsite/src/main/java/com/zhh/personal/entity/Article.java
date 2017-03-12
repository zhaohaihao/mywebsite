package com.zhh.personal.entity;

import java.util.Date;

/**
 * 文章类
 * @author zhaohaihao
 * @date 2017-3-10 下午11:35:13
 */
public class Article {
	
	private Integer id;			// 文章编号
	private String title;		// 文章标题
	private String url;			// 文章存放地址
	private Integer imgId;		// 主题图片编号
	private String keyword;		// 关键字
	private Integer state;		// 状态:0未审核,1审核通过,2审核未通过,3已删除
	private Date createTime;	// 创建时间
	private Date uepdateTime;	// 修改时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	public Date getUepdateTime() {
		return uepdateTime;
	}
	public void setUepdateTime(Date uepdateTime) {
		this.uepdateTime = uepdateTime;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", url=" + url
				+ ", imgId=" + imgId + ", keyword=" + keyword + ", state="
				+ state + ", createTime=" + createTime + ", uepdateTime="
				+ uepdateTime + "]";
	}
	
}

