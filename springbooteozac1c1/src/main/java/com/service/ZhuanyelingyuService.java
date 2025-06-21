package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuanyelingyuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhuanyelingyuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuanyelingyuView;


/**
 * 专业领域
 *
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
public interface ZhuanyelingyuService extends IService<ZhuanyelingyuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuanyelingyuVO> selectListVO(Wrapper<ZhuanyelingyuEntity> wrapper);
   	
   	ZhuanyelingyuVO selectVO(@Param("ew") Wrapper<ZhuanyelingyuEntity> wrapper);
   	
   	List<ZhuanyelingyuView> selectListView(Wrapper<ZhuanyelingyuEntity> wrapper);
   	
   	ZhuanyelingyuView selectView(@Param("ew") Wrapper<ZhuanyelingyuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuanyelingyuEntity> wrapper);

   	

}

