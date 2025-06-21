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


import com.dao.LvshiDao;
import com.entity.LvshiEntity;
import com.service.LvshiService;
import com.entity.vo.LvshiVO;
import com.entity.view.LvshiView;

@Service("lvshiService")
public class LvshiServiceImpl extends ServiceImpl<LvshiDao, LvshiEntity> implements LvshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LvshiEntity> page = this.selectPage(
                new Query<LvshiEntity>(params).getPage(),
                new EntityWrapper<LvshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LvshiEntity> wrapper) {
		  Page<LvshiView> page =new Query<LvshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<LvshiVO> selectListVO(Wrapper<LvshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LvshiVO selectVO(Wrapper<LvshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LvshiView> selectListView(Wrapper<LvshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LvshiView selectView(Wrapper<LvshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<LvshiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<LvshiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<LvshiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
