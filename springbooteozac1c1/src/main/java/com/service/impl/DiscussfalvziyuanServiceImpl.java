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


import com.dao.DiscussfalvziyuanDao;
import com.entity.DiscussfalvziyuanEntity;
import com.service.DiscussfalvziyuanService;
import com.entity.vo.DiscussfalvziyuanVO;
import com.entity.view.DiscussfalvziyuanView;

@Service("discussfalvziyuanService")
public class DiscussfalvziyuanServiceImpl extends ServiceImpl<DiscussfalvziyuanDao, DiscussfalvziyuanEntity> implements DiscussfalvziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussfalvziyuanEntity> page = this.selectPage(
                new Query<DiscussfalvziyuanEntity>(params).getPage(),
                new EntityWrapper<DiscussfalvziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussfalvziyuanEntity> wrapper) {
		  Page<DiscussfalvziyuanView> page =new Query<DiscussfalvziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussfalvziyuanVO> selectListVO(Wrapper<DiscussfalvziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussfalvziyuanVO selectVO(Wrapper<DiscussfalvziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussfalvziyuanView> selectListView(Wrapper<DiscussfalvziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussfalvziyuanView selectView(Wrapper<DiscussfalvziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
