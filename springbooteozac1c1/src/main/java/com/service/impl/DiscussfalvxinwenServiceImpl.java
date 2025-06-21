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


import com.dao.DiscussfalvxinwenDao;
import com.entity.DiscussfalvxinwenEntity;
import com.service.DiscussfalvxinwenService;
import com.entity.vo.DiscussfalvxinwenVO;
import com.entity.view.DiscussfalvxinwenView;

@Service("discussfalvxinwenService")
public class DiscussfalvxinwenServiceImpl extends ServiceImpl<DiscussfalvxinwenDao, DiscussfalvxinwenEntity> implements DiscussfalvxinwenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussfalvxinwenEntity> page = this.selectPage(
                new Query<DiscussfalvxinwenEntity>(params).getPage(),
                new EntityWrapper<DiscussfalvxinwenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussfalvxinwenEntity> wrapper) {
		  Page<DiscussfalvxinwenView> page =new Query<DiscussfalvxinwenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussfalvxinwenVO> selectListVO(Wrapper<DiscussfalvxinwenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussfalvxinwenVO selectVO(Wrapper<DiscussfalvxinwenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussfalvxinwenView> selectListView(Wrapper<DiscussfalvxinwenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussfalvxinwenView selectView(Wrapper<DiscussfalvxinwenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
