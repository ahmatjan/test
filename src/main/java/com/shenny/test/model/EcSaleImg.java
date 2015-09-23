package com.shenny.test.model;

import java.util.Date;

/**   
* @ClassName: EcSaleImg  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年9月22日 下午2:53:33  
*/
public class EcSaleImg {
	
	private int id;
	private int saleId;
	private String imgUri;
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
	 * @return the saleId
	 */
	public int getSaleId() {
		return saleId;
	}
	/**
	 * @param saleId the saleId to set
	 */
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	/**
	 * @return the imgUri
	 */
	public String getImgUri() {
		return imgUri;
	}
	/**
	 * @param imgUri the imgUri to set
	 */
	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
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
	
	

}
