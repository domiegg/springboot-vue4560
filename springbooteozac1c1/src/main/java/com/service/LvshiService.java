package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LvshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LvshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LvshiView;


/**
 * 律师
 *
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
public interface LvshiService extends IService<LvshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LvshiVO> selectListVO(Wrapper<LvshiEntity> wrapper);
   	
   	LvshiVO selectVO(@Param("ew") Wrapper<LvshiEntity> wrapper);
   	
   	List<LvshiView> selectListView(Wrapper<LvshiEntity> wrapper);
   	
   	LvshiView selectView(@Param("ew") Wrapper<LvshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LvshiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<LvshiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<LvshiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<LvshiEntity> wrapper);



}

