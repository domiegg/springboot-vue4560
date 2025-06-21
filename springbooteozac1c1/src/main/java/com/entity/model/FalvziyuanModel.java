package com.entity.model;

import com.entity.FalvziyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 法律资源
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
public class FalvziyuanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 资源分类
	 */
	
	private String ziyuanfenlei;
		
	/**
	 * 资源文件
	 */
	
	private String ziyuanwenjian;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 上传时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shangchuanshijian;
		
	/**
	 * 资源内容
	 */
	
	private String ziyuanneirong;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：资源分类
	 */
	 
	public void setZiyuanfenlei(String ziyuanfenlei) {
		this.ziyuanfenlei = ziyuanfenlei;
	}
	
	/**
	 * 获取：资源分类
	 */
	public String getZiyuanfenlei() {
		return ziyuanfenlei;
	}
				
	
	/**
	 * 设置：资源文件
	 */
	 
	public void setZiyuanwenjian(String ziyuanwenjian) {
		this.ziyuanwenjian = ziyuanwenjian;
	}
	
	/**
	 * 获取：资源文件
	 */
	public String getZiyuanwenjian() {
		return ziyuanwenjian;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：上传时间
	 */
	 
	public void setShangchuanshijian(Date shangchuanshijian) {
		this.shangchuanshijian = shangchuanshijian;
	}
	
	/**
	 * 获取：上传时间
	 */
	public Date getShangchuanshijian() {
		return shangchuanshijian;
	}
				
	
	/**
	 * 设置：资源内容
	 */
	 
	public void setZiyuanneirong(String ziyuanneirong) {
		this.ziyuanneirong = ziyuanneirong;
	}
	
	/**
	 * 获取：资源内容
	 */
	public String getZiyuanneirong() {
		return ziyuanneirong;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
