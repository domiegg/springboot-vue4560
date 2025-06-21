package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZhuanyelingyuEntity;
import com.entity.view.ZhuanyelingyuView;

import com.service.ZhuanyelingyuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 专业领域
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
@RestController
@RequestMapping("/zhuanyelingyu")
public class ZhuanyelingyuController {
    @Autowired
    private ZhuanyelingyuService zhuanyelingyuService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhuanyelingyuEntity zhuanyelingyu,
		HttpServletRequest request){
        EntityWrapper<ZhuanyelingyuEntity> ew = new EntityWrapper<ZhuanyelingyuEntity>();

		PageUtils page = zhuanyelingyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuanyelingyu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhuanyelingyuEntity zhuanyelingyu, 
		HttpServletRequest request){
        EntityWrapper<ZhuanyelingyuEntity> ew = new EntityWrapper<ZhuanyelingyuEntity>();

		PageUtils page = zhuanyelingyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuanyelingyu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhuanyelingyuEntity zhuanyelingyu){
       	EntityWrapper<ZhuanyelingyuEntity> ew = new EntityWrapper<ZhuanyelingyuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhuanyelingyu, "zhuanyelingyu")); 
        return R.ok().put("data", zhuanyelingyuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhuanyelingyuEntity zhuanyelingyu){
        EntityWrapper< ZhuanyelingyuEntity> ew = new EntityWrapper< ZhuanyelingyuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhuanyelingyu, "zhuanyelingyu")); 
		ZhuanyelingyuView zhuanyelingyuView =  zhuanyelingyuService.selectView(ew);
		return R.ok("查询专业领域成功").put("data", zhuanyelingyuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhuanyelingyuEntity zhuanyelingyu = zhuanyelingyuService.selectById(id);
        return R.ok().put("data", zhuanyelingyu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhuanyelingyuEntity zhuanyelingyu = zhuanyelingyuService.selectById(id);
        return R.ok().put("data", zhuanyelingyu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuanyelingyuEntity zhuanyelingyu, HttpServletRequest request){
        if(zhuanyelingyuService.selectCount(new EntityWrapper<ZhuanyelingyuEntity>().eq("zhuanyelingyu", zhuanyelingyu.getZhuanyelingyu()))>0) {
            return R.error("专业领域已存在");
        }
    	//ValidatorUtils.validateEntity(zhuanyelingyu);
        zhuanyelingyuService.insert(zhuanyelingyu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhuanyelingyuEntity zhuanyelingyu, HttpServletRequest request){
        if(zhuanyelingyuService.selectCount(new EntityWrapper<ZhuanyelingyuEntity>().eq("zhuanyelingyu", zhuanyelingyu.getZhuanyelingyu()))>0) {
            return R.error("专业领域已存在");
        }
    	//ValidatorUtils.validateEntity(zhuanyelingyu);
        zhuanyelingyuService.insert(zhuanyelingyu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhuanyelingyuEntity zhuanyelingyu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuanyelingyu);
        if(zhuanyelingyuService.selectCount(new EntityWrapper<ZhuanyelingyuEntity>().ne("id", zhuanyelingyu.getId()).eq("zhuanyelingyu", zhuanyelingyu.getZhuanyelingyu()))>0) {
            return R.error("专业领域已存在");
        }
        zhuanyelingyuService.updateById(zhuanyelingyu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhuanyelingyuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
