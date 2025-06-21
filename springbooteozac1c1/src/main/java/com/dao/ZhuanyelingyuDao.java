package com.dao;

import com.entity.ZhuanyelingyuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhuanyelingyuVO;
import com.entity.view.ZhuanyelingyuView;


/**
 * 专业领域
 * 
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
public interface ZhuanyelingyuDao extends BaseMapper<ZhuanyelingyuEntity> {
	
	List<ZhuanyelingyuVO> selectListVO(@Param("ew") Wrapper<ZhuanyelingyuEntity> wrapper);
	
	ZhuanyelingyuVO selectVO(@Param("ew") Wrapper<ZhuanyelingyuEntity> wrapper);
	
	List<ZhuanyelingyuView> selectListView(@Param("ew") Wrapper<ZhuanyelingyuEntity> wrapper);

	List<ZhuanyelingyuView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuanyelingyuEntity> wrapper);

	
	ZhuanyelingyuView selectView(@Param("ew") Wrapper<ZhuanyelingyuEntity> wrapper);
	

}
