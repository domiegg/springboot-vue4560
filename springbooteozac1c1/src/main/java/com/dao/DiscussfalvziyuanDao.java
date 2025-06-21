package com.dao;

import com.entity.DiscussfalvziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussfalvziyuanVO;
import com.entity.view.DiscussfalvziyuanView;


/**
 * 法律资源评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-02 08:50:30
 */
public interface DiscussfalvziyuanDao extends BaseMapper<DiscussfalvziyuanEntity> {
	
	List<DiscussfalvziyuanVO> selectListVO(@Param("ew") Wrapper<DiscussfalvziyuanEntity> wrapper);
	
	DiscussfalvziyuanVO selectVO(@Param("ew") Wrapper<DiscussfalvziyuanEntity> wrapper);
	
	List<DiscussfalvziyuanView> selectListView(@Param("ew") Wrapper<DiscussfalvziyuanEntity> wrapper);

	List<DiscussfalvziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfalvziyuanEntity> wrapper);

	
	DiscussfalvziyuanView selectView(@Param("ew") Wrapper<DiscussfalvziyuanEntity> wrapper);
	

}
