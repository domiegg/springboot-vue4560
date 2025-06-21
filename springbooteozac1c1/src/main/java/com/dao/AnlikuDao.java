package com.dao;

import com.entity.AnlikuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.AnlikuVO;
import com.entity.view.AnlikuView;


/**
 * 案例库
 * 
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
public interface AnlikuDao extends BaseMapper<AnlikuEntity> {
	
	List<AnlikuVO> selectListVO(@Param("ew") Wrapper<AnlikuEntity> wrapper);
	
	AnlikuVO selectVO(@Param("ew") Wrapper<AnlikuEntity> wrapper);
	
	List<AnlikuView> selectListView(@Param("ew") Wrapper<AnlikuEntity> wrapper);

	List<AnlikuView> selectListView(Pagination page,@Param("ew") Wrapper<AnlikuEntity> wrapper);

	
	AnlikuView selectView(@Param("ew") Wrapper<AnlikuEntity> wrapper);
	

}
