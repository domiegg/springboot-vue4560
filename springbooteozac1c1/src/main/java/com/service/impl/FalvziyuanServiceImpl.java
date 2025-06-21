package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FalvziyuanDao;
import com.entity.FalvziyuanEntity;
import com.service.FalvziyuanService;
import com.entity.vo.FalvziyuanVO;
import com.entity.view.FalvziyuanView;

@Service("falvziyuanService")
public class FalvziyuanServiceImpl extends ServiceImpl<FalvziyuanDao, FalvziyuanEntity> implements FalvziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FalvziyuanEntity> page = this.selectPage(
                new Query<FalvziyuanEntity>(params).getPage(),
                new EntityWrapper<FalvziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FalvziyuanEntity> wrapper) {
		  Page<FalvziyuanView> page =new Query<FalvziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FalvziyuanVO> selectListVO(Wrapper<FalvziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FalvziyuanVO selectVO(Wrapper<FalvziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FalvziyuanView> selectListView(Wrapper<FalvziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FalvziyuanView selectView(Wrapper<FalvziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
