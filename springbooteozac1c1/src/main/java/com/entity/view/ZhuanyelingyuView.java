package com.entity.view;

import com.entity.ZhuanyelingyuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 专业领域
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
@TableName("zhuanyelingyu")
public class ZhuanyelingyuView  extends ZhuanyelingyuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhuanyelingyuView(){
	}
 
 	public ZhuanyelingyuView(ZhuanyelingyuEntity zhuanyelingyuEntity){
 	try {
			BeanUtils.copyProperties(this, zhuanyelingyuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
