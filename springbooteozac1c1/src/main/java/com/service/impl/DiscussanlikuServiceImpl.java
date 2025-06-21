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


import com.dao.DiscussanlikuDao;
import com.entity.DiscussanlikuEntity;
import com.service.DiscussanlikuService;
import com.entity.vo.DiscussanlikuVO;
import com.entity.view.DiscussanlikuView;

@Service("discussanlikuService")
public class DiscussanlikuServiceImpl extends ServiceImpl<DiscussanlikuDao, DiscussanlikuEntity> implements DiscussanlikuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussanlikuEntity> page = this.selectPage(
                new Query<DiscussanlikuEntity>(params).getPage(),
                new EntityWrapper<DiscussanlikuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussanlikuEntity> wrapper) {
		  Page<DiscussanlikuView> page =new Query<DiscussanlikuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussanlikuVO> selectListVO(Wrapper<DiscussanlikuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussanlikuVO selectVO(Wrapper<DiscussanlikuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussanlikuView> selectListView(Wrapper<DiscussanlikuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussanlikuView selectView(Wrapper<DiscussanlikuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
