package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.AnlikuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.AnlikuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.AnlikuView;


/**
 * 案例库
 *
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
public interface AnlikuService extends IService<AnlikuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AnlikuVO> selectListVO(Wrapper<AnlikuEntity> wrapper);
   	
   	AnlikuVO selectVO(@Param("ew") Wrapper<AnlikuEntity> wrapper);
   	
   	List<AnlikuView> selectListView(Wrapper<AnlikuEntity> wrapper);
   	
   	AnlikuView selectView(@Param("ew") Wrapper<AnlikuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AnlikuEntity> wrapper);

   	

}

