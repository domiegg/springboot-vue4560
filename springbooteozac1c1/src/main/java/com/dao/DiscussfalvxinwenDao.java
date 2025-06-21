package com.dao;

import com.entity.DiscussfalvxinwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussfalvxinwenVO;
import com.entity.view.DiscussfalvxinwenView;


/**
 * 法律新闻评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-02 08:50:30
 */
public interface DiscussfalvxinwenDao extends BaseMapper<DiscussfalvxinwenEntity> {
	
	List<DiscussfalvxinwenVO> selectListVO(@Param("ew") Wrapper<DiscussfalvxinwenEntity> wrapper);
	
	DiscussfalvxinwenVO selectVO(@Param("ew") Wrapper<DiscussfalvxinwenEntity> wrapper);
	
	List<DiscussfalvxinwenView> selectListView(@Param("ew") Wrapper<DiscussfalvxinwenEntity> wrapper);

	List<DiscussfalvxinwenView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfalvxinwenEntity> wrapper);

	
	DiscussfalvxinwenView selectView(@Param("ew") Wrapper<DiscussfalvxinwenEntity> wrapper);
	

}
