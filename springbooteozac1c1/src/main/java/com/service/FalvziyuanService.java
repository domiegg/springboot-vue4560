package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FalvziyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FalvziyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FalvziyuanView;


/**
 * 法律资源
 *
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
public interface FalvziyuanService extends IService<FalvziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FalvziyuanVO> selectListVO(Wrapper<FalvziyuanEntity> wrapper);
   	
   	FalvziyuanVO selectVO(@Param("ew") Wrapper<FalvziyuanEntity> wrapper);
   	
   	List<FalvziyuanView> selectListView(Wrapper<FalvziyuanEntity> wrapper);
   	
   	FalvziyuanView selectView(@Param("ew") Wrapper<FalvziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FalvziyuanEntity> wrapper);

   	

}

