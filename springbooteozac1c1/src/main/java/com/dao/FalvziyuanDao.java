package com.dao;

import com.entity.FalvziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FalvziyuanVO;
import com.entity.view.FalvziyuanView;


/**
 * 法律资源
 * 
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
public interface FalvziyuanDao extends BaseMapper<FalvziyuanEntity> {
	
	List<FalvziyuanVO> selectListVO(@Param("ew") Wrapper<FalvziyuanEntity> wrapper);
	
	FalvziyuanVO selectVO(@Param("ew") Wrapper<FalvziyuanEntity> wrapper);
	
	List<FalvziyuanView> selectListView(@Param("ew") Wrapper<FalvziyuanEntity> wrapper);

	List<FalvziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<FalvziyuanEntity> wrapper);

	
	FalvziyuanView selectView(@Param("ew") Wrapper<FalvziyuanEntity> wrapper);
	

}
