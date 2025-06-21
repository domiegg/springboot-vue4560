package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussfalvxinwenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussfalvxinwenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussfalvxinwenView;


/**
 * 法律新闻评论表
 *
 * @author 
 * @email 
 * @date 2024-04-02 08:50:30
 */
public interface DiscussfalvxinwenService extends IService<DiscussfalvxinwenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfalvxinwenVO> selectListVO(Wrapper<DiscussfalvxinwenEntity> wrapper);
   	
   	DiscussfalvxinwenVO selectVO(@Param("ew") Wrapper<DiscussfalvxinwenEntity> wrapper);
   	
   	List<DiscussfalvxinwenView> selectListView(Wrapper<DiscussfalvxinwenEntity> wrapper);
   	
   	DiscussfalvxinwenView selectView(@Param("ew") Wrapper<DiscussfalvxinwenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfalvxinwenEntity> wrapper);

   	

}

