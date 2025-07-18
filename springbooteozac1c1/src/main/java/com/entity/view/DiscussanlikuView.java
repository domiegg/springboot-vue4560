package com.entity.view;

import com.entity.DiscussanlikuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 案例库评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-02 08:50:30
 */
@TableName("discussanliku")
public class DiscussanlikuView  extends DiscussanlikuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussanlikuView(){
	}
 
 	public DiscussanlikuView(DiscussanlikuEntity discussanlikuEntity){
 	try {
			BeanUtils.copyProperties(this, discussanlikuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
