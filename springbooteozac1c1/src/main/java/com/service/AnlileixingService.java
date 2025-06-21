package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.AnlileixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.AnlileixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.AnlileixingView;


/**
 * 案例类型
 *
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
public interface AnlileixingService extends IService<AnlileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AnlileixingVO> selectListVO(Wrapper<AnlileixingEntity> wrapper);
   	
   	AnlileixingVO selectVO(@Param("ew") Wrapper<AnlileixingEntity> wrapper);
   	
   	List<AnlileixingView> selectListView(Wrapper<AnlileixingEntity> wrapper);
   	
   	AnlileixingView selectView(@Param("ew") Wrapper<AnlileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AnlileixingEntity> wrapper);

   	

}

