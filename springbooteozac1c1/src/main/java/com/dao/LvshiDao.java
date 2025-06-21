package com.dao;

import com.entity.LvshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LvshiVO;
import com.entity.view.LvshiView;


/**
 * 律师
 * 
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
public interface LvshiDao extends BaseMapper<LvshiEntity> {
	
	List<LvshiVO> selectListVO(@Param("ew") Wrapper<LvshiEntity> wrapper);
	
	LvshiVO selectVO(@Param("ew") Wrapper<LvshiEntity> wrapper);
	
	List<LvshiView> selectListView(@Param("ew") Wrapper<LvshiEntity> wrapper);

	List<LvshiView> selectListView(Pagination page,@Param("ew") Wrapper<LvshiEntity> wrapper);

	
	LvshiView selectView(@Param("ew") Wrapper<LvshiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LvshiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LvshiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LvshiEntity> wrapper);



}
