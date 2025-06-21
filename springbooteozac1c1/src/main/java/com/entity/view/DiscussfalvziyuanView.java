package com.entity.view;

import com.entity.DiscussfalvziyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 法律资源评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-02 08:50:30
 */
@TableName("discussfalvziyuan")
public class DiscussfalvziyuanView  extends DiscussfalvziyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussfalvziyuanView(){
	}
 
 	public DiscussfalvziyuanView(DiscussfalvziyuanEntity discussfalvziyuanEntity){
 	try {
			BeanUtils.copyProperties(this, discussfalvziyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
