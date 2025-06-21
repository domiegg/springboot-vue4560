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


import com.dao.AnlikuDao;
import com.entity.AnlikuEntity;
import com.service.AnlikuService;
import com.entity.vo.AnlikuVO;
import com.entity.view.AnlikuView;

@Service("anlikuService")
public class AnlikuServiceImpl extends ServiceImpl<AnlikuDao, AnlikuEntity> implements AnlikuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AnlikuEntity> page = this.selectPage(
                new Query<AnlikuEntity>(params).getPage(),
                new EntityWrapper<AnlikuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AnlikuEntity> wrapper) {
		  Page<AnlikuView> page =new Query<AnlikuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<AnlikuVO> selectListVO(Wrapper<AnlikuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AnlikuVO selectVO(Wrapper<AnlikuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AnlikuView> selectListView(Wrapper<AnlikuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AnlikuView selectView(Wrapper<AnlikuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
