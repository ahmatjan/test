package com.shenny.test.model;

import java.io.Serializable;
import java.util.Date;

/**   
* @ClassName: BaseChinaCity  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年9月22日 下午1:29:56  
*/
public class BaseChinaCity implements Serializable {
	
	private static final long serialVersionUID = 2929796914376158870L;
	
	private int id;
	private String name;
	private int provinceId;
	private Date createTime;
	private Date updateTime;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the provinceId
	 */
	public int getProvinceId() {
		return provinceId;
	}
	/**
	 * @param provinceId the provinceId to set
	 */
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj==null)
			return false;
		if(!(obj instanceof BaseChinaCity))
		return false;
		BaseChinaCity base=(BaseChinaCity)obj;
		if(base.id!=this.id)
			return true;
		return true;
	}
	

}
