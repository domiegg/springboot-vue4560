package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussfalvziyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussfalvziyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussfalvziyuanView;


/**
 * 法律资源评论表
 *
 * @author 
 * @email 
 * @date 2024-04-02 08:50:30
 */
public interface DiscussfalvziyuanService extends IService<DiscussfalvziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfalvziyuanVO> selectListVO(Wrapper<DiscussfalvziyuanEntity> wrapper);
   	
   	DiscussfalvziyuanVO selectVO(@Param("ew") Wrapper<DiscussfalvziyuanEntity> wrapper);
   	
   	List<DiscussfalvziyuanView> selectListView(Wrapper<DiscussfalvziyuanEntity> wrapper);
   	
   	DiscussfalvziyuanView selectView(@Param("ew") Wrapper<DiscussfalvziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfalvziyuanEntity> wrapper);

   	

}

