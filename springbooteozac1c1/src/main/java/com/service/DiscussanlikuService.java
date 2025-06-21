package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussanlikuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussanlikuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussanlikuView;


/**
 * 案例库评论表
 *
 * @author 
 * @email 
 * @date 2024-04-02 08:50:30
 */
public interface DiscussanlikuService extends IService<DiscussanlikuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussanlikuVO> selectListVO(Wrapper<DiscussanlikuEntity> wrapper);
   	
   	DiscussanlikuVO selectVO(@Param("ew") Wrapper<DiscussanlikuEntity> wrapper);
   	
   	List<DiscussanlikuView> selectListView(Wrapper<DiscussanlikuEntity> wrapper);
   	
   	DiscussanlikuView selectView(@Param("ew") Wrapper<DiscussanlikuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussanlikuEntity> wrapper);

   	

}

