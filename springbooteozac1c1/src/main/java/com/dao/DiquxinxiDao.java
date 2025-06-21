package com.dao;

import com.entity.DiquxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiquxinxiVO;
import com.entity.view.DiquxinxiView;


/**
 * 地区信息
 * 
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
public interface DiquxinxiDao extends BaseMapper<DiquxinxiEntity> {
	
	List<DiquxinxiVO> selectListVO(@Param("ew") Wrapper<DiquxinxiEntity> wrapper);
	
	DiquxinxiVO selectVO(@Param("ew") Wrapper<DiquxinxiEntity> wrapper);
	
	List<DiquxinxiView> selectListView(@Param("ew") Wrapper<DiquxinxiEntity> wrapper);

	List<DiquxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiquxinxiEntity> wrapper);

	
	DiquxinxiView selectView(@Param("ew") Wrapper<DiquxinxiEntity> wrapper);
	

}
