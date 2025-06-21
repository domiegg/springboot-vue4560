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


import com.dao.FalvxinwenDao;
import com.entity.FalvxinwenEntity;
import com.service.FalvxinwenService;
import com.entity.vo.FalvxinwenVO;
import com.entity.view.FalvxinwenView;

@Service("falvxinwenService")
public class FalvxinwenServiceImpl extends ServiceImpl<FalvxinwenDao, FalvxinwenEntity> implements FalvxinwenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FalvxinwenEntity> page = this.selectPage(
                new Query<FalvxinwenEntity>(params).getPage(),
                new EntityWrapper<FalvxinwenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FalvxinwenEntity> wrapper) {
		  Page<FalvxinwenView> page =new Query<FalvxinwenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FalvxinwenVO> selectListVO(Wrapper<FalvxinwenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FalvxinwenVO selectVO(Wrapper<FalvxinwenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FalvxinwenView> selectListView(Wrapper<FalvxinwenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FalvxinwenView selectView(Wrapper<FalvxinwenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
