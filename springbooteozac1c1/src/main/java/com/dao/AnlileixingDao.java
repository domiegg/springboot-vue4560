package com.dao;

import com.entity.AnlileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.AnlileixingVO;
import com.entity.view.AnlileixingView;


/**
 * 案例类型
 * 
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
public interface AnlileixingDao extends BaseMapper<AnlileixingEntity> {
	
	List<AnlileixingVO> selectListVO(@Param("ew") Wrapper<AnlileixingEntity> wrapper);
	
	AnlileixingVO selectVO(@Param("ew") Wrapper<AnlileixingEntity> wrapper);
	
	List<AnlileixingView> selectListView(@Param("ew") Wrapper<AnlileixingEntity> wrapper);

	List<AnlileixingView> selectListView(Pagination page,@Param("ew") Wrapper<AnlileixingEntity> wrapper);

	
	AnlileixingView selectView(@Param("ew") Wrapper<AnlileixingEntity> wrapper);
	

}
