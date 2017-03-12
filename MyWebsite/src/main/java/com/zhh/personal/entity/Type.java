package com.zhh.personal.entity;
/**
 * 类型类
 * @author zhaohaihao
 * @date 2017-3-10 下午11:50:29
 */
public class Type {
	
	private Integer id;			// 类型编号
	private Integer objType;	// 对象类型:1图片,2文章
	private Integer objId;		// 对象编号
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getObjType() {
		return objType;
	}
	public void setObjType(Integer objType) {
		this.objType = objType;
	}
	public Integer getObjId() {
		return objId;
	}
	public void setObjId(Integer objId) {
		this.objId = objId;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", objType=" + objType + ", objId=" + objId
				+ "]";
	}
	
}
