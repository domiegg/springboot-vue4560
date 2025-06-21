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


import com.dao.ZhuanyelingyuDao;
import com.entity.ZhuanyelingyuEntity;
import com.service.ZhuanyelingyuService;
import com.entity.vo.ZhuanyelingyuVO;
import com.entity.view.ZhuanyelingyuView;

@Service("zhuanyelingyuService")
public class ZhuanyelingyuServiceImpl extends ServiceImpl<ZhuanyelingyuDao, ZhuanyelingyuEntity> implements ZhuanyelingyuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuanyelingyuEntity> page = this.selectPage(
                new Query<ZhuanyelingyuEntity>(params).getPage(),
                new EntityWrapper<ZhuanyelingyuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuanyelingyuEntity> wrapper) {
		  Page<ZhuanyelingyuView> page =new Query<ZhuanyelingyuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZhuanyelingyuVO> selectListVO(Wrapper<ZhuanyelingyuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuanyelingyuVO selectVO(Wrapper<ZhuanyelingyuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuanyelingyuView> selectListView(Wrapper<ZhuanyelingyuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuanyelingyuView selectView(Wrapper<ZhuanyelingyuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
