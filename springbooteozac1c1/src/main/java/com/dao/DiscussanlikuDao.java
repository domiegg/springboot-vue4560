package com.dao;

import com.entity.DiscussanlikuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussanlikuVO;
import com.entity.view.DiscussanlikuView;


/**
 * 案例库评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-02 08:50:30
 */
public interface DiscussanlikuDao extends BaseMapper<DiscussanlikuEntity> {
	
	List<DiscussanlikuVO> selectListVO(@Param("ew") Wrapper<DiscussanlikuEntity> wrapper);
	
	DiscussanlikuVO selectVO(@Param("ew") Wrapper<DiscussanlikuEntity> wrapper);
	
	List<DiscussanlikuView> selectListView(@Param("ew") Wrapper<DiscussanlikuEntity> wrapper);

	List<DiscussanlikuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussanlikuEntity> wrapper);

	
	DiscussanlikuView selectView(@Param("ew") Wrapper<DiscussanlikuEntity> wrapper);
	

}
