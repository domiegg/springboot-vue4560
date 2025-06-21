package com.dao;

import com.entity.FalvxinwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FalvxinwenVO;
import com.entity.view.FalvxinwenView;


/**
 * 法律新闻
 * 
 * @author 
 * @email 
 * @date 2024-04-02 08:50:30
 */
public interface FalvxinwenDao extends BaseMapper<FalvxinwenEntity> {
	
	List<FalvxinwenVO> selectListVO(@Param("ew") Wrapper<FalvxinwenEntity> wrapper);
	
	FalvxinwenVO selectVO(@Param("ew") Wrapper<FalvxinwenEntity> wrapper);
	
	List<FalvxinwenView> selectListView(@Param("ew") Wrapper<FalvxinwenEntity> wrapper);

	List<FalvxinwenView> selectListView(Pagination page,@Param("ew") Wrapper<FalvxinwenEntity> wrapper);

	
	FalvxinwenView selectView(@Param("ew") Wrapper<FalvxinwenEntity> wrapper);
	

}
