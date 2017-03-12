package com.zhh.personal.entity;

import java.util.Date;

/**
 * 附件类
 * @author zhaohaihao
 * @date 2017-3-10 下午11:40:11
 */
public class Attachment {
	
	private Integer id;				// 附件编号
	private Integer articleId;		// 文章编号
	private String title;			// 标题名
	private String filename;		// 文件名
	private String url;				// 附件地址
	private Date createTime;		// 上传时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Attachment [id=" + id + ", articleId=" + articleId + ", title="
				+ title + ", filename=" + filename + ", url=" + url
				+ ", createTime=" + createTime + "]";
	}
	
}
